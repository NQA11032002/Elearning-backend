package guild.elearning.service.interfaces;

import com.amazonaws.HttpMethod;
import org.springframework.http.ResponseEntity;

public interface IUploadCourseService {
    public String generatePreSignedUrl(String filePath, HttpMethod http);
}
