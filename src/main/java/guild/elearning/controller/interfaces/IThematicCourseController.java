package guild.elearning.controller.interfaces;

import guild.elearning.entity.ThematicCourse;
import guild.elearning.response.ResponseObject;

public interface IThematicCourseController {
    public ResponseObject findThematicByCourseID(Integer courseID);
    public ResponseObject insertThematic(ThematicCourse thematicCourse);

}
