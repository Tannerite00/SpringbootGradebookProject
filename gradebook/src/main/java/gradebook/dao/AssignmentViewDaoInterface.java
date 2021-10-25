package gradebook.dao;

import java.util.List;

import gradebook.entity.Assignment;

public interface AssignmentViewDaoInterface {

	
	/**
	 * 
	 * @param studentId
	 * @param fullName
	 * @return
	 */
	List<Assignment> fetchStudents(Long studentId);
}
