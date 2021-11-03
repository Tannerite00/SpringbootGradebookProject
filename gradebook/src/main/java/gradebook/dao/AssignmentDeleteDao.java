package gradebook.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.stereotype.Component;

@Component
public class AssignmentDeleteDao implements AssignmentDeleteDaoInterface {
	
	
	 @Autowired
	  private NamedParameterJdbcTemplate jdbcTemplate;
	  
	  @Override
	  public void deleteAssignment(Long assignmentId) {
	      
	    SqlParams params = generateInsertSql(assignmentId);
	    
	    jdbcTemplate.update(params.sql, params.source);
	    
	  }

	  private SqlParams generateInsertSql(Long assignmentId) {
	    SqlParams params = new SqlParams();
	    
	    // @formatter:off
	    params.sql = ""
	        + "DELETE "
	        + "from assignments "
	        + "where assignment_id = "
	        + ":assignmentId";
	    // @formatter:on
	    
	    params.source.addValue("assignmentId", assignmentId);
	    
	    return params;
	    
	  }
	  
	  class SqlParams {
	    String sql;
	    MapSqlParameterSource source = new MapSqlParameterSource();
	  }
	  
	}



