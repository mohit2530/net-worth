package io.finance.netTracker.liability;

import io.finance.netTracker.Repository.LongTermLiabilityRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * LongTermLiabilityController
 *
 */
@RestController
public class LongTermLiabilityController {

    private LongTermLiabilityRepository longTermLiabilityRepository;

    /**
     * Constructor
     *
     * @param longTermLiabilityRepository
     */
    public LongTermLiabilityController(LongTermLiabilityRepository longTermLiabilityRepository) {
        this.longTermLiabilityRepository = longTermLiabilityRepository;
    }

    @RequestMapping(value = "/retrieveLongTermLiability/{email}", method = {RequestMethod.GET})
    @ResponseStatus(HttpStatus.OK)
    public List<LongTermLiability> retrieveLongTermLiabilityByEmail(@PathVariable String email) {
        List<LongTermLiability> longTermLiability = longTermLiabilityRepository.findByEmail(email);
        return longTermLiability;
    }

    @RequestMapping(value = "/saveLongTermLiability", method = {RequestMethod.POST})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String saveLongTermLiability(@Valid @RequestBody LongTermLiability longTermLiability, BindingResult result) {
        if (longTermLiability == null) {
            return null;
        }
        if (result.hasErrors()) {
            String errorMessages = "";
            for (ObjectError error : result.getAllErrors()) {
                errorMessages += error.getDefaultMessage() + "\n";
            }
        }
        saveLongTermLiabilityInDatabase(longTermLiability);
        return "Long Term Liability Saved.";
    }

    /**
     * method saveLongTermLiabilityInDatabase
     *
     * @param longTermLiability
     * @return
     */
    private LongTermLiability saveLongTermLiabilityInDatabase(LongTermLiability longTermLiability) {
        LongTermLiability longTermLiability1;

        if (longTermLiability.getEmail() == null) {
            return null;
        }

        if (longTermLiability.getHasLongTermLiability()) {
            longTermLiability1 = longTermLiability.hasLongTermLiability(longTermLiability.getEmail(),
                    longTermLiability.getHomeMortgage(), longTermLiability.getHomeEquityLoan(),
                    longTermLiability.getRentalPropertyLoan(), longTermLiability.getCarLoans(),
                    longTermLiability.getStudentLoans(), longTermLiability.getLifeInsurancePolicyLoans(),
                    longTermLiability.getOtherLongTermDebt());
            return longTermLiabilityRepository.save(longTermLiability1);
        }
        longTermLiability1 = longTermLiability.hasNoLongTermLiability(longTermLiability.getEmail());
        return longTermLiabilityRepository.save(longTermLiability1);
    }
}
