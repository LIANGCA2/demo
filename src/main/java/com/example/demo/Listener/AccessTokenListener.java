package com.example.demo.Listener;


import com.example.demo.enums.InitName;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class AccessTokenListener implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        final String appId = InitName.APPID;
        final String appSecret = InitName.APPSECRET;
        new Thread(() -> {
            while (true) {
                try { //获取accessToken
                     AccessTokenInfo.accessToken = getAccessToken(appId, appSecret); //获取成功
                     if (AccessTokenInfo.accessToken != null) { //获取到access_token 休眠7000秒,大约2个小时左右 Thread.sleep(7000 * 1000); } else { //获取失败 Thread.sleep(1000 * 3); //获取的access_token为空 休眠3秒 } } catch (Exception e) { System.out.println("发生异常：" + e.getMessage()); e.printStackTrace(); try { Thread.sleep(1000 * 10); //发生异常休眠1秒 } catch (Exception e1) { e.printStackTrace(); } }
                    ---------------------

            }
    });
}
}
