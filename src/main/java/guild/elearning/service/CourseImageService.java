package guild.elearning.service;

import guild.elearning.entity.CourseImage;
import guild.elearning.repository.ICourseImageRepository;
import guild.elearning.response.ResponseObject;
import guild.elearning.service.interfaces.ICourseImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CourseImageService implements ICourseImageService {
    @Autowired
    private ICourseImageRepository iCourseImageRepository;

    @Override
    public ResponseObject insertCourseImage(CourseImage courseImage) {
        try {
            iCourseImageRepository.save(courseImage);

            return new ResponseObject(HttpStatus.CREATED.name(), "Insert new image of course successful", courseImage);
        } catch (Exception e) {
            return new ResponseObject(HttpStatus.BAD_REQUEST.name(), "Insert new image of course failed", e.getMessage());

        }
    }
}
