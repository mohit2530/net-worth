package io.finance.netTracker.asset;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CashEquivalent Class
 */
@Entity
@Table(name = "cashEquivalent")
public class CashEquivalent {

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private Long cashEquivalentId;

  private String email;
  private Boolean hasCashEquivalentAssets;
  private BigDecimal checkingAccount;
  private BigDecimal savingAccount;
  private BigDecimal moneyMarketAccount;
  private BigDecimal savingsBond;
  private BigDecimal certificateOfDeposit;
  private BigDecimal cashValueOfLifeInsurance;

  /**
   * Default Constructor
   */
  public CashEquivalent() {
  }

  /**
   * Constructor
   *
   * @param email
   * @param hasCashEquivalentAssets
   * @param checkingAccount
   * @param savingAccount
   * @param moneyMarketAccount
   * @param savingsBond
   * @param certificateOfDeposit
   * @param cashValueOfLifeInsurance
   */
  public CashEquivalent(String email, Boolean hasCashEquivalentAssets,
      BigDecimal checkingAccount, BigDecimal savingAccount, BigDecimal moneyMarketAccount,
      BigDecimal savingsBond, BigDecimal certificateOfDeposit,
      BigDecimal cashValueOfLifeInsurance) {
    this.email = email;
    this.hasCashEquivalentAssets = hasCashEquivalentAssets;
    this.checkingAccount = checkingAccount;
    this.savingAccount = savingAccount;
    this.moneyMarketAccount = moneyMarketAccount;
    this.savingsBond = savingsBond;
    this.certificateOfDeposit = certificateOfDeposit;
    this.cashValueOfLifeInsurance = cashValueOfLifeInsurance;
  }

  /**
   * method hasNoCashEquivalentAssets
   *
   * @return
   */
  public static CashEquivalent hasNoCashEquivalentAssets(String email) {
    return new CashEquivalent( email, false, BigDecimal.ZERO,BigDecimal.ZERO,BigDecimal.ZERO,BigDecimal.ZERO,BigDecimal.ZERO,BigDecimal.ZERO);
  }

  /**
   * method hasCashEquivalentAssets
   *
   * @param checkingAccount
   * @param savingAccount
   * @param moneyMarketAccount
   * @param savingsBond
   * @param certificateOfDeposit
   * @param cashValueOfLifeInsurance
   * @return
   */
  public static CashEquivalent hasCashEquivalentAssets(String email, Boolean hasCashEquivalentAssets, BigDecimal checkingAccount, BigDecimal savingAccount, BigDecimal moneyMarketAccount,
      BigDecimal savingsBond, BigDecimal certificateOfDeposit, BigDecimal cashValueOfLifeInsurance) {
    return new CashEquivalent(email, true, checkingAccount, savingAccount, moneyMarketAccount, savingsBond, certificateOfDeposit, cashValueOfLifeInsurance);
  }

  public Long getId() {
    return cashEquivalentId;
  }

  public String getEmail() { return email; }

  public Boolean getHasCashEquivalentAssets() {
    return hasCashEquivalentAssets;
  }

  public BigDecimal getCheckingAccount() {
    return checkingAccount;
  }

  public BigDecimal getSavingAccount() {
    return savingAccount;
  }

  public BigDecimal getMoneyMarketAccount() {
    return moneyMarketAccount;
  }

  public BigDecimal getSavingsBond() {
    return savingsBond;
  }

  public BigDecimal getCertificateOfDeposit() {
    return certificateOfDeposit;
  }

  public BigDecimal getCashValueOfLifeInsurance() {
    return cashValueOfLifeInsurance;
  }
}
