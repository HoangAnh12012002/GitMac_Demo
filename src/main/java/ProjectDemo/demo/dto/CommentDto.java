package ProjectDemo.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto implements Serializable {
    private String Body;

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }
}
