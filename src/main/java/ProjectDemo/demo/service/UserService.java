package ProjectDemo.demo.service;

import ProjectDemo.demo.dto.UserDto;
import ProjectDemo.demo.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void save(UserDto userDto);
    Boolean checkPasswordUser(String email,String password);
    Boolean checkUserbyEmail(String email);
    User getUserbyEmail(String email);
 //   User getUserbyEmail1(String email);
  //  List<User> check();
    Boolean checkEmail(String email);
     Boolean checkName(String name);
}
