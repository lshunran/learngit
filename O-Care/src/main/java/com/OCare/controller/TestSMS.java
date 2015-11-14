package com.OCare.controller;

import com.OCare.service.SMSSerivceImp;

/**
 * Created by fowafolo on 15/7/31.
 */

/*
    这个main是用来测试发短信的接口的
 */
public class TestSMS {
    public static void main(String[] args) {
        SMSSerivceImp ss = new SMSSerivceImp();
        ss.sendVerifyCodeToPhone("13162528836");
    }
}
