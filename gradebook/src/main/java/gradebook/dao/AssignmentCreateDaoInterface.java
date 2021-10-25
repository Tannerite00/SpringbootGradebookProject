package gradebook.dao;

import java.util.Optional;

import gradebook.entity.Assignment;
import gradebook.entity.ClassType;

public interface AssignmentCreateDaoInterface {

	

	Optional<Assignment> fetchStudent(Long studentId);

	Optional<Assignment> fetchAssignmentName(String assignmentName);

	Optional<Assignment> fetchclassName(ClassType className);

	Optional<Assignment> fetchpointsPossible(Long pointsPossible);

	Optional<Assignment> fetchpointsEarned(Long pointsEarned);

	

	Assignment deleteAssignment(Long studentId, ClassType className,
			String assignmentName, Long pointsPossible, Long pointsEarned);

	Assignment createAssignment(Optional<Assignment> student,
			Optional<Assignment> assignmentName, Optional<Assignment> className,
			Optional<Assignment> pointsPossible,
			Optional<Assignment> pointsEarned);

	Assignment saveAssignment(Optional<Assignment> student,
			Optional<Assignment> assignmentName, Optional<Assignment> className,
			Optional<Assignment> pointsPossible,
			Optional<Assignment> pointsEarned);

	

}
