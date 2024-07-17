package io.akhil.springbootstarter.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.akhil.springbootstarter.topic.Topic;

@RestController
public class CourseController {
	@Autowired
	private CourseService courseService;
  @GetMapping("/topics/{id}/courses")	
  public List<Course> getAllCourses(@PathVariable String id) {
	   courseService.getAllCourses(id);
  }
  @GetMapping("/topics/{topicId}/courses/{id}")
  public void getCourse(@PathVariable String id) {
	   courseService.getCourse(id);
  }
  @PostMapping("/topics/{topicId}/courses/{id}")
  public void addCourse(@RequestBody Course course,@PathVariable String topicId) {
	  course.setTopic(new Topic(topicId,"",""));
	  courseService.addCourse(course);
  }
  
  @PutMapping("/topics/{topicId}/courses/{id}")
  public void updateCourse(@RequestBody Course course,@PathVariable String id,@PathVariable String topicId)
  {
	 course.setTopic(new Topic(topicId,"","")); 
	 courseService.updateCourse(course);
  }
  @DeleteMapping("/topics/{topicId}/courses/{id}")
  public void deleteCourse(@PathVariable String id)
  {
	  courseService.deleteCourse(id);
  }
}
