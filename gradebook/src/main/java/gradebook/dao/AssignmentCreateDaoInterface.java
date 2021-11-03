package gradebook.dao;

import gradebook.entity.Assignment;

public interface AssignmentCreateDaoInterface {

	



	

	Assignment deleteAssignment(Long studentId, String className,
			String assignmentName, Long pointsPossible, Long pointsEarned);

	Assignment createAssignment(String studentId, String assignmentName, String className, String pointsPossible, String pointsEarned);

	

	

}
