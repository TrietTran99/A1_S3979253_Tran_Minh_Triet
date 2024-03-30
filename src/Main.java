//Imports
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * This will be the User Interface (UI) for the user.
 * @author <Tran Minh Triet - s3979253>
 */

public class Main {
    private ClaimProcessManager claimProcessManager;
    private Scanner scanner;

    public Main(ClaimProcessManager claimProcessManager) {
        this.claimProcessManager = claimProcessManager;
        this.scanner = new Scanner(System.in);
    }

    //Interface of the insurance system
    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("        | Tran Minh Triet - s3979253 |          ");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("-----------*** Hello fellow User ***------------");
            System.out.println("Welcome to the Insurance Claim Management System");
            System.out.println("================================================");
            System.out.println("_______________ 1. Add Claim ___________________");
            System.out.println("______________ 2. Update Claim _________________");
            System.out.println("______________ 3. Delete Claim _________________");
            System.out.println("_______________ 4. View Claim __________________");
            System.out.println("__________________ 5. Exit _____________________");
            System.out.println("================================================");
            System.out.println("Enter your Choice (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); //Consume the newline character

            switch (choice) {
                case 1:
                    addClaim();
                    break;
                case 2:
                    updateClaim();
                    break;
                case 3:
                    deleteClaim();
                    break;
                case 4:
                    viewClaims();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please re-enter a number from 1 and 5");
            }
        }
    }

    private void addClaim() {
        // Adding a new claim message
        System.out.println("Adding a new claim...");

        //Enter Claim ID
        System.out.print("Enter claim ID (e.g. CL001): ");
        String id = scanner.nextLine();

        //Enter Claim Date - [parsing it make sure the data enter is a Date]
        System.out.print("Enter claim date (YYYY-MM-DD): ");
        String claimDateString = scanner.nextLine();
        Date claimDate = parseDate(claimDateString);

        //Enter Insured Person
        System.out.print("Enter insured person (e.g Tran Minh Triet): ");
        String insuredPerson = scanner.nextLine();

        //Enter Card Number
        System.out.print("Enter card number: ");
        String cardNumber = scanner.nextLine();

        //Enter Exam Date
        System.out.print("Enter exam date (YYYY-MM-DD): ");
        String examDateString = scanner.nextLine();
        Date examDate = parseDate(examDateString);

        //Enter documents adds
        List<String> documents = new ArrayList<>();
        System.out.println("Enter documents (press Enter after each document, type 'finish' when finished):");
        String document;
        while (true) {
            document = scanner.nextLine();
            if (document.equals("finish")) {
                break;
            }
            documents.add(document);
        }

        //Enter Claim amount
        System.out.print("Enter claim amount: ");
        double claimAmount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character

        //Enter Claim status
        System.out.print("Enter claim status (New, Processing, Finish): ");
        String status = scanner.nextLine();

        //Enter reciever banking info
        System.out.print("Enter receiver banking info: ");
        String receiverBankingInfo = scanner.nextLine();

        // Create a new Claim object with the gathered information
        Claim claim = new Claim(id, claimDate, insuredPerson, cardNumber, examDate, documents, claimAmount, status, receiverBankingInfo);

        // Add the claim to the ClaimProcessManager
        claimProcessManager.add(claim);

        System.out.println("Claim added successfully!");
    }

    //Resolving the parseDate problem
    private Date parseDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use YYYY-MM-DD format.");
            return null;
        }
    }

    private void updateClaim() {
        //Updating a claim
        System.out.print("Updating a claim...");

        //Enter the ID of claim for update
        System.out.print("Enter the ID of the claim for update: ");
        String idToUpdate = scanner.nextLine();

        //Find the claim of the specific entered ID above.
        Claim claimToUpdate = claimProcessManager.getOne(idToUpdate);
        if (claimToUpdate == null) {
            System.out.println("Error: Claim not found.");
            return;
        }

        //Tell the user they have to update the claim information
        System.out.print("Enter new claim date (YYYY-MM-DD): ");
        String newClaimDateString = scanner.nextLine();
        Date newClaimDate = parseDate(newClaimDateString);
        if (newClaimDate != null) {
            claimToUpdate.setClaimDate(newClaimDate);
        }

        //Ask User: Enter new insured person
        System.out.print("Enter new insured person (Jason Tran): ");
        String newInsuredPerson = scanner.nextLine();
        claimToUpdate.setInsuredPerson(newInsuredPerson);

        //Ask User: Enter new card number
        String newCardNumber = scanner.nextLine();
        claimToUpdate.setCardNumber(newCardNumber);

        //Ask User: Enter new exam date
        System.out.print("Enter new exam date (YYYY-MM-DD): ");
        String newExamDateString = scanner.nextLine();
        Date newExamDate = parseDate(newExamDateString);
        if (newExamDate != null) {
            claimToUpdate.setExamDate(newExamDate);
        }

        //Ask User: Enter new documents
        System.out.println("Enter new documents (press Enter after each document, type 'finish' when finished): ");
        List<String> newDocuments = new ArrayList<>();
        String newDocument;
        while (true) {
            newDocument = scanner.nextLine();
            if (newDocument.equals("finish")) {
                break;
            }
            newDocuments.add(newDocument);
        }
        claimToUpdate.setDocuments(newDocuments);

        //Ask User: Enter new claim amount
        System.out.print("Enter new claim amount: ");
        double newClaimAmount = scanner.nextDouble();
        scanner.nextLine(); //Consume the new line character
        claimToUpdate.setClaimAmount(newClaimAmount);

        //Ask User: Enter new claim status
        System.out.print("Enter new claim status (New, Processing, Finish): ");
        String newStatus = scanner.nextLine();
        claimToUpdate.setStatus(newStatus);

        //Ask User: Enter new receiver banking info
        System.out.print("Enter new receiver banking info: ");
        String newReceiverBankingInfo = scanner.nextLine();
        claimToUpdate.setReceiverBankingInfo(newReceiverBankingInfo);

        //Update claim in the ClaimProcessManager
        claimProcessManager.update(claimToUpdate);

        //Message to notify that claim has been updated success.
        System.out.println("Claim updated successfully!");
    }

    private void deleteClaim() {
        //Message for deleting a claim
        System.out.println("Deleting a claim...");
        System.out.print("Enter the ID of the claim to be deleted: ");
        String idToDelete = scanner.nextLine();

        //Find the claim with the specific entered ID
        Claim claimToDelete = claimProcessManager.getOne(idToDelete);
        if(claimToDelete == null) {
            System.out.println("Error: Claim not found");
            return;
        }

        System.out.println("*Confirmation Message*");
        System.out.println("Are you sure you want to delete this claim, forever? (yes/no)");
        String confirmation = scanner.nextLine();
        if (confirmation.equalsIgnoreCase("yes")) {
            //Process to delete claim from ClaimProcessManager
            claimProcessManager.delete(idToDelete);
            System.out.println("Claim has been deleted successfully");
        } else {
            System.out.println("Deletion has been canceled.");
        }

    }

    private void viewClaims() {
        //Message processing viewing
        System.out.println("Viewing all claims...");
        List<Claim> allClaims = claimProcessManager.getAll();
        if (allClaims.isEmpty()) {
            System.out.println("No claims has been found.");
        } else {
            /**
             * These are the headers that the User have entered the data in.
             * The order that will be printed will be the same as the order the user entered respectively.
             * _____
             * Note: The data and the headers may not align with each other, please excuse that matter.
             *       I have recognized the problem and can't seem to find a way to fix this specific problem.
             */
            System.out.println("ID\tClaim Date\tInsured Person\tCard Number\tExam Date\tClaim Amount\tStatus\tReceiver Banking Info");
            for (Claim claim : allClaims) {
                System.out.println(claim.getId() + "\t" + claim.getClaimDate() + "\t" + claim.getInsuredPerson() + "\t" +
                        claim.getCardNumber() + "\t" + claim.getExamDate() + "\t" + claim.getClaimAmount() + "\t" +
                        claim.getStatus() + "\t" + claim.getReceiverBankingInfo());
            }
        }
    }

    public static void main(String[] args) {
        ClaimProcessManager claimProcessManager = (ClaimProcessManager) new ClaimProcessManagerImplement1();

        //Initialize the Main with ClaimProcessManager
        Main main = new Main(claimProcessManager);

        //Start the application
        main.start();
    }




}