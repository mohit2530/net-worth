package io.finance.netTracker.Repository;

import io.finance.netTracker.asset.PersonalAsset;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalAssetRepository extends JpaRepository<PersonalAsset, Long> {

  public List<PersonalAsset> findByEmail(String email);
}
