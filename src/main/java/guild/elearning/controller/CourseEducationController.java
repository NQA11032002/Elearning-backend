package guild.elearning.controller;

import guild.elearning.controller.interfaces.ICourseEducationController;
import guild.elearning.response.ResponseObject;
import guild.elearning.service.interfaces.ICourseCategoryService;
import guild.elearning.service.interfaces.ICourseEducationService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/educations")
@CrossOrigin("*")
public class CourseEducationController implements ICourseEducationController {
    @Autowired
    private ICourseEducationService courseEducationService;


    @Override
    @GetMapping("")
    public ResponseObject getAllCourseEducation() {
        return courseEducationService.getAllCourseEducation();
    }
}
