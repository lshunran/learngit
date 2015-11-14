package com.OCare.controller;

import com.OCare.entity.ElderCondition;
import com.OCare.entity.EldersLocation;
import com.OCare.service.ElderConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Li on 2015/7/29.
 */
@Controller
@RequestMapping("/map")
public class ElderConditionController {
    @Autowired
    private ElderConditionService elderConditionService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String ShowElders(ModelMap map,ServletRequest request,HttpSession session1) {
        // request.removeAttribute("Elders");
        List<ElderCondition> list = elderConditionService.allElderConditions();

        map.addAttribute("Elders",list);
//        session.close();
        return "Map";
    }

    @RequestMapping(value = "/Refresh", method = RequestMethod.GET)
    @ResponseBody
    public Object RefreshCondition(ModelMap map,HttpSession session)  {

        List<ElderCondition> list = elderConditionService.allElderConditions();

        List<EldersLocation> location_list = new ArrayList<EldersLocation>();

        for (int i = 0; i < list.size(); i++) {
            EldersLocation location_item = new EldersLocation();

            location_item.setElder_id(list.get(i).getElder_id());
            location_item.setLatitude(list.get(i).getLatitude());
            location_item.setLongtitude(list.get(i).getLongtitude());
            location_item.setJson_item_number(list.size());
            if(list.get(i).getStatus()==1)
                location_item.setElder_status("有紧急情况");
            else location_item.setElder_status("情况良好");
            location_list.add(location_item);
        }
//        System.out.println("test....................");
//        for (int i = 0; i < list.size() ; i++) {
//            System.out.println(location_list.get(i).getElder_status());
//        }
        return location_list;

    }

}
