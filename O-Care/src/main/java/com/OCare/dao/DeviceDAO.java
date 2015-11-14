package com.OCare.dao;

import com.OCare.entity.Device;

/**
 * Created by mark on 10/24/15.
 */
public interface DeviceDAO extends IGeneralDAO<Device> {

    public String getElderIdByQRCode(String QRCode);
}
