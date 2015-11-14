package com.OCare.controller;

import com.OCare.entity.*;
import com.OCare.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by mark on 8/2/15.
 */
@Controller
@RequestMapping("/app")
public class InterfaceController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private RegisterService registerService;
    @Autowired
    private VerifyService verifyService;
    @Autowired
    private SMSService smsService;
    @Autowired
    private ElderService elderService;
    @Autowired
    private RelativeService relativeService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ContractService contractService;
    @Autowired
    private ElderConditionService elderConditionService;

    /**
     * @param phoneNum：Phone number
     * @param password：Password
     * @return
     * Error: true, ErrorMsg
     * Error: false, Account type, Account detail
     */
    @RequestMapping(value = "/logon")
    @ResponseBody
    public Map<String, Object> logon(String phoneNum, String password){
        Map<String, Object> result = new HashMap<String, Object>();

        if(phoneNum == null || password == null || phoneNum == "" || password == ""){
            result.put("error", true);
            result.put("errorMsg", "PhoneNum or password is empty");
            return result;
        }else{
            String status = accountService.logon(phoneNum, password).getKey();
            if(status == "Invalid Account"){
                result.put("error", true);
                result.put("errorMsg", "Invalid Account");
                return result;
            }else if (status == "Incorrect password"){
                result.put("error", true);
                result.put("errorMsg", "Incorrect password");
                return result;
            }else{
                result.put("error", false);
                result.put("accountType", status);
                result.put("account", accountService.logon(phoneNum, password).getValue());
                return result;
            }
        }
    }

    /**
     * @param elderId: Elder CitizenId
     * @param companyId: Company Id
     * @param elderName: Elder Name
     * @param elderPhone: Elder Phone number
     * @param elderAddress: Elder address
     * @param elderPassword: Elder Password
     * @param elderImage: Elder Image
     * @return
     * Error: false, account detail
     */
    @RequestMapping(value = "/register/elder")
    @ResponseBody
    public Map<String, Object> elderRegister(String elderId, int companyId, String elderName,
                                             String elderPhone, String elderAddress,
                                             String elderPassword, String elderImage){
        Map<String, Object> result = new HashMap<String, Object>();

        //身份证或者手机号已经注册
        if (!isIdOrPhoneNumExist(elderId,elderPhone))
        {
            result.put("error",true);
            result.put("errorMsg","Id or phoneNum exists");
            return result;
        }
        //身份证或者手机号未被注册
        Elder elder = registerService.registerForAnElder(elderId, companyId, elderName, elderPhone, elderAddress, elderPassword, elderImage);
        System.out.println(isIdOrPhoneNumExist(elderId,elderPhone));
        result.put("error", false);
        result.put("account", elder);
        return result;
    }

    /**
     * @param relativeId: relative citizen_id
     * @param relativeName: relative name
     * @param relativePhone: relative phone number
     * @param relativeAddress: relative address
     * @param relativePassword: relative password
     * @param relativeImage: relative image
     * @return
     * Error: false, account detail
     */
    @RequestMapping(value = "/register/relative")
    @ResponseBody
    public Map<String, Object> relativeRegister(String relativeId, String relativeName,
                                                String relativePhone, String relativeAddress,
                                                String relativePassword, String relativeImage){
        Map<String, Object> result = new HashMap<String, Object>();
        //身份证或者手机号已经注册
        if (!isIdOrPhoneNumExist(relativeId,relativePhone))
        {
            result.put("error",true);
            result.put("errorMsg","Id or phoneNum exists");
            return result;
        }
        //身份证或者手机号未被注册
        Relative relative = registerService.registerForARelative(relativeId, relativeName, relativePhone, relativeAddress, relativePassword, relativeImage);
        result.put("error", false);
        result.put("account", relative);
        return result;
    }

    /**
     * @param volunteerId: volunteer citizenId
     * @param volunteerName: volunteer name
     * @param volunteerPhone: volunteer phone number
     * @param volunteerAddress: volunteer address
     * @param volunteerEmail: volunteer email
     * @param volunteerCompanyId: volunteer's companyId
     * @param volunteerPassword: volunteer password
     * @param volunteerImage: volunteer image
     * @return
     * Error: false, account detail
     */
    @RequestMapping(value = "/register/volunteer")
    @ResponseBody
    public Map<String, Object> volunteerRegister(String volunteerId, String volunteerName, String volunteerPhone,
                                                 String volunteerAddress, String volunteerEmail,
                                                 int volunteerCompanyId, String volunteerPassword, String volunteerImage){
        Map<String, Object> result = new HashMap<String, Object>();

        //身份证或者手机号已经注册
        if (!isIdOrPhoneNumExist(volunteerId,volunteerPhone))
        {
            result.put("error",true);
            result.put("errorMsg","Id or phoneNum exists");
            return result;
        }
        //身份证或者手机号未被注册
        Volunteer volunteer = registerService.registerForAVolunteer(volunteerId, volunteerName, volunteerPhone, volunteerAddress, volunteerEmail, volunteerCompanyId, volunteerPassword, volunteerImage);
        result.put("error", false);
        result.put("account", volunteer);
        return result;
    }

    /**
     * @param lpId: legal person citizenId
     * @param lpName: legal person name
     * @param lpPhone: legal person phone number
     * @param lpEmail: legal person email
     * @param lpPassword: legal person password
     * @param lpImage: lega person image
     * @return
     * Error: false, account detail
     */
    @RequestMapping(value = "/register/legalperson")
    @ResponseBody
    public Map<String, Object> legalPersonRegister(String lpId, String lpName, String lpPhone,
                                                   String lpEmail, String lpPassword, String lpImage){
        Map<String, Object> result = new HashMap<String, Object>();
        //身份证或者手机号已经注册
        if (!isIdOrPhoneNumExist(lpId,lpPhone))
        {
            result.put("error",true);
            result.put("errorMsg","Id or phoneNum exists");
            return result;
        }
        //身份证或者手机号未被注册
        LegalPerson legalPerson = registerService.registerForALegalPerson(lpId, lpName, lpPhone, lpEmail, lpPassword, lpImage);
        result.put("error", false);
        result.put("account", legalPerson);
        return result;
    }

    /**
     * @param relativeId: relative citizenId
     * @param elderId: elder citizenId
     * @param togetherImg: together image
     * @return
     * Error: false,
     */
    @RequestMapping(value = "/apply/monitor")
    @ResponseBody
    public Map<String, Object> applyMonitor(String relativeId, String elderId, String togetherImg){
        Map<String, Object> result = new HashMap<String, Object>();
        verifyService.submitMonitorApply(relativeId, elderId, togetherImg);
        result.put("error", false);
        return result;
    }

    /**
     * @param relativeId: relativeId
     * @return
     * Error: true, ErrorMsg
     * Error:false, monitor detail
     */
    @RequestMapping(value = "/status/monitor")
    @ResponseBody
    public Map<String, Object> checkMonitor(String relativeId){
        Map<String, Object> result = new HashMap<String, Object>();
        List<ElderMonitor> list = verifyService.monitorStatus(relativeId);
        if (list.size() == 0){
            result.put("error", true);
            result.put("errorMsg", "Invalid relativeId Or no related information.");
        }else{
            result.put("error", false);
            result.put("result", list);
        }
        return result;
    }

    /**
     * @param phoneNum: phone number
     * @return
     * Error: false, code
     */
    @RequestMapping(value = "/code")
    @ResponseBody
    public Map<String, Object> createCode(String phoneNum){
        Map<String, Object> result = new HashMap<String, Object>();
        int code = smsService.sendVerifyCodeToPhone(phoneNum);
        result.put("error", false);
        result.put("code", code);
        return result;
    }

    /**
     * @param id: citizenId
     * @param phoneNum: phone number
     * @return
     * Error: true, ErrorMsg
     * Error:false, account type
     */
    @RequestMapping(value = "/verify/phone")
    @ResponseBody
    public Map<String, Object> verifyPhoneNum(String id, String phoneNum){
        Map<String, Object> result = new HashMap<String, Object>();
        String status = accountService.verifyPhoneNum(id, phoneNum);
        if(status == "Incorrect phone number") {
            result.put("error", true);
            result.put("errorMsg", "Incorrect phone number");
            return result;
        }else if (status == "Invalid Account"){
            result.put("error", true);
            result.put("errorMsg", "Invalid Account");
            return result;
        }else{
            result.put("error", false);
            result.put("type", status);
            return result;
        }
    }

    /**
     * @param id: citizenId
     * @param password: new password
     * @return
     * Error: true, ErrorMsg
     * Error: false
     */
    @RequestMapping(value = "/changepassword")
    @ResponseBody
    public Map<String, Object> changePassword(String id, String password){
        Map<String, Object> result = new HashMap<String, Object>();
        String status = accountService.changePassword(id, password);
        if(status == "Invalid Account"){
            result.put("error", true);
            result.put("errorMsg", "Invalid Account");
            return result;
        }else{
            result.put("error", false);
            return result;
        }

    }

    public boolean isIdOrPhoneNumExist(String id, String phoneNum) {
        boolean flag = true;
        ArrayList<Elder> elders = registerService.getAllElders();
        ArrayList<Relative> relatives = registerService.getAllRelatives();
        ArrayList<Volunteer> volunteers = registerService.getAllVolunteers();
        ArrayList<LegalPerson> legalPersons = registerService.getAllLegalPerson();

        Iterator<Elder> elderIterator = elders.iterator();
        Iterator<Relative> relativeIterator = relatives.iterator();
        Iterator<Volunteer> volunteerIterator = volunteers.iterator();
        Iterator<LegalPerson> legalPersonIterator = legalPersons.iterator();

        while (elderIterator.hasNext())
        {
            Elder elder = elderIterator.next();
            if (elder.getId().equals(id)||elder.getPhone().equals(phoneNum))
            {
                flag = false;
            }
        }
        while (relativeIterator.hasNext())
        {
            Relative relative = relativeIterator.next();
            if (relative.getId().equals(id) || relative.getPhone().equals(phoneNum))
            {
                flag = false;
            }
        }
        while (volunteerIterator.hasNext())
        {
            Volunteer volunteer = volunteerIterator.next();
            if (volunteer.getId().equals(id) || volunteer.getPhone().equals(phoneNum))
            {
                flag = false;
            }
        }
        while (legalPersonIterator.hasNext())
        {
            LegalPerson legalPerson  = legalPersonIterator.next();
            if (legalPerson.getId().equals(id) || legalPerson.getPhone().equals(phoneNum))
            {
                flag = false;
            }
        }

        return flag;
    }

    /*
        功能：根据phoneNum拿到头像
     */
    @RequestMapping(value = "/getImageByPhoneNum")
    @ResponseBody
    public Map<String,Object> getImageByPhoneNum(String phoneNum)
    {
        Map<String , Object>result = new HashMap<String, Object>();
        //传参错误
        if (phoneNum == null || phoneNum == "null")
        {
            result.put("error",true);
            result.put("errorMsg","Phone Number is valid!");
        }else {
            String status = accountService.getImageByPhoneNum(phoneNum).getKey();
            if (status == "get image successfully.")
            {
                result.put("error",false);
                result.put("image",accountService.getImageByPhoneNum(phoneNum).getValue());
            }else if (status == "PhoneNum does not match to any account!")
            {
                result.put("error",true);
                result.put("errorMsg","PhoneNum does not match to any account!");
            }
        }
        return result;
    }

    /*
        功能：根据phoneNum修改头像为newImage
     */
    @RequestMapping("/setNewImageByPhoneNum")
    @ResponseBody
    public Map<String,Object>setNewImageByPhoneNum(String phoneNum, String newImage)
    {
        Map<String, Object>result = new HashMap<String, Object>();
        //传参数错误
        if (phoneNum == null || phoneNum == "" || newImage == null || newImage == "")
        {
            result.put("error",true);
            result.put("errorMsg","Phone Number is valid Or new Image is valid!");
        }else {
            boolean flag = accountService.isChangeImageSucc(phoneNum, newImage);
            if (flag == true)
            {
                result.put("error",false);
            }else
            {
                result.put("error",true);
                result.put("errorMsg","Change Image not Successfully!");
            }
        }
        return result;
    }

    /*
        功能：修改某个人和老人的关系为新的type
     */
    @RequestMapping("/changeRelation")
    @ResponseBody
    public Map<String,Object> changeRelationBetweenElderAndSomebody(String elderId,String sbPhoneNum,int newRelationType)
    {
        Map<String, Object> result = new HashMap<String, Object>();
        if (sbPhoneNum == null || sbPhoneNum == "")
        {
            result.put("error",true);
            result.put("errorMsg","Phone Number is valid Or new Image is valid!");
        }else {
            boolean flag = verifyService.changeRelationBetweenElderAndSomebody(elderId, sbPhoneNum, newRelationType);
            if (flag == false)
            {
                result.put("error",true);
                result.put("errorMsg","Change Relation Failed.");
            }else {
                result.put("error",false);
            }

        }
        return result;
    }

    /*
        功能：监护人负责删除某个人和老人的关系（设type为7）
     */
    @RequestMapping("/deleteRelation")
    @ResponseBody
    public Map<String,Object> deleteRelationBetweenElderAndSomebody(String elderId, String sbPhoneNum)
    {
        Map<String, Object> result = new HashMap<String, Object>();
        if (sbPhoneNum == null || sbPhoneNum == "")
        {
            result.put("error",true);
            result.put("errorMsg","Delete Relation Failed.");
        }else {
            boolean flag = verifyService.deleteRelationBetweenElderAndSomebody(elderId, sbPhoneNum);
            if (flag == false)
            {
                result.put("error",true);
                result.put("errorMsg","Delete Relation Failed.");
            }else {
                result.put("error",false);
            }
        }
        return result;
    }

    /*
        功能：通过身份证拿到某个老人的全部信息，即实体集
     */
    @RequestMapping("/getElderInfo")
    @ResponseBody
    public Map<String,Object> getElderInfoById(String elderId)
    {
        Map<String, Object> result = new HashMap<String, Object>();
        if (elderId == null || elderId == "")
        {
            result.put("error",true);
            result.put("errorMsg","Elder Id Input Error!");
        }else {
            Elder elder = elderService.getElderById(elderId);
            if (elder == null)
            {
                result.put("error",true);
                result.put("errorMsg","Get Entity Error!");
            } else {
                result.put("error",false);
                result.put("elderEntity",elder);
            }
        }
        return result;
    }

    /*
        功能：通过身份证拿到某个relative的全部信息，即实体集
     */
    @RequestMapping("/getRelativeInfo")
    @ResponseBody
    public Map<String,Object> getRelativeInfoById(String relativeId)
    {
        Map<String, Object> result = new HashMap<String, Object>();
        if (relativeId == null || relativeId == "")
        {
            result.put("error",true);
            result.put("errorMsg","Relative Id Input Error!");
        }else {
            Relative relative = relativeService.getRelativeById(relativeId);
            if (relative == null)
            {
                result.put("error",true);
                result.put("errorMsg","Get Entity Error!");
            }else {
                result.put("error",false);
                result.put("relativeEntity",relative);
            }
        }
        return result;
    }

    /*
        功能：通过老人Id拿到所有的监护人的list
     */
    @RequestMapping("/getMonitorsByElderId")
    @ResponseBody
    public Map<String ,Object> getMonitorsByElderId(String elderId)
    {
        Map<String ,Object> result = new HashMap<String, Object>();
        if (elderId == null || elderId == "")
        {
            result.put("error",true);
            result.put("errorMsg","Elder Id Input Error!");
        }else {
            ArrayList<Relative> relatives = elderService.getAllMonitorsByElderId(elderId);
            if (relatives == null)
            {
                result.put("error",true);
                result.put("errorMsg","Get List Error!");
            }else {
                result.put("error",false);
                result.put("monitorList",relatives);
            }
        }
        return result;
    }

    @RequestMapping("/getAllElders")
    @ResponseBody
    public Map<String, Object> getAllElders()
    {
        Map<String, Object> result = new HashMap<String, Object>();
        ArrayList<Elder> allElders = elderService.getAllElders();
        if (allElders.size() == 0)
        {
            result.put("error",true);
            result.put("errorMsg","没有老人的数据");
        }else {
            result.put("error",false);
            result.put("result",allElders);
        }
        return result;
    }


    /*
        功能：注册公司机构
        注意：注册机构分为两个步骤，先有法人代表才能注册公司
     */
    @RequestMapping("/company/register")
    @ResponseBody
    public Map<String, Object> companyRegister(String companyName, String companyLegalPersonId,
                                               String companyPhone, String companyAddress)
    {
        Map<String, Object> result = new HashMap<String, Object>();
        if (companyName == null || companyAddress == null || companyPhone == null || companyLegalPersonId == null)
        {
            result.put("error",true);
            result.put("errorMsg","Something is empty!");
        }else if(!registerService.isLegalPersonIdExist(companyLegalPersonId)) {
            result.put("error",true);
            result.put("errorMsg","Legal Person not exsits");
        }else {
            Company companyToRegister =  registerService.registerForCompany(companyName, companyLegalPersonId, companyPhone, companyAddress);
            result.put("error",false);
            result.put("account",companyToRegister);
        }
        return result;
    }

    /*
        功能：通过身份证号删除员工
        参数：身份证
     */
    @RequestMapping("/employee/delete")
    @ResponseBody
    public Map<String, Object> deleteEmployeeById(String id)
    {
        Map<String, Object> result = new HashMap<String, Object>();
        if (id == null || id == "")
        {
            result.put("error",true);
            result.put("errorMsg","Input phoneNum is null");
        }else {
            String flag = employeeService.deleteEmployeeById(id);
            if (flag == "success")
                result.put("error",false);
            else {
                result.put("error",true);
                result.put("errorMsg","Can not find such employee!");
            }
        }
        return result;
    }

    /*
        功能：更新员工信息
     */
    @RequestMapping("/employee/updateById")
    @ResponseBody
    public Map<String, Object> updateEmployeeInfoById(String id, String newName, String newPhone, String newAddress,
                                                      String newDepartment, String newPosition, int newStatus,
                                                      String newPassword, String newImage, String newSuperiot,
                                                      String newWorkExperience, String newWorkDetail)
    {
        Map<String, Object> result = new HashMap<String, Object>();
        boolean flag = employeeService.changeEmployeeInfoById(id,newName,newPhone,newAddress,newDepartment,newPosition,
                newStatus,newPassword,newImage,newSuperiot,newWorkExperience,newWorkDetail);
        if (flag == false)
        {
            result.put("error",true);
            result.put("errorMsg","failed to update the employee's info!");
        }else {
            result.put("error",false);
        }
        return result;
    }

    /*
        功能：显示老人有效合同的状况
        返回：Contract实例
     */
    @RequestMapping("/contract/showContractInServiceByElderId")
    @ResponseBody
    public Map<String, Object> showContractInServiceByElderId(String elderId)
    {
        Map<String ,Object> result = new HashMap<String, Object>();
        if (elderId == null || elderId == "")
        {
            result.put("error",true);
            result.put("errorMsg","input elder id is invalid");
        }else {
            result.put("error",false);
            result.put("contract",contractService.getElderContractInfoByElderId(elderId));
            result.put("contractStatus",contractService.getElderContractInfoByElderId(elderId).getStatus());
        }

        return result;
    }

    /*------------------2015.10.12------------------*/

    /*
        功能：通过老人身份证拿到老人最近一次的位置信息
        返回：经纬度坐标数组
     */
    @RequestMapping("/map/getElderPresentLocationById")
    @ResponseBody
    public Map<String, Object> getElderPresentLocationById(String elderId)
    {
        Map<String ,Object> result = new HashMap<String, Object>();
        if (elderId == null || elderId == "")
        {
            result.put("error",true);
            result.put("errorMsg","input elder id is invalid");
        }else  {
            ElderCondition presentElderCondition = elderConditionService.getElderPresentConditionById(elderId);
            if (presentElderCondition == null){
                result.put("error",true);
                result.put("errorMsg","No related info about this elder!");
                return result;
            }
            double latitude = presentElderCondition.getLatitude(),longtitude = presentElderCondition.getLongtitude();
            result.put("error",false);
            result.put("latitude",latitude);
            result.put("longtitude",longtitude);
        }

        return result;
    }

    /*
        功能：返回数据库所有老人和对应的所有监护人的集合
        返回值：
     */

    @RequestMapping("/getAllElderRelatedInfo")
    @ResponseBody
    public Map<String, Object> getAllElderRelatedInfo() {
        Map<String, Object> result = new HashMap<String, Object>();
        //get all elder entites
        ArrayList<Elder> elders  = elderService.getAllElders();

        //the list of result information together
        ArrayList<HashMap<String, Object>> elderInfo = new ArrayList<HashMap<String, Object>>();

        if (elders.size() == 0){
            result.put("error", true);
            result.put("errorMsg", "There is no elders in database");
            return result;
        }

        for (Elder elder : elders){
            //the current elder information
            HashMap<String, Object> tempElderInfo = new HashMap<String, Object>();
            //elder info
            tempElderInfo.put("elder", elder);
            //relative info
            tempElderInfo.put("relatives", verifyService.getMonitorsByElderId(elder.getId()));
            //add to list
            elderInfo.add(tempElderInfo);
        }

        result.put("error", false);
        result.put("info", elderInfo);

        return result;
    }

    /*
        功能：返回所有老人的当前（最后一次）位置信息
        返回值
     */
    @RequestMapping("map/allEldersPresentLocationInfo")
    @ResponseBody
    public Map<String, Object> allEldersPresentLocationInfo() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("error",false);
        ArrayList<ElderCondition> allEldersPresentLocationInfo = elderConditionService.getAllEldersPresentCondition();
        result.put("result",allEldersPresentLocationInfo);
        result.put("resultNum",allEldersPresentLocationInfo.size());
        return result;
    }

    /*
        功能：根据手机号找老人（所有老人，可能多个）mark
        返回值
     */

    @RequestMapping("/elder/phone/{phoneNum}")
    @ResponseBody
    public Map<String, Object> getEldersByPhoneNum(@PathVariable String phoneNum){
        Map<String, Object> result = new HashMap<String, Object>();

        if(phoneNum == null || phoneNum.equals("")){
            result.put("error", true);
            result.put("errorMsg", "INPUT_CANNOT_NULL");
            return result;
        }

        List<Elder> elders = elderService.getEldersByPhoneNum(phoneNum);

        if(elders == null || elders.size() == 0){
            result.put("error", true);
            result.put("errorMsg", "ELDER_NOT_EXIST");
            return result;
        }

        result.put("error", false);
        result.put("elder", elders);
        return result;
    }

    @RequestMapping("/getElderInfoByPhone/{relativePhoneNum}/{elderPhoneNum}")
    @ResponseBody
    public Map<String, Object> findElderWithRelativePhoneNumAndElderPhoneNum(@PathVariable String relativePhoneNum, @PathVariable String elderPhoneNum){
        Map<String, Object> result = new HashMap<String, Object>();

        if(relativePhoneNum == null || elderPhoneNum == null || relativePhoneNum.equals("") || elderPhoneNum.equals("")){
            System.out.println(relativePhoneNum+" "+elderPhoneNum);
            result.put("error", true);
            result.put("errorMsg", "INPUT_CANNOT_NULL");
            return result;
        }

        Relative relative = relativeService.getRelativeByPhoneNum(relativePhoneNum);
        //没有SQL注入直接利用其他接口返回值获取
        List<Elder> elders = elderService.getEldersByPhoneNum(elderPhoneNum);

        if(relative == null){
            result.put("error", true);
            result.put("errorMsg","RELATIVE_NOT_EXIST");
            return result;
        }

        if(elders == null || elders.size() == 0){
            result.put("error", true);
            result.put("errorMsg","ELDER_NOT_EXIST");
            return result;
        }

        Elder elder = elders.get(0);

        String relativeId = relative.getId();
        ArrayList<Elder> listElders = verifyService.getAllEldersByMonitorId(relativeId);

        int iFlag = 0;

        for (Elder tempElder: listElders){
            if (tempElder.getId() == elder.getId()){
                iFlag = 1;
                break;
            }
        }

        if(iFlag == 0){
            result.put("error", true);
            result.put("errorMsg", "RELATIVE_AND_ELDER_NOT_MATCH");
            return result;
        }

        result.put("error", false);
        result.put("elder", elder);
        return result;
    }

    /*
        功能：列出所有老人的合同情况和监护人
        参数：无
        返回：每个老人的合同和所有监护人
     */
    @RequestMapping("/contract/listAllEldersContractAndMonitors")
    @ResponseBody
    public Map<String,Object> listAllEldersContractAndMonitors() {
        Map<String, Object> result = new HashMap<String, Object>();


        //get all elder contract from contract entity
        ArrayList<Contract> contracts  = (ArrayList<Contract>) contractService.getAllContracts();

        //the list of result information together
        ArrayList<HashMap<String, Object>> contractInfo = new ArrayList<HashMap<String, Object>>();

        if (contracts.size() == 0){
            result.put("error", true);
            result.put("errorMsg", "There is no contract available");
            return result;
        }

        for (Contract contract : contracts){
            //the current elder information
            HashMap<String, Object> tempElderInfo = new HashMap<String, Object>();
            //elder info
            tempElderInfo.put("elderContract", contract);
            //relative info
            tempElderInfo.put("monitors", verifyService.getMonitorsByElderId(contract.getElder_id()));
            //elder name
            tempElderInfo.put("elderName",elderService.getElderById(contract.getElder_id()).getName());
            //add to list
            contractInfo.add(tempElderInfo);
        }

        result.put("error", false);
        result.put("info", contractInfo);

        return result;
    }

    /*
        功能：同上
        注意：返回给于子涵
     */
    @RequestMapping("/contract/listAllEldersContractAndMonitorsYu")
    @ResponseBody
    public ArrayList<HashMap<String, Object>> listAllEldersContractAndMonitorsYu() {
        ArrayList<HashMap<String, Object>> relatives = new ArrayList<HashMap<String, Object>>();
        //get all elder contract from contract entity
        ArrayList<Contract> contracts  = (ArrayList<Contract>) contractService.getAllContracts();

        //the list of result information together
        ArrayList<HashMap<String, Object>> contractInfo = new ArrayList<HashMap<String, Object>>();


        for (Contract contract : contracts){
            //the current elder information
            HashMap<String, Object> tempElderInfo = new HashMap<String, Object>();

            Elder tempElder = elderService.getElderById(contract.getElder_id());
            tempElderInfo.put("contract_id",contract.getId());
            tempElderInfo.put("old_name",tempElder.getName());
            tempElderInfo.put("old_id",contract.getElder_id());
            tempElderInfo.put("execution",contract.getStatus());
            tempElderInfo.put("date",contract.getStart_time());
            tempElderInfo.put("service","special service");
            tempElderInfo.put("payment","payed");

            ArrayList<Relative> tempMonitos = verifyService.getMonitorsByElderId(contract.getElder_id());

            for (int i=0; i<2; i++){
                if (tempMonitos.size()!=0 && tempMonitos.size() > i){
                    String tempStr1 = "keeper" + Integer.toString(i+1) +"_name";
                    tempElderInfo.put(tempStr1,tempMonitos.get(i).getName());
                    String tempStr2 = "keeper" + Integer.toString(i+1) +"_id";
                    tempElderInfo.put(tempStr2,verifyService.getMonitorsByElderId(contract.getElder_id()).get(i).getId());
                }
            }
            //add to list
            System.out.println(tempElderInfo.toString());
            contractInfo.add(tempElderInfo);
        }
        System.out.println(contractInfo.toString());
        relatives = contractInfo;
        return relatives;
    }

    /*
        功能：列出某个老人的合同情况和监护人
        参数：身份证号码
        返回：这个老人的合同和所有监护人
     */
    @RequestMapping("/contract/listOneElderContractAndMonitors")
    @ResponseBody
    public Map<String,Object> listOneElderContractAndMonitors(String elderId) {
        Map<String, Object> result = new HashMap<String, Object>();


        //get the elder contract from contract entity
        ArrayList<Contract> contracts  = (ArrayList<Contract>) contractService.getContractsByElderId(elderId);

        //the list of result information together
        ArrayList<HashMap<String, Object>> contractInfo = new ArrayList<HashMap<String, Object>>();

        if (contracts.size() == 0){
            result.put("error", true);
            result.put("errorMsg", "There is no contract available");
            return result;
        }

        for (Contract contract : contracts){
            //the current elder information
            HashMap<String, Object> tempElderInfo = new HashMap<String, Object>();
            //elder info
            tempElderInfo.put("elderContract", contract);
            //relative info
            tempElderInfo.put("monitors", verifyService.getMonitorsByElderId(contract.getElder_id()));
            //elder name
            tempElderInfo.put("elderName",elderService.getElderById(contract.getElder_id()).getName());
            //add to list
            contractInfo.add(tempElderInfo);
        }

        result.put("error", false);
        result.put("info", contractInfo);

        return result;
    }

    /*
       功能：列出某个老人的合同情况和监护人
       参数：身份证号码
       返回：这个老人的合同和所有监护人
    */
    @RequestMapping("contract/listOneContractAndMonitorsByContractId")
    @ResponseBody
    public Map<String,Object> listOneContractAndMonitorsByContractId(int contractId) {
        Map<String, Object> result = new HashMap<String, Object>();


        //get the elder contract from contract entity
        Contract contract = contractService.getContractsById(contractId);
        //the list of result information together
        ArrayList<HashMap<String, Object>> contractInfo = new ArrayList<HashMap<String, Object>>();

        if (contract == null){
            result.put("error", true);
            result.put("errorMsg", "There is no contract available");
            return result;
        }

        //the current elder information
        HashMap<String, Object> tempElderInfo = new HashMap<String, Object>();
        //elder info
        tempElderInfo.put("elderContract", contract);
        //relative info
        tempElderInfo.put("monitors", verifyService.getMonitorsByElderId(contract.getElder_id()));
        //elder name
        tempElderInfo.put("elderName",elderService.getElderById(contract.getElder_id()).getName());
        //add to list
        contractInfo.add(tempElderInfo);

        result.put("error", false);
        result.put("info", contractInfo);

        return result;
    }

    /*
       功能：列出某个老人的合同情况和监护人
       参数：身份证号码
       返回：这个老人的合同和所有监护人
    */
    @RequestMapping("contract/listOneContractAndMonitorsByMonitorId")
    @ResponseBody
    public Map<String,Object> listOneContractAndMonitorsByMonitorId(String monitorId) {
        Map<String, Object> result = new HashMap<String, Object>();

        //get the elder by monitor Id
        ArrayList<Elder> elders = verifyService.getAllEldersByMonitorId(monitorId);


        ArrayList<HashMap<String, Object>> allContractInfo = new ArrayList<HashMap<String, Object>>();

        if (elders.size() == 0){
            result.put("error", true);
            result.put("errorMsg", "There is no related elder of this monitor available");
            return result;
        }
        for (Elder elder: elders){
            //get the elder contract from contract entity
            ArrayList<Contract> contracts  = (ArrayList<Contract>) contractService.getContractsByElderId(elder.getId());

            if (contracts.size() != 0){
                for (Contract contract : contracts){
                    //the current elder information
                    HashMap<String, Object> tempElderInfo = new HashMap<String, Object>();
                    //elder info
                    tempElderInfo.put("elderContract", contract);
                    //relative info
                    tempElderInfo.put("monitors", verifyService.getMonitorsByElderId(contract.getElder_id()));
                    //elder name
                    tempElderInfo.put("elderName",elderService.getElderById(contract.getElder_id()).getName());
                    //add to list
                    allContractInfo.add(tempElderInfo);
                }
            }
        }
        if (allContractInfo.size()==0) {
            result.put("error", true);
            result.put("errorMsg", "There is no contract available");
        }else {
            result.put("error", false);
            result.put("info", allContractInfo);
        }
        return result;
    }

    /*
       功能：根据老人姓名列出所有符合条件的老人的合同信息和监护人
       参数：老人姓名
       返回：这个老人的合同和所有监护人
    */
    @RequestMapping("contract/listOneContractAndMonitorsByElderName")
    @ResponseBody
    public Map<String,Object> listOneContractAndMonitorsByElderName(String elderName) {
        Map<String, Object> result = new HashMap<String, Object>();

        //the list of result information together
        ArrayList<HashMap<String, Object>> contractInfo = new ArrayList<HashMap<String, Object>>();

        //get the elders with the given name
        ArrayList<Elder> elders = elderService.getAllEldersByElderName(elderName);

        for (Elder elder : elders) {
            //get the elder contract from contract entity
            ArrayList<Contract> contracts  = (ArrayList<Contract>) contractService.getContractsByElderId(elder.getId());
            if (contracts.size() != 0) {
                for (Contract contract : contracts){
                    //the current elder information
                    HashMap<String, Object> tempElderInfo = new HashMap<String, Object>();
                    //elder info
                    tempElderInfo.put("elderContract", contract);
                    //relative info
                    tempElderInfo.put("monitors", verifyService.getMonitorsByElderId(contract.getElder_id()));
                    //elder name
                    tempElderInfo.put("elderName",elderService.getElderById(contract.getElder_id()).getName());
                    //add to list
                    contractInfo.add(tempElderInfo);
                }
            }
        }
        if (contractInfo.size() == 0 ){
            result.put("error",false);
            result.put("errorMsg","There is no related elder contract of this elder name");
        }else {
            result.put("error", false);
            result.put("info", contractInfo);
        }
        return result;
    }

    /*
       功能：根据老人姓名列出所有符合条件的老人的合同信息和监护人
       参数：老人姓名
       返回：这个老人的合同和所有监护人
    */
    @RequestMapping("contract/listOneContractAndMonitorsByMonitorName")
    @ResponseBody
    public Map<String,Object> listOneContractAndMonitorsByMonitorName(String monitorName) {
        Map<String, Object> result = new HashMap<String, Object>();

        //the list of result information together
        ArrayList<HashMap<String, Object>> contractInfo = new ArrayList<HashMap<String, Object>>();

        //get the monitors with the given name
        ArrayList<Relative> monitors = verifyService.getAllMonitorsByName(monitorName);

        if (monitors == null) {
            result.put("error",true);
            result.put("errorMsg","No related info about this monitor name");
            return result;
        }
        //get the elders of the selected monitors
        ArrayList<Elder> elders = new ArrayList<Elder>();

        for (Relative relative: monitors) {
            ArrayList<Elder> tempElders = verifyService.getAllEldersByMonitorId(relative.getId());
            for (int i = 0; i<tempElders.size(); i++) {
                elders.add(tempElders.get(i));
            }
        }

        if (elders.size() == 0){
            result.put("error",true);
            result.put("errorMsg","No related info about this monitor name");
            return result;
        }

        for (Elder elder : elders) {
            System.out.println(elder.getName());
            //get the elder contract from contract entity
            ArrayList<Contract> contracts  = (ArrayList<Contract>) contractService.getContractsByElderId(elder.getId());
            if (contracts.size() != 0) {
                for (Contract contract : contracts){
                    //the current elder information
                    HashMap<String, Object> tempElderInfo = new HashMap<String, Object>();
                    //elder info
                    tempElderInfo.put("elderContract", contract);
                    //relative info
                    tempElderInfo.put("monitors", verifyService.getMonitorsByElderId(contract.getElder_id()));
                    //elder name
                    tempElderInfo.put("elderName",elderService.getElderById(contract.getElder_id()).getName());
                    //add to list
                    contractInfo.add(tempElderInfo);
                }
            }
        }
        if (contractInfo.size() == 0 ){
            result.put("error",false);
            result.put("errorMsg","No related info about this monitor name");

        }else {
            result.put("error", false);
            result.put("info", contractInfo);
        }
        return result;
    }



}
