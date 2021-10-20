final class Food {
	private String foodName;
	private String cuisine;
	private String foodType;
	private int quantityAvailable;
	private double unitPrice;
	
	public String getFoodName() {
		return this.foodName;
	}
	public String getCuisine() {
		return this.cuisine;
	}
	public String getFoodType() {
		return this.foodType;
	}
	public int getQuantityAvailable() {
		return this.quantityAvailable;
	}
	public double getUnitPrice() {
		return this.unitPrice;
	}
	
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
}
