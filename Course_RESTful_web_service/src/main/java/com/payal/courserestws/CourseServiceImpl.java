package com.payal.courserestws;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.payal.courserestws.model.Course;

@Service
public class CourseServiceImpl implements CourseService {

	// map
	Map<Long, Course> courses = new HashMap<>();
	long currentId = 420;

	// constructor
	public CourseServiceImpl() {
		init();
	}

	// init() method
	void init() {
		Course course = new Course();
		course.setCourseId(currentId);
		course.setCourseName("Developing Web Services");
		course.setInstructorName("Reza Mirsalari");
		course.setTextbookTitle("Web Services: Principles and Technology");
		course.setNumberOfCredits(2.00);
		// initializes the map
		courses.put(course.getCourseId(), course);
	}

	// method to retrieve all the courses
	@Override
	public List<Course> getCourses() {
		Collection<Course> results = courses.values();
		List<Course> response = new ArrayList<>(results);
		return response;
	}

	// method to retrieve specific course
	@Override
	public Course getCourse(Long id) {
		// exception handling
		if (courses.get(id) == null) {
			// Way 1 : using the WebApplicationException class
			// throw new WebApplicationException(Response.Status.NOT_FOUND);

			// Way 2 : using specific exceptions provided by JAX-RS
			throw new NotFoundException();
		}
		return courses.get(id);
	}

	// method to create course
	@Override
	public Response createCourse(Course course) {
		course.setCourseId(++currentId);
		courses.put(course.getCourseId(), course);
		return Response.ok(course).build();
	}

	// method to update course
	@Override
	public Response updateCourse(Course course) {
		// exception handling
		if (courses.get(course.getCourseId()) == null) {
			throw new NotFoundException();
		}
		Course currentCourse = courses.get(course.getCourseId());

		Response response;
		if (currentCourse != null) {
			courses.put(course.getCourseId(), course);
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();
		}
		return response;
	}

	// method to delete specific course
	@Override
	public Response deleteCourse(Long id) {
		// exception handling
		if (courses.get(id) == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		Course course = courses.get(id);

		Response response;
		if (course != null) {
			courses.remove(course.getCourseId(), course);
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();
		}
		return response;
	}

	// method to delete all courses
	@Override
	public Response deleteAllCourses() {

		Response response;
		// check if courses hash map is not empty
		if (courses.isEmpty() == false) {
			// clear courses i.e. remove everything
			courses.clear();
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();
		}
		return response;
	}

}
