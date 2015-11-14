package com.OCare.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by mark on 10/27/15.
 */
@Table
@Entity
public class ofMucRoom {

    @Id
    private int id;
    private int serviceID;
    private int roomID;
    private String creationDate;
    private String modificationDate;
    private String name;
    private String naturalName;
    private String description;
    private String lockedDate;
    private String emptyDate;
    private int canChangeSubject;
    private int maxUsers;
    private int publicRoom;
    private int moderated;
    private int membersOnly;
    private int canInvite;
    private String roomPassword;
    private int canDiscoverJID;
    private int logEnabled;
    private String subject;
    private int rolesToBroadcast;
    private int useReservedNick;
    private int canChangeNick;
    private int canRegister;
    private int isOCareRoom;

    public int getCanChangeNick() {
        return canChangeNick;
    }

    public void setCanChangeNick(int canChangeNick) {
        this.canChangeNick = canChangeNick;
    }

    public int getCanChangeSubject() {
        return canChangeSubject;
    }

    public void setCanChangeSubject(int canChangeSubject) {
        this.canChangeSubject = canChangeSubject;
    }

    public int getCanDiscoverJID() {
        return canDiscoverJID;
    }

    public void setCanDiscoverJID(int canDiscoverJID) {
        this.canDiscoverJID = canDiscoverJID;
    }

    public int getCanInvite() {
        return canInvite;
    }

    public void setCanInvite(int canInvite) {
        this.canInvite = canInvite;
    }

    public int getCanRegister() {
        return canRegister;
    }

    public void setCanRegister(int canRegister) {
        this.canRegister = canRegister;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmptyDate() {
        return emptyDate;
    }

    public void setEmptyDate(String emptyDate) {
        this.emptyDate = emptyDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsOCareRoom() {
        return isOCareRoom;
    }

    public void setIsOCareRoom(int isOCareRoom) {
        this.isOCareRoom = isOCareRoom;
    }

    public String getLockedDate() {
        return lockedDate;
    }

    public void setLockedDate(String lockedDate) {
        this.lockedDate = lockedDate;
    }

    public int getLogEnabled() {
        return logEnabled;
    }

    public void setLogEnabled(int logEnabled) {
        this.logEnabled = logEnabled;
    }

    public int getMaxUsers() {
        return maxUsers;
    }

    public void setMaxUsers(int maxUsers) {
        this.maxUsers = maxUsers;
    }

    public int getMembersOnly() {
        return membersOnly;
    }

    public void setMembersOnly(int membersOnly) {
        this.membersOnly = membersOnly;
    }

    public int getModerated() {
        return moderated;
    }

    public void setModerated(int moderated) {
        this.moderated = moderated;
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNaturalName() {
        return naturalName;
    }

    public void setNaturalName(String naturalName) {
        this.naturalName = naturalName;
    }

    public int getPublicRoom() {
        return publicRoom;
    }

    public void setPublicRoom(int publicRoom) {
        this.publicRoom = publicRoom;
    }

    public int getRolesToBroadcast() {
        return rolesToBroadcast;
    }

    public void setRolesToBroadcast(int rolesToBroadcast) {
        this.rolesToBroadcast = rolesToBroadcast;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getRoomPassword() {
        return roomPassword;
    }

    public void setRoomPassword(String roomPassword) {
        this.roomPassword = roomPassword;
    }

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getUseReservedNick() {
        return useReservedNick;
    }

    public void setUseReservedNick(int useReservedNick) {
        this.useReservedNick = useReservedNick;
    }
}
