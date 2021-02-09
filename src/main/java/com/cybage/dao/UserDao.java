package com.cybage.dao;

import java.sql.SQLException;
import java.util.List;

import com.cybage.model.*;

public interface UserDao {
	public int addUser(User user);
	public List<Course> getCourse(int id) throws Exception;
	public List<Category> getCategory();
	public int addEnrollement(EnrollCourse e);
	public int addVideoDetails(Video v);
	public List<Video> getVideo(int id) throws Exception;
}
