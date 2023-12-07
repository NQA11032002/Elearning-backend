package guild.elearning.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ThematicCourse")
public class ThematicCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer courseID;

    @Column(name = "name", length = 150)
    private String name;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "courseID", referencedColumnName = "id", insertable=false, updatable=false)
    @JsonBackReference(value = "reference-course-thematic")
    private Course course;

    @OneToMany(mappedBy = "thematicCourse")
    @JsonManagedReference(value = "reference-thematic-video")
    private List<VideoCourse> videoCourses;
}
