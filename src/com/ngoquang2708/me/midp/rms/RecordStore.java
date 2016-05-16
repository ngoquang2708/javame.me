package com.ngoquang2708.me.midp.rms;

import java.util.Hashtable;

import javax.microedition.rms.InvalidRecordIDException;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.rms.RecordStoreFullException;
import javax.microedition.rms.RecordStoreNotFoundException;
import javax.microedition.rms.RecordStoreNotOpenException;

import com.ngoquang2708.me.midp.rms.impl.NativeRecordComparatorForwarder;
import com.ngoquang2708.me.midp.rms.impl.NativeRecordFilterForwarder;
import com.ngoquang2708.me.midp.rms.impl.NativeRecordListenerForwarder;
import com.ngoquang2708.me.midp.rms.impl.RecordEnumerationImpl;


public class RecordStore {

	public static final int AUTHMODE_PRIVATE = 0;

	public static final int AUTHMODE_ANY = 1;
	
	private static final Hashtable recordStoreMap = new Hashtable();
	
	private static final Hashtable nameRecordStoreMap = new Hashtable();
	
	private final javax.microedition.rms.RecordStore nativeRecordStore;
	
	private final Hashtable recordListenerMap;

	private RecordStore(javax.microedition.rms.RecordStore nativeRecordStore) {
		if ((this.nativeRecordStore = nativeRecordStore) == null)
			throw new NullPointerException();
		this.recordListenerMap = new Hashtable();
	}
	
	public void closeRecordStore() throws RecordStoreNotOpenException, RecordStoreException {
		nameRecordStoreMap.remove(nativeRecordStore.getName());
		recordStoreMap.remove(nativeRecordStore);
		nativeRecordStore.closeRecordStore();
	}

	public String getName() throws RecordStoreNotOpenException {
		return nativeRecordStore.getName();
	}

	public int getVersion() throws RecordStoreNotOpenException {
		return nativeRecordStore.getVersion();
	}

	public int getNumRecords() throws RecordStoreNotOpenException {
		return nativeRecordStore.getNumRecords();
	}

	public int getSize() throws RecordStoreNotOpenException {
		return nativeRecordStore.getSize();
	}

	public int getSizeAvailable() throws RecordStoreNotOpenException {
		return nativeRecordStore.getSizeAvailable();
	}

	public long getLastModified() throws RecordStoreNotOpenException {
		return nativeRecordStore.getLastModified();
	}

	public void addRecordListener(RecordListener listener) {
		NativeRecordListenerForwarder nativeListener = new NativeRecordListenerForwarder(listener);
		nativeRecordStore.addRecordListener(nativeListener);
		recordListenerMap.put(listener, nativeListener);
	}

	public void removeRecordListener(RecordListener listener) {
		NativeRecordListenerForwarder nativeListener;
		if ((nativeListener = (NativeRecordListenerForwarder) recordListenerMap.remove(listener)) != null)
			nativeRecordStore.removeRecordListener(nativeListener);
	}

	public int getNextRecordID() throws RecordStoreNotOpenException, RecordStoreException {
		return nativeRecordStore.getNextRecordID();
	}

	public int addRecord(byte[] data, int offset, int numBytes)
			throws RecordStoreNotOpenException, RecordStoreException, RecordStoreFullException {
		return nativeRecordStore.addRecord(data, offset, numBytes);
	}

	public void deleteRecord(int recordId)
			throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException {
		nativeRecordStore.deleteRecord(recordId);
	}

	public int getRecordSize(int recordId)
			throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException {
		return nativeRecordStore.getRecordSize(recordId);
	}

	public int getRecord(int recordId, byte[] buffer, int offset)
			throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException {
		return nativeRecordStore.getRecord(recordId, buffer, offset);
	}

	public byte[] getRecord(int recordId)
			throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException {
		return nativeRecordStore.getRecord(recordId);
	}

	public void setMode(int authmode, boolean writable)
			throws RecordStoreException {
		nativeRecordStore.setMode(authmode, writable);
	}

	public void setRecord(int recordId, byte[] newData, int offset, int numBytes)
			throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException, RecordStoreFullException {
		nativeRecordStore.setRecord(recordId, newData, offset, numBytes);
	}

	public RecordEnumeration enumerateRecords(RecordFilter filter, RecordComparator comparator, boolean keepUpdated)
			throws RecordStoreNotOpenException {
		return new RecordEnumerationImpl(nativeRecordStore.enumerateRecords(
				new NativeRecordFilterForwarder(filter), new NativeRecordComparatorForwarder(comparator), keepUpdated));
	}

	public static RecordStore of(javax.microedition.rms.RecordStore nativeRecordStore) {
		return (RecordStore) recordStoreMap.get(nativeRecordStore);
	}

	public static String[] listRecordStores() {
		return javax.microedition.rms.RecordStore.listRecordStores();
	}

	public static RecordStore openRecordStore(String recordStoreName, boolean createIfNecessary)
			throws RecordStoreException, RecordStoreFullException, RecordStoreNotFoundException {
		javax.microedition.rms.RecordStore nativeRecordStore = javax.microedition.rms.RecordStore
				.openRecordStore(recordStoreName, createIfNecessary);
		RecordStore recordStore = new RecordStore(nativeRecordStore);
		recordStoreMap.put(nativeRecordStore, recordStore);
		nameRecordStoreMap.put(recordStoreName, recordStore);
		return recordStore;
	}

	public static RecordStore openRecordStore(String recordStoreName, boolean createIfNecessary, int authmode, boolean writable)
			throws RecordStoreException, RecordStoreFullException, RecordStoreNotFoundException {
		javax.microedition.rms.RecordStore nativeRecordStore = javax.microedition.rms.RecordStore
				.openRecordStore(recordStoreName, createIfNecessary, authmode, writable);
		RecordStore recordStore = new RecordStore(nativeRecordStore);
		recordStoreMap.put(nativeRecordStore, recordStore);
		nameRecordStoreMap.put(recordStoreName, recordStore);
		return recordStore;
	}

	public static RecordStore openRecordStore(String recordStoreName, String vendorName, String suiteName)
			throws RecordStoreException, RecordStoreNotFoundException {
		javax.microedition.rms.RecordStore nativeRecordStore = javax.microedition.rms.RecordStore
				.openRecordStore(recordStoreName, vendorName, suiteName);
		RecordStore recordStore = new RecordStore(nativeRecordStore);
		recordStoreMap.put(nativeRecordStore, recordStore);
		nameRecordStoreMap.put(recordStoreName, recordStore);
		return recordStore;
	}

	public static void deleteRecordStore(String recordStoreName)
			throws RecordStoreException, RecordStoreNotFoundException {
		recordStoreMap.remove(((RecordStore) nameRecordStoreMap.remove(recordStoreName)).nativeRecordStore);
		javax.microedition.rms.RecordStore.deleteRecordStore(recordStoreName);
	}
}