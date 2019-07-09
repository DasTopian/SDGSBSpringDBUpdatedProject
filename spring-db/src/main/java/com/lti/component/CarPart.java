package com.lti.component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_CARPARTS")
public class CarPart {
	@Id
	@Column(name="part_no")
	private int partNo;
	@Column(name="part_name")
	private String partName;
	@Column(name="car_model")
	private String carModel;
	@Column(name="quantity")
	private int quantity;
	public CarPart(int partNo, String partName, String carModel, int quantity) {
		super();
		this.partNo = partNo;
		this.partName = partName;
		this.carModel = carModel;
		this.quantity = quantity;
	}
	public CarPart() {
	}
	@Override
	public String toString() {
		return "CarPart [partNo=" + partNo + ", partName=" + partName + ", carModel=" + carModel + ", quantity="
				+ quantity + "]";
	}
	public int getPartNo() {
		return partNo;
	}
	public void setPartNo(int partNo) {
		this.partNo = partNo;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


}
