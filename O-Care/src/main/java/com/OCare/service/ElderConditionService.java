package com.OCare.service;

import com.OCare.entity.ElderCondition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fowafolo on 15/7/30.
 */
public interface ElderConditionService {
    public List<ElderCondition> allElderConditions();

    public ElderCondition getElderPresentConditionById(String elderId);

    public ArrayList<ElderCondition> getAllEldersPresentCondition();
}
