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
import com.smacrs.timemanagment.core.entities.systementity.Department;
import com.smacrs.timemanagment.core.entities.systementity.Project;
import com.smacrs.timemanagment.core.entities.systementity.Sprint;
import com.smacrs.timemanagment.core.entities.systementity.User;
import com.smacrs.timemanagment.core.services.AccountService;
import com.smacrs.timemanagment.core.services.CompanyService;
import com.smacrs.timemanagment.core.services.DepartmentService;
import com.smacrs.timemanagment.core.services.UserService;
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
		acc.setUsername(username);
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
		user = userTimeTrackService.Select(acc.getUsername());
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
	
	@RequestMapping(value = "/signup", method = { RequestMethod.GET })
	public ModelAndView SignUp() {
      ModelAndView model = new ModelAndView();
      model.setViewName("signup");
      return model ;
	}
	
	@Autowired 
	AccountService accountService;
	
	@Autowired
	CompanyService companyService; 
	
	@Autowired
	DepartmentService departmentService;
	
	@Autowired
	UserService userService;
	
	@ResponseBody
	@RequestMapping(value = "/Home", method =  {RequestMethod.GET} )
	public String SignupRespond(@RequestParam("name") String name,
			@RequestParam("username") String userName,@RequestParam("email") String email
			,@RequestParam("address") String address,@RequestParam("cvlink") String cvLink
			,@RequestParam("password") String password,@RequestParam("companynickname") String companyNickName
			,@RequestParam("companyaddress") String companyAddress,@RequestParam("departmentname") String departmentName
			,@RequestParam("companyname") String companyName,@RequestParam("companyemail") String companyEmail) {
		
	    byte b = 1;
		Account account = new Account();
		account.setEmail(email);
		account.setPassword(password);
		account.setUsername(userName);
	//	account.setName(name);
	    account.setIsAccountNonExpired(b);
	    account.setIsAccountNonLocked(b);
	    account.setIsCredentialsNonExpired(b);
	    account.setIsEnabled(b);
	    
	    accountService.createAccount(account);
	    
	    Company company = new Company();
	    company.setName(companyName);
	    company.setNickname(companyNickName);
	    company.setAddress(companyAddress);
	    company.setEmail(companyEmail);
	    company.setIsCompanyNonExpired(true);
       company.setIsCompanyNonLocked(true);	
       
	    companyService.CreateCompany(company);    
	    
	    Department department= new Department(); 
	    department.setName(departmentName);
	    department.setCompany(company);
	    department.setActive(true);
	    
	    departmentService.createDepartment(department);
	    
	    
	    User user = new User();
	    user.setName(name);
	   // user.setDepartment(department);
	    user.setCvLink(cvLink);
	    user.setAddress(address);
	    //user.setAccount(account);
	    System.out.println(account.getId());
	    user.setId(account.getId());
	    userService.CreateUser(user);
	    
	    
		return "You are successfully signed up";
	}
}