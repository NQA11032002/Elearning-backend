package guild.elearning.service;

import guild.elearning.entity.CourseEvaluation;
import guild.elearning.repository.ICourseEvaluationRepository;
import guild.elearning.response.ResponseObject;
import guild.elearning.service.interfaces.ICourseEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CourseEvaluationService implements ICourseEvaluationService {
    @Autowired
    private ICourseEvaluationRepository courseEvaluationRepository;

    @Override
    public ResponseObject getEvaluationsByCourseID(Integer courseID) {
        var evaluations = courseEvaluationRepository.findCourseEvaluationByCourseID(courseID);

        if (!evaluations.isEmpty()) {
            return new ResponseObject(HttpStatus.NOT_FOUND.name(), "No evaluations found with the given course ID: " + courseID, evaluations);
        }

        return new ResponseObject(HttpStatus.OK.name(), "Found evaluations with the given course ID: " + courseID, evaluations);
    }

    @Override
    public ResponseObject insertEvaluation(CourseEvaluation courseEvaluation) {
        try {
            courseEvaluationRepository.save(courseEvaluation);

            return new ResponseObject(HttpStatus.CREATED.name(), "Insert new evaluation successful", courseEvaluation);
        } catch (Exception e) {
            return new ResponseObject(HttpStatus.BAD_REQUEST.name(), "Insert new evaluation failed", e.getMessage());

        }
    }

    @Override
    public ResponseObject deleteEvaluation(Integer id) {
        try {
            var evaluation = courseEvaluationRepository.findById(id);

            if (evaluation.isPresent()) {
                courseEvaluationRepository.delete(evaluation.get());

                return new ResponseObject(HttpStatus.OK.name(), "Delete evaluation with the given ID: " + id + " successful", null);
            }

            return new ResponseObject(HttpStatus.OK.name(), "No evaluation found to update with the given ID: " + id, null);
        } catch (Exception e) {
            return new ResponseObject(HttpStatus.INTERNAL_SERVER_ERROR.name(), "An error occurred during the evaluation delete process", null);
        }
    }
}
