package gradebook.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;



import gradebook.entity.Assignment;
import gradebook.entity.ClassType;

@Component 
public class AssignmentCreateDao implements AssignmentCreateDaoInterface {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	
	public Assignment createAssignment(Long studentId, ClassType className, String assignmentName, Long pointsPossible, Long pointsEarned) {
		
		SqlParams params = generateInsertSql(studentId, className, assignmentName, pointsPossible, pointsEarned);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(params.sql, params.source, keyHolder);
		
		
				//@formatter: off
				return Assignment.builder()
						.studentId(studentId)
						.className(className)
						.assignmentName(assignmentName)
						.pointsEarned(pointsEarned)
						.pointsPossible(pointsPossible)
						.build();
				//@formatter: on
			};
	


	private SqlParams generateInsertSql(Long studentId, ClassType className,
			String assignmentName, Long pointsPossible, Long pointsEarned) {
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

	
	@Override
	public Assignment deleteAssignment(Long studentId, ClassType className, String assignmentName, Long pointsPossible, Long pointsEarned) {
		
		SqlParams params = generateDeleteSql(studentId, className, assignmentName, pointsPossible, pointsEarned);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(params.sql, params.source, keyHolder);
		
		
				//@formatter: off
				return Assignment.builder()
						.studentId(studentId)
						.className(className)
						.assignmentName(assignmentName)
						.pointsEarned(pointsEarned)
						.pointsPossible(pointsPossible)
						.build();
				//@formatter: on
			};
	


	private SqlParams generateDeleteSql(Long studentId, ClassType className,
			String assignmentName, Long pointsPossible, Long pointsEarned) {
		 SqlParams params = new SqlParams();
		    
		    // @formatter:off
		    params.sql = "delete from assignments where assignment_name = :assignment_name";
			//@formatter: on
		    
		    params.source.addValue("student_id", studentId.toString());
			params.source.addValue("class_name", className);
			params.source.addValue("assignment_name", assignmentName);
			params.source.addValue("points_possible", pointsPossible);
			params.source.addValue("points_earned", pointsEarned);
		    
		return params;
	}



	@Override
	public Optional<Assignment> fetchStudent(Long studentId) {
		// @formatter:off
	    String sql = "" 
	        + "SELECT student_id " 
	        + "FROM assignments "
	        + "WHERE student_id = :student_id";
	    // @formatter:on
	    Map<String, Object> params = new HashMap<>();
	    params.put("student_id", studentId);

	    return Optional.ofNullable(
	        jdbcTemplate.query(sql, params, new StudentResultSetExtractor()));
	  }
	    
	
	@Override
	public Optional<Assignment> fetchclassName(ClassType className) {
		// @formatter:off
	    String sql = "" 
	        + "SELECT class_name " 
	        + "FROM assignments "
	        + "WHERE class_name = :class_name";
	    // @formatter:on
	    Map<String, Object> params = new HashMap<>();
	    params.put("class_name", className);

	    return Optional.ofNullable(
	        jdbcTemplate.query(sql, params, new ClassNameResultSetExtractor()));
	}



	@Override
	public Optional<Assignment> fetchAssignmentName(String assignmentName) {
		// @formatter:off
	    String sql = "" 
	        + "SELECT assignment_name " 
	        + "FROM assignments "
	        + "WHERE assignment_name = :assignment_name";
	    // @formatter:on
	    Map<String, Object> params = new HashMap<>();
	    params.put("assignment_name", assignmentName);

	    return Optional.ofNullable(
	        jdbcTemplate.query(sql, params, new AssignmentNameResultSetExtractor()));
	  }
	



	



	@Override
	public Optional<Assignment> fetchpointsPossible(Long pointsPossible) {
		// @formatter:off
	    String sql = "" 
	        + "SELECT points_possible " 
	        + "FROM assignments "
	        + "WHERE points_possible = :points_possible";
	    // @formatter:on
	    Map<String, Object> params = new HashMap<>();
	    params.put("points_possible", pointsPossible);

	    return Optional.ofNullable(
	        jdbcTemplate.query(sql, params, new PointsPossibleResultSetExtractor()));
	}



	@Override
	public Optional<Assignment> fetchpointsEarned(Long pointsEarned) {
		// @formatter:off
	    String sql = "" 
	        + "SELECT points_earned " 
	        + "FROM assignments "
	        + "WHERE points_earned = :points_earned";
	    // @formatter:on
	    Map<String, Object> params = new HashMap<>();
	    params.put("points_earned", pointsEarned);

	    return Optional.ofNullable(
	        jdbcTemplate.query(sql, params, new PointsEarnedResultSetExtractor()));
	}

	



	@Override
	public Assignment createAssignment(Optional<Assignment> student,
			Optional<Assignment> assignmentName, Optional<Assignment> className,
			Optional<Assignment> pointsPossible,
			Optional<Assignment> pointsEarned) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Assignment saveAssignment(Optional<Assignment> student,
			Optional<Assignment> assignmentName, Optional<Assignment> className,
			Optional<Assignment> pointsPossible,
			Optional<Assignment> pointsEarned) {
		// TODO Auto-generated method stub
		return null;
	}



	



	
		
	}

class StudentResultSetExtractor implements ResultSetExtractor<Assignment> {
    @Override
    public Assignment extractData(ResultSet rs) throws SQLException {
      rs.next();

      // @formatter:off
      return Assignment.builder()
          .studentId(rs.getLong("student_id"))
          .build();
      // @formatter:on

    }
  }

	class AssignmentNameResultSetExtractor implements ResultSetExtractor<Assignment> {
		@Override
		public Assignment extractData(ResultSet rs) throws SQLException {
			rs.next();

			// @formatter:off
			return Assignment.builder()
					.assignmentName(rs.getString("assignment_name"))
					.build();
			// @formatter:on

		}
	}
	
	class ClassNameResultSetExtractor implements ResultSetExtractor<Assignment> {
		@Override
		public Assignment extractData(ResultSet rs) throws SQLException {
			rs.next();

			// @formatter:off
			return Assignment.builder()
					.className(ClassType.valueOf(rs.getString("class_name")))
					.build();
			// @formatter:on

		}
	}
	
	class PointsPossibleResultSetExtractor implements ResultSetExtractor<Assignment> {
		@Override
		public Assignment extractData(ResultSet rs) throws SQLException {
			rs.next();

			// @formatter:off
			return Assignment.builder()
					.pointsPossible(rs.getLong("points_possible")).build();
			// @formatter:on

		}
	}
	
	class PointsEarnedResultSetExtractor implements ResultSetExtractor<Assignment> {
		@Override
		public Assignment extractData(ResultSet rs) throws SQLException {
			rs.next();

			// @formatter:off
			return Assignment.builder()
					.pointsEarned(rs.getLong("points_earned"))
					.build();
			// @formatter:on

		}
	}


	class SqlParams {
		String sql;
		MapSqlParameterSource source = new MapSqlParameterSource();
	}
