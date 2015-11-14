package com.OCare.controller;

import com.OCare.entity.ElderMonitor;
import com.OCare.entity.Relative;
import com.OCare.entity.ofMucMember;
import com.OCare.entity.ofMucRoom;
import com.OCare.service.ElderService;
import com.OCare.service.RelativeService;
import com.OCare.service.openFireService;
import com.OCare.service.openFireServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mark on 10/27/15.
 */
@Controller
@RequestMapping("/app/openfire")
public class openFireController {

    private static final String INPUT_CANNOT_NULL = "INPUT_CANNOT_NULL";

    @Autowired
    private openFireService openFireService;
    @Autowired
    private RelativeService relativeService;
    @Autowired
    private ElderService elderService;

    /*
        功能：房间管理员查到所有成员的所有信息。
        参数：房间号，想查询信息的人的电话
        返回值：members
     */
    @RequestMapping("/admin/members")
    @ResponseBody
    public Map<String, Object> getMembers(String phoneNum, String roomId){
        Map<String, Object> result = new HashMap<String, Object>();

        if(phoneNum == null || roomId == null || phoneNum.equals("") || roomId.equals("")){
            result.put("error", true);
            result.put("errorMsg", INPUT_CANNOT_NULL);
            return result;
        }

        Object oResult = openFireService.findMembersByPhoneNum(phoneNum, roomId);

        if (oResult instanceof Integer){
            if ((Integer) oResult == openFireServiceImpl.ROOM_ID_INVALID){
                result.put("error", true);
                result.put("errorMsg", "ROOM_ID_INVALID");
                return result;
            }

            if ((Integer) oResult == openFireServiceImpl.ADMIN_NO_PERMISSION){
                result.put("error", true);
                result.put("errorMsg", "ADMIN_NO_PERMISSION");
                return result;
            }

            if ((Integer) oResult == openFireServiceImpl.ADMIN_NOT_EXIST){
                result.put("error", true);
                result.put("errorMsg", "ADMIN_NOT_EXIST");
                return result;
            }

            if ((Integer) oResult == openFireServiceImpl.ROOM_NOT_EXIST){
                result.put("error", true);
                result.put("errorMsg", "ROOM_NOT_EXIST");
                return result;
            }

        }

        result.put("error", false);
        result.put("members", oResult);
        return result;
    }

    /*
        2015.11.10修改
        功能：房间成员输入房间ID与成员电话与自己电话,可查询到任一成员的昵称、 图像、
        在该房间中的地位(是不是管理员,被踢的,publisher, none)、与老人的关系(如果该房间是养老房间)。
        参数：房间号，想查询信息的人的电话
     */

