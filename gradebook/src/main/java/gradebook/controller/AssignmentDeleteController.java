package gradebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import gradebook.service.AssignmentDeleteService;

@RestController
public class AssignmentDeleteController implements AssignmentDeleteControllerInterface {
	
	@Autowired
	private AssignmentDeleteService assignmentDeleteService;
	
	@Override
	public void deleteAssignment(Long assignmentId) {
		assignmentDeleteService.deleteAssignment(assignmentId);
	}

}
