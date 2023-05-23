package org.role.based.auth.jwt.repo;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.role.based.auth.jwt.entity.AdminData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository

@Transactional
public interface AdminRepository extends JpaRepository<AdminData, Long> {
	List<AdminData> findAll();
	Optional<AdminData> findByGenre(String genre);
	 
	List <AdminData> findByLang(String language);
	//List<AdminData> findByWatchMovie();
	
	
	
	// fetch movie by genre = action
	
	@Query(value="SELECT * FROM admin_data ad WHERE ad.genre LIKE 'Action%' ",nativeQuery=true)
	List<AdminData>  fetchByGenreAction();
	
	
	
	// fetch movie by genre = drama
	@Query(value="SELECT * FROM admin_data ad WHERE ad.genre LIKE 'Drama%' ",nativeQuery=true)
	List<AdminData>  fetchByGenreDrama();
	
	
	// fetch movie by genre = adult
//	@Query(value="SELECT * FROM admin_data ad WHERE ad.genre LIKE 'Adult%' ",nativeQuery=true)
//	List<AdminData>  fetchByGenreAdult();
//	
	
	// fetch movie by genre = romance
	@Query(value="SELECT * FROM admin_data ad WHERE ad.genre LIKE 'Adult%' ",nativeQuery=true)
	List<AdminData>  fetchByGenreRomance();
	
	
	// fetch movie by genre = thriller
	@Query(value="SELECT * FROM admin_data ad WHERE ad.genre LIKE 'Thriller%' ",nativeQuery=true)
	List<AdminData>  fetchByGenreThriller();
	
	
	// fetch movie by genre = Mystery
	@Query(value="SELECT * FROM admin_data ad WHERE ad.genre LIKE 'Mystery%' ",nativeQuery=true)
	List<AdminData>  fetchByGenreMystery();
	
	
	
	// fetch movie by genre = comedy
	@Query(value="SELECT * FROM admin_data ad WHERE ad.genre LIKE 'Comedy%' ",nativeQuery=true)
	List<AdminData>  fetchByGenreComedy();
	
	
	// fetch movie by genre = horror
	
	@Query(value="SELECT * FROM admin_data ad WHERE ad.genre LIKE 'Horror%' ",nativeQuery=true)
	List<AdminData>  fetchByGenreHorror();
	
	// fetch movie by Language = Telugu
	
	@Query(value="SELECT * FROM admin_data ad WHERE ad.lang LIKE 'Telugu%' ",nativeQuery=true)
	List<AdminData>  fetchByLangTelugu();
	
	
	// fetch movie by Language = Hindi

	@Query(value="SELECT * FROM admin_data ad WHERE ad.lang LIKE 'Hindi%' ",nativeQuery=true)
	List<AdminData>  fetchByLangHindi();
	
	
	// fetch movie by Language = English

	@Query(value="SELECT * FROM admin_data ad WHERE ad.lang LIKE 'English%' ",nativeQuery=true)
	List<AdminData>  fetchByLangEnglish();
	
	
	// fetch movie by Language = Tamil
	@Query(value="SELECT * FROM admin_data ad WHERE ad.lang LIKE 'Tamil%' ",nativeQuery=true)
	List<AdminData>  fetchByLangTamil();
	
	
	// fetch movie by Language = Kannada
	@Query(value="SELECT * FROM admin_data ad WHERE ad.lang LIKE 'Kannada%' ",nativeQuery=true)
	List<AdminData>  fetchByLangKannada();
	
	
	// fetch movie by Language = Malayalam
	@Query(value="SELECT * FROM admin_data ad WHERE ad.lang LIKE 'Malayalam%' ",nativeQuery=true)
	List<AdminData>  fetchByLangMalayalam();
	
	
	
	
	// fetch movie by MovieName
	
	@Query(value="SELECT * FROM admin_data ad WHERE ad.moviename=?#{[0]}",nativeQuery=true)
	List<AdminData> findBySearchFields(String moviename);
	
	
	
	
}

