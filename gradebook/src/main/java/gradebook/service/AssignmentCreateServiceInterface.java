package gradebook.service;

import gradebook.entity.Assignment;

public interface AssignmentCreateServiceInterface {

	Assignment createAssignment(String studentId, String assignmentName, String className, String pointsPossible, String pointsEarned);

}
