package com.OCare.controller;

import com.OCare.service.VerifyService;
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
@RequestMapping("/monitor")
public class ElderMonitorController {
    @Autowired
    private VerifyService verifyService;

    @RequestMapping("/list")
    public String listAllRequest(Model model){
        model.addAttribute("list",verifyService.getAllUntreatedRequests());
        return "homepage";
    }

    @RequestMapping(value="/agree/{id}", method = RequestMethod.GET)
    public String agreeRequest(@PathVariable String id, Model model){
        verifyService.checkMonitorApply(Integer.parseInt(id), 1);
        model.addAttribute("list", verifyService.getAllUntreatedRequests());
        model.addAttribute("request",verifyService.getRequestByID(Integer.parseInt(id)));
        return "verify";
    }

    @RequestMapping(value="/reject/{id}", method = RequestMethod.GET)
    public String rejectRequest(@PathVariable String id, Model model) {
        verifyService.checkMonitorApply(Integer.parseInt(id), 4);
        model.addAttribute("list", verifyService.getAllUntreatedRequests());
        model.addAttribute("request", verifyService.getRequestByID(Integer.parseInt(id)));
        return "verify";
    }

    @RequestMapping(value="/undesided/{id}", method = RequestMethod.GET)
    public String AllRequest(@PathVariable String id, Model model){
        verifyService.checkMonitorApply(Integer.parseInt(id), 3);
        model.addAttribute("list", verifyService.getAllUntreatedRequests());
        model.addAttribute("request",verifyService.getRequestByID(Integer.parseInt(id)));
        return "verify";
    }
    @RequestMapping(value = "/makeUndesigned/{id}",method = RequestMethod.GET)
    public String makeAMonitorUndesigned(@PathVariable int id,Model model) {
        boolean flag = verifyService.makeAMonitorRequestUndesigned(id);
        model.addAttribute("list",verifyService.getAllUntreatedRequests());
        return "homepage";
    }
    @RequestMapping(value = "/makeAgreed/{id}",method = RequestMethod.GET)
    public String makeAMonitorAgreed(@PathVariable int id,Model model) {
        boolean flag = verifyService.makeAMonitorRequestAgreed(id);
        model.addAttribute("list",verifyService.getAllUntreatedRequests());
        return "homepage";
    }
    @RequestMapping(value = "/makeReject/{id}",method = RequestMethod.GET)
    public String makeAMonitorReject(@PathVariable int id,Model model) {
        boolean flag = verifyService.makeAMonitorRequestDisAgreed(id);
        model.addAttribute("list",verifyService.getAllUntreatedRequests());
        return "homepage";
    }
}