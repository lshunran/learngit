package com.OCare.dao;

import com.OCare.entity.ElderMonitor;
import com.OCare.entity.Relative;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fowafolo on 15/7/31.
 */
@Repository
public class ElderMonitorDAOImp extends IGeneralDAOImpl<ElderMonitor> implements ElderMonitorDAO {


    @Override
    public List<ElderMonitor> getAllUntreatedRequests() {
        String hql = "from ElderMonitor";
        Query query = super.sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    @Override
    public List<ElderMonitor> queryByRelativeId(String relativeId) {
        String hql = "from ElderMonitor where relative_id = :m";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("m", relativeId);
        return query.list();
    }

    @Override
    public ElderMonitor getById(int id) {
        return (ElderMonitor) sessionFactory.getCurrentSession().get(ElderMonitor.class, id);
    }

    @Override
    public ArrayList<ElderMonitor> getMonitorByElderIdAndSbId(String elderId, String sbId) {
        ArrayList<ElderMonitor> list = new ArrayList<ElderMonitor>();
        String hql = "from ElderMonitor where relative_id = :m and elder_id = :n";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("m",sbId);
        query.setString("n",elderId);
        return (ArrayList<ElderMonitor>) query.list();
    }

    @Override
    public ArrayList<Relative> getAllMonitorsByElderId(String elderId) {
        ArrayList<Relative> list = new ArrayList<Relative>();
        String hql = "from ElderMonitor where elder_id = :n and type = :m";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("n",elderId);
        query.setInteger("m", 1);
        list = (ArrayList<Relative>) query.list();
        return list;
    }

    //或得该老人的所有监护人的ID
    @Override
    public List<ElderMonitor> getMonitorsByElderId(String elderId) {
        String hql = "from ElderMonitor where elder_id = :n and type = :m";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("n",elderId);
        query.setInteger("m", 1);
        return query.list();
    }

    @Override
    public List<ElderMonitor> getAllEldersByMonitorId(String monitorId) {
        String hql = "from ElderMonitor where relative_id = :n and type = :m";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("n",monitorId);
        query.setInteger("m",1);
        return query.list();
    }

    public ElderMonitorDAOImp()
    {
        super(ElderMonitor.class);
    }
}
