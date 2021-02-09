package com.cybage.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.cybage.model.*;
import com.cybage.util.DbUtil;

public class UserDaoImpl implements UserDao{
	
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Course> getCourse(int id) throws Exception {
		Connection con = DbUtil.getCon();

	
		String sql = "select course_id, course_name, course_image, category_id, course_desc from course where category_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		System.out.println("in course table category_id: "+id);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		List<Course> courses = new ArrayList<Course>();
		while (rs.next()) {
			Course course = new Course();
			course.setId(rs.getInt(1));
			course.setName(rs.getString(2));
			course.setCourse_image(rs.getBinaryStream(3));
			course.setCategory(rs.getString(4));
			course.setDesc(rs.getString(5));
			courses.add(course);
		}
		return courses;
	}

	public List<Category> getCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	public int addEnrollement(EnrollCourse e) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int addVideoDetails(Video v) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Video> getVideo(int id) throws Exception{
		Connection con = DbUtil.getCon();

		String sql = "select video_id, video_name, duration, video_url from video where course_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		List<Video> videos = new ArrayList<Video>();
		while (rs.next()) {
			Video video = new Video();
			video.setId(rs.getInt(1));
			video.setName(rs.getString(2));
			video.setDuration(rs.getInt(3));
			video.setUrl(rs.getString(4));
			videos.add(video);
		}
		return videos;
	}

}
