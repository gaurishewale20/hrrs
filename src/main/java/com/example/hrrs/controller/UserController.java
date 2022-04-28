package com.example.hrrs.controller;

import java.util.List;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;


import com.example.hrrs.constants.Constants;
import com.example.hrrs.controller.bean.Reservation;
import com.example.hrrs.controller.bean.User;
import com.example.hrrs.service.ReservationService;
import com.example.hrrs.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	ReservationService resService;

	Logger logger = LoggerFactory.getLogger(UserController.class);

	public int validLogin(HttpSession session, Long id) {
		if (id == session.getAttribute("id")) {
			return 1;
		}
		return 0;
	}

	@RequestMapping(value = { "", "/login" }, method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logoutPage(HttpSession session) {
//    	session.setAttribute("user","employee");
		session.removeAttribute("user");
		session.removeAttribute("id");
		return new ModelAndView("redirect:/login");
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminPage(ModelMap model, HttpSession session) {
		List<User> userList = userService.getAllUsers();
		List<Reservation> resList = resService.getAllReservations();
		model.put("userList", userList);
		model.put("resList", resList);

		String user = (String) session.getAttribute("user");
		if (user == "admin")
			return new ModelAndView("admin");

		return new ModelAndView("redirect:/login");

	}

	@RequestMapping(value = "/{id}/user", method = RequestMethod.GET)
	public ModelAndView userPage(ModelMap model, @PathVariable Long id, HttpSession session) {
		logger.info("id value: " + id);
		session.setAttribute("login_id", id);

		logger.info("session_login_id value: " + session.getAttribute("login_id"));

		if (validLogin(session, id) == 0)
			return new ModelAndView("redirect:/logout");
		User user = userService.getUserById(id);
		model.put("user_details", user);
//    	model.addAttribute("user_details",user);
		return new ModelAndView("user");
	}



	@RequestMapping(value = "/{id}/details", method = RequestMethod.GET)
	public ModelAndView userDetailsPage(ModelMap model, @PathVariable("id") Long id, HttpSession session) {
		logger.info("userdetails session_login_id value: " + session.getAttribute("login_id"));
		if (validLogin(session, id) == 0)
			return new ModelAndView("redirect:/logout");
		User user = userService.getUserById(id);
		ModelAndView mv = new ModelAndView("details");
		model.put("user_details", user);
		return mv;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView welcomePage(ModelMap model, @RequestParam String userId, @RequestParam String password,
			HttpSession session) {
		User user = userService.getUserByUserId(userId);
		Long id = user.getId();
		if (user.getPassword().equals(password)) {
			model.put("userId", userId);
			if (user.getRoleId() == Constants.ROLE_ADMIN) {
				session.setAttribute("user", "admin");
				session.setAttribute("id", id);
				return new ModelAndView("redirect:/admin");
			} else if (user.getRoleId() == Constants.ROLE_USER) {
				session.setAttribute("user", "user");
				session.setAttribute("id", id);
				return new ModelAndView("redirect:/" + id.toString() + "/user");
			}
		}

		model.put("errMsg", "Please provide the correct UserId and Password!");
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerPage(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		return "register";
	}

	@RequestMapping(value = "/{id}/createreservation", method = RequestMethod.GET)
	public ModelAndView NewReservationPage(@ModelAttribute("user_details") User user, ModelMap model,
			@PathVariable("id") Long id, HttpSession session) {
		if (validLogin(session, id) == 0)
			return new ModelAndView("redirect:/logout");
		Reservation reservation = new Reservation();
		ModelAndView mv = new ModelAndView("newreservation");
		model.addAttribute("reservation", reservation);
		model.addAttribute("id", id);
		model.put("user_details", user);
		return mv;

	}

	@RequestMapping(value = "/{id}/createreservation", method = RequestMethod.POST)
	public ModelAndView NewReservation(@ModelAttribute("user_details") User user,
			@ModelAttribute("reservation") Reservation reservation, ModelMap model, @PathVariable Long id,
			HttpSession session) {
		if (validLogin(session, id) == 0)
			return new ModelAndView("redirect:/logout");
		reservation.setUserId(id);
		reservation.setBookingDate(Date.valueOf(LocalDate.now()));
		int count = resService.createNewReservation(reservation);

		if (count != 1) {
			model.put("errorMsg", "Some issue occurred while making reservation");
			return new ModelAndView("redirect:/{id}/user");
		}

		model.put("successMsg", "Reservation created successfully");
		ModelAndView mv = new ModelAndView("redirect:/{id}/user");
		model.put("id", id);
		return mv;
	}

	@RequestMapping(value = "/{id}/pastreservations", method = RequestMethod.GET)
	public ModelAndView pastReservationsPage(ModelMap model, @PathVariable("id") Long id, HttpSession session) {
		logger.info("past_reservations session_login_id value: " + session.getAttribute("login_id"));
		if (validLogin(session, id) == 0)
			return new ModelAndView("redirect:/logout");
		ModelAndView mv = new ModelAndView("pastreservations");
		List<Reservation> resList = resService.getAllPastReservations(id);
		model.addAttribute("resList", resList);
		model.addAttribute("id", id);
		return mv;

	}

	@RequestMapping(value = "/{id}/pastreservations/{rid}/delete", method = RequestMethod.GET)
	public ModelAndView deletePastReservationsPage(@PathVariable("id") Long id, @PathVariable("rid") Long rid,
			ModelMap model, HttpSession session) {
		logger.info("Delete working?");
		if (validLogin(session, id) == 0)
			return new ModelAndView("redirect:/logout");
		resService.deleteReservation(rid, id);
		logger.info("Working?");
//    	if(value!=1) {
//    		model.put("errorMsg","Some issue occurred while deleting reservation");
//    		return new ModelAndView("redirect:/{id}/user");
//    	}
//    	
		if (id == 1) // Admin is user
			return new ModelAndView("redirect:/admin");
		return new ModelAndView("redirect:/{id}/pastreservations");

	}
//    
//    @RequestMapping(value ="/{id}/pastreservations/{res_id}/edit",method = RequestMethod.GET)
//    public ModelAndView editPastReservationsPage(ModelMap model,@PathVariable("id") Long id,@PathVariable("res_id") Long res_id,HttpSession session) {
//    	if(validLogin(session,id)==0)
//    		return new ModelAndView("redirect:/");
//    	
//    	return new ModelAndView("redirect:/{id}/pastreservations");
//       			
//    }

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("user") User user, ModelMap model) {
		int count = userService.createNewUser(user);

		if (count != 1) {
			model.put("errorMsg", "Some issue occurred with registration");
			return new ModelAndView("register");
		}

		model.put("successMsg", "User created successfully");
		return new ModelAndView("redirect:/login");
	}


}
