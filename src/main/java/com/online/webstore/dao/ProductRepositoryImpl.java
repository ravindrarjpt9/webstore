package com.online.webstore.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.jms.Session;
import javax.naming.NoPermissionException;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.online.webstore.exception.ProductNotFoundException;
import com.online.webstore.model.Product;

@Repository
public class ProductRepositoryImpl extends AbstractDao implements ProductRepository {


	@PostConstruct
	public void init(){
		System.out.println(" *********************** dummy data created ***********************");

	}
	public ProductRepositoryImpl() {
	System.out.println("No-aurg cust call......");
	}

	@Override
	public List<Product> getAllList() {
		
		Criteria criteria = getSession().createCriteria(Product.class);
		//Query query = session.createQuery("FROM "+Product.class.toString());
		List<Product> list = criteria.list();
		return list;
	}

	public Product getProductById(Integer productId) {
		
		Product p = (Product) getSession().get(Product.class, productId);
		if (p == null) {
			throw new ProductNotFoundException("No products found with the product id: " + productId);
		}
		return p;
	}
	
	@Override
	public void insertTestData() {
		    
			Product iphone = new Product("iPhone 5s", new BigDecimal(500));
			iphone.setDescription("Apple iPhone 5s smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera");
			iphone.setCategory("Smart Phone");
			iphone.setManufacturer("Apple");
			iphone.setUnitsInStock(1000);

			Product laptop_dell = new Product("Dell Inspiron", new BigDecimal(700));
			laptop_dell.setDescription("Dell Inspiron 14-inch Laptop (Black) with 3rd Generation Intel Core processors");
			laptop_dell.setCategory("Laptop");
			laptop_dell.setManufacturer("Dell");
			laptop_dell.setUnitsInStock(1000);

			Product tablet_Nexus = new Product("Nexus 7", new BigDecimal(300));
			tablet_Nexus.setDescription(
					"Google Nexus 7 is the lightest 7 inch tablet With a quad-core Qualcomm Snapdragon™ S4 Pro processor");
			tablet_Nexus.setCategory("Tablet");
			tablet_Nexus.setManufacturer("Google");
			tablet_Nexus.setUnitsInStock(1000);
			persist(iphone);
			persist(laptop_dell);
			persist(tablet_Nexus);
			System.out.println(" Inserted iphone id : "+ iphone.getProductId());
			System.out.println(" Insert laptop_dell ID : " + laptop_dell.getProductId());
			System.out.println(" Inserted tablet_Nexus ID : " + tablet_Nexus.getProductId());
		
	}
	
	@Override
	public List<Product> getProductsByCategory(String category) {
		Criteria criteria = getSession().createCriteria(Product.class);
		criteria.add(Restrictions.eq("category", category));
		return criteria.list();
	}
	
	@Override
	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		List<Product> list = getAllList();
		Set<Product> productByBrans = new HashSet<Product>();
		Set<Product> productByCategory = new HashSet<Product>();
		Set<String> filterKey = filterParams.keySet();
		if(filterKey.contains("brand")){
			for(String brand : filterParams.get("brand")){
				for(Product p : list){
					if(p.getManufacturer().equalsIgnoreCase(brand)){
						productByBrans.add(p);
					}
				}
			}
		}else if(filterKey.contains("category")){
			
			for(String category : filterParams.get("category")){
				for(Product p : list){
					if(p.getCategory().equalsIgnoreCase(category)){
						productByCategory.add(p);
					}
				}
			}
		}
		productByBrans.retainAll(productByCategory);
		return productByBrans;
	}
	
	@Override
	public void addProduct(Product product) {
		persist(product);
	}
}
