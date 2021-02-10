package com.cybage.service;

import java.util.List;

import com.cybage.dao.UserDao;
import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.model.EnrollCourse;
import com.cybage.model.User;
import com.cybage.model.Video;

public class UserServiceImpl implements UserService{

	private UserDao userDao;
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public List<Course> getCourse(int id) throws Exception {
		List<Course> course = userDao.getCourse(id);
		return course;
	}

	public List<Category> getCategory() throws Exception {
		List<Category> categories = userDao.getCategory();
		return categories;
	}

	public int addEnrollement(EnrollCourse e) throws Exception{
		return userDao.addEnrollement(e);
	}

	public List<Video> getVideo(int id) throws Exception{
		List<Video> video = userDao.getVideo(id);
		return video;
	}
	public int getentrollement(int user_id, int course_id) throws Exception {
		return userDao.getentrollement(user_id, course_id);
	}
	public int getUserId(String username) throws Exception {
		return userDao.getUserId(username);
	}

	public List<Category> searchByCategory(String search) throws Exception {
		return userDao.searchByCategory(search);
	}

	public List<Course> searchByCourse(String search) throws Exception {
		return userDao.searchByCourse(search);
	}

}
