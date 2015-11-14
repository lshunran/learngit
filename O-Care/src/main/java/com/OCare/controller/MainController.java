package com.OCare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by mark on 7/12/15.
 */
@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping("")
    public String index() {
        return "index";
    }

    @RequestMapping("/hr")
    public String hrHome() {
        return "HR";
    }

    @RequestMapping("/hr/entry")
    public String hrEntry() {
        return "entry";
    }

    @RequestMapping("/hr/import")
    public String hrImport() {
        return "import";
    }

    @RequestMapping("/hr/leave")
    public String hrLeave() {
        return "leave";
    }

    @RequestMapping("/hr/table")
    public String hrTable() {
        return "table";
    }


}
