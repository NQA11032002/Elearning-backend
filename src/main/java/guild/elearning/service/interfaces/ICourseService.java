package guild.elearning.service.interfaces;

import guild.elearning.entity.Course;
import guild.elearning.response.ResponseObject;
import org.springframework.stereotype.Service;

public interface ICourseService {
    public ResponseObject getAllCourse(Integer page, Integer records);
    public ResponseObject findCourseByID(Integer id);
    public ResponseObject findCourseByTitle(String title);
    public ResponseObject insertCourse(Course course);

    public ResponseObject updateCourse(Course course);
    public ResponseObject deleteCourse(Integer id);
}
