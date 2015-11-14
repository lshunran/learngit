package com.OCare.service;

import com.OCare.dao.AlarmHistoryDao;
import com.OCare.entity.AlarmHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ma on 2015/11/10.
 */
@Transactional
@Service("AlarmHistoryService")
public class AlarmHistoryServiceImp implements AlarmHistoryService  {

    @Autowired
    private AlarmHistoryDao alarmHistoryDao;

    @Override
    public List<AlarmHistory> getAlarmHistory(int limit,int offset) {

        List<AlarmHistory> listAll;
        List<AlarmHistory> list=new ArrayList<AlarmHistory>();
        listAll=(List<AlarmHistory>)alarmHistoryDao.queryAll();
        int set=limit*(offset-1);
        if((set+limit)<=listAll.size()) {
            list = listAll.subList(set, set + limit);
        }else if(set<=listAll.size())
        {
            list = listAll.subList(set, listAll.size());
        }
  return list;
}
}