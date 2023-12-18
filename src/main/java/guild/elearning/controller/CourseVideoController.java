package guild.elearning.controller;

import guild.elearning.controller.interfaces.ICourseVideoController;
import guild.elearning.entity.VideoCourse;
import guild.elearning.response.ResponseObject;
import guild.elearning.service.interfaces.ICourseVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ws.schild.jave.info.MultimediaInfo;

import java.net.MalformedURLException;
import java.net.URL;
import ws.schild.jave.MultimediaObject;
import ws.schild.jave.EncoderException;

@RestController
@RequestMapping(path = "api/course-media")
public class CourseVideoController implements ICourseVideoController {
    @Autowired
    private ICourseVideoService courseVideoService;

    @GetMapping("/info")
    public ResponseObject getInfoVideo(@RequestParam String videoUrl) throws EncoderException, MalformedURLException {

        URL url = new URL(videoUrl);

        MultimediaObject multimediaObject = new MultimediaObject(url);

        MultimediaInfo multimediaInfo = multimediaObject.getInfo();

        long minutes = (multimediaInfo.getDuration() / 1000) / 60;

        long seconds = (multimediaInfo.getDuration() / 1000) % 60;

        return new ResponseObject(HttpStatus.OK.name(),  minutes + ":" + seconds, multimediaInfo);
    }

    @Override
    @GetMapping("")
    public ResponseObject getAllVideo() {
        return courseVideoService.getAllVideo();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseObject getVideoByThematic(@PathVariable("id") Integer id) {
        return courseVideoService.getVideoByThematic(id);
    }

    @Override
    @PostMapping("")
    public ResponseObject insertVideo(@RequestBody VideoCourse videoCourse) {
        return courseVideoService.insertVideo(videoCourse);
    }

    @Override
    @PutMapping("")
    public ResponseObject updateVideo(@RequestBody VideoCourse videoCourse) {
        return courseVideoService.updateVideo(videoCourse);
    }

    @Override
    @DeleteMapping("")
    public ResponseObject deleteVideo(@RequestParam("id") Integer id) {
        return courseVideoService.deleteVideo(id);
    }
}
