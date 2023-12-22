package guild.elearning.service.interfaces;

import guild.elearning.entity.ThematicCourse;
import guild.elearning.response.ResponseObject;

public interface IThematicCourseService {
    public ResponseObject findThematicByCourseID(Integer courseID);
    public ResponseObject insertThematic(ThematicCourse thematicCourse);
}
