package guild.elearning.service;

import com.amazonaws.services.s3.AmazonS3;
import guild.elearning.service.interfaces.IUploadCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.amazonaws.HttpMethod;

import java.util.Calendar;
import java.util.Date;

@Service
public class UploadCourseService implements IUploadCourseService {
    @Autowired
    private AmazonS3 amazonS3;

    @Value("${aws.s3.bucket}")
    private String bucketName;

    @Override
    public String generatePreSignedUrl(String filePath, HttpMethod http) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MINUTE,2);
        return amazonS3.generatePresignedUrl(bucketName,filePath,cal.getTime(),http).toString();
    }
}
