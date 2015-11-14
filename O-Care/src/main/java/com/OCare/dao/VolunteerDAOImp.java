package com.OCare.dao;

import com.OCare.entity.Volunteer;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fowafolo on 15/7/28.
 */
@Repository
public class VolunteerDAOImp extends IGeneralDAOImpl<Volunteer> implements VolunteerDAO {

    public VolunteerDAOImp()
    {
        super(Volunteer.class);
    }

    @Override
    public Volunteer queryByPhoneNum(String phoneNum) {
        String hql = "from Volunteer where phone = :m";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("m", phoneNum);
        List<Volunteer> list = query.list();
        if (list.size() == 0){
            return null;
        }else{
            return list.get(0);
        }
    }
}
