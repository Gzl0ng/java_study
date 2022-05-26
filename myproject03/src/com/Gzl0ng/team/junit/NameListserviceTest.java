package com.Gzl0ng.team.junit;

import org.junit.Test;

import com.Gzl0ng.team.domain.Employee;
import com.Gzl0ng.team.service.NameListService;
import com.Gzl0ng.team.service.TeamException;

/**
 * 
* @Description NameListsService类的测试
* @author Gzl0ng Email:1329087835@qq.com
* @version
* @date 2021年5月13日下午3:37:54
*
 */
public class NameListserviceTest {

	@Test
	public void testGetAllEmployes(){
		NameListService service = new NameListService();
		Employee[] employees = service.getAllEmployees();
		for(int i = 0;i < employees.length;i++){
			System.out.println(employees[i]);
		}
	}
	
	@Test
	public void testGetEmployee(){
		NameListService service = new NameListService();
		int id = 1;
		id = 101;
		try {
			Employee employee = service.getEmployee(id);
			System.out.println(employee);
		} catch (TeamException e) {
			System.out.println(e.getMessage());
		}
	}
}
