package com.OCare.service;

import com.OCare.entity.ofMucRoom;

/**
 * Created by mark on 10/27/15.
 */
public interface openFireService {
    //先通过jid取到roomId
    public Object findRoomidByName(String name);
    //传说中的管理员查看某房间中的所有成员
    public Object findMembersByPhoneNum(String phoneNum, String roomId);
    public Object findRoomsById(String roomId);
    //某人查看某房间中的某一成员
    public Object findMemberByPhoneNumAndRoomId(String phoneNum, String roomId);

    /*
        功能：拿到成员或者管理员所在房间内的所有成员的电话号码
     */
    public Object getPeopleByPhoneNumAndRoomId(String phoneNum, int roomId);
}
