package com.OCare.dao;

import com.OCare.entity.Company;

import java.util.List;

/**
 * Created by mark on 8/2/15.
 */
public interface CompanyDAO extends IGeneralDAO<Company> {
    public Company getById(int id);
    public List<Company> unapproveCompanies();
    public List<Company> getByName(String name);
    public List<Company> getByLegalPerson(String legalPerson);
}
