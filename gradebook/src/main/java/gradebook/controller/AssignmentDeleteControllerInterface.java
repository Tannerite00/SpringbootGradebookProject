package gradebook.controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
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

@RequestMapping("/assignments")
@OpenAPIDefinition(info = @Info(title = "Nebula's School for the Gifted Gradebook"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})

public interface AssignmentDeleteControllerInterface {

//@formatter:off
  @Operation(
      summary = "Deletes an assignment",
      description = "Deletes a sighting given a sightingId",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "An assignment is deleted",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Assignment.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request paramters are invalid",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "No assignmentss were found with the input criteria",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500",
              description = "An unplanned error occurred",
              content = @Content(
                  mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "assignmentId",
              allowEmptyValue = false,
              required = false,
              description = "The Assignment ID (i.e. '1')")
      }
    )
  
  @DeleteMapping
  @ResponseStatus(code = HttpStatus.OK)
  void deleteAssignment(
      @RequestParam(required = false)
          Long assignmentId);
  // @formatter:on

}

