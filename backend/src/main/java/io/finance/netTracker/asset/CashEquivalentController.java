package io.finance.netTracker.asset;

import io.finance.netTracker.Repository.CashEquivalentRepository;

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
public class CashEquivalentController {

  private CashEquivalentRepository cashEquivalentRepository;

  /**
   * Constructor
   *
   * @param cashEquivalentRepository
   */
  public CashEquivalentController(CashEquivalentRepository cashEquivalentRepository) {
    this.cashEquivalentRepository = cashEquivalentRepository;
  }

  @RequestMapping(value = "/retrieveCashAssets/{email}", method = {RequestMethod.GET})
  @ResponseStatus(HttpStatus.OK)
  public List<CashEquivalent> retrieveCashEquivalentAssetsByEmail(@PathVariable String email) {

    List<CashEquivalent> cashEquivalent = cashEquivalentRepository.findByEmail(email);
    return cashEquivalent;
  }

  @RequestMapping(value = "/saveCashAssets", method = {RequestMethod.POST})
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public String saveCashEquivalent(@Valid @RequestBody CashEquivalent cashEquivalent, BindingResult result) {
    if (cashEquivalent == null) {
      return null;
    }
    if (result.hasErrors()) {
      String errorMessages = "";
      for (ObjectError error : result.getAllErrors()) {
        errorMessages += error.getDefaultMessage() + "\n";
      }
    }
      saveCashEquivalentInDatabase(cashEquivalent);
    return "Cash Equivalent Saved.";
  }

  /**
   * method saveCashEquivalentInDatabase
   *
   * @param cashEquivalent
   * @return
   */
  private CashEquivalent saveCashEquivalentInDatabase(CashEquivalent cashEquivalent) {
    CashEquivalent cashEquivalent1;

    if (cashEquivalent.getEmail() == null) {
      return null;
    }

    if (cashEquivalent.getHasCashEquivalentAssets()) {
      cashEquivalent1 = CashEquivalent.hasCashEquivalentAssets(cashEquivalent.getEmail(), true, cashEquivalent.getCheckingAccount(), cashEquivalent.getSavingAccount(), cashEquivalent.getMoneyMarketAccount(),
          cashEquivalent.getSavingsBond(), cashEquivalent.getCertificateOfDeposit(), cashEquivalent.getCashValueOfLifeInsurance());
      return cashEquivalentRepository.save(cashEquivalent1);
    }
    cashEquivalent1 = CashEquivalent.hasNoCashEquivalentAssets(cashEquivalent.getEmail());
    return cashEquivalentRepository.save(cashEquivalent1);
  }
}
