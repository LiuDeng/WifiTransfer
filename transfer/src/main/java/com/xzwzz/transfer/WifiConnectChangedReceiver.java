package com.xzwzz.transfer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Parcelable;

import com.xzwzz.transfer.interf.WifiConnectChangeListener;

public class WifiConnectChangedReceiver extends BroadcastReceiver {

    public WifiConnectChangeListener mListener;

    public WifiConnectChangedReceiver(WifiConnectChangeListener mListener) {
        this.mListener = mListener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (WifiManager.NETWORK_STATE_CHANGED_ACTION.equals(intent.getAction())) {
            Parcelable parcelableExtra = intent
                    .getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
            if (null != parcelableExtra) {
                NetworkInfo networkInfo = (NetworkInfo) parcelableExtra;
                mListener.changeWifiState(networkInfo.getState());
            }
        }
    }

}
