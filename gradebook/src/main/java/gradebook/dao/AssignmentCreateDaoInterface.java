package gradebook.dao;

import gradebook.entity.Assignment;

public interface AssignmentCreateDaoInterface {

	



	


	Assignment createAssignment(String studentId, String assignmentName, String className, String pointsPossible, String pointsEarned);

	

	

}
