package com.OCare.dao;

import com.OCare.entity.EmployeeCondition;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mark on 8/6/15.
 */
@Repository
public class EmployeeConditionDAOImp extends IGeneralDAOImpl<EmployeeCondition> implements EmployeeConditionDAO {
    public EmployeeConditionDAOImp() {
        super(EmployeeCondition.class);
    }

    public List<EmployeeCondition> findEmployeeConditionBetween(String employeeId, String start, String end){
        String hql = "from EmployeeCondition where time BETWEEN :s AND :e AND employee_id = :m";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("s", start);
        query.setString("e", end);
        query.setString("m", employeeId);
        return query.list();
    }

    @Override
    public List<EmployeeCondition> findEmployeeConditionByEmployeeId(String employeeId) {
        String hql = "from EmployeeCondition where employee_id = :m";
        Query query  = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("m", employeeId);
        return query.list();
    }

    @Override
    public EmployeeCondition findEmployeeConditionByEmployeeIdAndDate(String employeeId, String date) {
        String hql = "from EmployeeCondition where employee_id = :e AND time = :t";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("e", employeeId);
        query.setString("t", date);
        if (query.list().isEmpty()){
            return null;
        }else{
            return (EmployeeCondition) query.list().get(0);
        }
    }


}
