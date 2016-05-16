package com.ngoquang2708.me.cldc.io;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public interface Datagram extends DataInput, DataOutput {

	String getAddress();

	byte[] getData();

	int getLength();

	int getOffset();

	void setAddress(String addr) throws IOException;

	void setAddress(Datagram reference);

	void setLength(int len);

	void setData(byte[] buffer, int offset, int len);

	void reset();
	
	javax.microedition.io.Datagram getNativeDatagram();

}