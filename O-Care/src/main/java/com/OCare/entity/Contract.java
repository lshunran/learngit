package com.OCare.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by fowafolo on 15/7/26.
 */
@Entity
@Table
public class Contract {
    @Id
    private int id;

    private int company_id;
    private String elder_id;
    private Date start_time;
    private Date end_time;

    /*
        status = 101 代表 合同正在进行中
        status = 102 代表 合同已过期作废
     */
    private int status;
    private String folder_name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getElder_id() {
        return elder_id;
    }

    public void setElder_id(String elder_id) {
        this.elder_id = elder_id;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getFolder_name() { return folder_name; }

    public void setFolder_name(String folder_name) {
        this.folder_name = folder_name;
    }
}
