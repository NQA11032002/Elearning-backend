package guild.elearning.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer categoryID;

    private Integer userID;

    private Integer educationID;

    @Column(name = "title", length = 150)
    private String title;

    @Column(nullable = false, name = "description", columnDefinition = "TEXT")
    private String description;

    private double price;

    private Integer count;

    private String urlImage;

    private LocalDate expired;

    private Boolean status;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference(value = "reference-course-thematic")
    private List<ThematicCourse> thematicCourses;

    @OneToOne
    @JoinColumn(name = "educationID", referencedColumnName = "id", insertable=false, updatable=false)
    @JsonManagedReference(value="reference-course-education")
    private EducationCourse educationCourse;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference(value = "reference-course-evaluation")
    private List<CourseEvaluation> courseEvaluations;

    @ManyToOne
    @JoinColumn(name = "categoryID", referencedColumnName = "id", insertable=false, updatable=false)
    @JsonBackReference(value = "reference-course-catalog")
    private CourseCatalog courseCatalog;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference(value = "reference-course-document")
    private List<CourseDocument> courseDocuments;

}
