package com.lti.component;

import java.util.List;

public interface CarPartsInventory {

	public void addNewPart(CarPart cp);
	public List<CarPart> getAvailableParts();
}
