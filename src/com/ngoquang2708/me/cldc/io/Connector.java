package com.ngoquang2708.me.cldc.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.microedition.io.ConnectionNotFoundException;

import com.ngoquang2708.me.midp.io.impl.HttpsConnectionImpl;
import com.ngoquang2708.me.midp.io.impl.InputConnectionImpl;
import com.ngoquang2708.me.midp.io.impl.OutputConnectionImpl;
import com.ngoquang2708.me.midp.io.impl.SecureConnectionImpl;
import com.ngoquang2708.me.midp.io.impl.ServerSocketConnectionImpl;
import com.ngoquang2708.me.midp.io.impl.SocketConnectionImpl;
import com.ngoquang2708.me.midp.io.impl.UDPDatagramConnectionImpl;


public class Connector {

	public static final int READ = javax.microedition.io.Connector.READ;
	public static final int WRITE = javax.microedition.io.Connector.WRITE;
	public static final int READ_WRITE = javax.microedition.io.Connector.READ_WRITE;

	public static Connection open(String name) throws IOException {
		return getConnectionImpl(javax.microedition.io.Connector.open(name));
	}

	public static Connection open(String name, int mode) throws IOException {
		return getConnectionImpl(javax.microedition.io.Connector.open(name, mode));
	}

	public static Connection open(String name, int mode, boolean timeouts) throws IOException {
		return getConnectionImpl(javax.microedition.io.Connector.open(name, mode, timeouts));
	}

	public static DataInputStream openDataInputStream(String name) throws IOException {
		return javax.microedition.io.Connector.openDataInputStream(name);
	}

	public static DataOutputStream openDataOutputStream(String name) throws IOException {
		return javax.microedition.io.Connector.openDataOutputStream(name);
	}

	public static InputStream openInputStream(String name) throws IOException {
		return javax.microedition.io.Connector.openInputStream(name);
	}

	public static OutputStream openOutputStream(String name) throws IOException {
		return javax.microedition.io.Connector.openOutputStream(name);
	}

	private static Connection getConnectionImpl(javax.microedition.io.Connection connection)
			throws ConnectionNotFoundException {
		// StreamConnection
		if (connection instanceof javax.microedition.io.StreamConnection) {
			// ContentConnection
			if (connection instanceof javax.microedition.io.ContentConnection) {
				if (connection instanceof javax.microedition.io.HttpConnection) {
					// HttpsConnection
					if (connection instanceof javax.microedition.io.HttpsConnection)
						return new HttpsConnectionImpl(connection);
					// HttpConnection
					return new HttpsConnectionImpl(connection);
				}
			}
			// SocketConnection
			if (connection instanceof javax.microedition.io.SocketConnection) {
				// SecureConnection
				if (connection instanceof javax.microedition.io.SecureConnection)
					return new SecureConnectionImpl(connection);
				// SocketConnection
				return new SocketConnectionImpl(connection);
			}
		}
		// DatagramConnection
		if (connection instanceof javax.microedition.io.DatagramConnection) {
			// UDPDatagramConnection
			if (connection instanceof javax.microedition.io.UDPDatagramConnection)
				return new UDPDatagramConnectionImpl(connection);
		}
		// StreamConnectionNotifier
		if (connection instanceof javax.microedition.io.StreamConnectionNotifier) {
			// ServerSocketConnection
			if (connection instanceof javax.microedition.io.ServerSocketConnection)
				return new ServerSocketConnectionImpl(connection);
		}
		// InputConnection
		if (connection instanceof javax.microedition.io.InputConnection) {
			return new InputConnectionImpl(connection);
		}
		// OutputConnection
		if (connection instanceof javax.microedition.io.OutputConnection) {
			return new OutputConnectionImpl(connection);
		}
		throw new ConnectionNotFoundException();
	}
}