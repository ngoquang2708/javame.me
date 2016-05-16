package com.ngoquang2708.me.midp.io;

import java.io.IOException;

import javax.microedition.io.ConnectionNotFoundException;

public class PushRegistry {

	public static void registerConnection(String connection, String midlet, String filter) throws ClassNotFoundException, IOException {
		javax.microedition.io.PushRegistry.registerConnection(connection, midlet, filter);
	}

	public static boolean unregisterConnection(String connection) {
		return javax.microedition.io.PushRegistry.unregisterConnection(connection);
	}

	public static String[] listConnections(boolean available) {
		return javax.microedition.io.PushRegistry.listConnections(available);
	}

	public static String getMIDlet(String connection) {
		return javax.microedition.io.PushRegistry.getMIDlet(connection);
	}

	public static String getFilter(String connection) {
		return javax.microedition.io.PushRegistry.getFilter(connection);
	}

	public static long registerAlarm(String midlet, long time)
			throws ClassNotFoundException, ConnectionNotFoundException {
		return javax.microedition.io.PushRegistry.registerAlarm(midlet, time);
	}
}