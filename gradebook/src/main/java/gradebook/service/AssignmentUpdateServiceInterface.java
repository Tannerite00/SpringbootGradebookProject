package gradebook.service;

import gradebook.entity.Assignment;

public interface AssignmentUpdateServiceInterface {
	
	 Assignment updateAssignment(Long studentId, String assignmentName,
				String className, Long pointsPossible, Long pointsEarned);

}
