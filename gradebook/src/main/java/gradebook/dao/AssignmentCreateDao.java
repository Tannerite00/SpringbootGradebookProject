package gradebook.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;



import gradebook.entity.Assignment;

@Component 
public class AssignmentCreateDao implements AssignmentCreateDaoInterface {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	
	public Assignment createAssignment(String studentId, String assignmentName, String className, String pointsPossible, String pointsEarned) {
		
		SqlParams params = generateInsertSql(studentId, assignmentName, className, pointsPossible, pointsEarned);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(params.sql, params.source, keyHolder);
		
		Long assignmentId = keyHolder.getKey().longValue();
				
				//@formatter: off
				return Assignment.builder()
						.assignmentId(assignmentId)
						.build();
				//@formatter: on
			};
	


	private SqlParams generateInsertSql(String studentId, String assignmentName, String className, String pointsPossible, String pointsEarned) {
		 SqlParams params = new SqlParams();
		    
		    // @formatter:off
		    params.sql = "insert into assignments(student_id, class_name, assignment_name, points_possible, points_earned) values (:student_id, :class_name, :assignment_name, :points_possible, :points_earned)";
			//@formatter: on
		    
		    params.source.addValue("student_id", studentId);
			params.source.addValue("class_name", className);
			params.source.addValue("assignment_name", assignmentName);
			params.source.addValue("points_possible", pointsPossible);
			params.source.addValue("points_earned", pointsEarned);
		    
		return params;
	}

	
	

	

	class SqlParams {
		String sql;
		MapSqlParameterSource source = new MapSqlParameterSource();
	}
	
}
