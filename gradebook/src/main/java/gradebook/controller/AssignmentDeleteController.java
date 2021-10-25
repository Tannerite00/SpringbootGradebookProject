package gradebook.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import gradebook.entity.Assignment;
import gradebook.entity.AssignmentRequest;
import gradebook.service.AssignmentDeleteServiceInterface;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AssignmentDeleteController implements AssignmentDeleteControllerInterface {
	
	@Autowired
	private AssignmentDeleteServiceInterface assignmentDeleteServiceInterface;
	
	@Override
	public Assignment deleteAssignment(AssignmentRequest assignmentRequest) {
		log.debug("Assignment={}", assignmentRequest );
		return assignmentDeleteServiceInterface.oldAssignment(assignmentRequest);
	}


}
