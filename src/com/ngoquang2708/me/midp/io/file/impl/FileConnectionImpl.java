package com.ngoquang2708.me.midp.io.file.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.microedition.io.Connection;

import com.ngoquang2708.me.midp.io.file.FileConnection;
import com.ngoquang2708.me.midp.io.impl.StreamConnectionImpl;


public class FileConnectionImpl
		extends StreamConnectionImpl implements FileConnection {
	
	protected final javax.microedition.io.file.FileConnection fileConnection;

	public FileConnectionImpl(Connection connection) {
		super(connection);
		this.fileConnection = (javax.microedition.io.file.FileConnection) this.connection;
	}

	public boolean isOpen() {
		return fileConnection.isOpen();
	}

	public OutputStream openOutputStream(long byteOffset) throws IOException {
		return fileConnection.openOutputStream(byteOffset);
	}

	public long totalSize() {
		return fileConnection.totalSize();
	}

	public long availableSize() {
		return fileConnection.availableSize();
	}

	public long usedSize() {
		return fileConnection.usedSize();
	}

	public long directorySize(boolean includeSubDirs) throws IOException {
		return fileConnection.directorySize(includeSubDirs);
	}

	public long fileSize() throws IOException {
		return fileConnection.fileSize();
	}

	public boolean canRead() {
		return fileConnection.canRead();
	}

	public boolean canWrite() {
		return fileConnection.canWrite();
	}

	public boolean isHidden() {
		return fileConnection.isHidden();
	}

	public void setReadable(boolean readable) throws IOException {
		fileConnection.setReadable(readable);
	}

	public void setWritable(boolean writable) throws IOException {
		fileConnection.setWritable(writable);
	}

	public void setHidden(boolean hidden) throws IOException {
		fileConnection.setHidden(hidden);
	}

	public Enumeration list() throws IOException {
		return fileConnection.list();
	}

	public Enumeration list(String filter, boolean includeHidden) throws IOException {
		return fileConnection.list(filter, includeHidden);
	}

	public void create() throws IOException {
		fileConnection.create();
	}

	public void mkdir() throws IOException {
		fileConnection.mkdir();
	}

	public boolean exists() {
		return fileConnection.exists();
	}

	public boolean isDirectory() {
		return fileConnection.isDirectory();
	}

	public void delete() throws IOException {
		fileConnection.delete();
	}

	public void rename(String newName) throws IOException {
		fileConnection.rename(newName);
	}

	public void truncate(long byteOffset) throws IOException {
		fileConnection.truncate(byteOffset);
	}

	public void setFileConnection(String s) throws IOException {
		fileConnection.setFileConnection(s);
	}

	public String getName() {
		return fileConnection.getName();
	}

	public String getPath() {
		return fileConnection.getPath();
	}

	public String getURL() {
		return fileConnection.getURL();
	}

	public long lastModified() {
		return fileConnection.lastModified();
	}
}