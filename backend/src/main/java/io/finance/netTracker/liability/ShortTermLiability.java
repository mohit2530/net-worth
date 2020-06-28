package io.finance.netTracker.liability;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * ShortTermLiability Class
 *
 */
@Entity
@Table(name = "shortTermLiability")
public class ShortTermLiability {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long shortTermLiabilityId;

    private String email;
    private Boolean hasShortTermLiability;
    private BigDecimal creditCardBalances;
    private BigDecimal estimatedIncomeTax;
    private BigDecimal otherOutstandingBills;

    /**
     * Default Constructor
     */
    public ShortTermLiability() {
    }

    /**
     * Constructor
     *
     * @param creditCardBalances
     * @param estimatedIncomeTax
     * @param otherOutstandingBills
     */
    public ShortTermLiability(String email, Boolean hasShortTermLiability, BigDecimal creditCardBalances,
                             BigDecimal estimatedIncomeTax,
                             BigDecimal otherOutstandingBills) {
        this.email = email;
        this.hasShortTermLiability = hasShortTermLiability;
        this.creditCardBalances = creditCardBalances;
        this.estimatedIncomeTax = estimatedIncomeTax;
        this.otherOutstandingBills = otherOutstandingBills;
    }

    /**
     * method hasNoShortTermLiability
     *
     * @param email
     * @return
     */
    public ShortTermLiability hasNoShortTermLiability(String email) {
        return new ShortTermLiability(email, false, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
    }

    /**
     * method hasShortTermLiability
     *
     * @param email
     * @param creditCardBalances
     * @param estimatedIncomeTax
     * @param otherOutstandingBills
     * @return
     */
    public ShortTermLiability hasShortTermLiability(String email, BigDecimal creditCardBalances,
                                                   BigDecimal estimatedIncomeTax, BigDecimal otherOutstandingBills) {
        return new ShortTermLiability(email, true, creditCardBalances, estimatedIncomeTax, otherOutstandingBills);
    }


    public Long getShortTermLiabilityId() {
        return shortTermLiabilityId;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getHasShortTermLiability() {
        return hasShortTermLiability;
    }

    public BigDecimal getCreditCardBalances() {
        return creditCardBalances;
    }

    public BigDecimal getEstimatedIncomeTax() {
        return estimatedIncomeTax;
    }

    public BigDecimal getOtherOutstandingBills() {
        return otherOutstandingBills;
    }
}
