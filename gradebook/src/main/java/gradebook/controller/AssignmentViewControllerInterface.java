package gradebook.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import gradebook.entity.Assignment;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;


@OpenAPIDefinition(info = @Info(title = "Nebula's School for the Gifted Gradebook"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.")})

@Validated
@RequestMapping("/school-gradebook")
public interface AssignmentViewControllerInterface {
	// @formatter:off
		@Operation(
			summary = "Returns a list of students",
			description = "Returns a students assignments with grades given a student ID.",
			responses = {
				@ApiResponse(
						responseCode = "200", 
						description = "A list of a specific students assignments with grades are returned.", 
						content = @Content(
								mediaType = "application/json", 
								schema = @Schema(implementation = Assignment.class))),	
				@ApiResponse(
						responseCode = "400", 
						description = "The request parameters are invalid.",
						content = @Content(mediaType = "application/json")),	
				@ApiResponse(
						responseCode = "404", 
						description = "No Students were found with input criteria.",
						content = @Content(mediaType = "application/json")),	
				@ApiResponse(
						responseCode = "500",
						description = "An unplanned error occurred.", 
						content = @Content(mediaType = "application/json"))	
			},
			parameters = {
				@Parameter(
						name = "studentId", 
						allowEmptyValue = true, 
						required = false, 
						description = "The student's Id number (i.e., '1')"),
				
			}
		)
		// @formatter:on
		@GetMapping
		@ResponseStatus(code = HttpStatus.OK)
		List<Assignment> fetchStudents(@RequestParam Long studentId);
}
