package com.ngoquang2708.me.midp.io;

import java.io.IOException;

import com.ngoquang2708.me.cldc.io.DatagramConnection;

public interface UDPDatagramConnection extends DatagramConnection {
	
	String getLocalAddress() throws IOException;
	
	int getLocalPort() throws IOException;

}
