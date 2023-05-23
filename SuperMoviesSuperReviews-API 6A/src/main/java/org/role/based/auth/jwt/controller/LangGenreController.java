
package org.role.based.auth.jwt.controller;

import java.util.List;

import org.role.based.auth.jwt.entity.AdminData;
import org.role.based.auth.jwt.entity.Comment;
import org.role.based.auth.jwt.repo.AdminRepository;
import org.role.based.auth.jwt.repo.CommentRepository;
import org.role.based.auth.jwt.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4203")
public class LangGenreController {


	@Autowired
	AdminRepository adminRepository;
	@Autowired
	CommentRepository commentRepository;

	@Autowired
	AdminService adminService;


	// API'S for Genre wise filtering

	// 1st Drama

	@PreAuthorize("hasRole('User') or hasRole('Admin')")
	@GetMapping("/all-movies/genre/drama")
	public List<AdminData> fetchByGenreDrama() {

		List<AdminData> drama = (List<AdminData>) adminRepository.fetchByGenreDrama();
		return drama;
	}

	// 2nd action
	@PreAuthorize("hasRole('User') or hasRole('Admin')")
	@GetMapping("/all-movies/genre/action")
	public List<AdminData> fetchByGenreAction() {

		List<AdminData> action = (List<AdminData>) adminRepository.fetchByGenreAction();
		return action;
	}

	// 3rd romance
	@PreAuthorize("hasRole('User') or hasRole('Admin')")
	@GetMapping("/all-movies/genre/romance")
	public List<AdminData> fetchByGenreRomance() {

		List<AdminData> romance = (List<AdminData>) adminRepository.fetchByGenreRomance();
		return romance;
	}

	// 4th thriller
	@PreAuthorize("hasRole('User') or hasRole('Admin')")
	@GetMapping("/all-movies/genre/thriller")
	public List<AdminData> fetchByGenreThriller() {

		List<AdminData> thriller = (List<AdminData>) adminRepository.fetchByGenreThriller();
		return thriller;
	}

	// 5th adult
//	@PreAuthorize("hasRole('User') or hasRole('Admin')")
//	 @GetMapping("/all-movies/genre/adult")
//	 	public List<AdminData> fetchByGenreAdult() {
//	        
//		  List<AdminData> adult = (List<AdminData>) adminRepository.fetchByGenreAdult();
//	        return adult;
//	    }
//	 

	// 6th horror

	@PreAuthorize("hasRole('User') or hasRole('Admin')")

	@GetMapping("/all-movies/genre/horror")
	public List<AdminData> fetchByGenreHorror() {

		List<AdminData> horror = (List<AdminData>) adminRepository.fetchByGenreHorror();
		return horror;
	}

	// 7th comedy

	@PreAuthorize("hasRole('User') or hasRole('Admin')")
	@GetMapping("/all-movies/genre/comedy")
	public List<AdminData> fetchByGenreComedy() {

		List<AdminData> comedy = (List<AdminData>) adminRepository.fetchByGenreComedy();
		return comedy;
	}

	// API'S for language filtering

	// 1ST TELUGU

	@PreAuthorize("hasRole('User') or hasRole('Admin')")

	@GetMapping("/all-movies/lang/telugu")
	public List<AdminData> fetchByLangTelugu() {

		List<AdminData> Telugu = (List<AdminData>) adminRepository.fetchByLangTelugu();
		return Telugu;
	}

	// 2ND HINDI

	@PreAuthorize("hasRole('User') or hasRole('Admin')")
	@GetMapping("/all-movies/lang/hindi")
	public List<AdminData> fetchByLangHindi() {

		List<AdminData> Hindi = (List<AdminData>) adminRepository.fetchByLangHindi();
		return Hindi;
	}

	///// 3RD ENGLISH

	@PreAuthorize("hasRole('User') or hasRole('Admin')")

	@GetMapping("/all-movies/lang/english")
	public List<AdminData> fetchByLangEnglish() {

		List<AdminData> English = (List<AdminData>) adminRepository.fetchByLangEnglish();
		return English;
	}

	//// 4TH TAMIL

	@PreAuthorize("hasRole('User') or hasRole('Admin')")

	@GetMapping("/all-movies/lang/tamil")
	public List<AdminData> fetchByLangTamil() {

		List<AdminData> Tamil = (List<AdminData>) adminRepository.fetchByLangTamil();
		return Tamil;
	}

	////// 5th Kannada

	@PreAuthorize("hasRole('User') or hasRole('Admin')")

	@GetMapping("/all-movies/lang/kannada")
	public List<AdminData> fetchByLangKannada() {

		List<AdminData> Kannada = (List<AdminData>) adminRepository.fetchByLangKannada();
		return Kannada;
	}

	/// 6th malayalam

	@PreAuthorize("hasRole('User') or hasRole('Admin')")

	@GetMapping("/all-movies/lang/malayalam")
	public List<AdminData> fetchByLangMalayalam() {

		List<AdminData> Malayalam = (List<AdminData>) adminRepository.fetchByLangMalayalam();
		return Malayalam;
	}

	// search for movie list
	@GetMapping("/search-fields")
	@PreAuthorize("hasRole('User') or hasRole('Admin')")
	public List<AdminData> getByFields(@RequestParam(required = true) String moviename) {
		List<AdminData> searchByFields = (List<AdminData>) adminRepository.findBySearchFields(moviename);

		return searchByFields;
	}

	// search by moviename in comments
	@GetMapping("/search-for-comments")
	@PreAuthorize("hasRole('User') or hasRole('Admin')")
	public List<Comment> getMovienameInComments(@RequestParam(required = true) String moviename)

	{
		List<Comment> searchByFields = (List<Comment>) commentRepository.findBySearchFields(moviename);

		return searchByFields;
	}

}
