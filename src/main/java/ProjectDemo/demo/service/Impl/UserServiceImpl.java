package ProjectDemo.demo.service.Impl;


import ProjectDemo.demo.dto.UserDto;
import ProjectDemo.demo.entity.Profile;
import ProjectDemo.demo.entity.User;
import ProjectDemo.demo.reponsitory.ProfileReponsitory;
import ProjectDemo.demo.reponsitory.UserReponsitory;
import ProjectDemo.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {
    /*  @Autowired
     private BCryptPasswordEncoder passwordEncoder;*/
    @Autowired
    private UserReponsitory userReponsitory;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ProfileReponsitory profileReponsitory;

    @Override
    public void save(UserDto userDto) {
        LocalDateTime Date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String creationDate = Date.format(formatter);
        String password = passwordEncoder.encode(userDto.getPassword());

        User user = new User(userDto.getEmail(),
                userDto.getUserDisplayName(),
                ".",
                0,
                0,
                password,

                creationDate,
                "USER"
        );
        Profile profile = new Profile(
                "First Name",
                "Last Name",
                creationDate,
                "null",
                "Gender",
                "Adress",
                user
        );
        userReponsitory.save(user);
        profileReponsitory.save(profile);
    }

//    @Override
//    public Boolean checkPasswordUser(String email, String password) {
//        Optional<User> user = userReponsitory.findUserByEmail(email);
//        User user1 = user.get();
//        if (user1.getPassword().equals(password)) return true;
//        return false;
//    }
    @Override
    public Boolean checkPasswordUser(String email, String password) {
       User user = userReponsitory.findByEmail(email);
       if(user == null){
           return false;
       }
       return true;
    }

//    @Override
//    public Boolean checkPasswordUser(String email, String password) {
//        User user = userReponsitory.findUserByEmail(email);
//        if (user.getPassword().equals(password)) return true;
//        return false;
//    }

    /*   @Override
       public Boolean checkUserbyEmail(String email) {
           User user = userReponsitory.findUserByEmail(email);
           if(user==null) return false;
           return true;
       }*/
    @Override
    public Boolean checkUserbyEmail(String email) {
       User userOptional = userReponsitory.findByEmail(email);
        //  User user= userReponsitory.getUserByEmail(String email);
        if (userOptional!= null) {
            //  User user = userOptional.get();
            // Kiểm tra mật khẩu
            return false;
        }

        return true;
    }

    //Check format Email
    @Override
    public Boolean checkEmail(String email) {
        Pattern p = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]+@[a-zA-Z]+(.[a-zA-Z]+)+$");
        if (!p.matcher(email).find()) {
            return false;
        }
        return true;
    }

    //Check format Name
    @Override
    public Boolean checkName(String name) {
        Pattern p = Pattern.compile("^[a-zA-Z ]+$");
        if (!p.matcher(name).find()) {
            return false;
        }
        return true;
    }

    //    @Override
//    public User getUserbyEmail1(String email) {
//        return userReponsitory.getUserByEmail(email);
//    }
//}
    @Override
    public User getUserbyEmail(String email) {
        return userReponsitory.findByEmail(email);
        // Optional<User> userOptional = userReponsitory.findByEmail(email);
        //return userOptional.orElse(null); // Trả về null nếu không tìm thấy User
    }
}


