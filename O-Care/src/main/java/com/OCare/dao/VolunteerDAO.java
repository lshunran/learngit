package com.OCare.dao;

import com.OCare.entity.Volunteer;

/**
 * Created by fowafolo on 15/7/28.
 */
public interface VolunteerDAO extends IGeneralDAO<Volunteer> {
    public Volunteer queryByPhoneNum(String phoneNum);
}
