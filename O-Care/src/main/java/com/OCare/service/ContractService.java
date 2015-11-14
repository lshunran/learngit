package com.OCare.service;

import com.OCare.entity.Contract;
import com.OCare.entity.ElderCondition;

import java.util.List;

/**
 * Created by mark on 8/7/15.
 */
public interface ContractService {

    public List<Contract> getAllContracts();
    public List<Contract> getContractsByElderId(String elderId);
    public Contract getContractsById(int id);

    //ElderCondition
    public List<ElderCondition> getElderConditionByElderId(String elderId);

    /*
        功能：显示老人的有效合同（默认同时只有一个）
        参数：身份证
        返回值：Contract实例
     */
    public Contract getElderContractInfoByElderId(String id);

    public boolean insertContract(Contract contract);
}
