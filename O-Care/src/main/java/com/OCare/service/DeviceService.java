package com.OCare.service;

import com.OCare.entity.Device;

/**
 * Created by mark on 10/24/15.
 */
public interface DeviceService {
    public Object createNewDeviceWithoutElderIdAndQRCode(String id, String name, String communicationType, String description, String image);
    public Object addElderIdAndQRCodeToDevice(String deviceId, String ElderId, String QRCode);
    public Device getDeviceById(String deviceId);
    public Object modifyDeviceById(String deviceId, String name, String communicationType, String description, String image);
    public Device refreshDeviceById(String deviceId);
    public String getElderIdByQRCode(String QRCode);
}
