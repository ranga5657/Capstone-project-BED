//package org.role.based.auth.jwt.repo;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.times;
//import static org. junit. Assert. *;
//import org. junit. Test;
//import static org.mockito.Mockito.verify;
////import static org.junit.Assert.assertEquals;
////import static org.junit.Assert.assertEquals;
////import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
////import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.role.based.auth.jwt.entity.Comment;
//import org.role.based.auth.jwt.service.CommentService;
//import org.springframework.boot.test.context.SpringBootTest;
//
////@SpringBootTest
//////TestMethodOrder(MethodOrderer.OrderAnnotation.class)
////
////class CommentRepositoryTest {
////
//////	@Autowired
//////	  private MockMvc mockMvc;
//////
//////	  @Autowired
//////	  private ObjectMapper objectMapper;
//////
////
////	@Autowired
////	
////	//@Mock
////	CommentRepository commentRepository;
////
////	@Test
////	@Order(1)
////	@Rollback(value = false)
////	public void saveCommentTest() {
////
////		Comment employee = Comment.builder().moviename("Vakeel Saab").id(1L).comment("Nice Movie").rating(4L).build();
////
////		// commentRepository.save(employee);
////		Assertions.assertThat(employee.getId()).isGreaterThan(0);
////
////		// Assertions.assertThat(employee.getId()).isGreaterThan(0);
////	}
////
////	@Test
////	@Order(2)
////	public void getCommentByIdTest() {
////
////
////		Comment employee = commentRepository.findById(2L).get();
////
////		Assertions.assertThat(employee.getId()).isEqualTo(2L);
////
////	}
////
////	@Test
////	@Order(3)
////	public void getListAllCommentsTest() {
////
////		List<Comment> employees = commentRepository.findAll();
////		System.out.println(employees);
////
////		
////		Assertions.assertThat(employees.size()).isGreaterThan(0);
////
////	}
////
////	@Test
////	@Order(4)
////	@Rollback(value = false)
////	public void updateCommentTest() {
////
////		Comment employee = commentRepository.findById(2L).get();
////
////		employee.setMoviename("RRR");
////		;
////
////		Comment employeeUpdated = commentRepository.save(employee);
////
////		Assertions.assertThat(employeeUpdated.getMoviename()).isEqualTo("RRR");
////
////	}
////
//////	@Test
//////	@Order(5)
//////	public void DeleteCommentTest () {
//////		commentRepository.deleteById(3L);
//////		Assertions.assertThat(commentRepository.existsById(3L)).isFalse();
//////	}
//
//@SpringBootTest(classes=(CommentRepositoryTest.class))
//
//public class CommentRepositoryTest {
//
// 
//
//@Mock 
//
//private CommentRepository commentRepository;
//
//   
//
//@InjectMocks
//
//CommentService commentService;
//
//    
//
//    @Test
//
//    public void  getallcomments() {
//
//    String pattern = "dd/MM/yyyy hh:mm:ss";
//
// 
//
//SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//
// 
//
//String date = simpleDateFormat.format(new Date());
//
//    List<Comment> testcomments = new ArrayList<Comment>();
//
//    testcomments.add(new Comment((long) 1,"vakeel saab","good movie",4, date, date));
//
//    testcomments.add(new Comment((long) 2,"RRR","good",5, date, date));
//
//    when(commentRepository.findAll()).thenReturn(testcomments);//mocking
//
//    assertEquals(2,commentService.listAll().size());
//
//    
//
//    }
//
//    
//
//   //not working 
//
//  @Test
//
//  public void getbycommentbyid() {
//
//  String pattern = "dd/MM/yyyy hh:mm:ss";
//
//      SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//
//      String date = simpleDateFormat.format(new Date());
//
//  
//
//      List<Comment> testcomments = new ArrayList<Comment>();
//
//  
//
//      testcomments.add(new Comment(1L,"vakeel saab","good movie",4, date, date));
//
//    testcomments.add(new Comment(2L,"RRR","good",5, date, date));
//
//    //System.out.println(testcomments);
//
//    
//
//    //String moviename="vakeel saab";
//
//   //int id=1;
//
//    when(commentRepository.findAll()).thenReturn(testcomments);//mocking
//
//    //assertEquals(2L,commentService.getbyid(2L));
//
//  }
//
//  //assertequal not working
//
//  @Test
//
//  public void savecomment() {
//
//  String pattern = "dd/MM/yyyy hh:mm:ss";
//
//      SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//
//      String date = simpleDateFormat.format(new Date());
//
//  
//
//  Comment savedcomment = new Comment(1L,"vakeel saab","good movie",4, date, date);
//
// 
//
//  when(commentRepository.save(savedcomment)).thenReturn(savedcomment);
//
//  System.out.println(savedcomment);
//
//// assertequals(savedcomment,commentService.save(savedcomment));
// // assertEquals(savedcomment,commentService.save(savedcomment));
//
// 
//
//  }
//
//  
//
// 
//
// 
//
//@Test
//
//  public void updatecomment() {
//
//  String pattern = "dd/MM/yyyy hh:mm:ss";
//
//      SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//
//      String date = simpleDateFormat.format(new Date());
//
//  
//
//  Comment savedcomment = new Comment(1L,"vakeel saab","good movie",4, date, date);
//
// 
//
//  when(commentRepository.save(savedcomment)).thenReturn(savedcomment);
//
// 
//
//  //assertEquals(savedcomment,commentService.updatecomment(savedcomment));
//
// // assertEquals(savedcomment,commentService.save(savedcomment));
//
//  }
//
// 
//
//  @Test
//
//  public void deletecomment() {
//
//  String pattern = "dd/MM/yyyy hh:mm:ss";
//
//      SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//
//      String date = simpleDateFormat.format(new Date());
//
//  
//
//  Comment savedcomment = new Comment(1L,"vakeel saab","good movie",4, date, date);
//
//  commentService.delete(savedcomment);
//
//  verify(commentRepository,times(1)).delete(savedcomment);//mocking
//
//  }
//
//  
//
//    
//}
