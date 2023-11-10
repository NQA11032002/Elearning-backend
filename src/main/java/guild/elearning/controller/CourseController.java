package guild.elearning.controller;

import guild.elearning.controller.interfaces.ICourseController;
import guild.elearning.entity.Course;
import guild.elearning.response.ResponseCourse;
import guild.elearning.response.ResponseObject;
import guild.elearning.service.interfaces.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/course")
@CrossOrigin("*")
public class CourseController implements ICourseController {
    @Autowired
    private ICourseService iCourseService;

    @Override
    @GetMapping("")
    public ResponseCourse getAllCourse(@RequestParam Integer page, @RequestParam Integer records, @RequestParam Map<String, String> filters){
        return iCourseService.getAllCourse(page, records, filters);
    }

    @Override
    @GetMapping(path = "/{id}")
    public ResponseObject findCourseByID(@PathVariable("id") Integer id) {
        return iCourseService.findCourseByID(id);
    }

    @Override
    @GetMapping(path = "/title")
    public ResponseObject findCourseByTitle(@RequestParam("title") String title) {
        return iCourseService.findCourseByTitle(title);
    }

    @Override
    @PostMapping("")
    public ResponseObject insertCourse(@RequestBody Course course) {
        return iCourseService.insertCourse(course);
    }

    @Override
    @PutMapping("")
    public ResponseObject updateCourse(@RequestBody Course course) {
        return iCourseService.updateCourse(course);
    }

    @Override
    @DeleteMapping("")
    public ResponseObject deleteCourse(@RequestParam("id") Integer id) {
        return iCourseService.deleteCourse(id);
    }
}
