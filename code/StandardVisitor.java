/**
 * Represents a standard visitor to the art gallery, extending the base ArtGalleryVisitor class.
 * Provides features for discount upgrades based on visit count and standard visitor benefits.
 * @author Milan Timalsena
 */
public class StandardVisitor extends ArtGalleryVisitor {
    // Indicates if the visitor is eligible for a discount upgrade
    private boolean isEligibleForDiscountUpgrade;
    // Maximum number of visits required for discount upgrade
    private final int visitLimit = 5;
    // Discount percentage applied to purchases
    private float discountPercent;

    /**
     * Constructs a StandardVisitor with specified details, initializing standard-specific attributes.
     * @param visitorId Unique identifier for the visitor
     * @param fullName Full name of the visitor
     * @param gender Gender of the visitor
     * @param contactNumber Contact phone number of the visitor
     * @param registrationDate Date of visitor registration
     * @param ticketCost Cost of the ticket
     * @param ticketType Type of ticket (e.g., general, standard)
     */
    public StandardVisitor(int visitorId, String fullName, String gender, String contactNumber,
                          String registrationDate, double ticketCost, String ticketType) {
        super(visitorId, fullName, gender, contactNumber, registrationDate, ticketCost, 0.0, ticketType, 0, 0.0, 0);
        this.isEligibleForDiscountUpgrade = false;
        this.discountPercent = 0.10f; // Default discount percent for Standard visitors
    }

    /**
     * Gets the eligibility status for a discount upgrade.
     * @return True if eligible for discount upgrade, false otherwise
     */
    public boolean isEligibleForDiscountUpgrade() {
        return isEligibleForDiscountUpgrade;
    }

    /**
     * Gets the visit limit required for a discount upgrade.
     * @return The visit limit
     */
    public int getVisitLimit() {
        return visitLimit;
    }

    /**
     * Gets the current discount percentage for purchases.
     * @return The discount percentage
     */
    public float getDiscountPercent() {
        return discountPercent;
    }

    /**
     * Checks if the visitor is eligible for a discount upgrade based on visit count.
     * Updates discount percentage if eligible.
     * @return True if eligible for discount upgrade, false otherwise
     */
    public boolean checkDiscountUpgrade() {
        if (visitCount >= visitLimit) {
            isEligibleForDiscountUpgrade = true;
            discountPercent = 0.15f;
            return true; // Modified to return true when upgrade is applied
        }
        return isEligibleForDiscountUpgrade;
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
     * Calculates the discount for the purchased artwork based on the discount percentage.
     * @return The discount amount applied
     */
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

    /**
     * Calculates reward points based on the final price of the purchase (5 points per rupee).
     * @return The updated reward points
     */
    @Override
    public double calculateRewardPoint() {
        if (!isBought) {
            return 0.0;
        }
        calculateDiscount(); // Ensure discount is calculated first
        rewardPoints += finalPrice * 5;
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

    /**
     * Generates and displays a bill for the purchased artwork.
     */
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

    /**
     * Terminates the visitor's account, resetting key attributes.
     */
    private void terminateVisitor() {
        isActive = false;
        isEligibleForDiscountUpgrade = false;
        visitCount = 0;
        cancelCount = 0;
        rewardPoints = 0;
    }

    /**
     * Displays all visitor details, including standard-specific attributes.
     */
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