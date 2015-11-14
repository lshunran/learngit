package com.OCare.dao;

import com.OCare.entity.ofMucAffiliation;

import java.util.List;

/**
 * Created by mark on 10/27/15.
 */
public interface ofMucAffiliationDAO extends IGeneralDAO<ofMucAffiliation> {

    public List<ofMucAffiliation> getAffiliationByPhoneNum(String phoneNum);
}
