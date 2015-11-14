package com.OCare.dao;

import com.OCare.entity.ElderMonitor;
import com.OCare.entity.Relative;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fowafolo on 15/7/31.
 */
public interface ElderMonitorDAO extends IGeneralDAO<ElderMonitor> {

    /*
        列出所有未处理的监护人请求，即type为3的ElderMonitor的集合
     */
    public List<ElderMonitor> getAllUntreatedRequests();
    public List<ElderMonitor> queryByRelativeId(String relativeId);
    public ElderMonitor getById(int id);

    /*
        通过elder和某人的id拿到关系
     */
    public ArrayList<ElderMonitor> getMonitorByElderIdAndSbId(String elderId, String sbId);

    /*
        通过老人Id拿到所有监护人（type=1）
     */
    public ArrayList<Relative> getAllMonitorsByElderId(String elderId);

    public List<ElderMonitor> getMonitorsByElderId(String elderId);

     /*
        功能；通过监护人Id拿到所有老人
     */
    public List<ElderMonitor> getAllEldersByMonitorId(String monitorId);
}
