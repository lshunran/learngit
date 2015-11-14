package com.OCare.service;

import com.OCare.dao.ContractDAO;
import com.OCare.dao.ElderConditionDAO;
import com.OCare.entity.Contract;
import com.OCare.entity.ElderCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mark on 8/7/15.
 */
@Transactional
@Service("ContractService")
public class ContractServiceImp implements ContractService {

    @Autowired
    private ContractDAO contractDAO;

    @Autowired
    private ElderConditionDAO elderConditionDAO;


    @Override
    public List<Contract> getAllContracts() {
        return contractDAO.queryAll();
    }

    @Override
    public List<Contract> getContractsByElderId(String elderId) {
        return contractDAO.findContractsByElderId(elderId);
    }

    @Override
    public Contract getContractsById(int id) {
        return contractDAO.findContractById(id);
    }

    @Override
    public List<ElderCondition> getElderConditionByElderId(String elderId) {
        return elderConditionDAO.findElderCondition(elderId);
    }

    @Override
    public Contract getElderContractInfoByElderId(String id) {
        return contractDAO.getContractByElderId(id);
    }

    @Override
    public boolean insertContract(Contract contract) {
        contractDAO.insert(contract);
        return true;
    }
}
