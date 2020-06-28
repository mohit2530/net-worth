package io.finance.netTracker.Repository;

import io.finance.netTracker.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<User, Long> {

  public User findByEmail(String email);
  
  public Boolean existsUserByEmail(String email);
}
