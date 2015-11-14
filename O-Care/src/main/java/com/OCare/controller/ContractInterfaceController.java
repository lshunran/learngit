package com.OCare.controller;

import com.OCare.entity.Contract;
import com.OCare.entity.ElderCondition;
import com.OCare.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mark on 8/6/15.
 */
//test branch
@Controller
@RequestMapping("/app")
public class ContractInterfaceController {

    @Autowired
    private ContractService contractService;

    @ResponseBody
    @RequestMapping("/contract/all")
    public Map<String, Object> getAllContract(){
        Map<String, Object> result = new HashMap<String, Object>();

        List<Contract> list = contractService.getAllContracts();

        if(list == null || list.size() == 0){
            result.put("error", true);
            result.put("errorMsg", "No contracts");
            return result;
        }

        result.put("error", false);
        result.put("contracts", list);
        return result;
    }

    @ResponseBody
    @RequestMapping("/contract/id")
    public Map<String, Object> getAllContractById(String id){
        Map<String, Object> result = new HashMap<String, Object>();

        if (id == null || id.equals("")){
            result.put("error", true);
            result.put("errorMsg", "Input is null");
            return result;
        }

        Contract contract = contractService.getContractsById(Integer.parseInt(id));

        if (contract == null){
            result.put("error", true);
            result.put("errorMsg", "Contracts not exist");
            return result;
        }

        result.put("error", false);
        result.put("contracts", contract);
        return result;
    }

    @ResponseBody
    @RequestMapping("/contract/elderId")
    public Map<String, Object> getAllContractByElderId(String id) {
        Map<String, Object> result = new HashMap<String, Object>();

        if (id == null || id.equals("")){
            result.put("error", true);
            result.put("errorMsg", "Input is null");
            return result;
        }

        List<Contract> list = contractService.getContractsByElderId(id);

        if (list == null || list.size() == 0){
            result.put("error", true);
            result.put("errorMsg", "Contracts not exist");
            return result;
        }

        result.put("error", false);
        result.put("contracts", list);
        return result;
    }

    @ResponseBody
    @RequestMapping("/elder/condition")
    public Map<String, Object> getElderConditionByElderId(String id) {
        Map<String, Object> result = new HashMap<String, Object>();

        if (id == null || id.equals("")){
            result.put("error", true);
            result.put("errorMsg", "Input is null");
            return result;
        }

        List<ElderCondition> list = contractService.getElderConditionByElderId(id);

        if (list == null || list.size() == 0){
            result.put("error", true);
            result.put("errorMsg", "Condition not exist");
            return result;
        }

        result.put("error", false);
        result.put("contracts", list);
        return result;
    }


    @ResponseBody
    @RequestMapping("/contract/insert")
    public Map<String, Object> insertContract(int id,int company_id,String elder_id,Date start_time,Date end_time,int status,String folder_name) {
        Map<String, Object> result = new HashMap<String, Object>();

        if (elder_id == null || elder_id.equals("")||start_time == null || start_time.equals("")||end_time == null || end_time.equals("")||folder_name == null || folder_name.equals("")){
            result.put("error", true);
            result.put("errorMsg", "Input is null");
            return result;
        }

        Contract contract=new Contract();
        contract.setId(id);
        contract.setCompany_id(company_id);
        contract.setElder_id(elder_id);
        contract.setStart_time(start_time);
        contract.setEnd_time(end_time);
        contract.setStatus(status);
        contract.setFolder_name(folder_name);
        boolean b=contractService.insertContract(contract);


        result.put("error", false);
        result.put("insert","insert succeed" );
        return result;
    }

}
