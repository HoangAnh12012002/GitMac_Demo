package ProjectDemo.demo.ConfigSecurity;

import ProjectDemo.demo.entity.User;
import ProjectDemo.demo.reponsitory.UserReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
@Autowired
private UserReponsitory userReponsitory;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User user = userReponsitory.findByEmail(username);
      if(user == null){
          throw new UsernameNotFoundException("user not found");
      }
      return new CustomUserDetail(user);
    }
}
