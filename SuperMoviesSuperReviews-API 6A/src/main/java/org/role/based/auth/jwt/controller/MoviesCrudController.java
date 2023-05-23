
package org.role.based.auth.jwt.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.role.based.auth.jwt.entity.AdminData;
import org.role.based.auth.jwt.exception.movies.ResourceNotFoundException;
import org.role.based.auth.jwt.repo.AdminRepository;
import org.role.based.auth.jwt.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

@CrossOrigin(origins = "http://localhost:4203")

public class MoviesCrudController {

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	AdminService adminService;

	@SuppressWarnings("unused")
	private Date rDate;

	// for getting all movies with details from admin db
	
	@PreAuthorize("hasRole('User') or hasRole('Admin')")
	@GetMapping("/all-movies")
	public List<AdminData> findall() {
		return adminRepository.findAll();
	}

	@PreAuthorize("hasRole('User') or hasRole('Admin')")
	@GetMapping("/movies/{id}")
	public ResponseEntity<AdminData> getMovieById(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		AdminData adminData = adminRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Movie not found for this id :: " + id));
		return ResponseEntity.ok().body(adminData);
	}

	
	
	@PreAuthorize("hasRole('Admin')")
	
	@RequestMapping(value = "/create/movie", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })

	public AdminData createMovie(@Valid @RequestBody AdminData movieDetails) {

		AdminData adminservice = new AdminData();

		String pattern = "dd/MM/yyyy hh:mm:ss";

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date());

		
		adminservice.setMoviename(movieDetails.getMoviename());

		adminservice.setArtists(movieDetails.getArtists());
		adminservice.setAdmin(movieDetails.getAdmin());

		adminservice.setCreatedat(date);
		adminservice.setDirector(movieDetails.getDirector());
		adminservice.setGenre(movieDetails.getGenre());
		adminservice.setLang(movieDetails.getLang());
		adminservice.setMoviename(movieDetails.getMoviename());
		adminservice.setPicture(movieDetails.getPicture());
		adminservice.setProducer(movieDetails.getProducer());
		adminservice.setReleasedate(movieDetails.getReleasedate());
		adminservice.setSummary(movieDetails.getSummary());
		adminservice.setUpdatedat(date);
		adminservice.setWatchMovie(movieDetails.getWatchMovie());

		// AdminData newMovie=adminRepository.save(newMovie);

		return adminRepository.save(adminservice);

	}

	@PreAuthorize("hasRole('Admin')")
	@RequestMapping(value = "/update/movie/{id}", method = RequestMethod.PATCH, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AdminData> updateMoviebyid(@PathVariable(value = "id") Long id,
			@Valid @RequestBody AdminData movieDetails) throws ResourceNotFoundException {
		AdminData movie = adminRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Movie not found for this id :: " + id));

		@SuppressWarnings("unused")
		AdminData adminservice = new AdminData();

		String pattern = "dd/MM/yyyy hh:mm:ss";

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date());

		movie.setMoviename(movieDetails.getMoviename());//
		movie.setDirector(movieDetails.getDirector());//

		movie.setGenre(movieDetails.getGenre());//
		movie.setAdmin(movieDetails.getAdmin());//
		movie.setProducer(movieDetails.getProducer());//
		movie.setLang(movieDetails.getLang());//
		movie.setWatchMovie(movieDetails.getWatchMovie());//
		movie.setSummary(movieDetails.getSummary());//
		movie.setArtists(movieDetails.getArtists());//
		movie.setReleasedate(movieDetails.getReleasedate());//
		movie.setPicture(movieDetails.getPicture());//
		movie.setCreatedat(date);
		movie.setUpdatedat(date);
		final AdminData updatedMovie = adminRepository.save(movie);

		return (ResponseEntity<AdminData>) ResponseEntity.ok(updatedMovie);
	}

	// delete method movie by id woking for adminData

	@PreAuthorize("hasRole('Admin')")

	@DeleteMapping("/movies/{id}")
	public Map<String, Boolean> deleteMovie(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		AdminData movie = adminRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Movie not found for this id :: " + id));

		adminRepository.delete(movie);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	
	// WORKING for all lang,

	@PreAuthorize("hasRole('User') or hasRole('Admin')")
	@GetMapping("all-movies/lang/{lang}")

	public List<AdminData> fetchMovieByLang(@PathVariable("lang") String lang) {

		return adminService.getByLang(lang);

	}

	@PreAuthorize("hasRole('User') or hasRole('Admin')")

	@GetMapping("/released-movies")

	public ResponseEntity<List<AdminData>> getAll() {

		List<AdminData> releaseMovieList = new ArrayList<AdminData>();

		DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

		List<AdminData> movieDatalist = adminRepository.findAll();

		if (movieDatalist != null) {

			movieDatalist.stream().forEach(movie -> {

				try {

					Date rDate = format.parse(movie.getReleasedate());

					Date d = new Date();

					System.out.println(d);

					if (new Date().after(rDate)) {


						releaseMovieList.add(movie);

					}

				} catch (ParseException e) {


					e.printStackTrace();

				}

			});

		}

		return ResponseEntity.ok(releaseMovieList);

	}

	@PreAuthorize("hasRole('User') or hasRole('Admin')")
	@GetMapping("/upcoming-movies")

	public ResponseEntity<List<AdminData>> getupComingMovies() {

		List<AdminData> upcomingMovieList = new ArrayList<AdminData>();

		DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

		List<AdminData> movieDatalist = adminRepository.findAll();

		if (movieDatalist != null) {

			movieDatalist.stream().forEach(movie -> {

				try {

					Date rDate = format.parse(movie.getReleasedate());

					Date d = new Date();

					System.out.println(d);


					if (new Date().before(rDate)) {



						upcomingMovieList.add(movie);

					}

				} catch (ParseException e) {


					e.printStackTrace();

				}

			});

		}

		return ResponseEntity.ok(upcomingMovieList);

	}

}
