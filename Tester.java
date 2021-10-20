package SwiftFood;

public class Tester {

	public static void main(String[] args) {
		Address A1 = new Address("E-6", "13th Street", "NY", 546879);
		Customer C1 = new PremiumCustomer("C13", "JAck", 8754321523L, A1);
		A1.setCity("Boston");
//		C1.address.setCity("Boston");	// must have address variable as default
		C1.displayCustomerDetails();
		
		Food F1 = new Food();
		F1.setFoodName("Large Burger with Crisps");
		F1.setCuisine("American");
		F1.setFoodType("Veg");
		F1.setUnitPrice(35);
		F1.setQuantityAvailable(10);
		
		Food F2 = new Food();
		F2.setFoodName("Cheese Fries");
		F2.setCuisine("Belgian");
		F2.setFoodType("Veg");
		F2.setUnitPrice(15);
		F2.setQuantityAvailable(20);
		
		Food F3 = new Food();
		F3.setFoodName("Chicken Pasta with Garlic Buns");
		F3.setCuisine("Italian");
		F3.setFoodType("Non-Veg");
		F3.setUnitPrice(23);
		F3.setQuantityAvailable(15);
		
		Food[] OF1 = new Food[] {F1, F2, F3};
		Order O1 = new Order(OF1);
		
		Bill B1 = new Bill("PayPal");
		B1.generateBill(O1, C1);
	}

}
