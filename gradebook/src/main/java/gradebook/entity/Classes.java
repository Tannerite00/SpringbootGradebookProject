package gradebook.entity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Classes {

	private Long classId;
	private String className;
	private Long studentId;
	private Long teacherId;
}
