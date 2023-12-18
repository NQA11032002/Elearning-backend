package guild.elearning.controller.interfaces;

import guild.elearning.entity.Course;
import guild.elearning.response.ResponseCourse;
import guild.elearning.response.ResponseObject;
import ws.schild.jave.EncoderException;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

public interface ICourseController {
    public ResponseCourse getAllCourse(Integer page, Integer records, Map<String, String> filters);
    public ResponseObject findCourseByID(Integer id);
    public ResponseObject findCourseByTitle(String title);
    public ResponseObject insertCourse(Course course);
    public ResponseObject updateCourse(Course course);
    public ResponseObject deleteCourse(Integer id);
}
