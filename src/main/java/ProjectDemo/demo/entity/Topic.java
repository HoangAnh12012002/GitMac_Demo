package ProjectDemo.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;

@Entity
@NoArgsConstructor
@Data
@Table (name ="topic")
public class Topic implements Serializable {
    @Id
    @Column (name="id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(String creationDate) {
        CreationDate = creationDate;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name="title",nullable = false)
    private String title;

    @Column(name = "creation_date",nullable = false)
    private String CreationDate;

    @Column(name ="body",nullable = false, length = 1024)
    private String body;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Topic(String title, String creationDate, String body,User user) {
        this.title = title;
        CreationDate = creationDate;
        this.body = body;
        this.user=user;
    }
}
