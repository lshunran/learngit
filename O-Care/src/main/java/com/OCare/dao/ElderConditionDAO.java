package com.OCare.dao;

import com.OCare.entity.ElderCondition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fowafolo on 15/7/30.
 */
public interface ElderConditionDAO extends IGeneralDAO<ElderCondition> {
    public List<ElderCondition> findElderCondition(String elderId);

    public ArrayList<String> getAllEldersInThisTable();
}
