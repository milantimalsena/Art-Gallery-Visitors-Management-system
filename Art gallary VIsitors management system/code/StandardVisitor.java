/**
 *This is the child class of our Coursework, which abstract others sub classes.
 *
 * @author (Milan Timalsena)
 * 
 */
public class StandardVisitor extends ArtGalleryVisitor{
    
    
    private boolean isEligibleForDiscountUpgrade;
    private final int visitLimit = 5;
    private float discountPercent; //discount for Standard visitors
    
    
    public   StandardVisitor(int visitorId, String fullName, String gender, String contactNumber,
                           String registrationDate, double ticketCost, String ticketType) {  
                             
                     super(visitorId, fullName, gender, contactNumber, registrationDate, ticketCost,
         ticketCost, ticketType, visitorId, ticketCost, visitorId);              
       
        this.isEligibleForDiscountUpgrade = false;
        this.discountPercent = 0.10f; // Default discount percent for Standard visitors
    }
   
    public boolean isEligibleForDiscountUpgrade() {
        return isEligibleForDiscountUpgrade;
    }
    public int getVisitLimit() {
        return visitLimit;
    }
    public float getDiscountPercent() {
        return discountPercent;
    }

    public boolean checkDiscountUpgrade() {
        if (visitCount >= visitLimit) {
            isEligibleForDiscountUpgrade = true;
            discountPercent = 0.15f;
            return false;
        }
        return isEligibleForDiscountUpgrade;
    }
    // Override buyProduct method
    @Override
    public String buyProduct(String artworkName, double artworkPrice) {
        if (!isActive) {
            return "Error: Visitor is not active. Please log a visit before making a purchase.";
        }
        if (!isBought || this.artworkName == null || !this.artworkName.equals(artworkName)) {
            this.artworkName = artworkName;
            this.artworkPrice = artworkPrice;
            isBought = true;
            buyCount++;
            return "Purchase successfully: " + artworkName + " for " + artworkPrice;
        }
        return "Error: Artwork '" + artworkName + "' has already been purchased.";
    }
    
    // Override calculateDiscount method
    @Override
    public double calculateDiscount() {
        if (!isBought) {
            return 0.0;
        }
        checkDiscountUpgrade(); // Update discountPercent if eligible
        discountAmount = artworkPrice * discountPercent;
        finalPrice = artworkPrice - discountAmount;
        return discountAmount;
    }

    // Override calculateRewardPoint method
    @Override
    public double calculateRewardPoint() {
        if (!isBought) {
            return 0.0;
        }
        calculateDiscount(); 
        rewardPoints += finalPrice * 5;
        return rewardPoints;
    }

    // Override cancelProduct method
    @Override
    public String cancelProduct(String artworkName, String cancellationReason) {
        if (cancelCount >= cancelLimit) {
            terminateVisitor();
            return "Error: Cancellation limit reached. Visitor account terminated.";
        }
        if (buyCount == 0 || !isBought) {
            return "Error: No product purchased to cancel.";
        }
        if (!this.artworkName.equals(artworkName)) {
            return "Error: Artwork name '" + artworkName + "' does not match purchased artwork.";
        }
        refundableAmount = artworkPrice - (artworkPrice * 0.10); // 10% cancellation fee
        rewardPoints -= finalPrice * 5; // Deduct reward points
        this.artworkName = null;
        isBought = false;
        cancelCount++;
        buyCount--;
        this.cancellationReason = cancellationReason;
        return "Cancellation successful for '" + artworkName + "'. Refund amount: " + refundableAmount +
               ". Reason: " + cancellationReason;
    }

    // Override generateBill method
    @Override
    public void generateBill() {
        if (!isBought || artworkName == null) {
            System.out.println("No purchase made to generate a bill.");
            return;
        }
        System.out.println("Bill Details:");
        System.out.println("-------------");
        System.out.println("Visitor ID: " + visitorId);
        System.out.println("Visitor Name: " + fullName);
        System.out.println("Artwork Name: " + artworkName);
        System.out.println("Artwork Price: " + artworkPrice);
        System.out.println("Discount Amount: " + discountAmount);
        System.out.println("Final Price: " + finalPrice);
        System.out.println("-------------");
    }

    // Private terminateVisitor method
    private void terminateVisitor() {
        isActive = false;
        isEligibleForDiscountUpgrade = false;
        visitCount = 0;
        cancelCount = 0;
        rewardPoints = 0;
    }

    // Override display method
    @Override
    public void display() {
        super.display();
        System.out.println("Standard Visitor Details:");
        System.out.println("------------------------");
        System.out.println("Eligible for Discount Upgrade: " + isEligibleForDiscountUpgrade);
        System.out.println("Visit Limit: " + visitLimit);
        System.out.println("Discount Percent: " + (discountPercent * 100) + "%");
        System.out.println("------------------------");
    }
}


