package com.lincolnpomper.jogogourmet.logic;

public class FoodNode {

	private String name;
	private FoodNode childYes;
	private FoodNode childNo;

	public void setChildYes(FoodNode childYes) {
		this.childYes = childYes;
	}

	public void setChildNo(FoodNode childNo) {
		this.childNo = childNo;
	}

	public FoodNode(String name) {
		this.name = name;
	}

	boolean hasChildYes() {
		return childYes != null;
	}

	boolean hasChildNo() {
		return childNo != null;
	}

	FoodNode getChildYes() {
		return childYes;
	}

	FoodNode getChildNo() {
		return childNo;
	}

	String getName() {
		return name;
	}

	@Override public String toString() {
		return "FoodNode{" + "name='" + name + '\'' + ", childYes=" + childYes + ", childNo=" + childNo + '}';
	}
}