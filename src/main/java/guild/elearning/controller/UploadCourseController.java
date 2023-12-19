package guild.elearning.controller;

import com.amazonaws.HttpMethod;
import guild.elearning.controller.interfaces.IUploadCourseController;
import guild.elearning.response.ResponseObject;
import guild.elearning.service.UploadCourseService;
import guild.elearning.service.interfaces.IUploadCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ws.schild.jave.EncoderException;
import ws.schild.jave.MultimediaObject;
import ws.schild.jave.info.MultimediaInfo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(path = "api")
@CrossOrigin("*")
public class UploadCourseController implements IUploadCourseController {
    @Autowired
    private IUploadCourseService fileService;


    @Override
    @PostMapping("/upload")
    public ResponseObject uploadFile(@RequestParam("file") MultipartFile file) throws MalformedURLException, EncoderException {
        String urlFile = fileService.uploadFile(file);

        Map<String, String> response = new HashMap<>();
        response.put("url", urlFile);

        URL url = new URL(urlFile);

        MultimediaObject multimediaObject = new MultimediaObject(url);

        MultimediaInfo multimediaInfo = multimediaObject.getInfo();

        long minutes = (multimediaInfo.getDuration() / 1000) / 60;
        long seconds = (multimediaInfo.getDuration() / 1000) % 60;

        response.put("duration", minutes + ":" + seconds);

        return new ResponseObject(HttpStatus.CREATED.name(),  "Upload file successfully", response);
    }
}
