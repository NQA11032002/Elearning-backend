package guild.elearning.repository;

import guild.elearning.entity.CourseEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ICourseEvaluationRepository extends JpaRepository<CourseEvaluation, Integer> {
    public List<CourseEvaluation> findCourseEvaluationByCourseID(Integer userID);
}
