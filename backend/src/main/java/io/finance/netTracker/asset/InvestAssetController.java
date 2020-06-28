package io.finance.netTracker.asset;

import io.finance.netTracker.Repository.InvestAssetRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class InvestAssetController {

    private InvestAssetRepository investAssetRepository;

    /**
     * Constructor
     *
     * @param investAssetRepository
     */
    public InvestAssetController(InvestAssetRepository investAssetRepository) {
        this.investAssetRepository = investAssetRepository;
    }

    @RequestMapping(value = "/retrieveInvestAssets/{id}", method = {RequestMethod.GET})
    @ResponseStatus(HttpStatus.OK)
    public List<InvestAsset> retrieveInvestAssetsById(@PathVariable String email) {
        List<InvestAsset> investAsset = investAssetRepository.findByEmail(email);
        return investAsset;
    }

    @RequestMapping(value = "/saveInvestAssets", method = {RequestMethod.POST})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String saveInvestAssets(@Valid @RequestBody InvestAsset investAsset, BindingResult result) {
        if (investAsset == null) {
            return null;
        }
        if (result.hasErrors()) {
            String errorMessages = "";
            for (ObjectError error : result.getAllErrors()) {
                errorMessages += error.getDefaultMessage() + "\n";
            }
        }
        saveInvestAssetsInDatabase(investAsset);
        return "Invest Assets Saved.";
    }

    /**
     * method saveInvestAssetsInDatabase
     *
     * @param investAsset
     * @return
     */
    private InvestAsset saveInvestAssetsInDatabase(InvestAsset investAsset) {
        InvestAsset investAsset1;

        if (investAsset.getEmail() == null) {
            return null;
        }

        if (investAsset.isHasTaxableAccount()) {
            investAsset1 = InvestAsset.hasOnlyTaxableAccounts(investAsset.getEmail(), investAsset.isHasTaxableAccount(), investAsset.getBrokerageAccount(),
                    investAsset.getOtherTaxableAccount());
            return investAssetRepository.save(investAsset1);
        }

        if (investAsset.isHasRetirementAccount()) {
            investAsset1 = InvestAsset.hasOnlyRetirementAccounts(investAsset.getEmail(), investAsset.isHasRetirementAccount(), investAsset.getIraAccount(),
                    investAsset.getRothAccount(), investAsset.getFourZeroOne(), investAsset.getSepIra(),
                    investAsset.getQualifiedPlans(), investAsset.getPension(), investAsset.getAnnuity());
            return investAssetRepository.save(investAsset1);
        }
        investAsset1 = InvestAsset.hasOnlyBusinessOwnershipInterest(investAsset.getEmail(), investAsset.isHasBusinessOwnershipInterest(),
                investAsset.getRealEstate(), investAsset.getSoleProprietorship(), investAsset.getPartnership(),
                investAsset.getcCorp(), investAsset.getsCorp(), investAsset.getLimitedLiability(),
                investAsset.getOtherOwnership());
        return investAssetRepository.save(investAsset1);
    }
}
