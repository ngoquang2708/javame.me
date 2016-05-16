package com.ngoquang2708.me.midp.io.impl;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.microedition.io.Connection;

import com.ngoquang2708.me.cldc.io.OutputConnection;


public class OutputConnectionImpl
		extends ConnectionImpl implements OutputConnection {
	
	protected final javax.microedition.io.OutputConnection outputConnection;

	public OutputConnectionImpl(Connection connection) {
		super(connection);
		this.outputConnection = (javax.microedition.io.OutputConnection) this.connection;
	}

	public OutputStream openOutputStream() throws IOException {
		return outputConnection.openOutputStream();
	}

	public DataOutputStream openDataOutputStream() throws IOException {
		return outputConnection.openDataOutputStream();
	}
}