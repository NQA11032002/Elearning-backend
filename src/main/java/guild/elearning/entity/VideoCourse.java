package guild.elearning.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "VideoCourse")
public class VideoCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer thematicID;

    private String name;

    private String urlVideo;

    private String duration;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "thematicID", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonBackReference(value = "reference-thematic-video")
    private ThematicCourse thematicCourse;
}
