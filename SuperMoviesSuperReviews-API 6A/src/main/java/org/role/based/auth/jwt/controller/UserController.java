package org.role.based.auth.jwt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.role.based.auth.jwt.configuration.ResourceNotFoundException;
import org.role.based.auth.jwt.entity.User;
import org.role.based.auth.jwt.repo.UserRepository;
import org.role.based.auth.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4203")
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    UserRepository userRepo;


    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }

    //add r create 
    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user) {
        return userService.registerNewUser(user);
    }
    
    
  @PreAuthorize("hasRole('Admin')")
    // get all 
    @GetMapping("list-all-users")
  
    public List<User> listofusers() {
    	
    	return userRepo.findAll();
    	
    }
    
    // update user = forgot password -> reset password
  @PreAuthorize("hasRole('User') or hasRole('Admin')")
    @PatchMapping("/update/user")
    
    public User updateUser(@PathVariable(value = "user_name") String userName, @RequestBody User ud) {
		
    	User u1 = userRepo.findById(userName)
				.orElseThrow(() -> new ResourceNotFoundException("Username", "id", userName));
    	
    	u1.setUserFirstName(ud.getUserFirstName());
    	u1.setUserLastName(ud.getUserLastName());
    	//u1.setUserName(ud.getUserName());
    	u1.setUserPassword(ud.getUserPassword());
    	
    	User updatedUser = userRepo.save(u1);
    	
    	return updatedUser;
    	
    	
    }
    
    
    
    // delete user 
  @PreAuthorize("hasRole('Admin')")
	@DeleteMapping("/delete-user/{userName}")
	public Map<String, Boolean> deleteMovie(@PathVariable(value = "user_name") String userName) throws ResourceNotFoundException {
		User u1 = userRepo.findById(userName)
				.orElseThrow(() -> new ResourceNotFoundException("Username", "id", userName));
    	
    	
		userRepo.delete(u1);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
    
}
