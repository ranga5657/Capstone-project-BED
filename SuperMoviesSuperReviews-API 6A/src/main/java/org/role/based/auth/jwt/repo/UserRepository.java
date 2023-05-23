package org.role.based.auth.jwt.repo;

import org.role.based.auth.jwt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
	
	//List<User> findall();
	
	// 

}
