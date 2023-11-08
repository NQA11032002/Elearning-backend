package guild.elearning.service;

import guild.elearning.entity.Course;
import guild.elearning.repository.ICourseRepository;
import guild.elearning.response.ResponseCourse;
import guild.elearning.response.ResponseObject;
import guild.elearning.service.interfaces.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements ICourseService {
    @Autowired
    private ICourseRepository iCourseRepository;

    @Override
    public ResponseCourse getAllCourse(Integer page, Integer records) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        PageRequest pageRequest = PageRequest.of(page, records, sort);

        List<Course> courses = iCourseRepository.findAll(pageRequest).getContent();
        int totalPage = getTotalPage(records);

        if (courses.isEmpty()) {
            return new ResponseCourse(HttpStatus.NOT_FOUND.name(), "No courses found in the course table", courses, 0);
        }

        return new ResponseCourse(HttpStatus.OK.name(), "Found " + courses.size() + " courses in the course table", courses, totalPage);
    }

    @Override
    public int getTotalPage(Integer records) {
        List<Course> courses = iCourseRepository.findAll();

        double totalPage = (double)courses.size() / records;
        int roundedTotalPage = (int) Math.round(totalPage);

        return roundedTotalPage;
    }


    @Override
    public ResponseObject findCourseByID(Integer id) {
        var course = iCourseRepository.findById(id);

        if (!course.isPresent()) {
            return new ResponseObject(HttpStatus.NOT_FOUND.name(), "No course found with the given ID: " + id, course);
        }

        return new ResponseObject(HttpStatus.OK.name(), "Found course with the given ID: " + id, course.get());
    }

    @Override
    public ResponseObject findCourseByTitle(String title) {
        var course = iCourseRepository.findByTitleContaining(title);

        if (course.isEmpty()) {
            return new ResponseObject(HttpStatus.NOT_FOUND.name(), "No courses found with the given title: " + title, course);
        }

        return new ResponseObject(HttpStatus.OK.name(), "Found " + course.size() + " courses with the given title: " + title, course);
    }

    @Override
    public ResponseObject insertCourse(Course course) {
        try
        {
            iCourseRepository.save(course);

            return new ResponseObject(HttpStatus.CREATED.name(), "Insert new course successful", course);
        }catch (Exception e)
        {
            return new ResponseObject(HttpStatus.BAD_REQUEST.name(), "Insert new course failed", e.getMessage());

        }
    }

    @Override
    public ResponseObject updateCourse(Course course) {
        try
        {
            var foundCourse = iCourseRepository.findById(course.getId());

            if(!foundCourse.isPresent())
            {
                return new ResponseObject(HttpStatus.NOT_FOUND.name(), "No courses found", null);
            }

            Course updatedCourse = foundCourse.get();

            updatedCourse.setCategoryID(course.getCategoryID());
            updatedCourse.setEducationID(course.getEducationID());
            updatedCourse.setTitle(course.getTitle());
            updatedCourse.setDescription(course.getDescription());
            updatedCourse.setPrice(course.getPrice());
            updatedCourse.setCount(course.getCount());
            updatedCourse.setUrlImage(course.getUrlImage());
            updatedCourse.setStatus(course.getStatus());

            iCourseRepository.save(updatedCourse);

            return new ResponseObject(HttpStatus.OK.name(), "Update course with the given ID: " + course.getId() + " successful", course);
        }catch (Exception e)
        {
            return new ResponseObject(HttpStatus.INTERNAL_SERVER_ERROR.name(), "An error occurred during the course update process", e.getMessage());
        }
    }

    @Override
    public ResponseObject deleteCourse(Integer id) {
        try
        {
            var foundCourse = iCourseRepository.findById(id);

            if(foundCourse.isPresent())
            {
                iCourseRepository.delete(foundCourse.get());

                return new ResponseObject(HttpStatus.OK.name(), "Delete course with the given ID: " + id + " successful", null);
            }

            return new ResponseObject(HttpStatus.OK.name(), "No course found to update with the given ID: " + id, null);
        }catch (Exception e)
        {
            return new ResponseObject(HttpStatus.INTERNAL_SERVER_ERROR.name(), "An error occurred during the course delete process", null);
        }
    }
}
