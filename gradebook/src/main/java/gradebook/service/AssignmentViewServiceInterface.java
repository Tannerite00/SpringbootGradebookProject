package gradebook.service;

import java.util.List;

import gradebook.entity.Assignment;

public interface AssignmentViewServiceInterface {
	
	/**
	 * 
	 * @param studentId
	 * @param fullName
	 * @return
	 */
	List<Assignment> fetchStudents(Long studentId);

}
