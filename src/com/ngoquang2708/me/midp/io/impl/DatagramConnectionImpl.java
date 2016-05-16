package com.ngoquang2708.me.midp.io.impl;

import java.io.IOException;

import javax.microedition.io.Connection;

import com.ngoquang2708.me.cldc.io.Datagram;
import com.ngoquang2708.me.cldc.io.DatagramConnection;


public class DatagramConnectionImpl
		extends ConnectionImpl implements DatagramConnection {
	
	protected final javax.microedition.io.DatagramConnection datagramConnection;
	
	public DatagramConnectionImpl(Connection connection) {
		super(connection);
		this.datagramConnection = (javax.microedition.io.DatagramConnection) this.connection;
	}

	public int getMaximumLength() throws IOException {
		return datagramConnection.getMaximumLength();
	}

	public int getNominalLength() throws IOException {
		return datagramConnection.getNominalLength();
	}

	public void send(Datagram dgram) throws IOException {
		datagramConnection.send(dgram.getNativeDatagram());
	}

	public void receive(Datagram dgram) throws IOException {
		datagramConnection.receive(dgram.getNativeDatagram());
	}

	public Datagram newDatagram(int size) throws IOException {
		return new DatagramImpl(datagramConnection.newDatagram(size));
	}

	public Datagram newDatagram(int size, String addr) throws IOException {
		return new DatagramImpl(datagramConnection.newDatagram(size, addr));
	}

	public Datagram newDatagram(byte[] buf, int size) throws IOException {
		return new DatagramImpl(datagramConnection.newDatagram(buf, size));
	}

	public Datagram newDatagram(byte[] buf, int size, String addr) throws IOException {
		return new DatagramImpl(datagramConnection.newDatagram(buf, size, addr));
	}
}