package guild.elearning.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {
    private Integer page;
    private Integer records;
    private Map<String, String> filters;
}
