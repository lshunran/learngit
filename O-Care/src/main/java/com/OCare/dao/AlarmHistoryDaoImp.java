package com.OCare.dao;

import com.OCare.entity.AlarmHistory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Ma on 2015/11/10.
 */
@Repository
public class AlarmHistoryDaoImp extends IGeneralDAOImpl<AlarmHistory> implements AlarmHistoryDao {

    public AlarmHistoryDaoImp() {
        super(AlarmHistory.class);
    }


   /* @Override
    public List<AlarmHistory> getAlarmhistory(int offset) {
       // String hql = "select * from alarmHistory";
       // Query query = sessionFactory.getCurrentSession().createQuery(hql);

        //return query.list().get(0);
        return null;
    }*/
}
