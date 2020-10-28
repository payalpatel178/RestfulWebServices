package com.payal.courserestws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.payal.courserestws.model.Course;

@Consumes("application/xml,application/json")
@Produces("application/xml,application/json")
@Path("/courseservice")
public interface CourseService {

	// To retrieve all the courses
	@Path("/courses")
	@GET
	List<Course> getCourses();

	// To retrieve specific course
	@Path("/courses/{id}")
	@GET
	Course getCourse(@PathParam("id") Long id);

	// To create new course
	@Path("/courses")
	@POST
	Response createCourse(Course course);

	// To update course info
	@Path("/courses")
	@PUT
	Response updateCourse(Course course);

	// To delete specific course
	@Path("/courses/{id}")
	@DELETE
	Response deleteCourse(@PathParam("id") Long id);
	
	// To delete all the courses
	@Path("/courses")
	@DELETE
	Response deleteAllCourses();
}
