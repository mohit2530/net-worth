package io.finance.netTracker.Repository;

import io.finance.netTracker.asset.InvestAsset;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestAssetRepository extends JpaRepository<InvestAsset, Long> {

    public List<InvestAsset> findByEmail(String email);
}

