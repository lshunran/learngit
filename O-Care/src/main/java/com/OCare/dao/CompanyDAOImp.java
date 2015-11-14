package com.OCare.dao;

import com.OCare.entity.Company;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mark on 8/2/15.
 */
@Repository
public class CompanyDAOImp extends IGeneralDAOImpl<Company> implements CompanyDAO {

    public CompanyDAOImp() {
        super(Company.class);
    }

    @Override
    public Company getById(int id) {
        return (Company) sessionFactory.getCurrentSession().get(Company.class, id);
    }

    @Override
    public List<Company> unapproveCompanies() {
        String hql = "from Company where status = 101";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    @Override
    public List<Company> getByName(String name) {
        String hql = "from Company where name = :m";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("m", name);
        return query.list();
    }

    @Override
    public List<Company> getByLegalPerson(String legalPerson) {
        String hql = "from Company where legal_person_id = :m";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("m", legalPerson);
        return query.list();
    }

}
