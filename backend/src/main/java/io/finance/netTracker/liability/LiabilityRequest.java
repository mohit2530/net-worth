package io.finance.netTracker.liability;

public class LiabilityRequest {

  private String email;
  private Boolean hasLongTermLiability;
  private Boolean hasShortTermLiability;

  /**
   * Default Constructor
   */
  public LiabilityRequest() {
  }

  /**
   * Constructor
   *
   * @param email
   * @param hasLongTermLiability
   * @param hasShortTermLiability
   */
  public LiabilityRequest(String email, Boolean hasLongTermLiability,
      Boolean hasShortTermLiability) {
    this.email = email;
    this.hasLongTermLiability = hasLongTermLiability;
    this.hasShortTermLiability = hasShortTermLiability;
  }

  public String getEmail() {
    return email;
  }

  public Boolean getHasLongTermLiability() {
    return hasLongTermLiability;
  }

  public Boolean getHasShortTermLiability() {
    return hasShortTermLiability;
  }
}
