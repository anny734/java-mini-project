package com.cybage.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.cybage.model.*;
import com.cybage.util.DbUtil;

public class UserDaoImpl implements UserDao{

	public List<Course> getCourse(int id) throws Exception {
		Connection con = DbUtil.getCon();
		String sql = "select course_id, course_name, course_image, category_id, course_desc from course where category_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
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

	public List<Category> getCategory() throws Exception{
		Connection con = DbUtil.getCon();
		String sql = "select category_id, category_name, category_image from category";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		List<Category> categories = new ArrayList<Category>();
		while (rs.next()) {
			Category category = new Category();
			category.setId(rs.getInt(1));
			category.setName(rs.getString(2));
			category.setCategory_url(rs.getString(3));
			categories.add(category);
		}
		return categories;
	}

	public int addEnrollement(EnrollCourse e) throws Exception {
		int count = 0;
		Connection con = DbUtil.getCon();
		String sql = "insert into enroll_course (user_id,course_id,start_date) values (?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		int user_id = e.getUserId();
		int course_id = e.getCourseId();
		ps.setInt(1,user_id);
		ps.setInt(2,course_id);
		ps.setDate(3,e.getStartDate());

		if(ps.executeUpdate()==1) {
			String sql1 = "select video_id from video where course_id=? ";
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ps1.setInt(1, course_id);
			ResultSet rs = ps1.executeQuery();

			while (rs.next()) {
				int video_id = rs.getInt(1);
				String sql2 = "insert into enroll_course_video (user_id, course_id, video_id) values(?,?,?)";
				PreparedStatement ps2 = con.prepareStatement(sql2);
				ps2.setInt(1, user_id);
				ps2.setInt(2, course_id);
				ps2.setInt(3, video_id);
				
				ps2.executeUpdate();
			}
			
		}
		
		return count;
		 
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

	public int getentrollement(int user_id, int course_id) throws Exception {
		Connection con = DbUtil.getCon();
		String sql = "select start_date from enroll_course where user_id = ? and course_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, user_id);
		ps.setInt(2, course_id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			return 1;
		}else {
			return 0;
		}
		
	}

	public int getUserId(String username) throws Exception {
		Connection con = DbUtil.getCon();
		String sql = "select user_id from user where username = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
			return rs.getInt(1);
		else
			return 0;
	}

	public List<Category> searchByCategory(String search) throws Exception {
		Connection con = DbUtil.getCon();
		String sql = "select category_id, category_name, category_image from category where category_name like ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "%"+ search +"%");
		ResultSet rs = ps.executeQuery();

		List<Category> categories = new ArrayList<Category>();
		while (rs.next()) {
			Category category = new Category();
			category.setId(rs.getInt(1));
			category.setName(rs.getString(2));
			category.setCategory_url(rs.getString(3));
			categories.add(category);
		}
		return categories;
	}

	public List<Course> searchByCourse(String search) throws Exception {
		Connection con = DbUtil.getCon();
		String sql = "select course_id, course_name, course_image, category_id, course_desc from course where course_name like ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "%"+ search +"%");
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

}
