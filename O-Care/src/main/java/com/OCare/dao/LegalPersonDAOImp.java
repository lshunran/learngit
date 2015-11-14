package com.OCare.dao;

import com.OCare.entity.LegalPerson;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fowafolo on 15/7/28.
 */

@Repository
public class LegalPersonDAOImp extends IGeneralDAOImpl<LegalPerson> implements LegalPersonDAO {

    public LegalPersonDAOImp()
    {
        super(LegalPerson.class);
    }

    @Override
    public LegalPerson queryByPhoneNum(String phoneNum) {
        String hql = "from LegalPerson where phone = :m";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("m", phoneNum);
        List<LegalPerson> list = query.list();
        if (list.size() == 0){
            return null;
        }else{
            return list.get(0);
        }
    }
}
