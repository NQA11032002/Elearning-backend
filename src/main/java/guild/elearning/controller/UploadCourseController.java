package guild.elearning.controller;

import com.amazonaws.HttpMethod;
import guild.elearning.controller.interfaces.IUploadCourseController;
import guild.elearning.service.UploadCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "api/upload-course")
public class UploadCourseController implements IUploadCourseController {
    @Autowired
    private UploadCourseService fileService;

    @Override
    @PostMapping("")
    public ResponseEntity<String> generateUrl(@RequestParam String extension) {
        return ResponseEntity.ok(fileService.generatePreSignedUrl(
                UUID.randomUUID()+"."+extension, HttpMethod.PUT));
    }

    @Override
    @GetMapping("")
    public ResponseEntity<String> getUrl(@RequestParam String filename) {
        return ResponseEntity.ok(fileService.generatePreSignedUrl(
                filename, HttpMethod.GET));
    }

}
