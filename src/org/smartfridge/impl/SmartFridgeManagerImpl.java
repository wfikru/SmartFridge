package org.smartfridge.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.smartfridge.SmartFridgeManager;
import org.smartfridge.domain.Item;

public class SmartFridgeManagerImpl implements SmartFridgeManager {

	private List<Item> itemList = new ArrayList<Item>();
	private List<Long> forgetItemList = new ArrayList<Long>();
	
	@Override
	public void handleItemRemoved(String itemUUID) {
		if (this.itemList != null && this.itemList.size() > 0) {
			Iterator<Item> iterator = itemList.iterator();
			while (iterator.hasNext()) {
				Item next = iterator.next();
				if (next.getItemUUID().equals(itemUUID)) {
					iterator.remove();
				}
			}
		}
	}

	@Override
	public void handleItemAdded(long itemType, String itemUUID, String name, Double fillFactor) {
		if (this.itemList == null) {
			itemList = new ArrayList<Item>();
		}
		Item item = new Item();
		item.setItemType(itemType);
		item.setItemUUID(itemUUID);
		item.setName(name);
		item.setFillFactor(fillFactor);
		this.itemList.add(item);
	}

	@Override
	public Object[] getItems(Double fillFactor) {
		List<Item> replenishList = new ArrayList<Item>();
		if (this.itemList != null && this.itemList.size() > 0) {
			Iterator<Item> iterator = itemList.iterator();
			while (iterator.hasNext()) {
				Item next = iterator.next();
				if (next.getFillFactor().equals(fillFactor)) {
					replenishList.add(next);
				}
			}
		}
		return replenishList.toArray();
	}

	@Override
	public Double getFillFactor(long itemType) {
		// TODO Auto-generated method stub
		if (this.itemList != null && this.itemList.size() > 0) {
			Iterator<Item> iterator = itemList.iterator();
			while (iterator.hasNext()) {
				Item next = iterator.next();
				if (next.getItemType() == itemType && !this.forgetItemList.contains(itemType)) {
					return next.getFillFactor();
				}
			}
		}
		return null;
	}

	@Override
	public void forgetItem(long itemType) {
		// TODO Auto-generated method stub
		if (this.forgetItemList != null) {
			this.forgetItemList.add(itemType);
		}
	}

}
