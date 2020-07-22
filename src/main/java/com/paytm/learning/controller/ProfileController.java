package com.paytm.learning.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.paytm.learning.model.User;
import com.paytm.learning.service.ProfileService;


@Controller
public class ProfileController {
	
	
	@Autowired
	private ProfileService profileService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username or password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

//    @RequestMapping(value = {
//        "/",
//        "/welcome"
//    }, method = RequestMethod.GET)
//    public String welcome(Model model) {
//        return "welcome";
//    }
	
	@RequestMapping(method = RequestMethod.POST , path = "/profile/insert/")
	public String addProfile(@RequestBody User user) {
		profileService.addProfile(user);
		return "OK. 1 row inserted."; //change it
	}
	
	@RequestMapping(method = RequestMethod.GET , path = "/profile/show/")
	public Iterable<User> showAll()
	{
		return profileService.getAll();
	}

	@RequestMapping(method = RequestMethod.GET , path = "/profile/show/{jobrole}")
	public Iterable<User> showByJobrole(@PathVariable String jobrole)
	{
		return profileService.getByJobrole(jobrole);
	}
	
	@RequestMapping(method = RequestMethod.GET , path = "/profile/show/{id}")
	public Optional<User> showById(@PathVariable Long id)
	{
		return profileService.getById(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT , path = "/profile/update/{id}")
	public String updateProfile(@RequestBody User user, @PathVariable Long id) {
		profileService.updateProfileById(user, id);
		return "OK. 1 row updated.";
	}
	
	@RequestMapping(method = RequestMethod.DELETE , path = "/profile/delete/{id}")
	public String deleteProfile(@PathVariable Long id) {
		profileService.deleteProfileById(id);
		return "OK. 1 row deleted.";
	}
}
