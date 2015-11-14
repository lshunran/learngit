package com.OCare.dao;

import com.OCare.entity.ElderCondition;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by fowafolo on 15/7/30.
 */

@Repository
public class ElderConditionDAOImp extends IGeneralDAOImpl<ElderCondition> implements ElderConditionDAO {

    public ElderConditionDAOImp()
    {
        super(ElderCondition.class);
    }

    @Override
    public List<ElderCondition> findElderCondition(String elderId) {
        String hql = "from ElderCondition where elder_id = :m";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("m", elderId);
        return query.list();
    }

    @Override
    public ArrayList<String> getAllEldersInThisTable() {
        String hql = "from ElderCondition";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        Iterator<ElderCondition> elderConditionIterator = query.list().iterator();
        ArrayList<String> elderIds = new ArrayList<String>();

        while (elderConditionIterator.hasNext()) {
            String tmpId = elderConditionIterator.next().getElder_id();
            System.out.println(tmpId);
            elderIds.add(tmpId);
        }
        removeDuplicateWithOrder(elderIds);

        return elderIds;
    }

    public static void removeDuplicateWithOrder(ArrayList arlList)
    {
        Set set = new HashSet();
        List newList = new ArrayList();
        for (Iterator iter = arlList.iterator();
             iter.hasNext(); ) {
            Object element = iter.next();
            if (set.add(element))
                newList.add(element);
        }
        arlList.clear();
        arlList.addAll(newList);
    }
}
