package gradebook.entity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Teacher {

	private Long teacherId;
	private String fullName;
	private String className;
}
