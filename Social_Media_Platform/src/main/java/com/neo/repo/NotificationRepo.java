package com.neo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.neo.dto.NotificationResponse;
import com.neo.model.Notification;

public interface NotificationRepo extends JpaRepository<Notification, Integer> {

//	@Query(value = "SELECT MAX(cnt) FROM (SELECT COUNT(*) AS cnt FROM notifications GROUP BY user_id) AS subquery", nativeQuery = true)

//============================================================================================================================================================
	
//Manually Mapping resultset 

	@Query(value = "SELECT user_id, COUNT(*) AS notification_count " + "FROM notifications " + "GROUP BY user_id "
			+ "HAVING notification_count = (SELECT MAX(cnt) " + "FROM (SELECT COUNT(*) AS cnt " + "FROM notifications "
			+ "GROUP BY user_id) AS subquery)", nativeQuery = true)
	public List<Object[]> getMaxNotificationByUser();

//====================================================================================================================================
	
	
// Using Constructor Based JPQL Query
	
//	@Query(value = "SELECT new com.neo.dto.NotificationResponse(n.userId, COUNT(n))" + "FROM Notifications n" + "GROUP BY n.userId "
//			+ "HAVING notificationCount = (SELECT MAX(COUNT(sub.userId)) FROM Notification sub GROUP BY sub.userId)")
//	public List<NotificationResponse> getMaxNotificationByUser();
	
//	@Query("""
//		    SELECT new com.neo.dto.NotificationResponse(n.userId, COUNT(n)) 
//		    FROM Notifications n 
//		    GROUP BY n.userId 
//		    HAVING COUNT(n) = (
//		        SELECT MAX(notificationCount) 
//		        FROM (
//		            SELECT COUNT(sub.userId) as notificationCount 
//		            FROM Notifications sub 
//		            GROUP BY sub.userId
//		        )
//		    )
//		""")
//		public List<NotificationResponse> getMaxNotificationByUser();


//==========================================================================================================================================
	
	
//Using @SqlResultSetMapping for Native Queries
	
//	
//	@Query(name = "NotificationRepository.getMaxNotificationByUser",nativeQuery = true)
//	public List<NotificationResponse> getMaxNotificationByUser();
//	
//	
	
	
//	@Query(value = """
//	        SELECT n.user_id AS userId, COUNT(*) AS notificationCount
//	        FROM notifications n
//	        GROUP BY n.user_id
//	        HAVING notificationCount = (
//	            SELECT MAX(cnt)
//	            FROM (
//	                SELECT COUNT(*) AS cnt
//	                FROM notifications
//	                GROUP BY user_id
//	            ) AS subquery
//	        )
//	        """, nativeQuery = true)
//	List<NotificationResponse> getUsersWithMaxNotifications();

	
	
}

//SELECT user_id, COUNT(*) AS notification_count
//FROM notifications
//GROUP BY user_id
//HAVING notification_count = (
//    SELECT MAX(cnt) 
//    FROM (
//        SELECT COUNT(*) AS cnt
//        FROM notifications
//        GROUP BY user_id
//    ) AS subquery
//);
