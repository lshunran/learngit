package com.OCare.service;

import com.OCare.dao.ElderDAO;
import com.OCare.dao.LegalPersonDAO;
import com.OCare.dao.RelativeDAO;
import com.OCare.dao.VolunteerDAO;
import com.OCare.entity.*;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by mark on 8/2/15.
 */
@Service("LogonService")
@Transactional
public class AccountServiceImp implements AccountService {

    @Autowired
    private ElderDAO elderDAO;
    @Autowired
    private RelativeDAO relativeDAO;
    @Autowired
    private VolunteerDAO volunteerDAO;
    @Autowired
    private LegalPersonDAO legalPersonDAO;

    @Override
    public Pair<String, Object> logon(String phoneNum, String password) {
        String md5Password = JavaMD5Util.MD5(password);
        Elder elder = elderDAO.queryByPhoneNum(phoneNum);
        Relative relative = relativeDAO.queryByPhoneNum(phoneNum);
        Volunteer volunteer = volunteerDAO.queryByPhoneNum(phoneNum);
        LegalPerson legalPerson = legalPersonDAO.queryByPhoneNum(phoneNum);
        if(elder != null){
            if (elder.getPassword().equals(md5Password)){
                Pair<String, Object> pair = new Pair<String, Object>("Elder", elder);
                return pair;
            }else{
                Pair<String, Object> pair = new Pair<String, Object>("Incorrect password", null);
                return pair;
            }
        }else if(relative != null){
            if(relative.getPassword().equals(md5Password)){
                Pair<String, Object> pair = new Pair<String, Object>("Relative", relative);
                return pair;
            }else{
                Pair<String, Object> pair = new Pair<String, Object>("Incorrect password", null);
                return pair;
            }
        }else if (volunteer != null){
            if (volunteer.getPassword().equals(md5Password)){
                Pair<String, Object> pair = new Pair<String, Object>("Volunteer", volunteer);
                return pair;
            }else{
                Pair<String, Object> pair = new Pair<String, Object>("Incorrect password", null);
                return pair;
            }
        }else if (legalPerson != null){
            if (legalPerson.getPassword().equals(md5Password)){
                Pair<String, Object> pair = new Pair<String, Object>("LegalPerson", legalPerson);
                return pair;
            }else{
                Pair<String, Object> pair = new Pair<String, Object>("Incorrect password", null);
                return pair;
            }
        }else{
            Pair<String, Object> pair = new Pair<String, Object>("Invalid Account", null);
            return pair;
        }
    }

    @Override
    public String verifyPhoneNum(String id, String phoneNum) {
        Elder elder = elderDAO.queryById(id);
        Relative relative = relativeDAO.queryById(id);
        Volunteer volunteer = volunteerDAO.queryById(id);
        LegalPerson legalPerson = legalPersonDAO.queryById(id);
        if(elder != null){
            if (elder.getPhone().equals(phoneNum)){
                return "Elder";
            }else{
                return "Incorrect phone number";
            }
        }else if(relative != null){
            if(relative.getPhone().equals(phoneNum)){
                return "Relative";
            }else{
                return "Incorrect phone number";
            }
        }else if (volunteer != null){
            if (volunteer.getPhone().equals(phoneNum)){
                return "Volunteer";
            }else{
                return "Incorrect phone number";
            }
        }else if (legalPerson != null){
            if (legalPerson.getPhone().equals(phoneNum)){
                return "LegalPerson";
            }else{
                return "Incorrect phone number";
            }
        }else{
            return "Invalid Account";
        }
    }

    @Override
    public String changePassword(String id, String password) {
        String md5Password = JavaMD5Util.MD5(password);
        Elder elder = elderDAO.queryById(id);
        Relative relative = relativeDAO.queryById(id);
        Volunteer volunteer = volunteerDAO.queryById(id);
        LegalPerson legalPerson = legalPersonDAO.queryById(id);
        if(elder != null){
            elder.setPassword(md5Password);
            elderDAO.update(elder);
            return "change success";
        }else if(relative != null){
            relative.setPassword(md5Password);
            relativeDAO.update(relative);
            return "change success";
        }else if (volunteer != null){
            volunteer.setPassword(md5Password);
            volunteerDAO.update(volunteer);
            return "change success";
        }else if (legalPerson != null){
            legalPerson.setPassword(md5Password);
            legalPersonDAO.update(legalPerson);
            return "change success";
        }else{
            return "Invalid Account";
        }
    }

    @Override
    public Pair<String, Object> getImageByPhoneNum(String phoneNum) {
        Elder elder = elderDAO.queryByPhoneNum(phoneNum);
        Relative relative = relativeDAO.queryByPhoneNum(phoneNum);
        Volunteer volunteer = volunteerDAO.queryByPhoneNum(phoneNum);
        LegalPerson legalPerson = legalPersonDAO.queryByPhoneNum(phoneNum);

        if (elder!=null)
        {
            Pair<String, Object> pair = new Pair<String, Object>("get image successfully.",elder.getImage());
            return pair;
        }else if(relative != null){
            Pair<String, Object> pair = new Pair<String, Object>("get image successfully.",relative.getImage());
            return pair;
        }else if (volunteer != null){
            Pair<String, Object> pair = new Pair<String, Object>("get image successfully.",volunteer.getImage());
            return pair;
        }else if (legalPerson != null){
            Pair<String, Object> pair = new Pair<String, Object>("get image successfully.",legalPerson.getImage());
            return pair;
        }else{
            Pair<String, Object> pair = new Pair<String, Object>("PhoneNum does not match to any account!",null);
            return pair;
        }
    }

    @Override
    public boolean isChangeImageSucc(String phoneNum,String newImg) {
        Elder elder = elderDAO.queryByPhoneNum(phoneNum);
        Relative relative = relativeDAO.queryByPhoneNum(phoneNum);
        Volunteer volunteer = volunteerDAO.queryByPhoneNum(phoneNum);
        LegalPerson legalPerson = legalPersonDAO.queryByPhoneNum(phoneNum);
        boolean flag ;
        if (elder!=null)
        {
            elder.setImage(newImg);
            elderDAO.update(elder);
            flag = true;
        }else if(relative != null){
            relative.setImage(newImg);
            relativeDAO.update(relative);
            flag = true;
        }else if (volunteer != null){
            volunteer.setImage(newImg);
            volunteerDAO.update(volunteer);
            flag = true;
        }else if (legalPerson != null){
            legalPerson.setImage(newImg);
            legalPersonDAO.update(legalPerson);
            flag = true;
        }else{
            flag = false;
        }
        return flag;
    }
}
