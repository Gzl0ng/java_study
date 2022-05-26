package com.Gzl0ng.team.service;

import com.Gzl0ng.team.domain.*;

import static com.Gzl0ng.team.service.Data.*;
/**
 * 
* @Description 负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]的方法
* @author Gzl0ng Email:1329087835@qq.com
* @version v1.0
* @date 2021年5月13日下午2:25:13
*
 */
public class NameListService {
	
	private Employee[] employees;

	/**
	 * 给employees及数组元素进行初始化
	 */
	public NameListService() {
		super();
//		1.根据项目提供的Data类构建相应大小的employees数组
//		2.再根据Data类中的数据构建不同的对象，包括Employee、Programmer、Designer和Architect对象，以及相关联的Equipment子类的对象
//		3.将对象存于数组中
		employees = new Employee[EMPLOYEES.length];
		for(int i = 0;i < employees.length;i++){
			int type = Integer.parseInt(EMPLOYEES[i][0]);
			
			//获取Employee的4个基本信息
			int id = Integer.parseInt(EMPLOYEES[i][1]);
			String name = EMPLOYEES[i][2];
			int age = Integer.parseInt(EMPLOYEES[i][3]);
			double salary = Double.parseDouble(EMPLOYEES[i][4]);
			
			Equipment equipment;
			double bonus;
			int stock;
			switch(type){
			case EMPLOYEE:
				employees[i] = new Employee(id,name,age,salary);
				break;
			case PROGRAMMER:
				equipment = createEquipment(i);
				employees[i] = new Programmer(id,name,age,salary,equipment);
				break;
			case DESIGNER:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				employees[i] = new Designer(id,name,age,salary,equipment,bonus);	
				break;
			case ARCHITECT:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				stock = Integer.parseInt(EMPLOYEES[i][6]);
				employees[i] = new Architect(id,name,age,salary,equipment,bonus,stock);
				break;
			}
		}
		
	}
	/**
	 * 
	* @Description 获取指定index上的员工的设备
	* @author Gzl0ng
	* @date 2021年5月13日下午2:50:38
	* @param i
	* @return
	 */
	private Equipment createEquipment(int index) {
		int type = Integer.parseInt(EQIPMENTS[index][0]);
		String modelOrName = EQIPMENTS[index][1];
		switch(type){		
		case PC://21
			String display = EQIPMENTS[index][2];
			return new PC(modelOrName,display);
		case NOTEBOOK://22
			double price = Double.parseDouble(EQIPMENTS[index][2]);
			return new NoteBook(modelOrName,price);
		case PRINTER://23
			
			return new Printer(modelOrName,EQIPMENTS[index][2]);
		}
		return null;
	}
	/**
	 * 
	* @Description 获取当前所有的员工
	* @author Gzl0ng
	* @date 2021年5月13日下午3:27:30
	* @return
	 */
	public Employee[] getAllEmployees(){
		return employees;
	}
	
	/**
	 * 
	* @Description 获取指定id的员工对象
	* @author Gzl0ng
	* @date 2021年5月13日下午3:28:08
	* @param id
	* @return TeamException
	 * @throws TeamException 
	 */
	public Employee getEmployee(int id) throws TeamException{
		for(int i = 0;i < employees.length;i++){
			if(employees[i].getId() == id){
				return employees[i];
			}
		}
		throw new TeamException("找不到指定的员工");
	}
}
