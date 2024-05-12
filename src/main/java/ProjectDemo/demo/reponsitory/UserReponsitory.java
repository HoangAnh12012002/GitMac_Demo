package ProjectDemo.demo.reponsitory;

import ProjectDemo.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface UserReponsitory extends JpaRepository<User,Integer> {

    @Query("SELECT a FROM User a WHERE a.Views = :views")
    List<User> searchAllUser2(@Param("views") int views);
    User getUserByEmail(String email);
    User findUserByEmail(String email);

    User findByEmail(String email);

   //Optional<User> findByEmail(String email);

/*    @Query(
            value = "select * from user u where u.views=150 AND u.topic_counts=9",
            nativeQuery = true)
    List<User> getAllUser1();*/
//nếu fix cứng thì có thể dùng query dạng như trên, nhớ thêm nativeQuery=true
    @Query(
            value = "select * from user",
            nativeQuery = true)
    List<User> getAllUser();



}
