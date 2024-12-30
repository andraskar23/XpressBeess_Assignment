package com.neo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.dto.NotificationResponse;
import com.neo.repo.NotificationRepo;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepo notificationRepo;

//===========================================================================================

// Manually Mapping resultset 

//	public List<Object[]> getMaxNotificationByUser(){
//		
//		List<Object[]> response = notificationRepo.getMaxNotificationByUser();
//		
//		return response;
//	}

	public List<NotificationResponse> getMaxNotificationByUser() {

		List<Object[]> response = notificationRepo.getMaxNotificationByUser();

		List<NotificationResponse> response1 = this.mapToDto(response);

		return response1;
	}

	private List<NotificationResponse> mapToDto(List<Object[]> response) {
		// TODO Auto-generated method stub
		return response.stream()
				.map(records -> {
			NotificationResponse dto = new NotificationResponse();
			dto.setUserId(((Integer) records[0]).intValue());
			dto.setNotificationCount(((Long) records[1]).longValue());
			return dto; // Return the DTO
		}).toList(); // Collect to list
	}

//==============================================================================================	

//	 Using Constructor Based JPQL Query

//	public List<NotificationResponse> getMaxNotificationByUser(){
//		
//		List<NotificationResponse> response = notificationRepo.getMaxNotificationByUser();
//		
//		return response;
//	}
//	

//==========================================================================================================================================

//Using @SqlResultSetMapping for Native Queries

}