    @RequestMapping("/user/member")
    @ResponseBody
    public Map<String, Object> getMembersByUser(String phoneNum, String roomId,String thisPhoneNum){
        Map<String, Object> result = new HashMap<String, Object>();



        //发起查询的人必须房间的成员，服务端要做角色区别；
        Object thisMember = openFireService.findMemberByPhoneNumAndRoomId(thisPhoneNum, roomId);
        if(thisMember instanceof Integer) {
            if ((Integer) thisMember == openFireServiceImpl.MEMBER_NOT_EXIST) {
                result.put("error", true);
                result.put("errorMsg", "YOU_NOT_MEMBER");
                return result;
            }
        }
        if(phoneNum == null || roomId == null || phoneNum.equals("") || roomId.equals("")){
            result.put("error", true);
            result.put("errorMsg", INPUT_CANNOT_NULL);
            return result;
        }

        Object oRoom = openFireService.findRoomsById(roomId);
        Object oMember = openFireService.findMemberByPhoneNumAndRoomId(phoneNum, roomId);

        if(oRoom instanceof Integer){

            if ((Integer) oRoom ==openFireServiceImpl. ROOM_ID_INVALID){
                result.put("error", true);
                result.put("errorMsg", "ROOM_ID_INVALID");
                return result;
            }

            if ((Integer) oRoom ==openFireServiceImpl. ROOM_NOT_EXIST){
                result.put("error", true);
                result.put("errorMsg", "ROOM_NOT_EXIST");
                return result;
            }
        }

        if(oMember instanceof Integer){
            if((Integer) oMember == openFireServiceImpl.ROOM_ID_INVALID){
                result.put("error", true);
                result.put("errorMsg", "ROOM_ID_INVALID");
                return result;
            }

            if((Integer) oMember == openFireServiceImpl.MEMBER_NOT_EXIST){
                result.put("error", true);
                result.put("errorMsg", "MEMBER_NOT_EXIST");
                return result;
            }
        }

        result.put("error", false);

        ofMucRoom room = (ofMucRoom) oRoom;
        ofMucMember member = (ofMucMember) oMember;

        // result.put("room", room);                   //2015.11.10 不需要房间信息
        result.put("member", member);

        Relative relative = relativeService.getRelativeByPhoneNum(phoneNum);

        if(relative == null){
            result.put("relative","IS_NOT_RELATIVE");
            return result;
        }

        String relativeId = relative.getId();
        List<ElderMonitor> monitors = elderService.findAllElderMonitorsByRelativeId(relativeId);

        if(monitors == null){
            result.put("relative","NO_RELATION_WITH_ANY_ELDER");
            return result;
        }

        ArrayList<Map<String, Object>> relativeInfoList = new ArrayList<Map<String, Object>>();

        for(ElderMonitor monitor : monitors){
            Map<String, Object> relativeInfo = new HashMap<String, Object>();
            relativeInfo.put("relative", relative);
            relativeInfo.put("relationType", monitor.getType());
            relativeInfo.put("elder", elderService.getElderById(monitor.getElder_id()));
            relativeInfoList.add(relativeInfo);
        }

        result.put("relative", relativeInfoList);
        return result;
    }
    /*
        功能：房间管理员或者房间成员查看所有房间内成员的电话
        参数：房间号，想查询信息的人的jid
     */
    @RequestMapping("/getRoomMembersPhone")
    @ResponseBody
    public Map<String,Object> getRoomMembersPhone(String roomName, String phoneNum)
    {
        Map<String,Object> result = new HashMap<String, Object>();
        if(phoneNum == null || roomName == null || phoneNum.equals("") || roomName.equals("")){
            result.put("error", true);
            result.put("errorMsg", "INPUT_CANNOT_NULL");
            return result;
        }


        Object oRoom=openFireService.findRoomidByName(roomName);

        if (oRoom instanceof Integer) {
            if ((Integer)oRoom == openFireServiceImpl.ROOM_NOT_EXIST) {
                result.put("error", true);
                result.put("errorMsg", "ROOM_NOT_EXIST");
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>"+oRoom);
                return result;
            }
        }

        ofMucRoom mucroom=(ofMucRoom)oRoom;
        int roomId=mucroom.getRoomID();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>"+roomId);



        Object oResult = openFireService.getPeopleByPhoneNumAndRoomId(phoneNum, roomId);

        if (oResult instanceof Integer){
            if ((Integer) oResult == openFireServiceImpl.ROOM_ID_INVALID){
                result.put("error", true);
                result.put("errorMsg", "ROOM_ID_INVALID");
                return result;
            }

            if ((Integer) oResult == openFireServiceImpl.ROOM_NOT_EXIST){
                result.put("error", true);
                result.put("errorMsg", "ROOM_NOT_EXIST");
                return result;
            }

            if ((Integer) oResult == openFireServiceImpl.MEMBER_NOT_EXIST){
                result.put("error",true);
                result.put("errorMsg","MEMBER_NOT_EXIST");
                return result;
            }

        }
        List<ofMucMember> members = (List<ofMucMember>) oResult;
        ArrayList<String> phones = new ArrayList<String>();
        for (ofMucMember member:members){
            String split[] = member.getJid().split("@");
            phones.add(split[0]);
        }
        result.put("error", false);
        result.put("phones", phones);

        return result;
    }
}



