package gradebook.entity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Assignment {

	private Long assignmentId;
	private Long studentId;
	private String assignmentName;
	private String className;
	private Long pointsPossible;
	private Long pointsEarned;
}
