package com.employee.model.vo;

public class Department {
	private String deptId, deptTitle, locationId;

	public Department(String deptId, String deptTitle, String locationId) {
		this.deptId = deptId;
		this.deptTitle = deptTitle;
		this.locationId = locationId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptTitle() {
		return deptTitle;
	}

	public void setDeptTitle(String deptTitle) {
		this.deptTitle = deptTitle;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	@Override
	public String toString() {
		return  deptId + " " + deptTitle + ", l " + locationId;
	}
	
	
}
