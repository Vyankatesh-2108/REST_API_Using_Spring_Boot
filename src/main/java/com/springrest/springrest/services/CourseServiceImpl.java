package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {

//	List<Course> list;
	
	@Autowired
	private CourseDao courseDao;
	
	public CourseServiceImpl() {
//		list = new ArrayList<>();
//		list.add(new Course(101, "Java Core Course", "This is java Course"));
//		list.add(new Course(102, "Spring Boot Course", "This is Spring Boot"));
		
	}
	
	//get all courses
	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return courseDao.findAll();
	}
	

	//get specific course
	@Override
	public Course getCourse(long courseId) {
//		Course c = null;
//		for(Course course : list) {
//			if(course.getId() == courseId) {
//				c=course;
//				break;
//			}
//		}
		return courseDao.getOne(courseId);
	}

	//add course
	@Override
	public Course addCourse(Course course) {
//		list.add(course);
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
//		list.forEach(e -> {
//			if((e.getId() == course.getId())) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
//		list = this.list.stream().filter(e -> e.getId()!=parseLong).collect(Collectors.toList());
		Course entity = courseDao.getOne(parseLong);
		courseDao.delete(entity);
	}

}
