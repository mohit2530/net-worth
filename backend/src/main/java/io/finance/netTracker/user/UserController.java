package io.finance.netTracker.user;

import javax.validation.Valid;

import io.finance.netTracker.Repository.UserRespository;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController Class
 *
 */
@RestController
public class UserController {

  private UserRespository userRespository;

  public UserController(UserRespository userRespository) {
    this.userRespository = userRespository;
  }

  @RequestMapping(value = "/register", method = {RequestMethod.POST})
  public String saveUser(@Valid @RequestBody User user, BindingResult result){
    if (user == null) {
      return null;
    }
    if (result.hasErrors()) {
      String errorMessages = "";
      for (ObjectError error : result.getAllErrors()) {
        errorMessages += error.getDefaultMessage() + "\n";
      }
    }
    saveCashEquivalentInDatabase(user);
    return "User Saved.";
  }

  private User saveCashEquivalentInDatabase(User user) {
    User users = new User(user.getFirstName(), user.getEmail());
    return userRespository.save(users);
  }
}
