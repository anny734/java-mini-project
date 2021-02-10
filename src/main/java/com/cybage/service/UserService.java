package com.cybage.service;

import java.util.List;

import com.cybage.model.*;

public interface UserService {
	public int addUser(User user);
	public List<Course> getCourse(int id) throws Exception;
	public List<Category> getCategory();
	public int addEnrollement(EnrollCourse e) throws Exception;
	public int getentrollement(int user_id, int course_id) throws Exception;
	public int addVideoDetails(Video v);
	public List<Video> getVideo(int id) throws Exception;
	
}
