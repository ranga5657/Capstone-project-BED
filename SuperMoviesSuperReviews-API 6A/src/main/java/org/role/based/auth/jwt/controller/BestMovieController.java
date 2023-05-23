package org.role.based.auth.jwt.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.role.based.auth.jwt.entity.AdminData;
import org.role.based.auth.jwt.entity.Comment;
import org.role.based.auth.jwt.repo.AdminRepository;
import org.role.based.auth.jwt.repo.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4203")

public class BestMovieController {

	@Autowired

	CommentRepository commentRepo;

	@Autowired
	AdminRepository adminRepository;

	// api to get list of best movies

	// best movies= whose overall rating is 4

	@PreAuthorize("hasRole('User') or hasRole('Admin')")
	@GetMapping("/best-movies")

	public List<Comment> getBestMovies() {

		List<Comment> bestMovie = commentRepo.getBestMovies();

		return bestMovie;
	}

	// api to get list of trending movies

	// trending movies are those whose overall rating is 5

	@PreAuthorize("hasRole('User') or hasRole('Admin')")
	@GetMapping("/trending-movies")

	public List<Comment> getTrendingMovies() {

		List<Comment> trending = commentRepo.getTrending();

		return trending;
	}

	// movies that are currently in theatres from past 10 days

	@PreAuthorize("hasRole('User') or hasRole('Admin')")
	@GetMapping("/theatre-movies")

	public ResponseEntity<List<AdminData>> getcurrentMoviesintheatre() {

		List<AdminData> theatreMovieList = new ArrayList<AdminData>();

		DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

		List<AdminData> movieDatalist = adminRepository.findAll();

		if (movieDatalist != null) {

			movieDatalist.stream().forEach(movie -> {

				try {

					Date rDate = format.parse(movie.getReleasedate());
					System.out.println("releasedate=" + rDate);

					Calendar cal = Calendar.getInstance();
					System.out.println("Current Date = " + cal.getTime());
					cal.set(Calendar.HOUR_OF_DAY, 0);
					cal.set(Calendar.MINUTE, 0);
					cal.set(Calendar.SECOND, 0);
					cal.set(Calendar.MILLISECOND, 0);
					Date currentdate = cal.getTime();

					cal.add(Calendar.DATE, -20);

					Date minus = cal.getTime();
					System.out.println("after substracting=" + minus);

					// if (minusfive.equals(rDate)) {
					if (rDate.before(currentdate) && rDate.after(minus)) {

						theatreMovieList.add(movie);

					}

				} catch (ParseException e) {

					// TODO Auto-generated catch block

					e.printStackTrace();

				}

			});

		}

		return ResponseEntity.ok(theatreMovieList);

	}

}
