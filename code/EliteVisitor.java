/**
 * Represents an elite visitor to the art gallery, extending the base ArtGalleryVisitor class.
 * Provides additional features such as personal art advisor assignment and exclusive event access.
 * @author Milan Timalsena
 */
public class EliteVisitor extends ArtGalleryVisitor {
    // Indicates if the visitor has a personal art advisor assigned
    private boolean assignedPersonalArtAdvisor;
    // Indicates if the visitor has access to exclusive events
    private boolean exclusiveEventAccess;

    /**
     * Constructs an EliteVisitor with specified details, initializing elite-specific attributes.
     * @param visitorId Unique identifier for the visitor
     * @param fullName Full name of the visitor
     * @param gender Gender of the visitor
     * @param contactNumber Contact phone number of the visitor
     * @param registrationDate Date of visitor registration
     * @param ticketCost Cost of the ticket
     * @param ticketType Type of ticket (e.g., general, VIP)
     */
    public EliteVisitor(int visitorId, String fullName, String gender, String contactNumber,
                       String registrationDate, double ticketCost, String ticketType) {
        super(visitorId, fullName, gender, contactNumber, registrationDate, ticketCost, 0.0, ticketType, 0, 0.0, 0);
        this.assignedPersonalArtAdvisor = false;
        this.exclusiveEventAccess = false;
    }

    /**
     * Gets the status of the personal art advisor assignment.
     * @return True if a personal art advisor is assigned, false otherwise
     */
    public boolean getAssignedPersonalArtAdvisor() {
        return assignedPersonalArtAdvisor;
    }

    /**
     * Gets the status of exclusive event access.
     * @return True if the visitor has exclusive event access, false otherwise
     */
    public boolean getExclusiveEventAccess() {
        return exclusiveEventAccess;
    }

    /**
     * Assigns a personal art advisor if the visitor has sufficient reward points.
     * @return True if the advisor is assigned, false otherwise
     */
    public boolean assignPersonalArtAdvisor() {
        if (rewardPoints > 5000) {
            assignedPersonalArtAdvisor = true;
        }
        return assignedPersonalArtAdvisor;
    }

    /**
     * Grants exclusive event access if a personal art advisor is assigned.
     * @return True if exclusive event access is granted, false otherwise
     */
    public boolean exclusiveEventAccess() {
        if (assignedPersonalArtAdvisor) {
            exclusiveEventAccess = true;
        }
        return exclusiveEventAccess;
    }

    /**
     * Handles the purchase of an artwork, updating relevant visitor details.
     * @param artworkName Name of the artwork to purchase
     * @param artworkPrice Price of the artwork
     * @return Confirmation message indicating success or error
     */
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

    /**
     * Calculates the discount for the purchased artwork (40% for elite visitors).
     * @return The discount amount applied
     */
    @Override
    public double calculateDiscount() {
        if (!isBought) {
            return 0.0;
        }
        discountAmount = artworkPrice * 0.40; // 40% discount
        finalPrice = artworkPrice - discountAmount;
        return discountAmount;
    }

    /**
     * Calculates reward points based on the final price of the purchase (10 points per rupee).
     * @return The updated reward points
     */
    @Override
    public double calculateRewardPoint() {
        if (!isBought) {
            return 0.0;
        }
        calculateDiscount(); // Ensure discount is calculated first
        rewardPoints += finalPrice * 10; // 10 points per rupee
        return rewardPoints;
    }

    /**
     * Cancels a purchased artwork, applying a cancellation fee and updating visitor details.
     * @param artworkName Name of the artwork to cancel
     * @param cancellationReason Reason for the cancellation
     * @return Confirmation message indicating success or error
     */
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

    /**
     * Generates and displays a bill for the purchased artwork.
     */
    @Override
    public void generateBill() {
        if (!isBought || artworkName == null) {
            System.out.println("Please purchase first");
            return;
        }
        System.out.println("Bill Details:");
        System.out.println("-------------");
        System.out.println("Thank you " + fullName + " for visiting hamro art gallery");
        System.out.println("Visitor ID: " + visitorId);
        System.out.println("Visitor Name: " + fullName);
        System.out.println("Artwork Name: " + artworkName);
        System.out.println("Artwork Price: " + artworkPrice);
        System.out.println("Discount Amount: " + discountAmount);
        System.out.println("Final Price: " + finalPrice);
        System.out.println("-------------");
    }

    /**
     * Terminates the visitor's account, resetting key attributes.
     */
    private void terminateVisitor() {
        isActive = false;
        assignedPersonalArtAdvisor = false;
        exclusiveEventAccess = false;
        visitCount = 0;
        cancelCount = 0;
        rewardPoints = 0;
    }

    /**
     * Displays all visitor details, including elite-specific attributes.
     */
    @Override
    public void display() {
        super.display();
        System.out.println("Elite Visitor Details:");
        System.out.println("---------------------");
        System.out.println("Assigned Personal Art Advisor: " + assignedPersonalArtAdvisor);
        System.out.println("Exclusive Event Access: " + exclusiveEventAccess);
        System.out.println("---------------------");
    }
}