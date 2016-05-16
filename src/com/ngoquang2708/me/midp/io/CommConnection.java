package com.ngoquang2708.me.midp.io;

import com.ngoquang2708.me.cldc.io.StreamConnection;

public interface CommConnection extends StreamConnection {

	int getBaudRate();

	int setBaudRate(int baudrate);

}