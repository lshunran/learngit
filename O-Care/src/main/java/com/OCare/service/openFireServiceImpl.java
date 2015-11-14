package com.OCare.service;

import com.OCare.dao.ofMucAffiliationDAO;
import com.OCare.dao.ofMucMemberDAO;
import com.OCare.dao.ofMucRoomDAO;
import com.OCare.entity.ofMucAffiliation;
import com.OCare.entity.ofMucMember;
import com.OCare.entity.ofMucRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mark on 10/27/15.
 */
@Service("openFire")
@Transactional
public class openFireServiceImpl implements openFireService {

    public static final int ROOM_ID_INVALID = 1;
    public static final int ADMIN_NOT_EXIST = 2;
    public static final int ADMIN_NO_PERMISSION = 3;
    public static final int ROOM_NOT_EXIST = 4;
    public static final int MEMBER_NOT_EXIST = 5;

    @Autowired
    private ofMucAffiliationDAO affiliationDAO;
    @Autowired
    private ofMucMemberDAO memberDAO;
    @Autowired
    private ofMucRoomDAO roomDAO;

    @Override
    public Object findRoomidByName(String name) {
        ofMucRoom mucRoom=roomDAO.getRoomByName(name);
        if(mucRoom==null)
        {
           return ROOM_NOT_EXIST;
        }
        return mucRoom;
    }

    @Override
    public Object findMembersByPhoneNum(String phoneNum, String roomId) {

        Pattern pattern = Pattern.compile("^[0-9]*$");
        Matcher matcher = pattern.matcher(roomId);

        if(!matcher.matches()){
            return ROOM_ID_INVALID;
        }

        List<ofMucAffiliation> ofMucAffiliations = affiliationDAO.getAffiliationByPhoneNum(phoneNum);

        if(ofMucAffiliations == null || ofMucAffiliations.size() == 0){
            return ADMIN_NOT_EXIST;
        }

        //只取了List中的第一条记录判断！！
        if(ofMucAffiliations.get(0).getAffiliation() != 10){
            return ADMIN_NO_PERMISSION;
        }

        List<ofMucMember> ofMucMembers = memberDAO.getAllMembersByRoomId( Integer.parseInt(roomId));

        if(ofMucMembers == null){
            return ROOM_NOT_EXIST;
        }

        return ofMucMembers;

    }

    @Override
    public Object findRoomsById(String roomId) {
        Pattern pattern = Pattern.compile("^[0-9]*$");
        Matcher matcher = pattern.matcher(roomId);

        if(!matcher.matches()){
            return ROOM_ID_INVALID;
        }

        List<ofMucRoom> rooms = roomDAO.getRoomsById(Integer.parseInt(roomId));

        if(rooms == null || rooms.size() == 0){
            return ROOM_NOT_EXIST;
        }

        //只返回第一条记录！！！！！！
        return rooms.get(0);
    }

    @Override
    public Object findMemberByPhoneNumAndRoomId(String phoneNum, String roomId) {
        Pattern pattern = Pattern.compile("^[0-9]*$");
        Matcher matcher = pattern.matcher(roomId);

        if(!matcher.matches()){
            return ROOM_ID_INVALID;
        }

        List<ofMucMember> members = memberDAO.getMemberByRoomIdAndPhoneNum( Integer.parseInt(roomId), phoneNum);

        if(members == null || members.size() == 0){
            return MEMBER_NOT_EXIST;
        }

        //只返回第一条记录！！！！
        return members.get(0);
    }

    @Override
    public Object getPeopleByPhoneNumAndRoomId(String phoneNum, int roomId) {
        //2015.11.13修改，roomID为数据库表中的jid,所以不用正则表达式验证
        /*Pattern pattern = Pattern.compile("^[0-9]*$");
        Matcher matcher = pattern.matcher(roomId);

        if(!matcher.matches()){
            return ROOM_ID_INVALID;
        }*/

        //TODO: 判断是否是这个房间的人。先在移动端调用接口时注意下。

        List<ofMucMember> ofMucMembers = memberDAO.getAllMembersByRoomId(roomId);

        if(ofMucMembers == null){
            return ROOM_NOT_EXIST;
        }

        List<ofMucAffiliation> ofMucAffiliations = affiliationDAO.getAffiliationByPhoneNum(phoneNum);
        List<ofMucMember> tempMembers = memberDAO.getMemberByRoomIdAndPhoneNum(roomId,phoneNum);
        if((ofMucAffiliations == null || ofMucAffiliations.size() == 0)
                &&(tempMembers == null || tempMembers.size() == 0)){
            return MEMBER_NOT_EXIST;
        }


        return ofMucMembers;
    }
}
