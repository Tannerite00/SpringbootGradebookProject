package gradebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gradebook.dao.AssignmentUpdateDao;
import gradebook.entity.Assignment;

@Service
public class AssignmentUpdateService implements AssignmentUpdateServiceInterface {

	@Autowired
	private AssignmentUpdateDao assignmentUpdateDao;
	
	
	public Assignment updateAssignment(Long studentId, String assignmentName,
			String className, Long pointsPossible, Long pointsEarned) {
		return assignmentUpdateDao.updateAssignment(studentId, assignmentName, className, pointsPossible, pointsEarned);
	}

}
