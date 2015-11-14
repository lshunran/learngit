package com.OCare.controller;

import com.OCare.entity.AlarmHistory;
import com.OCare.service.AlarmHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ma on 2015/11/10.
 */
@Controller
@RequestMapping("/app/alarm")
public class AlarmHistoryController {

    @Autowired
    private AlarmHistoryService alarmHistoryService;

    /*
       功能：于子涵
     */
    @RequestMapping("/get/set")
    @ResponseBody
    public List<AlarmHistory> listAlarmHistoryBySet(int limit,int offset) {
        List<AlarmHistory> result= (List<AlarmHistory>) alarmHistoryService.getAlarmHistory(limit,offset);

        return result;
    }
}
