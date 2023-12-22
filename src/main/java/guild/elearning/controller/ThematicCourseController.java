package guild.elearning.controller;

import guild.elearning.controller.interfaces.IThematicCourseController;
import guild.elearning.entity.ThematicCourse;
import guild.elearning.response.ResponseObject;
import guild.elearning.service.interfaces.ICourseVideoService;
import guild.elearning.service.interfaces.IThematicCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/thematic")
@CrossOrigin("*")
public class ThematicCourseController implements IThematicCourseController{
    @Autowired
    private IThematicCourseService thematicCourseController;

    @Override
    @GetMapping("/{courseID}")
    public ResponseObject findThematicByCourseID(@PathVariable("courseID") Integer courseID) {
        return thematicCourseController.findThematicByCourseID(courseID);
    }

    @Override
    @PostMapping("")
    public ResponseObject insertThematic(@RequestBody ThematicCourse thematicCourse) {
        return thematicCourseController.insertThematic(thematicCourse);
    }
}
