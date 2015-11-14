package com.OCare.dao;

import com.OCare.entity.ofMucMember;

import java.util.List;

/**
 * Created by mark on 10/27/15.
 */
public interface ofMucMemberDAO extends IGeneralDAO<ofMucMember> {

    //2015.11.13修改，roomID实际为数据库中的jid
    //public ofMucMember getRoomidByjid(String jid);
    public List<ofMucMember> getAllMembersByRoomId(int roomId);
    public List<ofMucMember> getMemberByRoomIdAndPhoneNum(int roomId, String phoneNum);
}
