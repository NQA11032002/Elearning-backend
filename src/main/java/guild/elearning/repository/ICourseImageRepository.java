package guild.elearning.repository;

import guild.elearning.entity.CourseImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseImageRepository extends JpaRepository<CourseImage, Integer> {
}
