package guild.elearning.controller.interfaces;

import guild.elearning.entity.Course;
import guild.elearning.entity.CourseImage;
import guild.elearning.response.ResponseObject;

public interface ICourseImageController {
    public ResponseObject insertCourseImage(CourseImage courseImage);

}
