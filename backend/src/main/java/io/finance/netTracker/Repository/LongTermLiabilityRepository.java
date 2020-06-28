package io.finance.netTracker.Repository;

import io.finance.netTracker.liability.LongTermLiability;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LongTermLiabilityRepository extends JpaRepository<LongTermLiability, Long> {

    public List<LongTermLiability> findByEmail(String email);
}
