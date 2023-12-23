package guild.elearning.service;

import guild.elearning.repository.ICourseEducationRepository;
import guild.elearning.response.ResponseObject;
import guild.elearning.service.interfaces.ICourseEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CourseEducationService implements ICourseEducationService {
    @Autowired
    private ICourseEducationRepository courseEducationRepository;

    @Override
    public ResponseObject getAllCourseEducation() {
        var educations = courseEducationRepository.findAll();

        if (educations.isEmpty()) {
            return new ResponseObject(HttpStatus.NOT_FOUND.name(), "No educations found", educations);
        }

        return new ResponseObject(HttpStatus.OK.name(), "Found educations", educations);
    }
}
