import java.util.Scanner;

public class Bill {
	private static int counter;
	private String billId;
	private String paymentMode;
	
	static {
		counter = 0;
	}
	
	Bill(String paymentMode){
		this.paymentMode = paymentMode;
		this.billId = "B"+Integer.toString(400 + ++Bill.counter);
	}
	
	public static int getCounter() {
		return Bill.counter;
	}
	
	public String getBillId() {
		return this.billId;
	}
	public String getPaymentMode() {
		return this.paymentMode;
	}
	
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	
	public void generateBill(Order order, Customer customer) {
		try {
			System.out.println("\nBill Details \n******************");
			System.out.println("Bill Id : " + this.getBillId());
			System.out.println("Items Ordered : " + "\n-----------");
			for (Food food : order.getOrderedFoods()) {
				System.out.println(food.getFoodName());
			}
			
			double payableAmount = order.calculateTotalPrice(this.getPaymentMode());
			System.out.println("-----------\nPre-total : " + (int)(payableAmount*100)/100 + " bucks.");
			double finalAmount = customer.payBill(payableAmount);
			
		
			if (customer instanceof PremiumCustomer) {
			
				Scanner usePoints = new Scanner(System.in);
				System.out.println();
				System.out.println("Would you like to use your Reward Points?");
				char usePointsResponse = usePoints.next().charAt(0);
			
				if (usePointsResponse == 'Y' || usePointsResponse == 'y') {
					finalAmount = ((PremiumCustomer)customer).redeemPoints(finalAmount);
				}
				else {
					((PremiumCustomer) customer).setRewardPoints(((PremiumCustomer) customer).getRewardPoints() + (int)(0.1*payableAmount));
					System.out.println("Current Reward Points : " + (((PremiumCustomer) customer).getRewardPoints()));
				}
				
				usePoints.close();
			}
			System.out.println("Final Bill Amount After Math 55 : $" + (int)(finalAmount*100)/100.0);			
		}
		catch (Exception e) {
			System.out.println("Something went wrong :(");
		}
		finally {
			System.out.println("Thanks for dining. :)");
		}
			
	}
}
