package io.finance.netTracker.liability;

import io.finance.netTracker.Repository.ShortTermLiabilityRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * ShortTermLiabilityController
 */
@RestController
public class ShortTermLiabilityController {

    private ShortTermLiabilityRepository shortTermLiabilityRepository;

    /**
     * Constructor
     *
     * @param shortTermLiabilityRepository
     */
    public ShortTermLiabilityController(ShortTermLiabilityRepository shortTermLiabilityRepository) {
        this.shortTermLiabilityRepository = shortTermLiabilityRepository;
    }

    @RequestMapping(value = "/retrieveShortTermLiability/{email}", method = {RequestMethod.GET})
    @ResponseStatus(HttpStatus.OK)
    public List<ShortTermLiability> retrieveShortTermLiabilityByEmail(@PathVariable String email) {
        List<ShortTermLiability> shortTermLiability = shortTermLiabilityRepository.findByEmail(email);
        return shortTermLiability;
    }

    @RequestMapping(value = "/saveShortTermLiability", method = {RequestMethod.POST})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String saveShortTermLiability(@Valid @RequestBody ShortTermLiability shortTermLiability,
                                         BindingResult result) {
        if (shortTermLiability == null) {
            return null;
        }
        if (result.hasErrors()) {
            String errorMessages = "";
            for (ObjectError error : result.getAllErrors()) {
                errorMessages += error.getDefaultMessage() + "\n";
            }
        }
        saveShortTermLiabilityInDatabase(shortTermLiability);
        return "Short Term Liability Saved.";
    }

    /**
     * method saveShortTermLiabilityInDatabase
     *
     * @param shortTermLiability
     * @return
     */
    private ShortTermLiability saveShortTermLiabilityInDatabase(
        ShortTermLiability shortTermLiability) {
        ShortTermLiability shortTermLiability1;

        if (shortTermLiability.getEmail() == null) {
            return null;
        }

        if (shortTermLiability.getHasShortTermLiability()) {
            shortTermLiability1 = shortTermLiability.hasShortTermLiability(shortTermLiability.getEmail(),
                    shortTermLiability.getCreditCardBalances(), shortTermLiability.getEstimatedIncomeTax(),
                    shortTermLiability.getOtherOutstandingBills());
            return shortTermLiabilityRepository.save(shortTermLiability1);
        }
        shortTermLiability1 = shortTermLiability.hasNoShortTermLiability(shortTermLiability.getEmail());
        return shortTermLiabilityRepository.save(shortTermLiability1);
    }
}
