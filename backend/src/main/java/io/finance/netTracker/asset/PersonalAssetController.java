package io.finance.netTracker.asset;

import io.finance.netTracker.Repository.PersonalAssetRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonalAssetController {

  private PersonalAssetRepository personalAssetRepository;

  /**
   * Constructor
   *
   * @param personalAssetRepository
   */
  public PersonalAssetController(
      PersonalAssetRepository personalAssetRepository) {
    this.personalAssetRepository = personalAssetRepository;
  }

  @RequestMapping(value = "/retrievePersonalAssets/{id}", method = {RequestMethod.POST})
  @ResponseStatus(HttpStatus.OK)
  public List<PersonalAsset> retrievePersonalAssetsById(@PathVariable String email) {
    List<PersonalAsset> personalAsset = personalAssetRepository.findByEmail(email);
    return personalAsset;
  }

  @RequestMapping(value = "/savePersonalAssets", method = {RequestMethod.POST})
  @ResponseStatus(HttpStatus.CREATED)
  @ResponseBody
  public String savePersonalAssets(@Valid @RequestBody PersonalAsset personalAsset, BindingResult result) {
    if (personalAsset == null) {
      return null;
    }
    if (result.hasErrors()) {
      String errorMessages = "";
      for (ObjectError error : result.getAllErrors()) {
        errorMessages += error.getDefaultMessage() + "\n";
      }
    }
    savePersonalAssetsInDatabase(personalAsset);
    return "Personal Assets Saved. ";
  }

  /**
   * method savePersonalAssetsInDatabase
   *
   * @param personalAsset
   * @return
   */
  private PersonalAsset savePersonalAssetsInDatabase(PersonalAsset personalAsset){
    PersonalAsset personalAsset1;

    if (personalAsset.getEmail() == null) {
      return null;
    }

    if (personalAsset.getHasPersonalAsset()) {
      personalAsset1 = PersonalAsset.hasPersonalAssets(personalAsset.getEmail(), personalAsset.getPrincipalValue(), personalAsset.getVacationHome(), personalAsset.getCarsTrucksBoats(), personalAsset.getHomeFurnishing(),
          personalAsset.getArtsAndAntiques(), personalAsset.getJeweleryFurs(), personalAsset.getOtherAssets());
          return personalAssetRepository.save(personalAsset1);
    };
    personalAsset1 = PersonalAsset.hasNoPersonalAssets(personalAsset.getEmail());
    return personalAssetRepository.save(personalAsset1);
  }
}
