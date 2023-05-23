package org.role.based.auth.jwt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "comments_data")

public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

//	@Column(name = "moviename")
//	private String moviename;
	
	@Lob
	@Column(name = "comment", length=512)
	private String comment;

	@Column(name = "rating")
	private float rating;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private AdminData adminData;
	
	
}