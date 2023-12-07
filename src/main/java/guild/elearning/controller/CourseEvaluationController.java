package guild.elearning.controller;

import guild.elearning.controller.interfaces.ICourseEvaluationController;
import guild.elearning.entity.CourseEvaluation;
import guild.elearning.response.ResponseObject;
import guild.elearning.service.interfaces.ICourseEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/evaluation")
@CrossOrigin("*")
public class CourseEvaluationController implements ICourseEvaluationController {
    @Autowired
    private ICourseEvaluationService courseEvaluationService;

    @Override
    @GetMapping("")
    public ResponseObject getEvaluationsByCourseID(@RequestParam("courseID") Integer courseID) {
        return courseEvaluationService.getEvaluationsByCourseID(courseID);
    }

    @Override
    @PostMapping("")
    public ResponseObject insertEvaluation(@RequestBody CourseEvaluation courseEvaluation) {
        return courseEvaluationService.insertEvaluation(courseEvaluation);
    }

    @Override
    @DeleteMapping("")
    public ResponseObject deleteEvaluation(@RequestParam("id") Integer id) {
        return courseEvaluationService.deleteEvaluation(id);
    }
}
