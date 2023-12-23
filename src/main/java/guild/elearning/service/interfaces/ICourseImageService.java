package guild.elearning.service.interfaces;

import guild.elearning.entity.CourseImage;
import guild.elearning.response.ResponseObject;

public interface ICourseImageService {
    public ResponseObject insertCourseImage(CourseImage courseImage);
}
