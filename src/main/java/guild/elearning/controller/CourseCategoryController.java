package guild.elearning.controller;

import guild.elearning.controller.interfaces.ICourseCategoryController;
import guild.elearning.response.ResponseCourse;
import guild.elearning.response.ResponseObject;
import guild.elearning.service.interfaces.ICourseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/categories")
@CrossOrigin("*")
public class CourseCategoryController implements ICourseCategoryController {

    @Autowired
    private ICourseCategoryService courseCategoryService;

    @Override
    @GetMapping("")
    public ResponseObject getAllCourseCategory() {
        return courseCategoryService.getAllCourseCategory();
    }
}
