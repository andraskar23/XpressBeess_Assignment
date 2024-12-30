package com.neo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name= "Users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	 
	private String uname;
	
	private Integer age;
	
	
	@OneToMany(mappedBy ="user", cascade = CascadeType.ALL )
	private List<Post> posts;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Notification> notifications;


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public List<Post> getPosts() {
		return posts;
	}


	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}


	public List<Notification> getNotifications() {
		return notifications;
	}


	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", uname=" + uname + ", age=" + age + ", posts=" + posts + ", notifications="
				+ notifications + "]";
	}
	
	
	
	
	
	
	
	

}


//User = UserId, Name, Age, List<Post>, List<Notication>
//Post = Content, Time, User, Like;
//Notication = Post, Time