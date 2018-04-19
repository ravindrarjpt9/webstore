package com.online.webstore.controller;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.online.webstore.exception.NoProductsFoundUnderCategoryException;
import com.online.webstore.exception.ProductNotFoundException;
import com.online.webstore.model.Product;
import com.online.webstore.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping
	public String list(Model map) {
		map.addAttribute("products", productService.getAllList());
		return "products";

	}

	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setDisallowedFields("unitsInOrder", "discontinued");
	}

	@RequestMapping(value = "/{category}", method = RequestMethod.GET)
	public ModelAndView getProductByCategory(@PathVariable("category") String category, ModelAndView view) {
		view.addObject("products", productService.getProductsByCategory(category));
		view.setViewName("products");
		return view;

	}

	@RequestMapping(value = "/filter/{ByCriteria}", method = RequestMethod.GET)
	public ModelAndView getProductsByFilter(
			@MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> ByCriteria, ModelAndView modelAndView) {
		Set<Product> set = productService.getProductsByFilter(ByCriteria);
		if (set == null || set.size() == 0) {
			throw new NoProductsFoundUnderCategoryException();
		}
		modelAndView.addObject("products", set);
		modelAndView.setViewName("products");
		return modelAndView;
	}

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ModelAndView getProductById(@RequestParam(value = "id", required = true) Integer id,
			ModelAndView modelAndView) {
		modelAndView.addObject("product", productService.getProductById(id));
		modelAndView.setViewName("product");
		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("newProduct", product);
		return "addProduct";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct, BindingResult result,
			HttpServletRequest request) {
		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		MultipartFile file = newProduct.getProductImage();
		String rootDir = request.getSession().getServletContext().getRealPath("/");
		try {
			if (file != null && !file.isEmpty()) {
				file.transferTo(new File(rootDir + "resources\\images\\" + newProduct.getName()));
			}
		} catch (Exception e) {
			throw new RuntimeException("Product Image saving failed", e);
		}
		productService.addProduct(newProduct);
		return "redirect:/products";
	}

	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest request, ProductNotFoundException exception) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("invalidProductId", exception.getProductId());
		mav.addObject("exception", exception);
		mav.addObject("url", request.getRequestURL() + "?" + request.getQueryString());
		mav.setViewName("productNotFound");
		return mav;

	}
}
