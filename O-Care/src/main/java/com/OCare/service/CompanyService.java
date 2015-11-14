package com.OCare.service;

import com.OCare.entity.Company;

import java.util.List;

/**
 * Created by mark on 8/2/15.
 */
public interface CompanyService {
    public Company createCompany(String name, String legalPerson, String phone, String address);
    public void changeStatus(int companyId, int status);
    public List<Company> unapproveCompanies();
    public List<Company> getByName(String name);
    public List<Company> getByLegalPerson(String legalPerson);
    public Company getCompanyById(int id);
}
