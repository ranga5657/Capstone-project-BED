//package org.role.based.auth.jwt.repo;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.util.List;
//
//import org.assertj.core.api.Assertions;
////import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.mockito.Mockito;
////import org.junit.runner.RunWith;
//import org.role.based.auth.jwt.entity.AdminData;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//
//@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//
//
//// mocito 
//
//class AdminRepositoryTest {
//
//	@Autowired
//	private AdminRepository adminRepo;
//
//	@Test
//
//	@Order(1)
//	@Rollback(value = false)
//
//	public void saveAdminDataTest() {
//
//		AdminData ad = AdminData.builder().admin("ranga9").artists("pawan kalyan").director("venu sri ram")
//				.genre("Drama").id(1L).lang("Telugu").moviename("Vakeel saab").picture("Picture").producer("Dil Raju")
//				.releasedate("09/04/2022").summary("nice movie").watchMovie("watch").build();
//
//		// adminRepo.save(ad);
//
//		Assertions.assertThat(((AdminData) ad).getId()).isGreaterThan(0);
////		
//	}
//
//	@Test
//	@Order(3)
//	public void testReadAllList() {
//		List<AdminData> list = adminRepo.findAll();
//		assertThat(list).size().isGreaterThan(0);
//		
//		
//
//	}
//
////	
//	@Test
//	@Order(2)
//	public void testReadById() {
//		AdminData product = adminRepo.findById(2L).get();
//		assertEquals("KGF Chapter 2", product.getMoviename());
//	}
//
////	@Test
////	@Order(4)
////	public void DeleteMovieTest () {
////		adminRepo.deleteById(1L);
////		assertThat(adminRepo.existsById(1L)).isFalse();
////	}
//
//	@Test
//	@Order(5)
//	public void getMovieByIdTest() {
//
//		AdminData employee = adminRepo.findById(2L).get();
//
//		Assertions.assertThat(employee.getId()).isEqualTo(2L);
//
//	}
//
//	@Test
//	@Order(6)
//	@Rollback(value = false)
//	public void updateMovieTest() {
//
//		AdminData employee = adminRepo.findById(2L).get();
//
//		employee.setAdmin("sandip1");
//
//		AdminData employeeUpdated = adminRepo.save(employee);
//
//		Assertions.assertThat(employeeUpdated.getAdmin()).isEqualTo("sandip1");
//
//	}
//
//}
