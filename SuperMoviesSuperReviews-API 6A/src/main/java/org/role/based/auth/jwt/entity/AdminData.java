package org.role.based.auth.jwt.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "admin_data")

public class AdminData implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "admin")
	private String admin;

	

	@Column(name = "artists")
	private String artists;

	@Column(name = "summary")
	private String summary;

	@Column(name = "director")
	private String director;

	@Column(name = "genre")
	private String genre;

	@Column(name = "lang")
	private String lang;

	@Column(name = "moviename")
	private String moviename;

	@Column(name = "producer")
	private String producer;

	@Column(name = "releasedate")
	private String releasedate;

//    @Column(name = "image", unique = false, nullable = false, length = 100000)
//    private byte[] image;

	@Column(name = "createdat", nullable = false, updatable = false)
	private String createdat;

	@Column(name = "updatedat", nullable = false)
	private String updatedat;

//    @Column(name = "filename")
//    private String filename;
//
//    @Column(name = "filetype")
//    private String filetype;

	@Lob
	@Column(name = "picture", length = 512)
	private String picture;

//    
	@Lob
	@Column(name = "watch_movie", length = 512)
	private String watchMovie;
	
	@OneToMany(mappedBy = "adminData")
	@JsonIgnore
	private List<Comment> comments;

}