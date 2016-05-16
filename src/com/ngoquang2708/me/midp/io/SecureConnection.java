package com.ngoquang2708.me.midp.io;

import java.io.IOException;

public interface SecureConnection extends SocketConnection {

	SecurityInfo getSecurityInfo() throws IOException;
	
}
