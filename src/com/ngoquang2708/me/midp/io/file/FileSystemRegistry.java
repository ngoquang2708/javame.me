package com.ngoquang2708.me.midp.io.file;

import java.util.Enumeration;
import java.util.Hashtable;

import com.ngoquang2708.me.midp.io.file.impl.NativeFileSystemListenerForwarder;


public class FileSystemRegistry {
	
	private static final Hashtable fileSystemListenerMap = new Hashtable();

	private FileSystemRegistry() {
		throw new RuntimeException();
	}

	public static synchronized boolean addFileSystemListener(final FileSystemListener listener) {
		NativeFileSystemListenerForwarder nativeListener = new NativeFileSystemListenerForwarder(listener);
		if (javax.microedition.io.file.FileSystemRegistry.addFileSystemListener(nativeListener)) {
			fileSystemListenerMap.put(listener, nativeListener);
			return true;
		}
		return false;
	}

	public static synchronized boolean removeFileSystemListener(final FileSystemListener listener) {
		if (fileSystemListenerMap.contains(listener)) {
			NativeFileSystemListenerForwarder nativeListener = (NativeFileSystemListenerForwarder) fileSystemListenerMap.get(listener);
			if (javax.microedition.io.file.FileSystemRegistry.removeFileSystemListener(nativeListener)) {
				fileSystemListenerMap.remove(listener);
				return true;
			}
		}
		return false;
	}

	public static synchronized Enumeration listRoots() {
		return javax.microedition.io.file.FileSystemRegistry.listRoots();
	}
}