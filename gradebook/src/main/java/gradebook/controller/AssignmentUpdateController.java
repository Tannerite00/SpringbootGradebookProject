package gradebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import gradebook.entity.Assignment;
import gradebook.service.AssignmentUpdateService;

@RestController
public class AssignmentUpdateController implements AssignmentUpdateControllerInterface {

	@Autowired
	private AssignmentUpdateService assignmentUpdateService;
	
	
	@Override
	public Assignment updateAssignment(Long studentId, String assignmentName,
			String className, Long pointsPossible, Long pointsEarned) {
		
		return assignmentUpdateService.updateAssignment(studentId, assignmentName, className, pointsPossible, pointsEarned);
	}}
