package guild.elearning.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CourseImage")
public class CourseImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer courseID;

    private String urlImage;

    @ManyToOne
    @JoinColumn(name = "courseID", referencedColumnName = "id", insertable=false, updatable=false)
    @JsonBackReference(value = "reference-course-image")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Course course;
}
