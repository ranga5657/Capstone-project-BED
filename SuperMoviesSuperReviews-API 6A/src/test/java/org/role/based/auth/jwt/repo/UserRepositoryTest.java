//package org.role.based.auth.jwt.repo;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.util.List;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.role.based.auth.jwt.entity.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//
//@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//
//class UserRepositoryTest {
//
//	@Autowired
//
//	UserRepository userRepo;
//
//	@Test
//
//	@Order(1)
//	@Rollback(value = false)
////	
//	public void saveUserDataTest() {
////		
//		// List <AdminData> ad = (List<AdminData>) AdminData.builder()
////		 
//		@SuppressWarnings("unused")
//		User u = User.builder().userFirstName("Ranganayakulu").userLastName("Boya").userName("ranga99")
//				.userPassword("ranga@123")
//				// .role(Set<Admin>)
//				.build();
//
//		// adminRepo.save(ad);
//
//		// Assertions.assertThat( u)());
////		
//	}
//
//	@Test
//	@Order(2)
//	public void testReadAllList() {
//		List<User> list = userRepo.findAll();
//		assertThat(list).size().isGreaterThan(0);
//	
//	}
//	
//	
//
//	
//	@Test
//    @Order(3)
//    @Rollback(value = false)
//    public void updateUserTest(){
//
//        //Comment employee = commentRepository.findById(2L).get();
//		
//		User u= userRepo.findById("admin123").get();
//
//        //employee.setMoviename("RRR");;
//        u.setUserName("admin1");
//
//        User UpdatedUser =  userRepo.save(u);
//
//        //Assertions.assertThat(employeeUpdated.getMoviename()).isEqualTo("RRR");
//        Assertions.assertThat(UpdatedUser.getUserName()).isEqualTo("admin1");
//        
//        
//
//    }
//	
//	
//
////	
////	@Test
////	@Order(4)
////	public void DeleteUserTest () {
////		
////		//adminRepo.deleteById(1L);
////		//userRepo.deleteById("ranga123");
////		userRepo.deleteById("niranjan@242");
////		//assertThat(adminRepo.existsById(1L)).isFalse();
////	assertThat(userRepo.existsById("niranjan@242")).isFalse();
////	}
//	
//	
//	
//}
