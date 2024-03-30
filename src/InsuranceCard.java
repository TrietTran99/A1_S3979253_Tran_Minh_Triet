//Imports
import java.util.Date;

/**
 * This represents an insurance card.
 * Each card will have: card number, card-holder, policy owner, and expir. date.
 * @author <Tran Minh Triet - s3979253>
 */
public class InsuranceCard {
    private String cardNumber;
    private String cardHolder;
    private String policyOwner;
    private Date expirationDate;

    /**
     * Constructor for InsuranceCard object with the parameters.
     * @param cardNumber :Card number.
     * @param cardHolder :Card holder's name.
     * @param policyOwner :Policy owner's name.
     * @param expirationDate :Expir. date of the card.
     */
    public InsuranceCard(String cardNumber, String cardHolder, String policyOwner, Date expirationDate) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.policyOwner = policyOwner;
        this.expirationDate = expirationDate;
    }

    //Getter and setters for InsuranceCard class
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getPolicyOwner() {
        return policyOwner;
    }

    public void setPolicyOwner(String policyOwner) {
        this.policyOwner = policyOwner;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
