package com.OCare.service;

import com.OCare.entity.Elder;
import com.OCare.entity.ElderMonitor;
import com.OCare.entity.Relative;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fowafolo on 15/8/7.
 */
public interface ElderService {

    /*
        功能：通过Id拿到Elder实体
        参数：身份证
        返回值：实体Elder
     */
    public Elder getElderById(String elderId);

    /*
        功能：通过老人Id拿到所有监护人的list
        参数：身份证号码Id
        返回值：Arraylist<relative>
     */
    public ArrayList<Relative> getAllMonitorsByElderId(String elderId);

    /*
        功能：拿到所有老人信息
        参数：无
        返回值：Arraylist<Elder>
     */

    /*
        功能：根据老人姓名拿到所有老人
        返回值：所有老人
     */
    public ArrayList<Elder> getAllEldersByElderName(String elderName);
    
    public ArrayList<Elder> getAllElders();

    public List<Elder> getEldersByPhoneNum(String phone);

    public List<ElderMonitor> findAllElderMonitorsByRelativeId(String relativeId);
}
