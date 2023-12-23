package guild.elearning.repository;

import guild.elearning.entity.EducationCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseEducationRepository extends JpaRepository<EducationCourse, Integer> {
}
