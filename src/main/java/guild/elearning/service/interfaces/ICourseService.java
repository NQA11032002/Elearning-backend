package guild.elearning.service.interfaces;

import guild.elearning.entity.Course;
import guild.elearning.response.ResponseCourse;
import guild.elearning.response.ResponseObject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface ICourseService {
    public ResponseCourse getAllCourse(Integer page, Integer records, Map<String, String> filters);
    public int getTotalPage(Integer records);
    public ResponseObject findCourseByID(Integer id);
    public ResponseObject findCourseByTitle(String title);
    public ResponseObject insertCourse(Course course);
    public ResponseObject updateCourse(Course course);
    public ResponseObject deleteCourse(Integer id);
}
