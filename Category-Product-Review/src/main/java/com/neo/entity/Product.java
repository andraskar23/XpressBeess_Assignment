package com.neo.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "sss_product")
@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//It will enable the field like 
//@CreatedDate , @LastModifiedDate, @CreatedBy , @LastModifiedBy
//At main class or start(main)class write @EnableJpaAuditing at class level
@EntityListeners(AuditingEntityListener.class) 
//@JsonFilter("remove_pid_filter")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(access = Access.READ_ONLY)
	private int productId;
	
	@Column
	private String name;
	@Column
	private float price;
	@JsonProperty(access = Access.READ_ONLY)
	@Column
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Review> reviews;
	
	
	@ManyToOne
	@JoinColumn(name = "product_categoryid_fk")
	private Category category;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-dd-mm")
	@CreatedDate
	@JsonProperty(access = Access.READ_ONLY)
	private Date createdOn;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-dd-mm")
	@LastModifiedDate //
	@JsonProperty(access = Access.READ_ONLY)
	private Date modifiedOn;
	
	
//We can Specify like this also
//	@JsonFormat(shape = Shape.STRING, pattern = "dd-mm-yyyy")
//	private String date;

}
