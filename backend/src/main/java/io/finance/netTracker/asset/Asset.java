package io.finance.netTracker.asset;

import java.util.ArrayList;
import javax.validation.Valid;

import io.finance.netTracker.Repository.UserRespository;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Asset Class to hold all assets
 */

@RestController
public class Asset {

  private CashEquivalentController cashEquivalentController;
  private InvestAssetController investAssetController;
  private PersonalAssetController personalAssetController;
  private UserRespository userRespository;

  /**
   * Constructor
   *
   * @param cashEquivalentController
   * @param investAssetController
   * @param personalAssetController
   * @param userRespository
   */
  public Asset(CashEquivalentController cashEquivalentController, InvestAssetController investAssetController, PersonalAssetController personalAssetController, UserRespository userRespository) {
    this.cashEquivalentController = cashEquivalentController;
    this.investAssetController = investAssetController;
    this.personalAssetController = personalAssetController;
    this.userRespository = userRespository;
  }

  @RequestMapping(value = "/retrieveAllAssets", method = {RequestMethod.POST})
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public AssetResponse retrieveAllAssets(@Valid @RequestBody AssetRequest assetRequest, BindingResult result) {
    AssetResponse assetResponse = new AssetResponse();

    if (assetRequest == null) {
      return null;
    }

    if (result.hasErrors()) {
      String errorMessages = "";
      for (ObjectError error : result.getAllErrors()) {
        errorMessages += error.getDefaultMessage() + "\n";
      }
    }

    if (!userRespository.existsUserByEmail(assetRequest.getEmail())) {
      return null;
    }

    if (assetRequest.getHasCashEquivalentAssets()) {
      assetResponse.cashEquivalentList = cashEquivalentController.retrieveCashEquivalentAssetsByEmail(assetRequest.getEmail());
    } else {
      assetResponse.cashEquivalentList = new ArrayList<CashEquivalent>();
    }

    if (assetRequest.getHasTaxableAccount() || assetRequest.getHasRetirementAccount() ||
        assetRequest.getHasBusinessOwnershipInterest()) {
      assetResponse.investAssetList = investAssetController.retrieveInvestAssetsById(assetRequest.getEmail());
    } else {
      assetResponse.investAssetList = new ArrayList<InvestAsset>();
    }

    if (assetRequest.getHasPersonalAsset()) {
      assetResponse.personalAssetList = personalAssetController.retrievePersonalAssetsById(assetRequest.getEmail());
    } else {
      assetResponse.personalAssetList = new ArrayList<PersonalAsset>();
    }

    return assetResponse;
  }
}
