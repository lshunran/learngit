package com.OCare.dao;

import com.OCare.entity.Contract;

import java.util.List;

/**
 * Created by mark on 8/6/15.
 */
public interface ContractDAO extends IGeneralDAO<Contract>{
    public Contract findContractById(int id);
    public List<Contract> findContractsByElderId(String elderId);
    public Contract getContractByElderId(String elderId);



}
