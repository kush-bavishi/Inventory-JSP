package com.kush.model.entity;

public class Item
{
	private String itemId;
	private String itemName;
	private String itemManufacturer;
	private String itemType;
	private String itemDescription;
	private int itemQuantity;
	private float itemRating;
	private String itemColor;
	private double itemPrice;
	private String itemImageName;
	private byte[] itemImageData;
	
	public Item(String itemId, String itemName, String itemManufacturer,
			String itemType, String itemDescription, int itemQuantity,
			float itemRating, String itemColor, double itemPrice, String itemImageName, byte[] itemImageData) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemManufacturer = itemManufacturer;
		this.itemType = itemType;
		this.itemDescription = itemDescription;
		this.itemQuantity = itemQuantity;
		this.itemRating = itemRating;
		this.itemColor = itemColor;
		this.itemPrice = itemPrice;
		this.itemImageName = itemImageName;
		this.itemImageData = itemImageData;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemManufacturer() {
		return itemManufacturer;
	}

	public void setItemManufacturer(String itemManufacturer) {
		this.itemManufacturer = itemManufacturer;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public float getItemRating() {
		return itemRating;
	}

	public void setItemRating(float itemRating) {
		this.itemRating = itemRating;
	}

	public String getItemColor() {
		return itemColor;
	}

	public void setItemColor(String itemColor) {
		this.itemColor = itemColor;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Override
	public String toString() {
		return "Item [itemColor=" + itemColor + ", itemDescription="
				+ itemDescription + ", itemId=" + itemId
				+ ", itemManufacturer=" + itemManufacturer + ", itemName="
				+ itemName + ", itemQuantity=" + itemQuantity + ", itemRating="
				+ itemRating + ", itemType=" + itemType + "]";
	}
	
	public String getItemImageName() {
		return itemImageName;
	}

	public void setItemImageName(String itemImageName) {
		this.itemImageName = itemImageName;
	}

	public byte[] getItemImageData() {
		return itemImageData;
	}

	public void setItemImageData(byte[] itemImageData) {
		this.itemImageData = itemImageData;
	}

}
