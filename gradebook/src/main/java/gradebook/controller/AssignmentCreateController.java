package gradebook.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import gradebook.entity.Assignment;
import gradebook.entity.AssignmentRequest;
import gradebook.service.AssignmentCreateServiceInterface;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AssignmentCreateController implements AssignmentCreateControllerInterface {
	
	@Autowired
	private AssignmentCreateServiceInterface assignmentCreateServiceInterface;
	
	@Override
	public Assignment createAssignment(AssignmentRequest assignmentRequest) {
		log.debug("Assignment={}", assignmentRequest );
		return assignmentCreateServiceInterface.newAssignment(assignmentRequest);
	}


}
