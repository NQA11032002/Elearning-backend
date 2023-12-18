package guild.elearning.controller.interfaces;

import guild.elearning.entity.VideoCourse;
import guild.elearning.response.ResponseObject;
import ws.schild.jave.EncoderException;

import java.net.MalformedURLException;

public interface ICourseVideoController {
    public ResponseObject getInfoVideo(String videoUrl) throws EncoderException, MalformedURLException;

    public ResponseObject getAllVideo();

    public ResponseObject getVideoByThematic(Integer id);

    public ResponseObject insertVideo(VideoCourse videoCourse);

    public ResponseObject updateVideo(VideoCourse videoCourse);

    public ResponseObject deleteVideo(Integer id);
}
