package SwiftFood;

class Order {
	private static int orderIdCounter;
	private int orderId;
	private double totalPrice;
	private String status;
	private Food[] orderedFood;
	
	static {
		orderIdCounter = 100;
	}
	
	Order(){
		this.orderedFood = new Food[1];	
	}
	
	Order(Food[] orderedFood) {
		this.orderId = 100 + ++Order.orderIdCounter;
		this.orderedFood = orderedFood;
	}
	
	public int getOrderId() {
		return this.orderId;
	}
	public double getTotalPrice() {
		return this.totalPrice;
	}
	public String getStatus() {
		return this.status;
	}
	public Food[] getOrderedFoods() {
		return this.orderedFood;
	}
	
	public static int getTotalNoOfOrders() {
		return Order.orderIdCounter;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setOrderedFoods(Food[] orderedFood) {
		this.orderedFood = orderedFood;
	}
	
	public double calculateTotalPrice(String paymentMode) {
		double totalPrice = 0;
		for(Food food : orderedFood) {
			totalPrice += food.getUnitPrice();
		}
		return totalPrice;
	}
}
