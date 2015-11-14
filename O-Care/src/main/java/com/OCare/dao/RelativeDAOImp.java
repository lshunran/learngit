package com.OCare.dao;

import com.OCare.entity.Relative;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fowafolo on 15/7/28.
 */
@Repository
public class RelativeDAOImp extends IGeneralDAOImpl<Relative> implements RelativeDAO {

    public RelativeDAOImp()
    {
        super(Relative.class);
    }

    @Override
    public Relative queryByPhoneNum(String phoneNum) {
        String hql = "from Relative where phone = :m";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("m", phoneNum);
        List<Relative> list = query.list();
        if (list.size() == 0){
            return null;
        }else{
            return list.get(0);
        }
    }

    @Override
    public List<Relative> getAllMonitorsByName(String name) {
        String hql = "from Relative where name = :m";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("m",name);
        List<Relative> list = query.list();
        if (list.size() != 0)
            return list;
        else
            return null;
    }
}
