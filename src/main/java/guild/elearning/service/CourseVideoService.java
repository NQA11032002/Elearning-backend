package guild.elearning.service;

import guild.elearning.entity.VideoCourse;
import guild.elearning.repository.ICourseVideoRepository;
import guild.elearning.response.ResponseObject;
import guild.elearning.service.interfaces.ICourseVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CourseVideoService implements ICourseVideoService {
    @Autowired
    private ICourseVideoRepository courseVideoRepository;

    @Override
    public ResponseObject getAllVideo() {
        var videos = courseVideoRepository.findAll();

        if (videos.isEmpty()) {
            return new ResponseObject(HttpStatus.NOT_FOUND.name(), "No videos found in the videos table", videos);
        }

        return new ResponseObject(HttpStatus.NOT_FOUND.name(), "No videos found in the videos table", videos);
    }

    @Override
    public ResponseObject getVideoByThematic(Integer id) {
        var videos = courseVideoRepository.findVideoCourseByThematicID(id);

        if (!videos.isEmpty()) {
            return new ResponseObject(HttpStatus.NOT_FOUND.name(), "No videos found with the given thematic ID: " + id, videos);
        }

        return new ResponseObject(HttpStatus.OK.name(), "Found videos with the given thematic ID: " + id, videos);
    }

    @Override
    public ResponseObject insertVideo(VideoCourse videoCourse) {
        try {
            courseVideoRepository.save(videoCourse);

            return new ResponseObject(HttpStatus.CREATED.name(), "Insert new videoCourse successful", videoCourse);
        } catch (Exception e) {
            return new ResponseObject(HttpStatus.BAD_REQUEST.name(), "Insert new videoCourse failed", e.getMessage());

        }    }

    @Override
    public ResponseObject updateVideo(VideoCourse videoCourse) {
        try {
            var videoFound = courseVideoRepository.findById(videoCourse.getId());

            if (videoFound.isEmpty()) {
                return new ResponseObject(HttpStatus.NOT_FOUND.name(), "No video found", null);
            }

            VideoCourse updatedVideo = videoFound.get();

            updatedVideo.setThematicID(videoCourse.getThematicID());
            updatedVideo.setUrlVideo(videoCourse.getUrlVideo());
            updatedVideo.setName(videoCourse.getName());
            updatedVideo.setDuration(updatedVideo.getDuration());


            courseVideoRepository.save(updatedVideo);

            return new ResponseObject(HttpStatus.OK.name(), "Update video with the given ID: " + updatedVideo.getId() + " successful", updatedVideo);
        } catch (Exception e) {
            return new ResponseObject(HttpStatus.INTERNAL_SERVER_ERROR.name(), "An error occurred during the course update process", e.getMessage());
        }
    }

    @Override
    public ResponseObject deleteVideo(Integer id) {
        try {
            var foundVideo = courseVideoRepository.findById(id);

            if (foundVideo.isPresent()) {
                courseVideoRepository.delete(foundVideo.get());

                return new ResponseObject(HttpStatus.OK.name(), "Delete video with the given ID: " + id + " successful", null);
            }

            return new ResponseObject(HttpStatus.OK.name(), "No video found to update with the given ID: " + id, null);
        } catch (Exception e) {
            return new ResponseObject(HttpStatus.INTERNAL_SERVER_ERROR.name(), "An error occurred during the course delete process", null);
        }
    }
}
