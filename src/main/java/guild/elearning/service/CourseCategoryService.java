package guild.elearning.service;

import guild.elearning.repository.ICourseCategoryRepository;
import guild.elearning.response.ResponseCourse;
import guild.elearning.response.ResponseObject;
import guild.elearning.service.interfaces.ICourseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CourseCategoryService implements ICourseCategoryService {
    @Autowired
    private ICourseCategoryRepository courseCategoryRepository;

    @Override
    public ResponseObject getAllCourseCategory() {
        var categories = courseCategoryRepository.findAll();

        if (categories.isEmpty()) {
            return new ResponseObject(HttpStatus.NOT_FOUND.name(), "No categories found", categories);
        }

        return new ResponseObject(HttpStatus.OK.name(), "Found categories", categories);
    }
}
