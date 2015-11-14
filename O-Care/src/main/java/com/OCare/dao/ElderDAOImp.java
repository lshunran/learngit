package com.OCare.dao;

import com.OCare.entity.Elder;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fowafolo on 15/7/28.
 */
@Repository
public class ElderDAOImp extends IGeneralDAOImpl<Elder> implements ElderDAO{

    public ElderDAOImp()
    {
        super(Elder.class);
    }

    @Override
    public Elder queryByPhoneNum(String phoneNum) {
        String hql = "from Elder where phone = :m";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("m", phoneNum);
        List<Elder> list = query.list();
        if (list.size() == 0){
            return null;
        }else{
            return list.get(0);
        }
    }

    @Override
    public List<Elder> getEldersByPhoneNum(String phoneNum) {
        String hql = "from Elder where phone = :m";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("m", phoneNum);
        return query.list();
    }

    @Override
    public List<Elder> getAllEldersByName(String elderName) {
        String hql = "from Elder where name = :n";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("n",elderName);
        return query.list();
    }
}
