package com.OCare.dao;

import com.OCare.entity.Device;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mark on 10/24/15.
 */
@Repository
public class DeviceDAOImpl extends IGeneralDAOImpl<Device> implements DeviceDAO {
    public DeviceDAOImpl() {
        super(Device.class);
    }

    @Override
    public String getElderIdByQRCode(String QRCode) {
        String hql = "from Device where QRCode = :m";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("m", QRCode);
        List<Device> devices = query.list();
        //二唯码唯一性无法保证，只取list中的第一项
        if(devices.size() == 0){
            return null;
        }else{
            return devices.get(0).getElderId();
        }
    }
}
