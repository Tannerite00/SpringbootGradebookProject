package gradebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gradebook.dao.AssignmentCreateDaoInterface;
import gradebook.entity.Assignment;


@Service
public class AssignmentCreateService implements AssignmentCreateServiceInterface {

	@Autowired
	private AssignmentCreateDaoInterface assignmentCreateDaoInterface;
	
	@Transactional
	@Override
	public Assignment createAssignment(String studentId, String assignmentName, String className, String pointsPossible, String pointsEarned) {
				
		
		return assignmentCreateDaoInterface.createAssignment(studentId, assignmentName, className, pointsPossible, pointsEarned );
	}

	

	
}
