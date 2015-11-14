package com.OCare.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by fowafolo on 15/7/26.
 */
@Entity
@Table
public class Company {
    @Id
    private int id;

    private String name;
    private String legal_person_id;
    private String phone;
    private String address;

    /*
        status = 101 代表未审核
        status = 102 代表审核通过
        status = 103 代表审核通过
     */
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLegal_person_id() {
        return legal_person_id;
    }

    public void setLegal_person_id(String legal_person_id) {
        this.legal_person_id = legal_person_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
