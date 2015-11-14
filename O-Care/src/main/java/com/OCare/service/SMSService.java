package com.OCare.service;

/**
 * Created by fowafolo on 15/7/31.
 */
public interface SMSService {

    /*
        功能：发送短信验证码到手机
        参数：要发送验证码的手机号码String值
        返回值：返回发送的四位验证码int值
     */
    public int sendVerifyCodeToPhone(String phoneToSendCode);

    /*
        功能：验证手机发过来的验证码是否正确
        参数：正确的验证码，发来的验证码
        返回值：是否正确，正确返回true,错误返回false
     */
    public boolean isCodeRight(int rightCode, int sentCode);

}
