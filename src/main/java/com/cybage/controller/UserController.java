package com.cybage.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cybage.dao.UserDao;
import com.cybage.dao.UserDaoImpl;
import com.cybage.model.Course;
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
		System.out.println(path);
		if (path.equals("/main")) {
			request.getRequestDispatcher("/user/landing.jsp").forward(request, response);
			System.out.println("ugvwu");
		}
		if (path.equals("/show-courses")) {
			System.out.println("inside allcourses of usercontroller");
			List<Course> course = null;
			try {
				course = userService.getCourse(1);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("course", course);
			request.getRequestDispatcher("/user/categorydetails.jsp").forward(request, response);
			
		}
		
		if (path.equals("/start-course")) {
			System.out.println("inside allvideos of usercontroller");
			
			System.out.println("id: "+request.getParameter("course_id"));
			/*System.out.println("name"+session.getAttribute("course_name"));*/
			
			List<Video> video = null;
			try {
				video = userService.getVideo(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
//			userService.addEnrollement(e)
			request.setAttribute("video", video);
			request.getRequestDispatcher("/user/videodetails.jsp").forward(request, response);
		}
		if (path.equals("/start-video")) {
			System.out.println("inside viewvideo of usercontroller");
//			List<Video> video = null;
//			try {
//				video = userService.getVideo(1);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			request.setAttribute("video", video);
//			request.getRequestDispatcher("/user/videodetails.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
