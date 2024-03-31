//Import
import java.util.Date;
import java.util.List;

/**
 * Represent claim in the insurance system.
 * Each claim should have: ID, claim date, insured person, card number, exam date, list of documents, claim amount, status, and receiver banking information.
 * @author <Tran Minh Triet - s3979253>
 */

public class Claim {
    private String id;
    private Date claimDate;
    private String insuredPerson;
    private String cardNumber;
    private Date examDate;
    private List<String> documents;
    private double claimAmount;
    private String status;
    private String receiverBankingInfo;

    /**
     * Custructor for Claim object with parameters.
     * @param id :ID of the claim.
     * @param claimDate :Date when the claim was made.
     * @param insuredPerson :Name of the insured person.
     * @param cardNumber :Card number associated with the claim.
     * @param examDate :Date of the medical examination.
     * @param documents :List of documents that are related with the claim.
     * @param claimAmount :Amount claimed
     * @param status :Status of the claim [New, Processing, Finish].
     * @param receiverBankingInfo :Reciever's banking information.
     */
    public Claim(String id, Date claimDate, String insuredPerson, String cardNumber, Date examDate, List<String> documents, double claimAmount, String status, String receiverBankingInfo) {
        this.id = id;
        this.claimDate = claimDate;
        this.insuredPerson = insuredPerson;
        this.cardNumber = cardNumber;
        this.examDate = examDate;
        this.documents = documents;
        this.claimAmount = claimAmount;
        this.status = status;
        this.receiverBankingInfo = receiverBankingInfo;
    }

    //Getter and setters for Claim class.
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    public String getInsuredPerson() {
        return insuredPerson;
    }

    public void setInsuredPerson(String insuredPerson) {
        this.insuredPerson = insuredPerson;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public List<String> getDocuments() {
        return documents;
    }

    public void setDocuments(List<String> documents) {
        this.documents = documents;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReceiverBankingInfo() {
        return receiverBankingInfo;
    }

    public void setReceiverBankingInfo(String receiverBankingInfo) {
        this.receiverBankingInfo = receiverBankingInfo;
    }
}
