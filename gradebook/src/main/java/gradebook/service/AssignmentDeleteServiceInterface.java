package gradebook.service;

import gradebook.entity.Assignment;
import gradebook.entity.AssignmentRequest;

public interface AssignmentDeleteServiceInterface {

	Assignment oldAssignment(AssignmentRequest assignmentRequest);

}
