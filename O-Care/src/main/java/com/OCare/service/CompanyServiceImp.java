package com.OCare.service;

import com.OCare.dao.CompanyDAO;
import com.OCare.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mark on 8/2/15.
 */
@Service("CompanyService")
@Transactional
public class CompanyServiceImp implements CompanyService {

    @Autowired
    private CompanyDAO companyDAO;
    @Override
    public Company createCompany(String name, String legalPerson, String phone, String address) {
        Company company = new Company();
        company.setName(name);
        company.setLegal_person_id(legalPerson);
        company.setPhone(phone);
        company.setAddress(address);
        company.setStatus(101);//101表示已提交申请，申请审核中
        companyDAO.insert(company);
        return company;
    }

    public void changeStatus(int companyId, int status){
        Company company = companyDAO.getById(companyId);
        //102通过，103拒绝
        company.setStatus(status);
        companyDAO.update(company);
    }

    public List<Company> unapproveCompanies(){
        return companyDAO.unapproveCompanies();
    }

    @Override
    public List<Company> getByName(String name) {
        return companyDAO.getByName(name);
    }

    @Override
    public List<Company> getByLegalPerson(String legalPerson) {
        return companyDAO.getByLegalPerson(legalPerson);
    }

    @Override
    public Company getCompanyById(int id) {
        return companyDAO.getById(id);
    }
}
