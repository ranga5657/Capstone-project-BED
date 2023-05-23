package org.role.based.auth.jwt.service;

import java.util.List;

import org.role.based.auth.jwt.entity.Comment;
import org.role.based.auth.jwt.repo.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentService {
	
	
	 @Autowired
	    CommentRepository commentRepository;
	 
	 
	 public List<Comment> listAll() {
	        return commentRepository.findAll();
	 }
	   
	 
	    public void save(Comment comment) {
	        commentRepository.save(comment);
	    }

	    
	    
	    public void delete(Comment savedcomment) {
	        commentRepository.delete(savedcomment);
	    }
	    
	    
	    
	    public Comment getbyid(long id) {
	        return commentRepository.findById(id).get();
	    }
	    
	    

	    public List<Comment> getByLang(String moviename) {
	        return commentRepository.findBySearchFields(moviename);
	    }
	//    
}
