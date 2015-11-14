package com.OCare.controller;

import com.OCare.entity.*;
import com.OCare.service.*;
import javafx.scene.input.DataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by mark on 10/24/15.
 */
@Controller
@RequestMapping("/app/device")
public class DeviceInterfaceController {

    public static final String INPUT_NULL = "INPUT_CANNOT_NULL";

    @Autowired
    private DeviceService deviceService;
    @Autowired
    private ElderService elderService;
    @Autowired
    private VerifyService verifyService;
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addDevice(String id, String name, String communicationType, String description, String image){
        Map<String, Object> result = new HashMap<String, Object>();

        if(id == null || name == null || communicationType == null || description == null || image == null ||
                id == "" || name == "" || communicationType == "" || description == "" || image == ""){
            result.put("error", true);
            result.put("errorMsg", INPUT_NULL);
            return result;
        }

        Object oResult = deviceService.createNewDeviceWithoutElderIdAndQRCode(id, name, communicationType, description, image);

        if(oResult instanceof Integer){
            if((Integer)oResult == DeviceServiceImpl.DEVICE_ALREADY_EXIST){
                result.put("error", true);
                result.put("errorMsg", "DEVICE_ALREADY_EXIST");
                return result;
            }
        }

        result.put("error", false);
        result.put("device", oResult);

        return result;
    }

    @RequestMapping(value = "/match", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> matchDevice(String deviceId, String elderId, String QRCode){
        Map<String, Object> result = new HashMap<String, Object>();

        if(deviceId == null || elderId == null ||QRCode == null ||
                deviceId == "" || elderId == "" ||QRCode == ""){
            result.put("error", true);
            result.put("errorMsg", INPUT_NULL);
            return result;
        }

        Object oResult = deviceService.addElderIdAndQRCodeToDevice(deviceId, elderId, QRCode);

        if(oResult instanceof Integer){
            if((Integer) oResult == DeviceServiceImpl.DEVICE_NOT_EXIST){
                result.put("error", true);
                result.put("errorMsg", "DEVICE_NOT_EXIST");
                return result;
            }

            if ((Integer) oResult == DeviceServiceImpl.ELDER_NOT_EXIST){
                result.put("error", true);
                result.put("errorMsg", "ELDER_NOT_EXIST");
                return result;
            }

            if((Integer) oResult == DeviceServiceImpl.DEVICE_ALREADY_MATCH){
                result.put("error", true);
                result.put("errorMsg", "DEVICE_ALREADY_MATCH");
                return result;
            }
        }

        result.put("error", false);
        result.put("device", oResult);
        return result;
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> modifyDevice(String deviceId, String name, String communicationType, String description, String image){
        Map<String, Object> result = new HashMap<String, Object>();

        if(deviceId == null || name == null || communicationType == null || description == null || image == null||
                deviceId == "" || name == "" || communicationType == "" || description == "" || image == ""){
            result.put("error", true);
            result.put("errorMsg", INPUT_NULL);
            return result;
        }

        Object oResult = deviceService.modifyDeviceById(deviceId, name, communicationType, description, image);

        if(oResult instanceof Integer){
            if ((Integer) oResult == DeviceServiceImpl.DEVICE_NOT_EXIST){
                result.put("error", true);
                result.put("errorMsg", "DEVICE_NOT_EXIST");
                return result;
            }
        }

        result.put("error", false);
        result.put("device", oResult);
        return result;
    }

    @RequestMapping("/get/{deviceId}")
    @ResponseBody
    public Map<String, Object> getDevice(@PathVariable String deviceId){
        Map<String, Object> result = new HashMap<String, Object>();

        if(deviceId == null || deviceId.equals("")){
            result.put("error", true);
            result.put("errorMsg", INPUT_NULL);
            return result;
        }

        Device device = deviceService.getDeviceById(deviceId);
        device.setElderId("");

        if (device == null){
            result.put("error", true);
            result.put("errorMsg", "DEVICE_NOT_EXIST");
            return result;
        }

        result.put("error", false);
        result.put("device", device);
        return result;
    }

    @RequestMapping("/refresh/{deviceId}")
    @ResponseBody
    public Map<String, Object> refreshDevice(@PathVariable String deviceId){
        Map<String, Object> result = new HashMap<String, Object>();

        if(deviceId == null || deviceId.equals("")){
            result.put("error", true);
            result.put("errorMsg", INPUT_NULL);
            return result;
        }

        Device device = deviceService.refreshDeviceById(deviceId);

        if (device == null){
            result.put("error", true);
            result.put("errorMsg", "DEVICE_NOT_EXIST");
            return result;
        }

        result.put("error", false);
        result.put("device", device);
        return result;
    }

    @RequestMapping(value = "/user/elderInfo", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> userGetElderInfo(String userId, String QRCode){
        Map<String, Object> result = new HashMap<String, Object>();

        if(userId == null || QRCode == null || userId.equals("") || QRCode.equals("")){
            result.put("error", true);
            result.put("errorMsg", INPUT_NULL);
            return result;
        }

        String elderId = deviceService.getElderIdByQRCode(QRCode);

        if (elderId == null){
            result.put("error", true);
            result.put("errorMsg", "QRCODE_NOT_EXIST");
            return result;
        }

        Elder elder = elderService.getElderById(elderId);//elder exist for sure

        result.put("error", false);
        result.put("elderName", elder.getName());
        result.put("elderPhone", elder.getPhone());
        result.put("elderAddress", elder.getAddress());

        ArrayList<Relative> relatives = verifyService.getMonitorsByElderId(elderId);

        if (relatives == null){
            result.put("elderRelatives", "NO_ELDER_MONITORS");
        }else{
            ArrayList<String> monitorPhone = new ArrayList<String>();
            for (Relative relative  : relatives){
                monitorPhone.add(relative.getPhone());
            }
            result.put("elderRelativesPhones", monitorPhone);
        }

        return result;
    }

    @RequestMapping(value = "/employee/elderInfo", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> employeeGetElderInfo(String employeeId, String QRCode){
        Map<String, Object> result = new HashMap<String, Object>();

        if(employeeId == null || QRCode == null || employeeId.equals("") || QRCode.equals("")){
            result.put("error", true);
            result.put("errorMsg", INPUT_NULL);
            return result;
        }

        Employee employee = employeeService.getEmployeeById(employeeId);

        if(employee == null){
            result.put("error", true);
            result.put("errorMsg", "EMPLOYEE_NOT_EXIST");
            return result;
        }

        String elderId = deviceService.getElderIdByQRCode(QRCode);

        if (elderId == null){
            result.put("error", true);
            result.put("errorMsg", "QRCODE_NOT_EXIST");
            return result;
        }

        Elder elder = elderService.getElderById(elderId);

        result.put("error", false);
        result.put("elder", elder);

        ArrayList<Relative> relatives = verifyService.getMonitorsByElderId(elderId);

        if (relatives == null){
            result.put("elderRelatives", "NO_ELDER_MONITORS");
        }else{
            result.put("elderRelatives", relatives);
        }

        return result;
    }

    @RequestMapping("/QRCode")
    @ResponseBody
    public Map<String, Object> getQRCode(){
        Map<String, Object> result = new HashMap<String, Object>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String time = dateFormat.format(new Date());
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String strUUID = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
        result.put("QRCode",time + strUUID);
        return result;
    }
}
