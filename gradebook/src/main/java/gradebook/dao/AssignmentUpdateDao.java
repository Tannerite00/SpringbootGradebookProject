package gradebook.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import gradebook.entity.Assignment;

@Component
public class AssignmentUpdateDao implements AssignmentUpdateDaoInterface{

	 @Autowired
	  private NamedParameterJdbcTemplate jdbcTemplate;
	
	public Assignment updateAssignment(Long studentId, String assignmentName, String className, Long pointsPossible, Long pointsEarned) {
		
		SqlParams params = generateInsertSql(studentId, assignmentName, className, pointsPossible, pointsEarned);
		
		jdbcTemplate.update(params.sql, params.source);
	    
		// @formatter:off
	  return Assignment.builder()
			  .studentId(studentId)
			  .assignmentName(assignmentName)
			  .className(className)
			  .pointsPossible(pointsPossible)
			  .pointsEarned(pointsEarned)
			  .build();
			  // @formatter:on
}

	private SqlParams generateInsertSql(Long studentId, String assignmentName,
			String className, Long pointsPossible, Long pointsEarned) {
		
		  SqlParams params = new SqlParams();
		  
		    // @formatter:off
		    params.sql = ""
		      + "UPDATE assignments where "
		      + "student_id = :student_id, "
		      + "assignment_name = :assignment_name, "
		      + "class_name = :class_name, "
		      + "points_possible = :points_possible "
		      + "points_earned = :points_earned ";
		    // @formatter:on
		  
		    params.source.addValue("student_id", studentId);
		    params.source.addValue("assignment_name", assignmentName);
		    params.source.addValue("class_name", className);
		    params.source.addValue("points_possible", pointsPossible);
		    params.source.addValue("points_earned", pointsEarned);
		  
		    return params;
		}

		class SqlParams {
		  String sql;
		  MapSqlParameterSource source = new MapSqlParameterSource();
		    }
		
	}

