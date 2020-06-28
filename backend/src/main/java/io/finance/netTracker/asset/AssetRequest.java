package io.finance.netTracker.asset;

/**
 * AssetRequest Class
 */
public class AssetRequest {

  private String email;
  private Boolean hasCashEquivalentAssets;
  private Boolean hasTaxableAccount;
  private Boolean hasRetirementAccount;
  private Boolean hasBusinessOwnershipInterest;
  private Boolean hasPersonalAsset;

  /**
   * Default Constructor
   */
  public AssetRequest() {
  }

  /**
   * Constructor
   *
   * @param email
   * @param hasCashEquivalentAssets
   * @param hasTaxableAccount
   * @param hasRetirementAccount
   * @param hasBusinessOwnnershipInterest
   * @param hasPersonalAsset
   */
  public AssetRequest(String email, Boolean hasCashEquivalentAssets, Boolean hasTaxableAccount,
      Boolean hasRetirementAccount, Boolean hasBusinessOwnnershipInterest,
      Boolean hasPersonalAsset) {
    this.email = email;
    this.hasCashEquivalentAssets = hasCashEquivalentAssets;
    this.hasTaxableAccount = hasTaxableAccount;
    this.hasRetirementAccount = hasRetirementAccount;
    this.hasBusinessOwnershipInterest = hasBusinessOwnnershipInterest;
    this.hasPersonalAsset = hasPersonalAsset;
  }

  public String getEmail() {
    return email;
  }

  public Boolean getHasCashEquivalentAssets() {
    return hasCashEquivalentAssets;
  }

  public Boolean getHasTaxableAccount() {
    return hasTaxableAccount;
  }

  public Boolean getHasRetirementAccount() {
    return hasRetirementAccount;
  }

  public Boolean getHasBusinessOwnershipInterest() {
    return hasBusinessOwnershipInterest;
  }

  public Boolean getHasPersonalAsset() {
    return hasPersonalAsset;
  }
}
