package guild.elearning.controller;

import guild.elearning.controller.interfaces.ICourseImageController;
import guild.elearning.entity.CourseImage;
import guild.elearning.response.ResponseObject;
import guild.elearning.service.interfaces.ICourseImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/course-image")
@CrossOrigin("*")
public class CourseImageController implements ICourseImageController {
    @Autowired
    private ICourseImageService iCourseImageService;

    @Override
    @PostMapping
    public ResponseObject insertCourseImage(@RequestBody CourseImage courseImage) {
        return iCourseImageService.insertCourseImage(courseImage);
    }
}
