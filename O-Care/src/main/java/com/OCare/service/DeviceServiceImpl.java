package com.OCare.service;

import com.OCare.dao.DeviceDAO;
import com.OCare.dao.ElderDAO;
import com.OCare.entity.Device;
import com.OCare.entity.Elder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by mark on 10/24/15.
 */
@Service("deviceService")
@Transactional
public class DeviceServiceImpl implements DeviceService {

    public static final int SUCCESS = 0;
    public static final String DEFAULT_ELDER = "elder000";
    public static final String DEFAULT_QRCODE = "00000000";
    public static final int DEVICE_NOT_EXIST = 1;
    public static final int DEVICE_ALREADY_EXIST = 2;
    public static final int ELDER_NOT_EXIST = 3;
    public static final int DEVICE_ALREADY_MATCH = 4;


    @Autowired
    private DeviceDAO deviceDAO;
    @Autowired
    private ElderDAO elderDAO;


    @Override
    public Object createNewDeviceWithoutElderIdAndQRCode(String id, String name, String communicationType, String description, String image) {

        Device getDevice = deviceDAO.queryById(id);

        if(getDevice != null){
            return DEVICE_ALREADY_EXIST;
        }

        Device newDevice = new Device();
        newDevice.setDeviceId(id);
        newDevice.setDeviceName(name);
        newDevice.setCommunicationType(communicationType);
        newDevice.setDescription(description);
        newDevice.setImage(image);
        newDevice.setElderId(DEFAULT_ELDER);
        newDevice.setQRCode(DEFAULT_QRCODE);

        deviceDAO.insert(newDevice);

        return newDevice;
    }

    @Override
    public Object addElderIdAndQRCodeToDevice(String deviceId, String ElderId, String QRCode) {

        Device getDevice = deviceDAO.queryById(deviceId);

        if (getDevice == null){
            return DEVICE_NOT_EXIST;
        }

        Elder getElder = elderDAO.queryById(ElderId);

        if(getElder == null){
            return ELDER_NOT_EXIST;
        }

        if(!getDevice.getElderId().equals(DEFAULT_ELDER)){
            return DEVICE_ALREADY_MATCH;
        }

        getDevice.setElderId(ElderId);
        getDevice.setQRCode(QRCode);

        deviceDAO.update(getDevice);

        return getDevice;
    }

    @Override
    public Device getDeviceById(String deviceId) {
        return deviceDAO.queryById(deviceId);
    }

    @Override
    public Object modifyDeviceById(String deviceId, String name, String communicationType, String description, String image) {
        Device getDevice = deviceDAO.queryById(deviceId);

        if(getDevice == null){
            return DEVICE_NOT_EXIST;
        }

        getDevice.setDeviceName(name);
        getDevice.setCommunicationType(communicationType);
        getDevice.setDescription(description);
        getDevice.setImage(image);

        deviceDAO.update(getDevice);

        return getDevice;
    }

    @Override
    public Device refreshDeviceById(String deviceId) {
        Device getDevice =  deviceDAO.queryById(deviceId);
        if(getDevice == null){
            return null;
        }else{
            getDevice.setElderId(DEFAULT_ELDER);
            getDevice.setQRCode(DEFAULT_QRCODE);
            deviceDAO.update(getDevice);
            return getDevice;
        }
    }

    @Override
    public String getElderIdByQRCode(String QRCode) {
        return deviceDAO.getElderIdByQRCode(QRCode);
    }
}
