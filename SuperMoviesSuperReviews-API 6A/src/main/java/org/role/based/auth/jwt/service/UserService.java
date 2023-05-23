package org.role.based.auth.jwt.service;

import java.util.HashSet;
import java.util.Set;

import org.role.based.auth.jwt.dao.RoleDao;
import org.role.based.auth.jwt.dao.UserDao;
import org.role.based.auth.jwt.entity.Role;
import org.role.based.auth.jwt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleDao.save(userRole);

        User adminUser = new User();
        adminUser.setUserName("admin123");
        adminUser.setUserPassword(getEncodedPassword("admin@pass"));
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

        @SuppressWarnings("unused")
		User adminUser1 = new User();
        adminUser.setUserName("ranga9");
        adminUser.setUserPassword(getEncodedPassword("ranga@123"));
        adminUser.setUserFirstName("Ranganayakulu");
        adminUser.setUserLastName("Boya");
        @SuppressWarnings("unused")
		Set<Role> adminRoles1 = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);
        
        @SuppressWarnings("unused")
		User adminUser2 = new User();
        adminUser.setUserName("sandip1");
        adminUser.setUserPassword(getEncodedPassword("sandip@123"));
        adminUser.setUserFirstName("Sandip Madhukar");
        adminUser.setUserLastName("Gunjal");
        @SuppressWarnings("unused")
		Set<Role> adminRoles2 = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);
        
        
        
       User user = new User();
        user.setUserName("ranga123");
        user.setUserPassword(getEncodedPassword("ranga@123"));
        user.setUserFirstName("ranga");
        user.setUserLastName("nayakulu");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userDao.save(user);
    }

    public User registerNewUser(User user) {
        Role role = roleDao.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));

        return userDao.save(user);
    }

    
    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
