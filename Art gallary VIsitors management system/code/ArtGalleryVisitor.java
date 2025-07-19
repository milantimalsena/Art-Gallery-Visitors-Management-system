 /**
 *This is the parent class of our Coursework, which abstract others sub classes.
 *
 * @author (Milan Timalsena)
 * 
 */
 abstract class ArtGalleryVisitor{

    protected int visitorId;
    protected String fullName;
    protected String gender;
    protected String contactNumber;
    protected String registrationDate;
    protected double ticketCost;
    protected String ticketType;
    protected int visitCount;
    protected double rewardPoints;
    protected final int cancelLimit;
    protected int cancelCount;
    protected double refundableAmount;
    protected boolean isActive;
    protected boolean isBought;
    protected int buyCount;
    protected double finalPrice;
    protected double discountAmount;
    protected String artworkName;
    protected double artworkPrice;
    protected String cancellationReason;


    public ArtGalleryVisitor(int visitorId, String fullName,String gender,
    String contactNumber,String registrationDate, double ticketCost, double refundableAmount,
    String ticketType, int visitCount, double rewardPoints, int cancelCount){

    
    this.visitorId=visitorId;
    this.fullName=fullName;
    this.gender=gender;
    this.contactNumber=contactNumber;
    this.registrationDate=registrationDate;
    this.ticketCost=ticketCost;
    this.ticketType=ticketType;
    this.visitCount=visitCount;
    this.rewardPoints=rewardPoints;
    this.cancelCount=cancelCount;
    this.refundableAmount=0;
    this.isActive=false;
    this.isBought=false;
    this.buyCount=0;
    this.cancelLimit=3;
    this.finalPrice=0;
    this.artworkName="";
    this.artworkPrice=0;
    this.cancellationReason = null;
  


    }
    public ArtGalleryVisitor(int visitorId2, String fullName2, String gender2, String contactNumber2,
            String registrationDate2, double ticketCost2, String ticketType2) {
                this.cancelLimit = 0;
        //TODO Auto-generated constructor stub
    }
    

    // Accessor method


    public int getVisitorId() {
        return visitorId;
    }
    public String getFullName() {
        return fullName;
    }
    public String getgender(){
        return gender;
    }
    public String getContactNumber() {
        return contactNumber;
    }
    public String getRegistrationDate() {
        return registrationDate;
    }
    public double getTicketCost() {
        return ticketCost;
    }

    public String getTicketType() {
        return ticketType;
    }
    public int getVisitCount() {
        return visitCount;
    }

    public double getRewardPoints() {
        return rewardPoints;
    }
    public int getCancelCount() {
        return cancelCount;
    }
    public double getRefundableAmount() {
        return refundableAmount;
    }
    public boolean isActive() {
        return isActive;
    }
    public boolean isBought() {
        return isBought;
    }
    public int getBuyCount() {
        return buyCount;
    }
    public double getFinalPrice() {
        return finalPrice;
    }
    public double getDiscountAmount() {
        return discountAmount;
    }
    public String getArtworkName() {
        return artworkName;
    }
    public double getArtworkPrice() {
        return artworkPrice;
    }
    
  
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void logVisit() {
        this.visitCount = this.visitCount + 1;
        this.isActive = true;
    }

      // Abstract methods
    public abstract String buyProduct(String artworkName, double artworkPrice);

    public abstract double calculateDiscount();

    public abstract double calculateRewardPoint();

    public abstract String cancelProduct(String artworkName, String cancellationReason);

    public abstract void generateBill();

    // Display method
    public void display() {
        System.out.println("Visitor Details:");
        System.out.println("---------------");
        System.out.println("Visitor ID: " + visitorId);
        System.out.println("Full Name: " + fullName);
        System.out.println("Gender: " + gender);
        System.out.println("Contact Number: " + contactNumber);
        System.out.println("Registration Date: " + registrationDate);
        System.out.println("Ticket Type: " + ticketType);
        System.out.println("Ticket Cost: " + ticketCost);
        System.out.println("Visit Count: " + visitCount);
        System.out.println("Reward Points: " + rewardPoints);
        System.out.println("Cancel Limit: " + cancelLimit);
        System.out.println("Cancel Count: " + cancelCount);
        System.out.println("Cancellation Reason: " + (cancellationReason != null ? cancellationReason : "None"));
        System.out.println("Refundable Amount: " + refundableAmount);
        System.out.println("Is Active: " + isActive);
        System.out.println("Is Bought: " + isBought);
        System.out.println("Buy Count: " + buyCount);
        System.out.println("Final Price: " + finalPrice);
        System.out.println("Discount Amount: " + discountAmount);
        System.out.println("Artwork Name: " + (artworkName != null ? artworkName : "None"));
        System.out.println("Artwork Price: " + artworkPrice);
        System.out.println("---------------");
    }
}

