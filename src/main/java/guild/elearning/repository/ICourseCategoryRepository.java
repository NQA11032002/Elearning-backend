package guild.elearning.repository;

import guild.elearning.entity.CourseCatalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseCategoryRepository extends JpaRepository<CourseCatalog, Integer> {
}
