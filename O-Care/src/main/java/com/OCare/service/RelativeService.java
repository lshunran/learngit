package com.OCare.service;

import com.OCare.entity.Relative;

/**
 * Created by fowafolo on 15/8/7.
 */
public interface RelativeService {

    /*
        功能：通过Id找到这个relative并且返回其实体
        参数：relativeId
        返回值：实体Relative
     */
    public Relative getRelativeById(String id);
    public Relative getRelativeByPhoneNum(String phoneNum);
}
