package ProjectDemo.demo.controller.admin;

import ProjectDemo.demo.dto.UserDto;
import ProjectDemo.demo.entity.User;
import ProjectDemo.demo.reponsitory.CommentReponsitory;
import ProjectDemo.demo.reponsitory.TopicReponsitory;
import ProjectDemo.demo.reponsitory.UserReponsitory;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@AllArgsConstructor
@SessionAttributes("userdto")
public class TestQuery {
    @Autowired
    private TopicReponsitory topicReponsitory;

    @Autowired
    private CommentReponsitory commentReponsitory;

    @Autowired
    private UserReponsitory userReponsitory;

    @ModelAttribute("userdto")
    public UserDto userDto(){
        return new UserDto();
    }
    @GetMapping("/table_usertest")
    public String showUserControl(@ModelAttribute("userdto") UserDto userDto, Model model,@Param("keyword") String keyword){
        List<User> users = userReponsitory.getAllUser();
        if(keyword != null){
            int keywordInt = Integer.parseInt(keyword);
          users = userReponsitory.searchAllUser2(keywordInt);
            model.addAttribute("keyword",keyword);
          //  model.addAttribute("users",users);
        }
    //    List<User> users = userReponsitory.getAllUser2(150);
        model.addAttribute("users",users);
        model.addAttribute("commentcount",commentReponsitory);
        model.addAttribute("topiccount",topicReponsitory);
        return "table_usertest";
    }
}
