package com.OCare.dao;

import com.OCare.entity.ofMucRoom;

import java.util.List;

/**
 * Created by mark on 10/27/15.
 */
public interface ofMucRoomDAO extends IGeneralDAO<ofMucRoom> {

    public ofMucRoom getRoomByName(String name);
    public List<ofMucRoom> getRoomsById(int id);
}
