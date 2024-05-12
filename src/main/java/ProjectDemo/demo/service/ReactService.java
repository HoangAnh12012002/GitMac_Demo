package ProjectDemo.demo.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


import ProjectDemo.demo.dto.CommentDto;
import ProjectDemo.demo.entity.Comment;
import ProjectDemo.demo.entity.Topic;
import ProjectDemo.demo.entity.User;

@Service
@Transactional
public interface ReactService {
    void saveReactTopic(String namereact, Topic topic, User user);
    void saveReactComment(String namereact, Comment comment, User user);
    int countReact(Topic topic);
    int countReactComment(Comment comment);
    void delete(Integer topicId);
}
