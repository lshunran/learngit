package com.OCare.service;

import com.OCare.dao.RelativeDAO;
import com.OCare.entity.Relative;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by fowafolo on 15/8/7.
 */

@Service("Relative")
@Transactional
public class RelativeServiceImp implements RelativeService {

    @Autowired
    private RelativeDAO relativeDAO;

    @Override
    public Relative getRelativeById(String id) {
        if (!isElderExist(id))
            return null;
        Relative relative = relativeDAO.queryById(id);
        return relative;
    }

    public Relative getRelativeByPhoneNum(String phoneNum) {
        return relativeDAO.queryByPhoneNum(phoneNum);
    }

    public boolean isElderExist(String relativeId){
        boolean flag = false;
        ArrayList<Relative> list = (ArrayList<Relative>) relativeDAO.queryAll();
        Iterator<Relative> iterator = list.iterator();
        while (iterator.hasNext())
        {
            Relative tmp = iterator.next();
            if (tmp.getId().equals(relativeId))
                flag = true;
        }
        return flag;
    }
}
