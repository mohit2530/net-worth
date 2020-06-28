package io.finance.netTracker.Repository;

import io.finance.netTracker.asset.CashEquivalent;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CashEquivalentRepository
 */
public interface CashEquivalentRepository extends JpaRepository<CashEquivalent, Long> {

//  public CashEquivalent findByHasCashEquivalentAssetsAndSavingsBondAndCertificateOfDeposit(Boolean x, BigDecimal y, BigDecimal z);
    public List<CashEquivalent> findByEmail(String email);
}
