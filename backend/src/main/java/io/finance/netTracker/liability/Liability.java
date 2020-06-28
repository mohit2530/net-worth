package io.finance.netTracker.liability;

import io.finance.netTracker.Repository.UserRespository;
import java.util.ArrayList;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Liability Class to hold all liabilities
 */
public class Liability {

  private UserRespository userRespository;
  private ShortTermLiabilityController shortTermLiabilityController;
  private LongTermLiabilityController longTermLiabilityController;

  /**
   * Constructor
   *
   * @param userRespository
   * @param shortTermLiabilityController
   * @param longTermLiabilityController
   */
  public Liability(UserRespository userRespository,
      ShortTermLiabilityController shortTermLiabilityController,
      LongTermLiabilityController longTermLiabilityController) {
    this.userRespository = userRespository;
    this.shortTermLiabilityController = shortTermLiabilityController;
    this.longTermLiabilityController = longTermLiabilityController;
  }

  @RequestMapping(value = "/retrieveAllLiability", method = {RequestMethod.POST})
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public LiabilityResponse retrieveAllLiabilities(@Valid @RequestBody LiabilityRequest liabilityRequest, BindingResult result) {
    LiabilityResponse liabilityResponse = new LiabilityResponse();

    if (liabilityResponse == null) {
      return null;
    }
    if (result.hasErrors()) {
      String errorMessages = "";
      for (ObjectError error : result.getAllErrors()) {
        errorMessages += error.getDefaultMessage() + '\n';
      }
    }

    if (!userRespository.existsUserByEmail(liabilityRequest.getEmail())) {
      return null;
    }

    if (liabilityRequest.getHasLongTermLiability()) {
      liabilityResponse.longTermLiabilityList = longTermLiabilityController.retrieveLongTermLiabilityByEmail(liabilityRequest.getEmail());
    } else {
      liabilityResponse.longTermLiabilityList = new ArrayList<LongTermLiability>(null);
    }

    if (liabilityRequest.getHasShortTermLiability()) {
      liabilityResponse.shortTermLiabilityList = shortTermLiabilityController.retrieveShortTermLiabilityByEmail(liabilityRequest.getEmail());
    } else {
      liabilityResponse.shortTermLiabilityList = new ArrayList<ShortTermLiability>(null);
    }
    return liabilityResponse;
  }
}
