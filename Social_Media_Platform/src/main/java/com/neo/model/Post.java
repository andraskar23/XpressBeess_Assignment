package com.neo.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Posts")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postId;
	
	private String content;
	

		
	private Integer likes;
	
	@CreationTimestamp
	private LocalDateTime postCreationDate;
	
	@UpdateTimestamp
	private LocalDateTime postUpdationDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	


	public Integer getPostId() {
		return postId;
	}


	public void setPostId(Integer postId) {
		this.postId = postId;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}
	
	


	public Integer getLikes() {
		return likes;
	}




	public void setLikes(Integer likes) {
		this.likes = likes;
	}


	public LocalDateTime getPostCreationDate() {
		return postCreationDate;
	}


	public void setPostCreationDate(LocalDateTime postCreationDate) {
		this.postCreationDate = postCreationDate;
	}


	public LocalDateTime getPostUpdationDate() {
		return postUpdationDate;
	}


	public void setPostUpdationDate(LocalDateTime postUpdationDate) {
		this.postUpdationDate = postUpdationDate;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Post [postId=" + postId + ", content=" + content + ", likes=" + likes + ", postCreationDate="
				+ postCreationDate + ", postUpdationDate=" + postUpdationDate + ", user=" + user + "]";
	}


	

}
//User = UserId, Name, Age, List<Post>, List<Notication>
//Post = Content, Time, User, Like;
//Notication = Post, Time