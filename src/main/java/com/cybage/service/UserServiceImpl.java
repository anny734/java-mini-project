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
	public int addUser(User user) {
		
		return 0;
	}

	public List<Course> getCourse(int id) throws Exception {
		List<Course> course = userDao.getCourse(id);
		return course;
	}

	public List<Category> getCategory() {
	
		return null;
	}

	public int addEnrollement(EnrollCourse e) {
		
		return 0;
	}

	public int addVideoDetails(Video v) {
		
		return 0;
	}

	public List<Video> getVideo(int id) throws Exception{
		List<Video> video = userDao.getVideo(id);
		return video;
	}

}
