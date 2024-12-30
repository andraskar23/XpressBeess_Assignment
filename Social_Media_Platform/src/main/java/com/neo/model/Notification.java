package com.neo.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Notifications")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer notificationId;
	
	private Integer postId;
	
	@CreationTimestamp
	@DateTimeFormat(pattern = "mm-dd-yyyy")
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime notificationCreationDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	

	public Integer getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(Integer notificationId) {
		this.notificationId = notificationId;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	
	

	public LocalDateTime getNotificationCreationDate() {
		return notificationCreationDate;
	}

	public void setNotificationCreationDate(LocalDateTime notificationCreationDate) {
		this.notificationCreationDate = notificationCreationDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Notification [notificationId=" + notificationId + ", postId=" + postId + ", notificationCreationDate="
				+ notificationCreationDate + ", user=" + user + "]";
	}

	
	
}




//User = UserId, Name, Age, List<Post>, List<Notication>
//Post = Content, Time, User, Like;
//Notication = Post, Time