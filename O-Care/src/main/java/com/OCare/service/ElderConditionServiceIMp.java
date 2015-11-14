package com.OCare.service;

import com.OCare.dao.ElderConditionDAO;
import com.OCare.entity.ElderCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fowafolo on 15/7/30.
 */
@Service("elderConditionService")
@Transactional
public class ElderConditionServiceIMp implements ElderConditionService {
    @Autowired
    private ElderConditionDAO elderConditionDAO;

    @Override
    public List<ElderCondition> allElderConditions() {
        return elderConditionDAO.queryAll();
    }

    @Override
    public ElderCondition getElderPresentConditionById(String elderId) {
        ArrayList<ElderCondition> elders = (ArrayList<ElderCondition>) elderConditionDAO.findElderCondition(elderId);
        int count = elders.size();
        System.out.println("get count -1");
//        System.out.println(elderConditionDAO.findElderCondition(elderId).get(count-1).getElder_id());
        if (count == 0){
            return null;
        }else {
            return elderConditionDAO.findElderCondition(elderId).get(count-1);
        }
    }

    @Override
    public ArrayList<ElderCondition> getAllEldersPresentCondition() {
        ArrayList<ElderCondition> result = new ArrayList<ElderCondition>();
        ArrayList<String> elderList = elderConditionDAO.getAllEldersInThisTable();
        for (int i = 0; i < elderList.size(); i++) {
            result.add(getElderPresentConditionById(elderList.get(i)));
        }

        return result;
    }


}
