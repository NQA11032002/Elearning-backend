package guild.elearning.controller.interfaces;

import guild.elearning.response.ResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import ws.schild.jave.EncoderException;

import java.net.MalformedURLException;
import java.util.Map;


public interface IUploadCourseController {
    public ResponseObject uploadFile(MultipartFile file) throws MalformedURLException, EncoderException;

}
