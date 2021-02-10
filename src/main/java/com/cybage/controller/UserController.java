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
import com.cybage.model.Category;
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
			String username = "vedang7";
			int user_id = 0;
			try {
				user_id = userService.getUserId(username);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			List<Category> allCategories = null;
			try {
				allCategories = userService.getCategory();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			session.setAttribute("user_id", user_id);
			request.setAttribute("allCategories", allCategories);
			request.getRequestDispatcher("/user/landing.jsp").forward(request, response);
		}
		if (path.equals("/search")) {
			String text = request.getParameter("search");
			int searchresult = 0;
			List<Course> searchedcourse = null;
			try {
				searchedcourse = userService.searchByCourse(text);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			List<Category> searchedcategories = null;
			try {
				searchedcategories = userService.searchByCategory(text);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(searchedcategories.size() == 0) {
				searchresult = 0;
				request.setAttribute("searchresult", searchresult);
			}
			request.setAttribute("searchedcategories", searchedcategories);
			request.getRequestDispatcher("/user/landing.jsp").forward(request, response);
		}
		if (path.equals("/show-courses")) {
			int category_id = Integer.parseInt(request.getParameter("category_id"));
			int user_id = (Integer)session.getAttribute("user_id");
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
			request.setAttribute("enrolledcourse", enrolledcourse);
			request.setAttribute("newcourse", newcourse);
			request.getRequestDispatcher("/user/allcoursesforuser.jsp").forward(request, response);
		}
		
		if (path.equals("/start-course")) {
			int course_id = Integer.parseInt(request.getParameter("course_id"));
			int user_id = (Integer)session.getAttribute("user_id");
			
			java.util.Date utilDate = new java.util.Date();
			Date startDate = new Date(utilDate.getTime());
			
			EnrollCourse enroll = new EnrollCourse(user_id, course_id,startDate, null);
			try {
				userService.addEnrollement(enroll);
			} catch (Exception e) {
				e.getLocalizedMessage();
			}
			List<Video> video = null;
			try {
				video = userService.getVideo(course_id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("video", video);
			request.getRequestDispatcher("/user/videodetails.jsp").forward(request, response);
		}
		if (path.equals("/continue-course")) {
			int course_id = Integer.parseInt(request.getParameter("course_id"));
			List<Video> video = null;
			try {
				video = userService.getVideo(course_id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("video", video);
			request.getRequestDispatcher("/user/videodetails.jsp").forward(request, response);
		}
		if (path.equals("/start-video")) {
			System.out.println("inside /start-video of usercontroller");
			int video_id = Integer.parseInt(request.getParameter("video_id"));
			System.out.println("video_id: "+video_id);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
