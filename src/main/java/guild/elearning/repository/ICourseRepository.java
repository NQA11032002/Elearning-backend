package guild.elearning.repository;

import guild.elearning.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICourseRepository extends JpaRepository<Course, Integer> {
    public List<Course> findByTitleContaining(String title);
    public List<Course> findByUserID(Integer userID);
}
