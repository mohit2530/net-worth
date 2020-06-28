package io.finance.netTracker.asset;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PersonalAsset Class
 */
@Entity
@Table(name = "personalAsset")
public class PersonalAsset {

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private Long personalAssetId;

  private String email;
  private Boolean hasPersonalAsset;
  private BigDecimal principalValue;
  private BigDecimal vacationHome;
  private BigDecimal carsTrucksBoats;
  private BigDecimal homeFurnishing;
  private BigDecimal artsAndAntiques;
  private BigDecimal jeweleryFurs;
  private BigDecimal otherAssets;

  /**
   * Default Constructor
   */
  public PersonalAsset() {
  }

  /**
   * Constructor
   *
   * @param email
   * @param hasPersonalAsset
   * @param principalValue
   * @param vacationHome
   * @param carsTrucksBoats
   * @param homeFurnishing
   * @param artsAndAntiques
   * @param jeweleryFurs
   * @param otherAssets
   */
  public PersonalAsset(String email, Boolean hasPersonalAsset, BigDecimal principalValue,
      BigDecimal vacationHome, BigDecimal carsTrucksBoats, BigDecimal homeFurnishing,
      BigDecimal artsAndAntiques, BigDecimal jeweleryFurs, BigDecimal otherAssets) {
    this.email = email;
    this.hasPersonalAsset = hasPersonalAsset;
    this.principalValue = principalValue;
    this.vacationHome = vacationHome;
    this.carsTrucksBoats = carsTrucksBoats;
    this.homeFurnishing = homeFurnishing;
    this.artsAndAntiques = artsAndAntiques;
    this.jeweleryFurs = jeweleryFurs;
    this.otherAssets = otherAssets;
  }

  /**
   * method hasNoPersonalAssets
   * @return
   */
  public static PersonalAsset hasNoPersonalAssets(String email) {
    return new PersonalAsset(email, false, BigDecimal.ZERO, BigDecimal.ZERO,BigDecimal.ZERO,BigDecimal.ZERO,BigDecimal.ZERO,BigDecimal.ZERO,BigDecimal.ZERO);
  }

  /**
   * method hasPersonalAssets
   *
   * @param principalValue
   * @param vacationHome
   * @param carsTrucksBoats
   * @param homeFurnishing
   * @param artsAndAntiques
   * @param jeweleryFurs
   * @param otherAssets
   * @return
   */
  public static PersonalAsset hasPersonalAssets(String email, BigDecimal principalValue, BigDecimal vacationHome, BigDecimal carsTrucksBoats,
      BigDecimal homeFurnishing, BigDecimal artsAndAntiques, BigDecimal jeweleryFurs, BigDecimal otherAssets) {
    return new PersonalAsset(email, true, principalValue, vacationHome, carsTrucksBoats,
        homeFurnishing, artsAndAntiques, jeweleryFurs, otherAssets);
  }

  public Long getPersonalAssetId() {
    return personalAssetId;
  }

  public String getEmail() {
    return email;
  }

  public Boolean getHasPersonalAsset() {
    return hasPersonalAsset;
  }

  public BigDecimal getPrincipalValue() {
    return principalValue;
  }

  public BigDecimal getVacationHome() {
    return vacationHome;
  }

  public BigDecimal getCarsTrucksBoats() {
    return carsTrucksBoats;
  }

  public BigDecimal getHomeFurnishing() {
    return homeFurnishing;
  }

  public BigDecimal getArtsAndAntiques() {
    return artsAndAntiques;
  }

  public BigDecimal getJeweleryFurs() {
    return jeweleryFurs;
  }

  public BigDecimal getOtherAssets() {
    return otherAssets;
  }
}
