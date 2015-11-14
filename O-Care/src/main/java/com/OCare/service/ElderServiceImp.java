package com.OCare.service;

import com.OCare.dao.ElderDAO;
import com.OCare.dao.ElderMonitorDAO;
import com.OCare.entity.Elder;
import com.OCare.entity.ElderMonitor;
import com.OCare.entity.Relative;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by fowafolo on 15/8/7.
 */

@Service("Elder")
@Transactional
public class ElderServiceImp implements ElderService {
    @Autowired
    private ElderDAO elderDAO;
    @Autowired
    private ElderMonitorDAO elderMonitorDAO;

    @Override
    public Elder getElderById(String elderId) {
        if (!isElderExist(elderId))
            return null;
        Elder elder = elderDAO.queryById(elderId);
        return elder;
    }

    @Override
    public ArrayList<Relative> getAllMonitorsByElderId(String elderId) {
        if (!isElderExist(elderId))
            return null;
        ArrayList<Relative> list = elderMonitorDAO.getAllMonitorsByElderId(elderId);
        return list;
    }

    @Override
    public ArrayList<Elder> getAllEldersByElderName(String elderName) {
        ArrayList<Elder> elders = (ArrayList<Elder>) elderDAO.getAllEldersByName(elderName);
        return elders;
    }

    @Override
    public ArrayList<Elder> getAllElders() {
        return (ArrayList<Elder>) elderDAO.queryAll();
    }

    public boolean isElderExist(String elderId){
        boolean flag = false;
        ArrayList<Elder> list = (ArrayList<Elder>) elderDAO.queryAll();
        Iterator<Elder> iterator = list.iterator();
        while (iterator.hasNext())
        {
            Elder tmp = iterator.next();
            if (tmp.getId().equals(elderId))
                flag = true;
        }
        return flag;
    }

    @Override
    public List<Elder> getEldersByPhoneNum(String phone){
        return elderDAO.getEldersByPhoneNum(phone);
    }

    @Override
    public List<ElderMonitor> findAllElderMonitorsByRelativeId(String relativeId) {
        return elderMonitorDAO.queryByRelativeId(relativeId);
    }
}
