package gradebook.entity;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AssignmentRequest {
	
	@NotNull
	private Long studentId;
	
	@NotNull
	private String assignmentName;
	
	@NotNull
	private ClassType className;
	
	@NotNull
	private Long pointsPossible;
	
	@NotNull
	private Long pointsEarned;
	
}
