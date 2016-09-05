package com.smacrs.timemanagment.rest.mvc;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.servlet.ModelAndView;

import com.smacrs.timemanagment.core.entities.logicentity.UserTimeTrack;
import com.smacrs.timemanagment.core.entities.systementity.Account;
import com.smacrs.timemanagment.core.entities.systementity.Company;
import com.smacrs.timemanagment.core.entities.systementity.Project;
import com.smacrs.timemanagment.core.entities.systementity.Sprint;
import com.smacrs.timemanagment.core.entities.systementity.User;
import com.smacrs.timemanagment.core.services.UserTimeTrackService;

@Controller
public class HelloController {

	public HelloController() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	Account acc = new Account();

	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is welcome page!");
		model.setViewName("hello");
		return model;

	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin/index");

		return model;

	}

	@RequestMapping(value = "/admin/m**", method = RequestMethod.GET)
	public ModelAndView adminPagse() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin/m");

		return model;

	}

	@RequestMapping(value = "/student**", method = RequestMethod.GET)
	public ModelAndView studentPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is protected page!");
		model.setViewName("student/index");

		return model;

	}

	// Spring Security see this :
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully. Bye");
		}
		model.setViewName("login");

		return model;

	}

	@ResponseBody
	@RequestMapping(value = "/Attend", method = { RequestMethod.POST })
	public ModelAndView GoToAttendanceForm(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		acc.setName(username);
		acc.setPassword(password);
		ModelAndView model = new ModelAndView();
		model.setViewName("Attendance");
		return model;
	}

	@Autowired 
	private UserTimeTrackService userTimeTrackService;

	@RequestMapping(value = "/AttendRespond", method = { RequestMethod.GET })
	public ModelAndView AttendanceRespond() {

		Date StartDate = new Date();
		User user = new User();
		user = userTimeTrackService.Select(acc.getName());
		System.out.println(user.getName());
		System.out.println(user.getId());
		System.out.println(user.getCvLink());
		//user.setId(1);
		Company co= new Company();
		co.setId(1);
      UserTimeTrack userTimeTrack = new UserTimeTrack();
      userTimeTrack.setStartTime(StartDate);
      userTimeTrack.setUser(user);
      userTimeTrack.setCompany(co);
      userTimeTrack.setDate(StartDate);
      userTimeTrack.setEndTime(StartDate);
      userTimeTrack.setTotalMinutes(0);
      
     
      userTimeTrackService.insert(userTimeTrack);
      ModelAndView model = new ModelAndView();
		model.setViewName("AttendanceRespond");
		return model;

	}

}