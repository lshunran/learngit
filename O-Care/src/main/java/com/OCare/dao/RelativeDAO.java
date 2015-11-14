package com.OCare.dao;

import com.OCare.entity.Relative;

import java.util.List;

/**
 * Created by fowafolo on 15/7/28.
 */
public interface RelativeDAO extends IGeneralDAO<Relative>{
    public Relative queryByPhoneNum(String phoneNum);

    public List<Relative> getAllMonitorsByName(String name);
}
