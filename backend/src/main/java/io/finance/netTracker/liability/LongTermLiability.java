package io.finance.netTracker.liability;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * LongTermLiability Class
 *
 */
@Entity
@Table(name = "longTermLiability")
public class LongTermLiability {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long longTermLiabilityId;

    private String email;
    private Boolean hasLongTermLiability;
    private BigDecimal homeMortgage;
    private BigDecimal homeEquityLoan;
    private BigDecimal rentalPropertyLoan;
    private BigDecimal carLoans;
    private BigDecimal studentLoans;
    private BigDecimal lifeInsurancePolicyLoans;
    private BigDecimal otherLongTermDebt;

    /**
     * Default Constructor
     *
     */
    public LongTermLiability() {
    }

    /**
     * Constructor
     *
     * @param email
     * @param homeMortgage
     * @param homeEquityLoan
     * @param rentalPropertyLoan
     * @param carLoans
     * @param studentLoans
     * @param lifeInsurancePolicyLoans
     * @param otherLongTermDebt
     */
    public LongTermLiability(String email, Boolean hasLongTermLiability, BigDecimal homeMortgage,
                             BigDecimal homeEquityLoan,
                             BigDecimal rentalPropertyLoan,
                             BigDecimal carLoans, BigDecimal studentLoans, BigDecimal lifeInsurancePolicyLoans, BigDecimal otherLongTermDebt) {
        this.email = email;
        this.hasLongTermLiability = hasLongTermLiability;
        this.homeMortgage = homeMortgage;
        this.homeEquityLoan = homeEquityLoan;
        this.rentalPropertyLoan = rentalPropertyLoan;
        this.carLoans = carLoans;
        this.studentLoans = studentLoans;
        this.lifeInsurancePolicyLoans = lifeInsurancePolicyLoans;
        this.otherLongTermDebt = otherLongTermDebt;
    }

    /**
     * method hasNoLongTermLiability
     *
     * @param email
     * @return
     */
    public LongTermLiability hasNoLongTermLiability(String email) {
        return new LongTermLiability(email, false, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
    }

    /**
     * method hasLongTermLiability
     *
     * @param email
     * @param homeMortgage
     * @param homeEquityLoan
     * @param rentalPropertyLoan
     * @param carLoans
     * @param studentLoans
     * @param lifeInsurancePolicyLoans
     * @param otherLongTermDebt
     * @return
     */
    public LongTermLiability hasLongTermLiability(String email,BigDecimal homeMortgage, BigDecimal homeEquityLoan, BigDecimal rentalPropertyLoan, BigDecimal carLoans, BigDecimal studentLoans,
                                                  BigDecimal lifeInsurancePolicyLoans, BigDecimal otherLongTermDebt) {
        return new LongTermLiability(email, true, homeMortgage, homeEquityLoan, rentalPropertyLoan, carLoans, studentLoans,
                lifeInsurancePolicyLoans, otherLongTermDebt);
    }

    public Long getLongTermLiabilityId() {
        return longTermLiabilityId;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getHasLongTermLiability() {
        return hasLongTermLiability;
    }

    public BigDecimal getHomeMortgage() {
        return homeMortgage;
    }

    public BigDecimal getHomeEquityLoan() {
        return homeEquityLoan;
    }

    public BigDecimal getRentalPropertyLoan() {
        return rentalPropertyLoan;
    }

    public BigDecimal getCarLoans() {
        return carLoans;
    }

    public BigDecimal getStudentLoans() {
        return studentLoans;
    }

    public BigDecimal getLifeInsurancePolicyLoans() {
        return lifeInsurancePolicyLoans;
    }

    public BigDecimal getOtherLongTermDebt() {
        return otherLongTermDebt;
    }
}
