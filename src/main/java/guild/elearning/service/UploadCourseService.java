package guild.elearning.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import guild.elearning.service.interfaces.IUploadCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class UploadCourseService implements IUploadCourseService {
    @Autowired
    private AmazonS3 amazonS3;

    @Value("${aws.s3.bucket}")
    private String bucketName;

    @Autowired
    private AmazonS3Client amazonS3Client;


    @Override
    public String uploadFile(MultipartFile file) {
        String extension = StringUtils.getFilenameExtension(file.getOriginalFilename());

        String key = UUID.randomUUID().toString() + "." + extension;

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());

        try{
            amazonS3Client.putObject(bucketName, key, file.getInputStream(), metadata);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        amazonS3Client.setObjectAcl(bucketName, key, CannedAccessControlList.PublicRead);

        return amazonS3Client.getResourceUrl(bucketName, key);
    }
}
