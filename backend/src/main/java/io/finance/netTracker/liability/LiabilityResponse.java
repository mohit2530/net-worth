package io.finance.netTracker.liability;

import java.util.List;

/**
 * LiabilityResponse Class
 */
public class LiabilityResponse {

  List<ShortTermLiability> shortTermLiabilityList;
  List<LongTermLiability> longTermLiabilityList;

  /**
   * Default Constructor
   *
   */
  public LiabilityResponse() {
  }

  /**
   * Constructor
   *
   * @param shortTermLiabilityList
   * @param longTermLiabilityList
   */
  public LiabilityResponse(
      List<ShortTermLiability> shortTermLiabilityList,
      List<LongTermLiability> longTermLiabilityList) {
    this.shortTermLiabilityList = shortTermLiabilityList;
    this.longTermLiabilityList = longTermLiabilityList;
  }

  public List<ShortTermLiability> getShortTermLiabilityList() {
    return shortTermLiabilityList;
  }

  public List<LongTermLiability> getLongTermLiabilityList() {
    return longTermLiabilityList;
  }
}
