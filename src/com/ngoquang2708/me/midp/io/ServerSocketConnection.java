package com.ngoquang2708.me.midp.io;

import java.io.IOException;

import com.ngoquang2708.me.cldc.io.StreamConnectionNotifier;

public interface ServerSocketConnection extends StreamConnectionNotifier {
	
	String getLocalAddress() throws IOException;
	
	int getLocalPort() throws IOException;

}
