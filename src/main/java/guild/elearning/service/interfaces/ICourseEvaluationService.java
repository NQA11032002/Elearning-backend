package guild.elearning.service.interfaces;

import guild.elearning.entity.CourseEvaluation;
import guild.elearning.response.ResponseObject;

public interface ICourseEvaluationService {
    public ResponseObject getEvaluationsByCourseID(Integer id);
    public ResponseObject insertEvaluation(CourseEvaluation courseEvaluation);
    public ResponseObject deleteEvaluation(Integer id);
}
