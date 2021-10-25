package gradebook.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import gradebook.entity.Assignment;
import gradebook.entity.ClassType;
import lombok.extern.slf4j.Slf4j;

@Component 
@Slf4j
public class AssignmentViewDao implements AssignmentViewDaoInterface {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public List<Assignment> fetchStudents(Long studentId) {
		log.debug("DAO: studentId={}", studentId);
		
		//@formatter: off
				String sql = ""
						+ "Select * "
						+ "From assignments "
						+ "where student_id = :student_id";
				//@formatter: on
				
				Map<String, Object> params = new HashMap<>(); 
				params.put("student_id", studentId.toString());
				 
				
				return jdbcTemplate.query(sql,  params, new RowMapper<>() {

					@Override
					public Assignment mapRow(ResultSet rs, int rowNum) throws SQLException {
						//@formatter: off
						return Assignment.builder()
								.assignmentId(rs.getLong("assignment_id"))
								.studentId(rs.getLong("student_id"))
								.assignmentName(rs.getString("assignment_name"))
								.className(ClassType.valueOf(rs.getString("class_name")))
								.pointsEarned(rs.getLong("points_earned"))
								.pointsPossible(rs.getLong("points_possible"))
								.build();
					}});
			}
	}


