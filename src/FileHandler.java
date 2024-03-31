//Imports
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Arrays;

/**
 * Utility class for reading from and writing to files.
 * @author <Tran Minh Triet - s3979253>
 */

public class FileHandler {
    private static final String CUSTOMER_FILE_HEADER = "id,fullname,cardNumber";
    private static final String CLAIM_FILE_HEADER = "id,claimDate,insuredPerson,cardNumber,examDate,documents,claimAmount,status,reciverBankingInfo";
    private static final String FILE_NAME = "claim.txt";

    /**
     * Reads the customer data from a file, then returns a list of Customer objects.
     * @param filename :Name of the file to read.
     * @return list of Customer objects read from the file.
     */
    public static List<Customer> readCustomersFromFile(String filename) {
        List<Customer> customers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            // Skip the header line when reading
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    Customer customer = new Customer(parts[0], parts[1], new InsuranceCard(parts[2], "", "", null));
                    customers.add(customer);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }

    /**
     * Writes a list of Customers objects to a file.
     * @param filename :Name of the file to write.
     * @param customers :List of Customer objects to write.
     */
    public static void writeCustomersToFile(String filename, List<Customer> customers) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println(CUSTOMER_FILE_HEADER);
            for (Customer customer : customers) {
                writer.println(customer.getId() + "," + customer.getFullName() + "," + customer.getInsuranceCard().getCardNumber());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads the insurance card data from a file then returns a list of InsuranceCard objects.
     * @param filename :The name of the file to read.
     * @return list of InsuranceCard objects read from the file.
     */
    public static List<InsuranceCard> readInsuranceCardFromFile(String filename) {
        List<InsuranceCard> insuranceCards = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            //Skip the header line when reading.
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    InsuranceCard insuranceCard = new InsuranceCard(parts[0], parts[1], parts[2], new SimpleDateFormat("dd-MM-yyyy").parse(parts[3]));
                    insuranceCards.add(insuranceCard);
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return insuranceCards;
    }

    /**
     * Writes list of InsuranceCard objects to a file.
     * @param filename :Name of the file to write.
     * @param insuranceCards :List of InsuranceCard objects to write.
     */
    public static void writeInsuranceCardsToFile(String filename, List<InsuranceCard> insuranceCards) {
        try (PrintWriter writer = new PrintWriter(new PrintWriter(filename))) {
            writer.println("cardNumber,cardHolder,policyOwner,expirationDate");
            for (InsuranceCard insuranceCard : insuranceCards) {
                String expirationDate = new SimpleDateFormat("dd-MM-yyyy").format(insuranceCard.getExpirationDate());
                writer.println(insuranceCard.getCardNumber() + "," + insuranceCard.getCardHolder() + "," + insuranceCard.getPolicyOwner() + "," + expirationDate);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads claim data from a file and returns a list of Claim objects.
     * @param filename :Name of the file to read from.
     * @return list of Claim objects read from the file.
     */
    public static List<Claim> readClaimsFromFIle(String filename) {
        List<Claim> claims = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            //Skip the header line when reading.
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 8) {
                    List<String> documents = Arrays.asList(parts[5].split(";"));
                    Claim claim = new Claim(parts[0], new SimpleDateFormat("dd-MM-yyyy").parse(parts[1]), parts[2], parts[3], new SimpleDateFormat("dd-MM-yyyy").parse(parts[4]), documents, Double.parseDouble(parts[6]), parts[7], parts[8]);
                    claims.add(claim);
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return claims;
    }

    /**
     * Writes a list of Claim objects to a file.
     * @param filename :Name of the file to write.
     * @param claims :List of Claim objects to write.
     */
    public static void writeClaimsToFile(String filename, List<Claim> claims) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            writer.println("id,claimDate,insuredPerson,cardNumber,examDate,documents,claimAmount,status,receiverBankingInfo");
            for (Claim claim : claims) {
                String documentList = String.join(";", claim.getDocuments());
                String claimDate = new SimpleDateFormat("dd-MM-yyyy").format(claim.getClaimDate());
                String examDate = new SimpleDateFormat("dd-MM-yyyy").format(claim.getExamDate());
                writer.println(claim.getId() + "," + claimDate + "," + claim.getInsuredPerson() + "," + claim.getCardNumber() + "," +
                        examDate + "," + documentList + "," + claim.getClaimAmount() + "," + claim.getStatus() + "," +
                        claim.getReceiverBankingInfo());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
