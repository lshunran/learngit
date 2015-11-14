package com.OCare.dao;

import com.OCare.entity.Employee;

import java.util.List;

/**
 * Created by fowafolo on 15/7/28.
 */
public interface EmployeeDAO extends IGeneralDAO<Employee> {
    public Employee queryByPhoneNum(String phoneNum);
    public List<Employee> findEmployeeByName(String name);
    public List<Employee> findEmployeeByPosition(String position);
    public List<Employee> findEmployeeByDepartment(String department);
    public List<Employee> findEmployeeByPhoneNum(String phoneNum);
}
