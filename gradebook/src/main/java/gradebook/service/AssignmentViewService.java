package gradebook.service;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




import gradebook.dao.AssignmentViewDaoInterface;
import gradebook.entity.Assignment;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AssignmentViewService implements AssignmentViewServiceInterface {
	
	
	@Autowired AssignmentViewDaoInterface gradebookDao;
	
	
	@Transactional(readOnly = true)
	@Override
	public List<Assignment> fetchStudents(Long studentId) {
		log.debug("the fetchStudents model was called with studentId={}", studentId);
		List<Assignment> students = gradebookDao.fetchStudents(studentId);
		
		if(students.isEmpty()) {
			String msg = String.format("No students found with studentId = %s " , studentId);
			
			throw new NoSuchElementException(msg);
		}
		
		
		return students;
	}
	
	
	
		}


