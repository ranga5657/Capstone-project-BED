package org.role.based.auth.jwt.service;
//
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

//
import org.role.based.auth.jwt.entity.AdminData;
import org.role.based.auth.jwt.repo.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//
//
@Service
@Transactional


public class AdminService {
//	
//
    @Autowired
    AdminRepository adminRepository;
    
	public List<AdminData> fetchBygenreAction;
     
	
	
	//@HystrixCommand(fallbackMethod = "AdminFallback")
    public List<AdminData> listAll() {
        return adminRepository.findAll();
    }
     
    public void save(AdminData adminData) {
        adminRepository.save(adminData);
    }
//     
    public AdminData get(long id) {
        return adminRepository.getById(id);
    }
//    
    public Optional<AdminData> getByGenre(String genre) {
        return adminRepository.findByGenre(genre);
    }
    
//
    public List<AdminData> getByLang(String language) {
        return adminRepository.findByLang(language);
    }
     
//     
    public void delete(long id) {
        adminRepository.deleteById(id);
    }
    
    
   

}