class Address {
	private String doorNo;
	private String street;
	private String city;
	private int zipcode;
	
	Address(String doorNo, String street, String city, int zipcode) {
		this.doorNo = doorNo;
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
	}
	
	public String getDoorNo() {
		return this.doorNo;
	}
	public String getStreet() {
		return this.street;
	}
	public String getCity() {
		return this.city;
	}
	public int getZipcode() {
		return this.zipcode;
	}
	
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
}

abstract class Customer {
	protected String customerId;
	protected String customerName;
	protected long contactNumber;
	protected Address address;
	
	Customer(){
		this.customerId = "";
		this.customerName = "";
		this.contactNumber = 0000000000L;
		this.address = new Address("0", "0", "0", 0);
	}
	Customer(String customerId, String customerName, long contactNumber, Address address){
		this.customerId = customerId;
		this.customerName = customerName;
		this.contactNumber = contactNumber;
		this.address = address;
	}
	Customer(String customerName, long contactNumber, Address address){
		this.customerName = customerName;
		this.contactNumber = contactNumber;
		this.address = address;
	}
	
	public String getCustomerId() {
		return this.customerId;
	}
	public String getCustomerName() {
		return this.customerName;
	}
	public long getContactNumber() {
		return this.contactNumber;
	}
	public String getAddress() {
		return (this.address.getDoorNo() + ", " + this.address.getStreet() + ", " + this.address.getCity() + ", " + this.address.getZipcode());
	}
	
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public void updateDetails(long contactNumber) {
		System.out.println("Updating Contact Number...");
		this.setContactNumber(contactNumber);
	}
	public void updateDetails(Address address) {
		System.out.println("Updating Address...");
		this.setAddress(address);
	}
	
	public void displayCustomerDetails() {
		System.out.println("\nCustomer Details \n*********************");
		System.out.println("Customer ID : " + getCustomerId());
		System.out.println("Customer Name : " + getCustomerName());
		System.out.println("Contact Number : " + getContactNumber());
		System.out.println("Address : " + getAddress());
	}
	
	public abstract double payBill(double totalPrice);
}

class RegularCustomer extends Customer {
	
	protected float discountPercentage;
	
	RegularCustomer(){
		super();
		this.discountPercentage = 5.0f;
	}
	
	RegularCustomer(String customerId, String customerName, long contactNumber, Address address){
		super(customerId, customerName, contactNumber, address);
		this.discountPercentage = 5.0f;
	}
	
	RegularCustomer(String customerName, long contactNumber, Address address){
		super(customerName,  contactNumber, address);
		this.discountPercentage = 5.0f;
	}
	
	public float getDiscount() {
		return this.discountPercentage;
	}
	
	public void setDiscount(float discount) {
		this.discountPercentage = discount;
	}
	
	@Override
	public double payBill(double totalPrice) {
		double priceAfterDiscount = totalPrice*(1-(this.discountPercentage/100));
		return priceAfterDiscount;
	}
}

interface PremiumCards {
	int WELCOME_POINTS = 100;
	
	double redeemPoints(double totalPrice);
	
	void addPoints(double money);
}

class PremiumCustomer extends RegularCustomer implements PremiumCards{
	
	private int rewardPoints = WELCOME_POINTS;
	
	PremiumCustomer(){
		super();
		this.discountPercentage = super.discountPercentage + 3.0f;
	}
	
	PremiumCustomer(String customerId, String customerName, long contactNumber, Address address){
		super(customerId, customerName, contactNumber, address);
		this.discountPercentage = super.discountPercentage + 3.0f;
	}
	
	PremiumCustomer(String customerName, long contactNumber, Address address){
		super(customerName,  contactNumber, address);
		this.discountPercentage = super.discountPercentage + 3.0f;
	}
	
	@Override
	public double redeemPoints(double totalPrice) {
		int pointsRedeemed = (int)(checkAvailablePoints(totalPrice) ? totalPrice : this.rewardPoints);
		this.rewardPoints -= pointsRedeemed;
		System.out.println(pointsRedeemed + " points deducted from your Premium Membership Points");
		System.out.println(this.rewardPoints + " points remaining.");
		return totalPrice - pointsRedeemed;
	}
	
	public boolean checkAvailablePoints(double amountPayable) {
		if(this.rewardPoints >= Math.round(amountPayable)) {
			return true;
		}
		return false;
	}
	
	@Override
	public void addPoints(double money) {
		int pointsAdded = (int)money/10;
		this.rewardPoints += pointsAdded;
		System.out.println(pointsAdded + " points added for your purchase");
		System.out.println(this.rewardPoints + " concurrent points.");
	}
	
	public int getRewardPoints() {
		return this.rewardPoints;
	}

	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	@Override
	public double payBill(double totalPrice) {
	    double priceAfterDiscount = super.payBill(totalPrice);
	    return priceAfterDiscount;
	}
}

class GuestCustomer extends Customer {
	
	private double deliveryCharge;
	
	GuestCustomer(){
		this.deliveryCharge = 8;
	}
	
	GuestCustomer(String customerId, String customerName, long contactNumber, Address address){
		super(customerId, customerName, contactNumber, address);
		this.deliveryCharge = 8;
	}
	
	GuestCustomer(String customerName, long contactNumber, Address address){
		super(customerName,  contactNumber, address);
		this.deliveryCharge = 8;
	}
	
	public double getDeliveryCharge() {
		return this.deliveryCharge;
	}
	
	public void setDeliveryCharge(double deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}
	
	@Override
	public double payBill(double totalPrice) {
		double priceAfterAdditionalCharges = totalPrice + this.deliveryCharge;
		return priceAfterAdditionalCharges;
	}
}
