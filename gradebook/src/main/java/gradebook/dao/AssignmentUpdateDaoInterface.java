package gradebook.dao;

import gradebook.entity.Assignment;

public interface AssignmentUpdateDaoInterface {
	Assignment updateAssignment(Long studentId, String assignmentName,
			String className, Long pointsPossible, Long pointsEarned);
}
