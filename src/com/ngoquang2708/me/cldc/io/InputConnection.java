package com.ngoquang2708.me.cldc.io;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.IOException;


public interface InputConnection extends Connection {

	InputStream openInputStream() throws IOException;

	DataInputStream openDataInputStream() throws IOException;

}