package io.finance.netTracker.asset;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * InvestAsset Class
 */

@Entity
@Table(name = "investAsset")
public class InvestAsset {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long investAssetId;

    private String email;
    private boolean hasTaxableAccount;
    private boolean hasRetirementAccount;
    private boolean hasBusinessOwnershipInterest;

    private BigDecimal brokerageAccount;
    private BigDecimal otherTaxableAccount;

    private BigDecimal iraAccount;
    private BigDecimal rothAccount;
    private BigDecimal fourZeroOne;
    private BigDecimal sepIra;
    private BigDecimal qualifiedPlans;
    private BigDecimal pension;
    private BigDecimal annuity;

    private BigDecimal realEstate;
    private BigDecimal soleProprietorship;
    private BigDecimal partnership;
    private BigDecimal cCorp;
    private BigDecimal sCorp;
    private BigDecimal limitedLiability;
    private BigDecimal otherOwnership;

    /**
     * Default Constructor
     */
    public InvestAsset() {
    }

    /**
     * Constructor
     *
     * @param email
     * @param hasTaxableAccount
     * @param hasRetirementAccount
     * @param hasBusinessOwnershipInterest
     * @param brokerageAccount
     * @param otherTaxableAccount
     * @param iraAccount
     * @param rothAccount
     * @param fourZeroOne
     * @param sepIra
     * @param qualifiedPlans
     * @param pension
     * @param annuity
     * @param realEstate
     * @param soleProprietorship
     * @param partnership
     * @param cCorp
     * @param sCorp
     * @param limitedLiability
     * @param otherOwnership
     */
    public InvestAsset(String email, boolean hasTaxableAccount, boolean hasRetirementAccount,
        boolean hasBusinessOwnershipInterest, BigDecimal brokerageAccount,
        BigDecimal otherTaxableAccount, BigDecimal iraAccount, BigDecimal rothAccount,
        BigDecimal fourZeroOne, BigDecimal sepIra, BigDecimal qualifiedPlans,
        BigDecimal pension, BigDecimal annuity, BigDecimal realEstate,
        BigDecimal soleProprietorship, BigDecimal partnership, BigDecimal cCorp,
        BigDecimal sCorp, BigDecimal limitedLiability, BigDecimal otherOwnership) {
        this.email = email;
        this.hasTaxableAccount = hasTaxableAccount;
        this.hasRetirementAccount = hasRetirementAccount;
        this.hasBusinessOwnershipInterest = hasBusinessOwnershipInterest;
        this.brokerageAccount = brokerageAccount;
        this.otherTaxableAccount = otherTaxableAccount;
        this.iraAccount = iraAccount;
        this.rothAccount = rothAccount;
        this.fourZeroOne = fourZeroOne;
        this.sepIra = sepIra;
        this.qualifiedPlans = qualifiedPlans;
        this.pension = pension;
        this.annuity = annuity;
        this.realEstate = realEstate;
        this.soleProprietorship = soleProprietorship;
        this.partnership = partnership;
        this.cCorp = cCorp;
        this.sCorp = sCorp;
        this.limitedLiability = limitedLiability;
        this.otherOwnership = otherOwnership;
    }

    /**
     * method hasOnlyTaxableAccount
     *
     * @param hasTaxableAccount
     * @param brokerageAccount
     * @param otherTaxableAccount
     * @return
     */
    public static InvestAsset hasOnlyTaxableAccounts(String email, Boolean hasTaxableAccount, BigDecimal brokerageAccount,
                                                     BigDecimal otherTaxableAccount ) {
        return new InvestAsset(email, hasTaxableAccount, false, false, brokerageAccount, otherTaxableAccount,
                BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO,
                BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
    }


    /**
     * method hasOnlyRetirementAccount
     *
     * @param hasRetirementAccount
     * @param iraAccount
     * @param rothAccount
     * @param fourZeroOne
     * @param sepIra
     * @param qualifiedPlans
     * @param pension
     * @param annuity
     * @return
     */
    public static InvestAsset hasOnlyRetirementAccounts(String email, Boolean hasRetirementAccount, BigDecimal iraAccount, BigDecimal rothAccount, BigDecimal fourZeroOne, BigDecimal sepIra,
                                                        BigDecimal qualifiedPlans, BigDecimal pension, BigDecimal annuity) {
        return new InvestAsset(email, false, hasRetirementAccount, false, BigDecimal.ZERO, BigDecimal.ZERO,
                iraAccount, rothAccount, fourZeroOne, sepIra, qualifiedPlans, pension, annuity, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO,
                BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
    }


    /**
     * method hasOnlyBusinessOwnershipInterest
     *
     * @param hasBusinessOwnnershipInterest
     * @param realEstate
     * @param soleProprietorship
     * @param partnership
     * @param cCorp
     * @param sCorp
     * @param limitedLiability
     * @param otherOwnership
     * @return
     */
    public static InvestAsset hasOnlyBusinessOwnershipInterest(String email, Boolean hasBusinessOwnnershipInterest, BigDecimal realEstate, BigDecimal soleProprietorship, BigDecimal partnership,
                                                                BigDecimal cCorp, BigDecimal sCorp, BigDecimal limitedLiability, BigDecimal otherOwnership) {
        return new InvestAsset(email, false, false, hasBusinessOwnnershipInterest, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO,
                BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, realEstate, soleProprietorship, partnership, cCorp, sCorp, limitedLiability, otherOwnership);
    }

    public Long getInvestAssetId() {
        return investAssetId;
    }

    public String getEmail() {
        return email;
    }

    public boolean isHasTaxableAccount() {
        return hasTaxableAccount;
    }

    public boolean isHasRetirementAccount() {
        return hasRetirementAccount;
    }

    public boolean isHasBusinessOwnershipInterest() {
        return hasBusinessOwnershipInterest;
    }

    public BigDecimal getBrokerageAccount() {
        return brokerageAccount;
    }

    public BigDecimal getOtherTaxableAccount() {
        return otherTaxableAccount;
    }

    public BigDecimal getIraAccount() {
        return iraAccount;
    }

    public BigDecimal getRothAccount() {
        return rothAccount;
    }

    public BigDecimal getFourZeroOne() {
        return fourZeroOne;
    }

    public BigDecimal getSepIra() {
        return sepIra;
    }

    public BigDecimal getQualifiedPlans() {
        return qualifiedPlans;
    }

    public BigDecimal getPension() {
        return pension;
    }

    public BigDecimal getAnnuity() {
        return annuity;
    }

    public BigDecimal getRealEstate() {
        return realEstate;
    }

    public BigDecimal getSoleProprietorship() {
        return soleProprietorship;
    }

    public BigDecimal getPartnership() {
        return partnership;
    }

    public BigDecimal getcCorp() {
        return cCorp;
    }

    public BigDecimal getsCorp() {
        return sCorp;
    }

    public BigDecimal getLimitedLiability() {
        return limitedLiability;
    }

    public BigDecimal getOtherOwnership() {
        return otherOwnership;
    }
}
