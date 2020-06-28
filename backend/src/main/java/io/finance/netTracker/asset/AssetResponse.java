package io.finance.netTracker.asset;

import java.util.List;

/**
 * AssetResponse Class
 */
public class AssetResponse {

  List<CashEquivalent> cashEquivalentList;
  List<InvestAsset> investAssetList;
  List<PersonalAsset> personalAssetList;

  /**
   * Default Constructor
   */
  public AssetResponse() {
  }

  /**
   * Constructor
   *
   * @param cashEquivalentList
   * @param investAssetList
   * @param personalAssetList
   */
  public AssetResponse(List<CashEquivalent> cashEquivalentList,
      List<InvestAsset> investAssetList,
      List<PersonalAsset> personalAssetList) {
    this.cashEquivalentList = cashEquivalentList;
    this.investAssetList = investAssetList;
    this.personalAssetList = personalAssetList;
  }

  public List<CashEquivalent> getCashEquivalentList() {
    return cashEquivalentList;
  }

  public List<InvestAsset> getInvestAssetList() {
    return investAssetList;
  }

  public List<PersonalAsset> getPersonalAssetList() {
    return personalAssetList;
  }
}
