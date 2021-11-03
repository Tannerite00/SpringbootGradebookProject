package gradebook.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import gradebook.entity.Assignment;
import gradebook.service.AssignmentCreateServiceInterface;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AssignmentCreateController implements AssignmentCreateControllerInterface {
	
	@Autowired
	private AssignmentCreateServiceInterface assignmentCreateServiceInterface;
	
	@Override
	public Assignment createAssignment(String studentId, String assignmentName, String className, String pointsPossible, String pointsEarned) {
		log.debug("Student={}, Assignment={}, Class={}, Points Possible={}, Points Earned={}", studentId, assignmentName, className, pointsPossible, pointsEarned);
		return assignmentCreateServiceInterface.createAssignment(studentId, assignmentName, className, pointsPossible, pointsEarned);
	}


}
