package com.growthpush;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.growthpush.handler.DefaultReceiveHandler;

public class LaunchViaPushNotificationBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		GrowthPush.getInstance().setReceiveHandler(new DefaultReceiveHandler(new DefaultReceiveHandler.Callback() {

			@Override
			public void onOpen(Context context, Intent intent) {
				trackLaunchViaPushNotificationEvent(context, intent.getExtras());
				super.onOpen(context, intent);
			}

		}));
		super.onReceive(context, intent);

	}

	private void trackLaunchViaPushNotificationEvent(Context context, Bundle extras) {

		String additionalFieldJson = extras.getString("growthpush");

		int notificationId = 0;
		if (additionalFieldJson == null)
			return;

		try {
			JSONObject additionalField = new JSONObject(additionalFieldJson);
			if (additionalField.has("notificationId"))
				notificationId = additionalField.getInt("notificationId");

		} catch (JSONException e) {
		}

		if (notificationId <= 0)
			return;

		GrowthPush.getInstance().trackEvent(String.format("Launch via push notification %d", notificationId));

	}

}
