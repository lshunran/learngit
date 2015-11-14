package com.OCare.dao;

import com.OCare.entity.Employee;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fowafolo on 15/7/28.
 */
@Repository
public class EmployeeDAOImp extends IGeneralDAOImpl<Employee> implements EmployeeDAO {

    public EmployeeDAOImp()
    {
        super(Employee.class);
    }

    @Override
    public Employee queryByPhoneNum(String phoneNum) {
        String hql = "from Employee where phone = :m";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("m", phoneNum);
        List<Employee> list = query.list();
        if (list.size() == 0){
            return null;
        }else{
            return list.get(0);
        }
    }

    @Override
    public List<Employee> findEmployeeByName(String name) {
        String hql = "from Employee where name = :m";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("m", name);
        return query.list();
    }

    @Override
    public List<Employee> findEmployeeByPosition(String position) {
        String hql = "from Employee where position = :m";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("m", position);
        return query.list();
    }

    @Override
    public List<Employee> findEmployeeByDepartment(String department) {
        String hql = "from Employee where department = :m";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("m", department);
        return query.list();
    }

    @Override
    public List<Employee> findEmployeeByPhoneNum(String phoneNum) {
        String hql = "from Employee where phone = :m";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("m", phoneNum);
        return query.list();
    }
}
