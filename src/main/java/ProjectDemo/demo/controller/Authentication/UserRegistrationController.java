package ProjectDemo.demo.controller.Authentication;


import ProjectDemo.demo.dto.UserDto;
import ProjectDemo.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class UserRegistrationController {
    private UserService userService;
    @ModelAttribute("userdto")
    public UserDto userResgistrationDto(){
        return new UserDto();
    }
    @GetMapping("/registration")
    public String showRegistrationForm(){
        return "/registration";
    }

    @PostMapping("/registration")
    /*
    Phương thức này nhận một đối tượng UserDto từ mô hình (model) Spring, với tên là "userdto".
    Đối tượng UserDto thường chứa thông tin nhập vào từ người dùng trên giao diện đăng ký.
     */
    public String registerUserAccount(@ModelAttribute("userdto") UserDto userDto){
        if(userService.checkUserbyEmail(userDto.getEmail())==false){
            return "redirect:/registration?emailexist";
        }
        if(userDto.getPassword().equals(userDto.getCheckPass())==false){
            return "redirect:/registration?checkpass";
        }
        if(userService.checkEmail(userDto.getEmail())==false){
            return "redirect:/registration?wrongformatemail";
        }
        if(userService.checkName(userDto.getUserDisplayName())==false){
            return "redirect:/registration?wrongformatname";
        }
        userService.save(userDto);
        return "redirect:/registration?success";
    }
}
