package org.smartfridge.domain;

public class Item {
	
	private String name;
	private String itemUUID;
	private long itemType;
	private Double fillFactor;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getItemUUID() {
		return itemUUID;
	}
	public void setItemUUID(String itemUUID) {
		this.itemUUID = itemUUID;
	}
	public long getItemType() {
		return itemType;
	}
	public void setItemType(long itemType) {
		this.itemType = itemType;
	}
	public Double getFillFactor() {
		return fillFactor;
	}
	public void setFillFactor(Double fillFactor) {
		this.fillFactor = fillFactor;
	}	
	
}