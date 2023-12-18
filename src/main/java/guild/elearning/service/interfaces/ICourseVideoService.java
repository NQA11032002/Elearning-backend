package guild.elearning.service.interfaces;

import guild.elearning.entity.VideoCourse;
import guild.elearning.response.ResponseObject;
import ws.schild.jave.EncoderException;

import java.net.MalformedURLException;

public interface ICourseVideoService {

    public ResponseObject getAllVideo();

    public ResponseObject getVideoByThematic(Integer id);

    public ResponseObject insertVideo(VideoCourse videoCourse);

    public ResponseObject updateVideo(VideoCourse videoCourse);

    public ResponseObject deleteVideo(Integer id);
}
