package ProjectDemo.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profile implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "first_name", nullable = false)
    private String FirstName;

    @Column(name = "last_name",nullable = false)
    private String LastName;

    @Column(name ="date_of_birth",nullable = false)
    private String DateofBirth;

    @Column(name="img_url",nullable = false)
    private String ImgUrl;

    @Column(name="gender",nullable = false)
    private String Gender;

    @Column(name="adress",nullable = false)
    private String Adress;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getDateofBirth() {
        return DateofBirth;
    }

    public void setDateofBirth(String dateofBirth) {
        DateofBirth = dateofBirth;
    }

    public String getImgUrl() {
        return ImgUrl;
    }

    public void setImgUrl(String imgUrl) {
        ImgUrl = imgUrl;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Profile(String firstName, String lastName, String dateofBirth, String imgUrl, String gender, String adress, User user) {
        FirstName = firstName;
        LastName = lastName;
        DateofBirth = dateofBirth;
        ImgUrl = imgUrl;
        Gender = gender;
        Adress = adress;
        this.user = user;
    }
}
