package io.finance.netTracker.Repository;

import io.finance.netTracker.liability.ShortTermLiability;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortTermLiabilityRepository extends JpaRepository<ShortTermLiability, Long> {

    public List<ShortTermLiability> findByEmail(String email);
}

