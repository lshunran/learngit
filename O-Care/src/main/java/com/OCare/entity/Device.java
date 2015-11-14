package com.OCare.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by mark on 10/24/15.
 */
@Table
@Entity
public class Device {

    @Id
    private String DeviceId;
    private String DeviceName;
    private String CommunicationType;
    private String Description;
    private String Image;
    private String ElderId;
    private String QRCode;

    public String getCommunicationType() {
        return CommunicationType;
    }

    public void setCommunicationType(String communicationType) {
        CommunicationType = communicationType;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDeviceId() {
        return DeviceId;
    }

    public void setDeviceId(String deviceId) {
        DeviceId = deviceId;
    }

    public String getDeviceName() {
        return DeviceName;
    }

    public void setDeviceName(String deviceName) {
        DeviceName = deviceName;
    }

    public String getElderId() {
        return ElderId;
    }

    public void setElderId(String elderId) {
        ElderId = elderId;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getQRCode() {
        return QRCode;
    }

    public void setQRCode(String QRCode) {
        this.QRCode = QRCode;
    }
}
