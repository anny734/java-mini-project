package com.cybage.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cybage.dao.UserDao;
import com.cybage.dao.UserDaoImpl;
import com.cybage.model.Course;
import com.cybage.model.EnrollCourse;
import com.cybage.model.Video;
import com.cybage.service.UserService;
import com.cybage.service.UserServiceImpl;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDaoImpl();
	
	private UserService userService = new UserServiceImpl(userDao);

    public UserController() {
        super();
        }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();
//		pw.append("Served at: ").append(request.getContextPath());
		String path = request.getPathInfo();
		if (path.equals("/main")) {
			request.getRequestDispatcher("/user/landing.jsp").forward(request, response);
		}
		
		if (path.equals("/show-courses")) {
			System.out.println("inside allcourses of usercontroller");
			int category_id = Integer.parseInt(request.getParameter("category_id"));
			int user_id = 1011;
			List<Course> course = null;
			List<Course> enrolledcourse = new ArrayList<Course>();
			List<Course> newcourse = new ArrayList<Course>();
			try {
				course = userService.getCourse(category_id);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			for (int i = 0; i < course.size(); i++) {
	            int course_id = course.get(i).getId();
	            try {
				int result = userService.getentrollement(user_id, course_id);
						if(result==1) {
							enrolledcourse.add(course.get(i));
						}else{
							newcourse.add(course.get(i));	
						}		
	            	} catch (Exception e1) {
	            		e1.getLocalizedMessage();
	            		}
	        }
			for (int i = 0; i < enrolledcourse.size(); i++) {
				System.out.println(enrolledcourse.get(i).toString());
			}
			request.setAttribute("enrolledcourse", enrolledcourse);
			request.setAttribute("newcourse", newcourse);
			request.getRequestDispatcher("/user/allcoursesforuser.jsp").forward(request, response);
//			request.setAttribute("newcourse", newcourse);
//			request.getRequestDispatcher("/user/allcourses.jsp").forward(request, response);
		}
		
		if (path.equals("/start-course")) {
			System.out.println("inside /start-course");
			int course_id = Integer.parseInt(request.getParameter("course_id"));
			int user_id = 15;
			
			java.util.Date utilDate = new java.util.Date();
			Date startDate = new Date(utilDate.getTime());
			
			EnrollCourse enroll = new EnrollCourse(user_id, course_id,startDate, null);
			
//			System.out.println("name"+request.getParameter("course_name"));
			
			List<Video> video = null;
			try {
				video = userService.getVideo(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			try {
				userService.addEnrollement(enroll);
			} catch (Exception e) {
				e.getLocalizedMessage();
			}
			request.setAttribute("video", video);
			request.getRequestDispatcher("/user/videodetails.jsp").forward(request, response);
		}
		if (path.equals("/continue-course")) {
			List<Video> video = null;
			try {
				video = userService.getVideo(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("video", video);
			request.getRequestDispatcher("/user/videodetails.jsp").forward(request, response);
		}
		if (path.equals("/start-video")) {
			System.out.println("inside viewvideo of usercontroller");
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
