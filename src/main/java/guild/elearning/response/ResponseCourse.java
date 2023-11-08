package guild.elearning.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCourse {
    private String status;
    private String message;
    private Object data;
    private Integer totalPage;
}
