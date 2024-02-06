package com.project.factory.view.dept;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

import com.project.factory.Today;
import com.project.factory.dept.distribution.admin.EmployeeInfo;
import com.project.factory.dept.distribution.user.Assign;
import com.project.factory.member.Identify;
import com.project.factory.resource.dept.AssignData;
import com.project.factory.resource.dept.DistributionData;
import com.project.factory.view.MainView;

public class DistributionView {

	
		public static String assignRegion;

		public static void DistributionMemberView(){
			
			AssignData.load();
			DistributionData.load();

			System.out.println(Today.day());
			System.out.println();

	        for (EmployeeInfo employeeInfo :DistributionData.distributionMembersList ) {
	        	if(employeeInfo.getId().equals(Identify.auth)) {
	            	System.out.printf("[%s 님 - %s]",Identify.name, employeeInfo.getAssignedRegion());
	            	System.out.println();
	            	
	        	}
	        }
	        
	        AssignData.getCompletedOrderCountByMemberId(Identify.auth);
	        
	        int totalOrderCount = AssignData.getOrderCountByMemberId(Identify.auth); // 배정 받은 주문 개수
	        int completeOrderCount = AssignData.getCompletedOrderCountByMemberId(Identify.auth);
	        int incompleteOrderCount = totalOrderCount - completeOrderCount;

	        System.out.printf("오늘 배정 받은 주문 개수: %d\n", totalOrderCount);
	        System.out.printf("완료: %d\n", completeOrderCount);
	        System.out.printf("미완료: %d\n", incompleteOrderCount);
	        
	        System.out.println();
	        System.out.println();
	        

	         

	        

	}
}
