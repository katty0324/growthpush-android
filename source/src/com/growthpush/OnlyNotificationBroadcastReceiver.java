package com.growthpush;

import android.content.Context;
import android.content.Intent;

import com.growthpush.handler.OnlyNotificationReceiveHandler;

public class OnlyNotificationBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		GrowthPush.getInstance().setReceiveHandler(new OnlyNotificationReceiveHandler());
		super.onReceive(context, intent);

	}

}
