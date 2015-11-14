package com.OCare.service;

import com.OCare.entity.*;

import java.util.ArrayList;

/**
 * Created by fowafolo on 15/7/28.
 */
public interface RegisterService {

    /*
        功能：老人注册功能
        参数：老人ID，老人所在公司的ID，老人姓名，老人电话，老人住址，老人密码，老人头像的字符串
        返回值：老人实例Elder
     */
    public Elder registerForAnElder(String elderId,int companyId,String elderName, String elderPhone,String elderAddress, String elderPassword,String elderImage);

    /*
        功能：监护人注册功能
        参数：监护人ID，监护人姓名，监护人电话，监护人地址，监护人密码，监护人头像字符串
        返回值：监护人实例
     */
    public Relative registerForARelative(String relativeId,String relativeName, String relativePhone, String relativeAddress, String relativePassword, String relativeImage);

    /*
        功能：志愿者注册功能
        参数：志愿者ID，志愿者姓名，志愿者电话，志愿者地址，志愿者邮箱，制原则公司ID，志愿者密码，志愿者头像字符串
        返回值：志愿者实例Volunteer
    */
    public Volunteer registerForAVolunteer(String volunteerId,String volunteerName, String volunteerPhone, String volunteerAddress, String volunteerEmail, int volunteerCompanyId,String volunteerPassword, String volunteerImage);

    /*
        功能：法人注册
        参数：法人Id，法人姓名，法人电话，法人邮件，法人密码，法人头像字符串
        返回值：法人实例LegalPerson
     */
    public LegalPerson registerForALegalPerson(String lpId,String lpName, String lpPhone, String lpEmail,String lpPassword,String lpImage);

    /*
        功能：检测身份证号和手机号是否已经被注册过了
        参数：注册的身份证号，注册的手机号
        返回值：布尔值，true表示身份证号和手机号可以注册，false表示其中一项已经注册过了
     */
//    public boolean isIdOrPhoneNumExist(String id, String phoneNum);

    /*
        功能：注册公司
        参数：
        返回值：实例
     */
    public Company registerForCompany(String comName, String comLegalPersonId, String comPhone, String comAddress);

    /*
        功能：判断法人代表是否存在
        参数：法人代表Id
        返回：值布尔值
     */
    public boolean isLegalPersonIdExist(String legalPersonId);

    public ArrayList<Elder> getAllElders();
    public ArrayList<Relative> getAllRelatives();
    public ArrayList<Volunteer> getAllVolunteers();
    public ArrayList<LegalPerson> getAllLegalPerson();
}
