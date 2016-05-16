package com.ngoquang2708.me.cldc.io;

import java.io.IOException;


public interface StreamConnectionNotifier extends Connection {

	StreamConnection acceptAndOpen() throws IOException;

}
