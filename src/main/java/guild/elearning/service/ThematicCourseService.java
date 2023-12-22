package guild.elearning.service;

import guild.elearning.entity.ThematicCourse;
import guild.elearning.repository.IThematicRepository;
import guild.elearning.response.ResponseObject;
import guild.elearning.service.interfaces.IThematicCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ThematicCourseService implements IThematicCourseService {
    @Autowired
    private IThematicRepository thematicRepository;

    @Override
    public ResponseObject findThematicByCourseID(Integer courseID) {
        var thematics = thematicRepository.findByCourseID(courseID);

        if (thematics.isEmpty()) {
            return new ResponseObject(HttpStatus.NOT_FOUND.name(), "No thematic found in the thematics table", thematics);
        }

        return new ResponseObject(HttpStatus.NOT_FOUND.name(), "No thematic found in the thematics table", thematics);    }

    @Override
    public ResponseObject insertThematic(ThematicCourse thematicCourse) {
        try {
            thematicRepository.save(thematicCourse);

            return new ResponseObject(HttpStatus.CREATED.name(), "Insert new thematic successful", thematicCourse);
        } catch (Exception e) {
            return new ResponseObject(HttpStatus.BAD_REQUEST.name(), "Insert new thematic failed", e.getMessage());

        }
    }
}
