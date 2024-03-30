//Imports
import java.util.ArrayList;
import java.util.List;

/**
 * Customer class represents a customer that is in the insurance system.
 * Customer should have their: ID, Fullname, list of claims, and insurance cards.
 * Customers can be policy holders or dependents.
 * This class will manipulate the customer data for other classes.
 * @author <Tran Minh Triet - s3979253>
 */

public class Customer {
    private String id;
    private String fullName;
    private InsuranceCard insuranceCard;
    private List<Claim> claims;

    /**
     * Constructs a Customer object with the given parameters.
     * @param id The ID of the customer.
     * @param fullName The full name of the customer.
     * @param insuranceCard The insurance card associated with the customer.
     */
    public Customer(String id, String fullName, InsuranceCard insuranceCard) {
        this.id = id;
        this.fullName = fullName;
        this.insuranceCard = insuranceCard;
        this.claims = new ArrayList<>();
    }

    //Getter and Setter for Customer
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public InsuranceCard getInsuranceCard() {
        return insuranceCard;
    }

    public void setInsuranceCard(InsuranceCard insuranceCard) {
        this.insuranceCard = insuranceCard;
    }

    public List<Claim> getClaims() {
        return claims;
    }

    /**
     * We need to add a claim to the customer's claim lists (listofclaims).
     * @param claim :The claim that needs to be added.
     */
     public void addClaim(Claim claim) {
         claims.add(claim);
     }

    /**
     * Removes a claim that is from the customer's list of claims.
     * @param claim :Claim to be removed.
     */
    public void removeClaim(Claim claim) {
        claims.remove(claim);
    }
}



