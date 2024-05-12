package ProjectDemo.demo.controller.Authentication;

import ProjectDemo.demo.dto.UserDto;
import ProjectDemo.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.security.Principal;

@Controller

@SessionAttributes("userdto")

public class UserLoginController {

    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    private UserService userService;


    @ModelAttribute("userdto")
    public UserDto userDto(){
        return new UserDto();
    }


    @GetMapping("/login")
    public String showLoginForm() {
        return "/login";
    }

    @GetMapping("/user-page")
    public String userPage(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "/user";
    }

    @GetMapping("/admin-page")
    public String adminPage(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("userdto", userDetails);
        return "/admin_home";
    }
}
//    @PostMapping("/login")
//    public String Login(Model model, Principal principal) {
//        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
//        if (userDetails == null) {
//            return "redirect:/login?error";
//        }
//
////        if (userService.checkPasswordUser(userDto.getEmail(), userDto.getPassword())==false) {
////            return "redirect:/login?passwordwrong";
////        }
//        model.addAttribute("user", userDetails);
///*//        User user = userService.getUserbyEmail(userDto.getEmail()).get();
//        if(userDetails == null){
//            return "redirect:/login?error"alse
//        }
////
//        if(userService.checkPasswordUser(userDto.getEmail(),userDto.getPassword())==false){
//
//            return "redirect:/login?passwordwrong";
//        }
////        if(user.getRole().equals("ADMIN")){
////           return  "redirect:/admin_home";
////      }
////*/
//        return "redirect:/home?success";
//    }
//}
//
//
////test api
////@RestController
////@RequestMapping("/api")
////@AllArgsConstructor
////public class UserLoginController {
////    private final UserService userService;
////
////    @PostMapping("/login")
////    public ResponseEntity<String> login(@RequestBody UserDto userDto) {
////        if (!userService.checkUserbyEmail(userDto.getEmail())) {
////            return new ResponseEntity<>("Email is incorrect", HttpStatus.BAD_REQUEST);
////        }
////
////        User user = userService.getUserbyEmail(userDto.getEmail());
////
////        if (user.getRole().equals("ADMIN")) {
////            return new ResponseEntity<>("Redirect to admin home", HttpStatus.OK);
////        }
////
////        if (userService.checkPasswordUser(userDto.getEmail(), userDto.getPassword())) {
////            return new ResponseEntity<>("Login successful", HttpStatus.OK);
////        }
////
////        return new ResponseEntity<>("Password is incorrect", HttpStatus.BAD_REQUEST);
////    }
////}
