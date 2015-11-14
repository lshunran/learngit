package com.OCare.service;

import com.OCare.entity.Employee;
import com.OCare.entity.EmployeeCondition;

import java.util.List;

/**
 * Created by mark on 8/3/15.
 */
public interface EmployeeService {
    public Employee createEmployee(String employeeId, int companyId, String name, String phone,
                                   String address, String start, String end, String image, String password,
                                   String position, String department);
    public Employee createEmployee(String employeeId, int companyId, String name, String phone,
                                   String address, String start, String end, String image, String password);
    public Employee createEmployee(String employeeId, int companyId, String name, String phone,
                                   String address, String start, String end, String image, String password,
                                   String position, String department, String superior, String workExperience,
                                   String workDetail);
    public Employee getEmployeeById(String id);
    public List<Employee> getEmployeesByName(String name);
    public List<Employee> getEmployeesByDepartment(String department);
    public List<Employee> getEmployeesByPosition(String position);
    public List<Employee> getEmployeesByPhoneNum(String phoneNum);
    public List<Employee> getAllEmployees();
    public boolean changeEmployeePassword(String employeeId, String newPassword);
    public boolean changeEmployeeStatus(String employeeId, int status);
    public boolean isPasswordMatchEmployeeId(String employeeId, String password);

    public List<EmployeeCondition> getEmployeeConditionByEmployeeId(String employeeId);
    public List<EmployeeCondition> getEmployeeConditionBetween(String start, String end, String employeeId);
    public EmployeeCondition setEmployeeConditionStatus(String employeeId, String time, String status);

    /*
        功能：删除员工
        参数：身份证号码
        返回值：String成功或者失败原因
     */
    public String deleteEmployeeById(String id);

    /*
        功能：更新员工信息
        返回值：boolean
     */
    public boolean changeEmployeeInfoById(String id, String newName, String newPhone, String newAddress,
                                          String newDepartment, String newPosition, int newStatus,
                                          String newPassword, String newImage, String newSuperiot,
                                          String newWorkExperience, String newWorkDetail);
}
