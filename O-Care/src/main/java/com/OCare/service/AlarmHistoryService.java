package com.OCare.service;

import com.OCare.entity.AlarmHistory;

import java.util.List;

/**
 * Created by Ma on 2015/11/10.
 */
public interface AlarmHistoryService {
    public List<AlarmHistory> getAlarmHistory(int limit,int offset);
}
