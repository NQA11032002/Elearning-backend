package guild.elearning.service.interfaces;

import com.amazonaws.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface IUploadCourseService {

    public String uploadFile(MultipartFile file);
}
