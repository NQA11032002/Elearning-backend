package guild.elearning.repository;

import guild.elearning.entity.ThematicCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IThematicRepository extends JpaRepository<ThematicCourse, Integer> {
    public List<ThematicCourse> findByCourseID(Integer courseID);
}
