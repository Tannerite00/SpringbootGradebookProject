package gradebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gradebook.dao.AssignmentDeleteDao;


@Service

public class AssignmentDeleteService implements AssignmentDeleteServiceInterface {

	@Autowired
	private AssignmentDeleteDao assignmentDeleteDao;

	public void deleteAssignment(Long assignmentId) {
		assignmentDeleteDao.deleteAssignment(assignmentId);
		
	}

	
	
	
}
