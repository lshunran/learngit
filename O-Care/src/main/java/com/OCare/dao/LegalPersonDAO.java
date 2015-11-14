package com.OCare.dao;

import com.OCare.entity.LegalPerson;

/**
 * Created by fowafolo on 15/7/28.
 */
public interface LegalPersonDAO extends IGeneralDAO<LegalPerson> {
    public LegalPerson queryByPhoneNum(String phoneNum);
}
