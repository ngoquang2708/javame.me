package com.ngoquang2708.me.midp.io;

import java.io.IOException;

public interface HttpsConnection extends HttpConnection {
	
	SecurityInfo getSecurityInfo() throws IOException;
	
	int getPort();

}
