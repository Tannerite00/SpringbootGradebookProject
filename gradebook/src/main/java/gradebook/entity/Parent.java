package gradebook.entity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Parent {

	private Long parentId;
	private String fullName;
	private Long studentId;
}
