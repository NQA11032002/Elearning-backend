package guild.elearning.controller;

import guild.elearning.response.ResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ws.schild.jave.info.MultimediaInfo;

import java.net.MalformedURLException;
import java.net.URL;
import ws.schild.jave.MultimediaObject;
import ws.schild.jave.EncoderException;
import ws.schild.jave.InputFormatException;

@RestController
@RequestMapping(path = "api/course-media")
public class CourseMediaController {

    @GetMapping("")
    public ResponseObject getInfo(@RequestParam String videoUrl) throws EncoderException, MalformedURLException {

        URL url = new URL(videoUrl);

            MultimediaObject multimediaObject = new MultimediaObject(url);

            MultimediaInfo multimediaInfo = multimediaObject.getInfo();

            long minutes = (multimediaInfo.getDuration() / 1000) / 60;

            long seconds = (multimediaInfo.getDuration() / 1000) % 60;

            return new ResponseObject(HttpStatus.OK.name(),  minutes + ":" + seconds, multimediaInfo);

    }
}
