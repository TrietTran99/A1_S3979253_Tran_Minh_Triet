//Imports
import java.util.ArrayList;
import java.util.List;

/**
 * This will be the logic stored for implementation
 * @author <Tran Minh Triet - s3979253>
 */


public class ClaimProcessManagerImplement1 implements ClaimProcessManager{
    //private the list of claims
    private List<Claim> claims;

    //object claim to new arraylist
    public ClaimProcessManagerImplement1() {
        this.claims = new ArrayList<>();
    }

    public void add(Claim claim) {
        claims.add(claim);
    }

    public void update(Claim claim) {
        //Find the claim with the specific same ID and update the claim
        for (int i = 0; i < claims.size(); i++) {
            if (claims.get(i).getId().equals(claim.getId())) {
                claims.set(i, claim);
                return;
            }
        }
    }

    public void delete(String claimId) {
        //Find and remove the specific claim with the specific ID entered
        claims.removeIf(claim -> claim.getId().equals(claimId));
    }

    public Claim getOne(String claimId) {
        //Find and return the specific claim with the specific ID entered
        for (Claim claim : claims) {
            if (claim.getId().equals(claimId)) {
                return claim;
            }
        }
        return null; //In the case claim is not found
    }

    public List<Claim> getAll() {
        //Return all the claims
        return new ArrayList<>(claims);
    }
}
