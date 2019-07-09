package com.lti.component;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

	@Test
	public void insertTest() {
		ApplicationContext context=new ClassPathXmlApplicationContext("Spring-config.xml");
		((CarPartsInventory)context.getBean("carPartsImpl3")).addNewPart(new CarPart(242,"Night","Monkey",23));
	}
	@Test
	public void getTest() {
		ApplicationContext context=new ClassPathXmlApplicationContext("Spring-config.xml");
		for(CarPart p:((CarPartsInventory)context.getBean("carPartsImpl4")).getAvailableParts()) {
			System.out.println(p);
		}
		
		
	}
	
	@Test
	public void insertBidderTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-config.xml");
		BidderInfoLibrary bil = (BidderInfoLibrary)context.getBean("BidLib1");
		BidderInformation bi = new BidderInformation();
		bi.setBidderName("Roshan Murali");
		bi.setBidEmail("murali@roshan.com");
		bil.addBidderInfo(bi);
		
	}
	
	@Test
	public void showBidderTest() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-config.xml");
		BidderInfoLibrary bil = (BidderInfoLibrary)context.getBean("BidLib1");
		List<BidderInformation> list = bil.showAllBidderDetails();
		for (BidderInformation b:list) {
			System.out.println("========================");
			System.out.println("Bidder ID: "+b.getBidderId());
			System.out.println("Bidder Name: "+b.getBidderName());
			System.out.println("Bidder Email: "+b.getBidEmail());
			System.out.println("========================"); 
		}
	}
	
}
