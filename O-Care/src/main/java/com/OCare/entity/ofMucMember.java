package com.OCare.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by mark on 10/24/15.
 */
@Table
@Entity
public class ofMucMember {

    @Id
    private int id;

    private int roomID;
    private String jid;
    private String nickname;
    private String firstName;
    private String lastName;
    private String url;
    private String email;
    private String faqentry;
    private String relation;
    private String ofMucMembercol;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFaqentry() {
        return faqentry;
    }

    public void setFaqentry(String faqentry) {
        this.faqentry = faqentry;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJid() {
        return jid;
    }

    public void setJid(String jid) {
        this.jid = jid;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getOfMucMembercol() {
        return ofMucMembercol;
    }

    public void setOfMucMembercol(String ofMucMembercol) {
        this.ofMucMembercol = ofMucMembercol;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
