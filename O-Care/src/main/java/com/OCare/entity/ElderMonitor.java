package com.OCare.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by fowafolo on 15/7/30.
 */

@Entity
@Table
public class ElderMonitor {

    @Id
    private int id;

    private String elder_id;
    private String relative_id;
    //2表示监护类型为普通亲戚；1表示监护类型为监护人；3表示在申请监护人;
    //4表示申请监护人被拒绝;5代表邻居关系;
    //7.代表原来有关系现在没关系了
    private int type;
    private String togetherImg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getElder_id() {
        return elder_id;
    }

    public void setElder_id(String elder_id) {
        this.elder_id = elder_id;
    }

    public String getRelative_id() {
        return relative_id;
    }

    public void setRelative_id(String relative_id) {
        this.relative_id = relative_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTogetherImg() {
        return togetherImg;
    }

    public void setTogetherImg(String togetherImg) {
        this.togetherImg = togetherImg;
    }
}
