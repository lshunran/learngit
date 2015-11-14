package com.OCare.controller;

import com.OCare.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by mark on 8/2/15.
 */
@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    /**
     * 功能：创建一个机构
     * @param name 公司名称
     * @param legalPerson 法人的身份证号码
     * @param phone 公司的电话
     * @param address 公司的地址
     * @return null
     */
    @RequestMapping("/create")
    public String createCompany(String name, String legalPerson, String phone, String address){
        companyService.createCompany(name, legalPerson, phone, address);
        return "company";
    }

    /**
     * 功能：能过名字查找公司
     * @param name：公司的名称（不支持模糊查找）
     * @param model：返回值集合
     * @return null
     */
    @RequestMapping(value="/name/{name}", method = RequestMethod.GET)
    public String getCompanyByName(@PathVariable String name, Model model){
        model.addAttribute("companies", companyService.getByName(name));
        return "company";
    }

    /**
     * 功能：通过法人的身份证号码查找公司
     * @param legalPerson 法人身份证号码
     * @param model 返回值集合
     * @return null
     */
    @RequestMapping("/legalperson")
    public String getCompanyByLegalPerson(String legalPerson, Model model){
        model.addAttribute("companies", companyService.getByLegalPerson(legalPerson));
        return "company";
    }


    /**
     * 功能：列出所有正在申请中的公司
     * @param model 返回值集合
     * @return null
     */
    @RequestMapping("/list")
    public String listUnapproveCompanies(Model model){
        model.addAttribute("list", companyService.unapproveCompanies());
        return "company";
    }

    /**
     * 功能：同意申请
     * @param id 公司的编号
     * @return Null
     */
    @RequestMapping(value = "/agree/{id}", method = RequestMethod.GET)
    public String agreeApply(@PathVariable String id){
        companyService.changeStatus(Integer.parseInt(id), 102);
        return "company";
    }

    /**
     * 功能：拒绝申请
     * @param id 公司的编号
     * @return Null
     */
    @RequestMapping(value = "/reject/{id}", method = RequestMethod.GET)
    public String rejectApply(@PathVariable String id){
        companyService.changeStatus(Integer.parseInt(id), 103);
        return "company";
    }

}
