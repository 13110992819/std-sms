package com.std.sms.sent.jiguang;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

import com.std.sms.common.PropertiesUtil;

public class JPushClientSend {
    protected static final Logger LOG = LoggerFactory
        .getLogger(JPushClient.class);

    public static boolean toSendPush(String appKey, String masterSecret,
            String noticeInfo) {
        return toSendPush(appKey, masterSecret, null, noticeInfo);
    }

    public static boolean toSendPush(String appKey, String masterSecret,
            String alias, String noticeInfo) {
        boolean res = false;
        ClientConfig clientConfig = ClientConfig.getInstance();
        JPushClient jpushClient = new JPushClient(masterSecret, appKey, null,
            clientConfig);
        // 生产环境apnsProduction传入true，研发传false
        Boolean apnsProduction = false;
        if ("1".equals(PropertiesUtil.Config.APNS_PRODUCTION)) {
            apnsProduction = true;
        }
        PushPayload payload = null;
        // 全渠道发或者单发
        if (StringUtils.isNotBlank(alias)) {
            payload = buildPushObject_android_and_ios_alert(noticeInfo,
                apnsProduction, alias);
        } else {
            payload = buildPushObject_android_and_ios_alert(noticeInfo,
                apnsProduction);
        }
        try {
            PushResult result = jpushClient.sendPush(payload);
            LOG.info("responseCode:" + result.getResponseCode());
            LOG.info("Got result - " + result);
            if (200 == result.getResponseCode()) {
                res = true;
            }
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error(
                "Error response from JPush server. Should review and fix it. ",
                e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
            LOG.info("Msg ID: " + e.getMsgId());
        } catch (Exception e) {
            LOG.info("Error Message: " + e.getMessage());
        }
        return res;
    }

    public static PushPayload buildPushObject_all_all_alert(String alert) {
        return PushPayload.alertAll(alert);
    }

    public static PushPayload buildPushObject_android_and_ios_alert(
            String ALERT, boolean APNS_PRODUCTION) {
        return PushPayload
            .newBuilder()
            .setPlatform(Platform.all())
            .setAudience(Audience.all())
            .setNotification(
                Notification
                    .newBuilder()
                    .addPlatformNotification(
                        AndroidNotification.newBuilder().setAlert(ALERT)
                            .build())
                    .addPlatformNotification(
                        IosNotification.newBuilder().setAlert(ALERT)
                            .setBadge(5).setSound("happy").build()).build())
            .setOptions(
                Options.newBuilder().setApnsProduction(APNS_PRODUCTION).build())
            .build();
    }

    public static PushPayload buildPushObject_android_and_ios_alert(
            String ALERT, boolean APNS_PRODUCTION, String... alias1) {
        return PushPayload
            .newBuilder()
            .setPlatform(Platform.all())
            .setAudience(
                Audience.newBuilder()
                    .addAudienceTarget(AudienceTarget.alias(alias1)).build())
            .setNotification(
                Notification
                    .newBuilder()
                    .addPlatformNotification(
                        AndroidNotification.newBuilder().setAlert(ALERT)
                            .build())
                    .addPlatformNotification(
                        IosNotification.newBuilder().setAlert(ALERT)
                            .setBadge(5).setSound("happy").build()).build())
            .setOptions(
                Options.newBuilder().setApnsProduction(APNS_PRODUCTION).build())
            .build();
    }
}
