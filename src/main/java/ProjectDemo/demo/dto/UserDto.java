package ProjectDemo.demo.dto;

import java.io.Serializable;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class UserDto implements Serializable {
    private String Email;
    private String UserDisplayName;
    private String Password;
    private String CheckPass;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUserDisplayName() {
        return UserDisplayName;
    }

    public void setUserDisplayName(String userDisplayName) {
        UserDisplayName = userDisplayName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getCheckPass() {
        return CheckPass;
    }

    public void setCheckPass(String checkPass) {
        CheckPass = checkPass;
    }
    //  private String Role;

//
    public UserDto() {
    }

    public UserDto(String email, String userDisplayName, String password) {
        Email = email;
        UserDisplayName = userDisplayName;
        Password = password;

    }
}
