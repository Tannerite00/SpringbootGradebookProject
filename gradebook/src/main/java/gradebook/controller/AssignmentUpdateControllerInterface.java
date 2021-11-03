package gradebook.controller;
import gradebook.entity.Assignment;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;


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
@RequestMapping("/assignment")
public interface AssignmentUpdateControllerInterface {
	// @formatter:off
				@Operation(
					summary = "Updates an assignment",
					description = "Updates an existing assignment.",
					responses = {
						@ApiResponse(
								responseCode = "201", 
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
								description = "No Assignments were found with input criteria.",
								content = @Content(mediaType = "application/json")),	
						@ApiResponse(
								responseCode = "500",
								description = "An unplanned error occurred.", 
								content = @Content(mediaType = "application/json"))	
					},
							 parameters = {
							          @Parameter(
							              name = "studentId",
							              allowEmptyValue = false,
							              required = false,
							              description = "The student ID"),
							          
							          @Parameter(
							              name = "assignmentName",
							              allowEmptyValue = false,
							              required = false,
							              description = "The assignment name"),
							          
							          @Parameter(
							              name = "className",
							              allowEmptyValue = false,
							              required = false,
							              description = "The class name"),
							          
							          @Parameter(
							              name = "pointsPossible",
							              allowEmptyValue = false,
							              required = false,
							              description = "The maximum points possible"),
							          @Parameter(
							              name = "pointsEarned",
							              allowEmptyValue = false,
							              required = false,
							              description = "The points earned by the student")
							      }
				)
			
				@PostMapping
				  @ResponseStatus(code = HttpStatus.OK)
				  Assignment updateAssignment(
				      @RequestParam(required = false)
				          Long studentId,
				      @RequestParam(required = false)
				          String assignmentName,
				      @RequestParam(required = false)
				          String className,
				      @RequestParam(required = false)
				          Long pointsPossible,
				      @RequestParam(required = false)
				          Long pointsEarned);

				// @formatter:on

}
