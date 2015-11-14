package com.OCare.service;


import com.OCare.entity.Elder;
import com.OCare.entity.ElderMonitor;
import com.OCare.entity.Relative;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by fowafolo on 15/7/29.
 */

public interface VerifyService {
    /*
        功能：监护人提交监护某老人的申请
        参数：监护人ID，老人Id，两人合照字符串
        返回值：无
     */
    public void submitMonitorApply(String relativeId, String elderId,String togetherImg);

    /*
        功能：管理员审核监护人提出的监护老人的申请
        参数：申请Id,是否同意，false为不同意，true为同意，这个值由管理员传入
        返回值：无
     */
    public void checkMonitorApply(int elderMonitorId, int isApproval);

    /*
        功能：列出所有未处理的监护人请求，即type为3的ElderMonitor的集合
        参数：无
        返回值：所有type为3，即未处理的请求。
     */
    public List<ElderMonitor> getAllUntreatedRequests();

    public ElderMonitor getRequestByID(int requestid);

    public List<ElderMonitor> monitorStatus(String relativeId);

    /*
        功能：监护人修改某人和老人之间的关系
        参数：老人Id，某人电话，新的关系类型
        返回值：是否成功，true为成功，false为失败
     */
    public boolean changeRelationBetweenElderAndSomebody(String elderId,String sbPhoneNum,int newRelationType);

    /*
        功能：监护人删除老人和某人的关系（最好不要删，改掉type好了）
        参数：老人Id，某人电话
        返回值：是否成功，成功为true ,false为失败
     */
    public boolean deleteRelationBetweenElderAndSomebody(String elderId, String sbPhoneNum);

    /*
        功能：使一个申请变为未审核状态
        参数：申请id
        返回值：是否成功Boolean值
     */
    public boolean makeAMonitorRequestUndesigned(int monitorId);

    /*
        功能：使一个申请变为拒绝状态
        参数：申请id
        返回值：是否成功Boolean值
     */
    public boolean makeAMonitorRequestAgreed(int monitorId);

    /*
        功能：使一个申请变为拒绝状态
        参数：申请id
        返回值：是否成功Boolean值
     */
    public boolean makeAMonitorRequestDisAgreed(int monitorId);


    /*
        功能：通过老人Id可以拿到所有老人，监护人（type=1）的arraylist
     */
    public ArrayList<Map<Elder,Relative>> getAllMonitorByElderId(String elderId);

    public ArrayList<Relative> getMonitorsByElderId(String elderid);

    /*
        功能；通过监护人Id拿到所有老人
     */
    public ArrayList<Elder> getAllEldersByMonitorId(String monitorId);

    /*
        功能：查找某一姓名的所有监护人
        注意：type=1，只查监护人
     */
    public ArrayList<Relative> getAllMonitorsByName(String monitorName);
}
