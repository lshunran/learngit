package com.OCare.dao;

import com.OCare.entity.Contract;
import com.OCare.entity.Elder;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mark on 8/6/15.
 */
@Repository
public class ContractDAOImp extends IGeneralDAOImpl<Contract> implements ContractDAO {
    public ContractDAOImp() {
        super(Contract.class);
    }

    @Override
    public Contract findContractById(int id) {
        return (Contract) sessionFactory.getCurrentSession().get(Contract.class, id);
    }

    @Override
    public List<Contract> findContractsByElderId(String elderId) {
        String hql = "from Contract where elder_id = :m";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("m", elderId);
        return query.list();
    }

    @Override
    public Contract getContractByElderId(String elderId) {
        String hql = "from Contract where elder_id = :m and status = 101";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("m",elderId);
        return (Contract) query.list().get(0);
    }
}
