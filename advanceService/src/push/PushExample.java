package push;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.APIConnectionException;
import cn.jpush.api.common.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

public class PushExample {
	//客户端
	private static final String appKey = "957b490f34678cdd3e4c8b1b";
	private static final String masterSecret = "426a90164774d996fa6f4582";
	//商户端
	private static final String appKey_shop = "1ed92b6399831f430ad902c6";
	private static final String masterSecret_shop = "11d6db25f05af052a5ec32c8";
	//客户端
	private JPushClient jpushClient;
	//商户端
	private JPushClient jpushClient_shop;

	public PushExample() {
		jpushClient = new JPushClient(masterSecret, appKey, 3);
		jpushClient_shop = new JPushClient(masterSecret_shop, appKey_shop, 3);
	}

	/**
	 * 所有平台，所有设备，内容为 【成佩涛发送过来的!】 的通知
	 * 
	 * */
	public static PushPayload buildPushObject_all_all_alert() {
		return PushPayload.alertAll("成佩涛发送过来的!");
	}

	/**
	 * 所有平台，推送目标是别名为 "alias1"，通知内容为 【神马都是浮云!】
	 * 
	 * */
	public static PushPayload buildPushObject_all_alias_alert() {
		return PushPayload.newBuilder().setPlatform(Platform.android())
				.setAudience(Audience.alias("alias1"))
				.setNotification(Notification.alert("神马都是浮云!")).build();
	}

	/**
	 * 平台是 Android，目标是 tag 为 "tag1" 的设备，内容是 【这是内容】，并且标题为 【这是标题】。
	 * 
	 * */
	/*
	 * public static PushPayload buildPushObject_android_tag_alertWithTitle() {
	 * return PushPayload.newBuilder() .setPlatform(Platform.android())
	 * .setAudience(Audience.registrationId("18071adc030e4cf63b2"))
	 * .setNotification(Notification.android("这是内容", "这是标题", null)) .build(); }
	 */
	/*
	 * public static PushPayload registerTitle(String title,String text,String
	 * token) { return PushPayload.newBuilder()
	 * .setPlatform(Platform.android_ios())
	 * .setAudience(Audience.registrationId(token))
	 * .setNotification(Notification.android(text, title, null)) .build(); }
	 */
	/*
	 * public PushResult registerTitle(String title,String text,String token) {
	 * try { PushPayload payload = PushPayload.newBuilder()
	 * .setPlatform(Platform.ios()) .setAudience(Audience.registrationId(token))
	 * .setNotification(Notification.android(text, title,
	 * null)).setOptions(Options.newBuilder() .setApnsProduction(true) .build())
	 * .build(); return jpushClient.sendPush(payload); } catch
	 * (APIConnectionException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (APIRequestException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } return null; }
	 */
	//客户端
	public PushResult registerTitle(String title, String text, String token) {
		PushPayload payload = PushPayload
				.newBuilder()
				.setPlatform(Platform.android_ios())
				.setAudience(Audience.registrationId(token))
				// 18071adc030e4cf63b2 141fe1da9ea8da13ace
				.setNotification(Notification.alert(text))
				.setOptions(
						Options.newBuilder().setApnsProduction(false).build())
				.build();
		try {
			return jpushClient.sendPush(payload);
		} catch (APIConnectionException | APIRequestException e) {
			e.printStackTrace();
		}
		return null;
	}
	//商户端
	public PushResult registerTitle_shop(String title, String text, String token) {
		PushPayload payload = PushPayload
				.newBuilder()
				.setPlatform(Platform.android_ios())
				.setAudience(Audience.registrationId(token))
				// 18071adc030e4cf63b2 141fe1da9ea8da13ace
				.setNotification(Notification.alert(text))
				.setOptions(
						Options.newBuilder().setApnsProduction(false).build())
						.build();
		try {
			return jpushClient_shop.sendPush(payload);
		} catch (APIConnectionException | APIRequestException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * //测试主方法 public static void main(String arg[]){
	 * 
	 * // For push, all you need do is to build PushPayload object. //
	 * PushPayload payload = buildPushObject_android_tag_alertWithTitle(); //
	 * try { PushResult result = registerTitle("String title","text","token");
	 * System.out.println(result); /* } catch (APIConnectionException e) {
	 * e.printStackTrace(); } catch (APIRequestException e) {
	 * System.out.println("Should review the error, and fix the request"+ e);
	 * System.out.println("HTTP Status: " + e.getStatus());
	 * System.out.println("Error Code: " + e.getErrorCode());
	 * System.out.println("Error Message: " + e.getErrorMessage()); }
	 */
	// }
	// }

}
