package com.ngoquang2708.me.midp.io.impl;

import java.io.IOException;

import com.ngoquang2708.me.cldc.io.Datagram;


public class DatagramImpl implements Datagram {
	
	protected final javax.microedition.io.Datagram nativeDatagram;
	
	public DatagramImpl(javax.microedition.io.Datagram datagram) {
		if ((this.nativeDatagram = datagram) == null)
			throw new NullPointerException();
	}

	public void setAddress(Datagram reference) {
		nativeDatagram.setAddress(reference.getNativeDatagram());
	}

	public boolean readBoolean() throws IOException {
		return nativeDatagram.readBoolean();
	}

	public byte readByte() throws IOException {
		return nativeDatagram.readByte();
	}

	public char readChar() throws IOException {
		return nativeDatagram.readChar();
	}

	public double readDouble() throws IOException {
		return nativeDatagram.readDouble();
	}

	public float readFloat() throws IOException {
		return nativeDatagram.readFloat();
	}

	public void readFully(byte[] b) throws IOException {
		nativeDatagram.readFully(b);
	}

	public void readFully(byte[] b, int off, int len) throws IOException {
		nativeDatagram.readFully(b, off, len);
	}

	public int readInt() throws IOException {
		return nativeDatagram.readInt();
	}

	public long readLong() throws IOException {
		return nativeDatagram.readLong();
	}

	public short readShort() throws IOException {
		return nativeDatagram.readShort();
	}

	public String readUTF() throws IOException {
		return nativeDatagram.readUTF();
	}

	public int readUnsignedByte() throws IOException {
		return nativeDatagram.readUnsignedByte();
	}

	public int readUnsignedShort() throws IOException {
		return nativeDatagram.readUnsignedShort();
	}

	public int skipBytes(int n) throws IOException {
		return nativeDatagram.skipBytes(n);
	}

	public void write(int b) throws IOException {
		nativeDatagram.write(b);
	}

	public void write(byte[] b) throws IOException {
		nativeDatagram.write(b);
	}

	public void write(byte[] b, int off, int len) throws IOException {
		nativeDatagram.write(b, off, len);
	}

	public void writeBoolean(boolean v) throws IOException {
		nativeDatagram.writeBoolean(v);
	}

	public void writeByte(int v) throws IOException {
		nativeDatagram.writeByte(v);
	}

	public void writeChar(int v) throws IOException {
		nativeDatagram.writeChar(v);
	}

	public void writeChars(String s) throws IOException {
		nativeDatagram.writeChars(s);
	}

	public void writeDouble(double v) throws IOException {
		nativeDatagram.writeDouble(v);
	}

	public void writeFloat(float v) throws IOException {
		nativeDatagram.writeFloat(v);
	}

	public void writeInt(int v) throws IOException {
		nativeDatagram.writeInt(v);
	}

	public void writeLong(long v) throws IOException {
		nativeDatagram.writeLong(v);
	}

	public void writeShort(int v) throws IOException {
		nativeDatagram.writeShort(v);
	}

	public void writeUTF(String s) throws IOException {
		nativeDatagram.writeUTF(s);
	}

	public String getAddress() {
		return nativeDatagram.getAddress();
	}

	public byte[] getData() {
		return nativeDatagram.getData();
	}

	public int getLength() {
		return nativeDatagram.getLength();
	}

	public int getOffset() {
		return nativeDatagram.getOffset();
	}

	public void setAddress(String addr) throws IOException {
		nativeDatagram.setAddress(addr);
	}

	public void setLength(int len) {
		nativeDatagram.setLength(len);
	}

	public void setData(byte[] buffer, int offset, int len) {
		nativeDatagram.setData(buffer, offset, len);
	}

	public void reset() {
		nativeDatagram.reset();
	}
	
	public javax.microedition.io.Datagram getNativeDatagram() {
		return nativeDatagram;
	}
}