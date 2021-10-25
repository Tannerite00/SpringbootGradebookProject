package gradebook.entity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {

	private Long studentId;
	private String fullName;
}
