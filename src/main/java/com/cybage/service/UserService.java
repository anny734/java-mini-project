package com.cybage.service;

import java.util.List;

import com.cybage.model.*;

public interface UserService {
	public List<Course> getCourse(int id) throws Exception;
	public List<Category> getCategory() throws Exception;
	public int addEnrollement(EnrollCourse e) throws Exception;
	public int getentrollement(int user_id, int course_id) throws Exception;
	public List<Video> getVideo(int id) throws Exception;
	public int getUserId(String username) throws Exception;
	public List<Category> searchByCategory(String search) throws Exception;
	public List<Course> searchByCourse(String search) throws Exception;
}
