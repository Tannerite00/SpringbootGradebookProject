package gradebook.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gradebook.dao.AssignmentCreateDaoInterface;
import gradebook.entity.Assignment;
import gradebook.entity.AssignmentRequest;

@Service
public class AssignmentDeleteService implements AssignmentDeleteServiceInterface {

	@Autowired
	private AssignmentCreateDaoInterface assignmentCreateDaoInterface;
	
	@Transactional
	@Override
	public Assignment oldAssignment(AssignmentRequest assignmentRequest) {
		Optional<Assignment> student = getStudent(assignmentRequest);
		Optional<Assignment> assignmentName = getAssignmentName(assignmentRequest);
		Optional<Assignment> className = getClassName(assignmentRequest);
		Optional<Assignment> pointsPossible = getPointsPossible(assignmentRequest);
		Optional<Assignment> pointsEarned = getPointsEarned(assignmentRequest);
				
		
		
		return assignmentCreateDaoInterface.saveAssignment(student, assignmentName, className, pointsPossible, pointsEarned );
	}

	private Optional<Assignment> getPointsEarned(AssignmentRequest assignmentRequest) {
		return assignmentCreateDaoInterface.fetchpointsEarned(assignmentRequest.getPointsEarned());
	}

	private Optional<Assignment> getPointsPossible(AssignmentRequest assignmentRequest) {
		return assignmentCreateDaoInterface.fetchpointsPossible(assignmentRequest.getPointsPossible());
	}

	private Optional<Assignment> getClassName(AssignmentRequest assignmentRequest) {
		return assignmentCreateDaoInterface.fetchclassName(assignmentRequest.getClassName());
	}

	private Optional<Assignment> getAssignmentName(AssignmentRequest assignmentRequest) {
		return assignmentCreateDaoInterface.fetchAssignmentName(assignmentRequest.getAssignmentName());
	}

	protected Optional<Assignment> getStudent(AssignmentRequest assignmentRequest) {
		return assignmentCreateDaoInterface.fetchStudent(assignmentRequest.getStudentId());
	}



	
}


