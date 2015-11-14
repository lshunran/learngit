package com.OCare.entity;

/**
 * Created by Li on 2015/8/3.
 */
public class EldersLocation {
    private String elder_id;
    private Double latitude;
    private Double longtitude;
    private String elder_status;
    private int json_item_number;

    public String getElder_id() {
        return elder_id;
    }

    public void setElder_id(String elder_id) {
        this.elder_id = elder_id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(Double longtitude) {
        this.longtitude = longtitude;
    }

    public String getElder_status() {
        return elder_status;
    }

    public void setElder_status(String elder_status) {
        this.elder_status = elder_status;
    }

    public int getJson_item_number() {
        return json_item_number;
    }

    public void setJson_item_number(int json_item_number) {
        this.json_item_number = json_item_number;
    }
}
