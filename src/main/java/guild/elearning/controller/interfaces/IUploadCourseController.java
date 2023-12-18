package guild.elearning.controller.interfaces;

import org.springframework.http.ResponseEntity;


public interface IUploadCourseController {
    public ResponseEntity<String> generateUrl(String extension);
    public ResponseEntity<String> getUrl(String filename);
}
