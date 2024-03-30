//Import
import java.util.List;

/**
 * The interface to manage insurance claims.
 * @author <Tran Minh Triet - s3979253>
 */

public interface ClaimProcessManager {
    /**
     * Add a claim to the insurance system.
     * @param claim :Claim to be added.
     */
    void add(Claim claim);

    /**
     * Updates an existing claim in the insurance system.
     * @param claim :THe claim to be updated.
     */
    void update(Claim claim);

    /**
     * Deletes a claim from the insurance system based on the ID.
     * @param claimId :ID of the claim to be deleted.
     */
    void delete(String claimId);

    /**
     * Retrieves a single claim from the insurance system based on the ID.
     * @param claimId :ID of the claim to be retrieved.
     * @return Claim with the specified ID, or null if the ID is not found.
     */
    Claim getOne(String claimId);

    /**
     * Retrieves all of the claims in the insurance system.
     * @return A list of all of the claims in the system.
     */
    List<Claim> getAll();
}
