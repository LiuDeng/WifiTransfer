package com.xzwzz.transfer.interf;

import android.net.NetworkInfo;

public interface WifiConnectChangeListener {
    void changeWifiState(NetworkInfo.State state);
}
