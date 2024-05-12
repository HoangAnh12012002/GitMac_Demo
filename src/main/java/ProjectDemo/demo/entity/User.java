package ProjectDemo.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    //Tài khoản đăng nhập kết nối với database
    @Id
    @Column (name = "id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "user_display_name",nullable = false)
    private String UserDisplayName;

    @Column(name = "about_me",nullable = true)
    private String AboutMe;

    @Column(name = "views",nullable = false)
    private int Views;

    @Column(name = "topic_counts",nullable = false)
    private int TopicCounts;

    @Column(name = "password",nullable = false)
    private String Password;

    @Column(name = "creation_date",nullable = false)
    private String CreationDate;

    @Column(name = "role",nullable = false)
    private String Role;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserDisplayName() {
        return UserDisplayName;
    }

    public void setUserDisplayName(String userDisplayName) {
        UserDisplayName = userDisplayName;
    }

    public String getAboutMe() {
        return AboutMe;
    }

    public void setAboutMe(String aboutMe) {
        AboutMe = aboutMe;
    }

    public int getViews() {
        return Views;
    }

    public void setViews(int views) {
        Views = views;
    }

    public int getTopicCounts() {
        return TopicCounts;
    }

    public void setTopicCounts(int topicCounts) {
        TopicCounts = topicCounts;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(String creationDate) {
        CreationDate = creationDate;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public User(String Email, String userDisplayName, String aboutMe, int views, int topicCounts, String password, String creationDate, String role) {
        email = Email;
        UserDisplayName = userDisplayName;
        AboutMe = aboutMe;
        Views = views;
        TopicCounts = topicCounts;
        Password = password;
        CreationDate = creationDate;
        Role = role;
    }
}
