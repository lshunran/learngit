package com.OCare.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Ma on 2015/11/10.
 */

@Table
@Entity
public class AlarmHistory {

    private int talk_type;
    private int talk_cate;
    private String picture_url;
    private int direction;
    private double who_loc_log;
    private double who_loc_lat;
    private String who_address;
    private String talk_at;
    private int talk_alarm;
    private String who_Privateto;
    private int talk_time;
    private String audio_url;
    private String messageid;
    @Id
    private int generateid;
    private String messagefrom;
    private String messageto;

    public void setTalk_type(int talk_type) {
        this.talk_type = talk_type;
    }

    public void setTalk_cate(int talk_cate) {
        this.talk_cate = talk_cate;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setWho_loc_log(double who_loc_log) {
        this.who_loc_log = who_loc_log;
    }

    public void setWho_loc_lat(double who_loc_lat) {
        this.who_loc_lat = who_loc_lat;
    }

    public void setWho_address(String who_address) {
        this.who_address = who_address;
    }

    public void setTalk_at(String talk_at) {
        this.talk_at = talk_at;
    }

    public void setTalk_alarm(int talk_alarm) {
        this.talk_alarm = talk_alarm;
    }

    public void setWho_Privateto(String who_Privateto) {
        this.who_Privateto = who_Privateto;
    }

    public void setTalk_time(int talk_time) {
        this.talk_time = talk_time;
    }

    public void setAudio_url(String audio_url) {
        this.audio_url = audio_url;
    }

    public void setMessageid(String messageid) {
        this.messageid = messageid;
    }

    public void setGenerateid(int generateid) {
        this.generateid = generateid;
    }

    public void setMessagefrom(String messagefrom) {
        this.messagefrom = messagefrom;
    }

    public void setMessageto(String messageto) {
        this.messageto = messageto;
    }



    public int getTalk_type() {
        return talk_type;
    }

    public int getTalk_cate() {
        return talk_cate;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public int getDirection() {
        return direction;
    }

    public double getWho_loc_log() {
        return who_loc_log;
    }

    public double getWho_loc_lat() {
        return who_loc_lat;
    }

    public String getWho_address() {
        return who_address;
    }

    public String getTalk_at() {
        return talk_at;
    }

    public int getTalk_alarm() {
        return talk_alarm;
    }

    public String getWho_Privateto() {
        return who_Privateto;
    }

    public int getTalk_time() {
        return talk_time;
    }

    public String getAudio_url() {
        return audio_url;
    }

    public String getMessageid() {
        return messageid;
    }

    public int getGenerateid() {
        return generateid;
    }

    public String getMessagefrom() {
        return messagefrom;
    }

    public String getMessageto() {
        return messageto;
    }





}
