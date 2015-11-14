package com.OCare.dao;

import com.OCare.entity.EmployeeCondition;

import java.sql.Date;
import java.util.List;

/**
 * Created by mark on 8/6/15.
 */
public interface EmployeeConditionDAO extends IGeneralDAO<EmployeeCondition> {

    public List<EmployeeCondition> findEmployeeConditionBetween(String employeeId, String start, String end);
    public List<EmployeeCondition> findEmployeeConditionByEmployeeId(String employeeId);
    public EmployeeCondition findEmployeeConditionByEmployeeIdAndDate(String employeeId, String date);
}
