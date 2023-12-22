package guild.elearning.controller;

import guild.elearning.controller.interfaces.ICourseVideoController;
import guild.elearning.entity.VideoCourse;
import guild.elearning.response.ResponseObject;
import guild.elearning.service.interfaces.ICourseVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/course-video")
@CrossOrigin("*")
public class CourseVideoController implements ICourseVideoController {
    @Autowired
    private ICourseVideoService courseVideoService;

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
