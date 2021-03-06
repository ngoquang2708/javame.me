package com.ngoquang2708.me.cldc.io;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public interface OutputConnection extends Connection {

	OutputStream openOutputStream() throws IOException;

	DataOutputStream openDataOutputStream() throws IOException;

}
