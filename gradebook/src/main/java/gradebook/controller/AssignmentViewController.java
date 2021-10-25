package gradebook.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import gradebook.entity.Assignment;
import gradebook.service.AssignmentViewServiceInterface;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AssignmentViewController implements AssignmentViewControllerInterface{
	
	@Autowired
	private AssignmentViewServiceInterface gradebookService;
	
	@Override
	public List<Assignment> fetchStudents(Long studentId) {
		log.debug("studentId={}", studentId);
		return gradebookService.fetchStudents(studentId);
	}

}
