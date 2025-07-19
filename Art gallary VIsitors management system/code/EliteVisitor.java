/**
 *This is the child class of our Coursework, which abstract others sub classes.
 *
 * @author (Milan Timalsena)
 * 
 */
public class EliteVisitor extends ArtGalleryVisitor {
    private boolean assignedPersonalArtAdvisor;
    private boolean exclusiveEventAccess;

    // Constructor
    public EliteVisitor(int visitorId, String fullName, String gender, String contactNumber,
                       String registrationDate, double ticketCost, String ticketType) {
        super(visitorId, fullName, gender, contactNumber, registrationDate, ticketCost,
         ticketType);
        this.assignedPersonalArtAdvisor = false;
        this.exclusiveEventAccess = false;
    }

    // Accessor methods
    public boolean getAssignedPersonalArtAdvisor() { return assignedPersonalArtAdvisor; }
    public boolean getExclusiveEventAccess() { return exclusiveEventAccess; }

    // Assign personal art advisor
    public boolean assignPersonalArtAdvisor() {
        if (rewardPoints > 5000) {
            assignedPersonalArtAdvisor = true;
        }
        return assignedPersonalArtAdvisor;
    }

    

    // Check exclusive event access
    public boolean exclusiveEventAccess() {
        if (assignedPersonalArtAdvisor) {
            exclusiveEventAccess = true;
        }
        return exclusiveEventAccess;
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
            return "Purchase successful: " + artworkName + " for " + artworkPrice;
        }
        return "Error: Artwork '" + artworkName + "' has already been purchased.";
    }

    // Override calculateDiscount method
    @Override
    public double calculateDiscount() {
        if (!isBought) {
            return 0.0;
        }
        discountAmount = artworkPrice * 0.40; // 40% discount
        finalPrice = artworkPrice - discountAmount;
        return discountAmount;
    }

    // Override calculateRewardPoint method
    @Override
    public double calculateRewardPoint() {
        if (!isBought) {
            return 0.0;
        }
        calculateDiscount(); // Ensure discount is calculated first
        rewardPoints += finalPrice * 10; // 10 points per rupee
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
        refundableAmount = artworkPrice - (artworkPrice * 0.05); // 5% cancellation fee
        rewardPoints -= finalPrice * 10; // Deduct reward points
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
            System.out.println("Please purchase first");
            return;
        }
        System.out.println("Bill Details:");
        System.out.println("-------------");
        System.out.println("Thank you "+fullName +" for visiting hamro art gallery");
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
        assignedPersonalArtAdvisor = false;
        exclusiveEventAccess = false;
        visitCount = 0;
        cancelCount = 0;
        rewardPoints = 0;
    }

    // Override display method
    @Override
    public void display() {
        super.display();
        System.out.println("Elite Visitor Details:");
        System.out.println("---------------------");
        System.out.println("Assigned Personal Art Advisor:" + assignedPersonalArtAdvisor);
        System.out.println("Exclusive Event Access: " + exclusiveEventAccess);
        System.out.println("---------------------");
    }
}