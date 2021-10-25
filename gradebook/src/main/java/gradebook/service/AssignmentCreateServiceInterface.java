package gradebook.service;

import gradebook.entity.Assignment;
import gradebook.entity.AssignmentRequest;

public interface AssignmentCreateServiceInterface {

	Assignment newAssignment(AssignmentRequest assignmentRequest);

}
