package guild.elearning.repository;

import guild.elearning.entity.VideoCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICourseVideoRepository extends JpaRepository<VideoCourse, Integer> {
    public List<VideoCourse> findByThematicCourse(Integer id);
}
