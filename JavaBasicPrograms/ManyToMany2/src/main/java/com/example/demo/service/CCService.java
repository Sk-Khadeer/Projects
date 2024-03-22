package com.example.demo.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CC;
import com.example.demo.entity.College;
import com.example.demo.entity.Course;
import com.example.demo.repository.CollegeRepository;

@Service
public class CCService {
	@Autowired
	private CollegeRepository cRepo;

	public Set<College> create(CC dto){
		Set<Course> courseList=dto.getCourses();
		Set<College> collegeList=dto.getColleges();
		courseList.forEach(course->course.setCollege(collegeList));
		collegeList.forEach(college->college.setCourses(courseList));
		cRepo.saveAll(collegeList);
		return collegeList;
	}
}
