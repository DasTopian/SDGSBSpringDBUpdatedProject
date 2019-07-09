package com.lti.component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BidderInformation {
	
	@Id
	@GeneratedValue
	private int bidderId;
	private String bidderName;
	private String bidEmail;
	public int getBidderId() {
		return bidderId;
	}
	public void setBidderId(int bidderId) {
		this.bidderId = bidderId;
	}
	public String getBidderName() {
		return bidderName;
	}
	public void setBidderName(String bidderName) {
		this.bidderName = bidderName;
	}
	public String getBidEmail() {
		return bidEmail;
	}
	public void setBidEmail(String bidEmail) {
		this.bidEmail = bidEmail;
	}
	
	

}
