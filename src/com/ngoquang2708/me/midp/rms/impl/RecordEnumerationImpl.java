package com.ngoquang2708.me.midp.rms.impl;

import javax.microedition.rms.InvalidRecordIDException;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.rms.RecordStoreNotOpenException;

import com.ngoquang2708.me.midp.rms.RecordEnumeration;


public class RecordEnumerationImpl implements RecordEnumeration {
	
	protected final javax.microedition.rms.RecordEnumeration recordEnumeration;
	
	public RecordEnumerationImpl(
			javax.microedition.rms.RecordEnumeration recordEnumeration) {
		if ((this.recordEnumeration = recordEnumeration) == null)
			throw new NullPointerException();
	}

	public int numRecords() {
		return recordEnumeration.numRecords();
	}

	public byte[] nextRecord() throws InvalidRecordIDException, RecordStoreNotOpenException, RecordStoreException {
		return recordEnumeration.nextRecord();
	}

	public int nextRecordId() throws InvalidRecordIDException {
		return recordEnumeration.nextRecordId();
	}

	public byte[] previousRecord() throws InvalidRecordIDException, RecordStoreNotOpenException, RecordStoreException {
		return recordEnumeration.previousRecord();
	}

	public int previousRecordId() throws InvalidRecordIDException {
		return recordEnumeration.previousRecordId();
	}

	public boolean hasNextElement() {
		return recordEnumeration.hasNextElement();
	}

	public boolean hasPreviousElement() {
		return recordEnumeration.hasPreviousElement();
	}

	public void reset() {
		recordEnumeration.reset();
	}

	public void rebuild() {
		recordEnumeration.rebuild();
	}

	public void keepUpdated(boolean keepUpdated) {
		recordEnumeration.keepUpdated(keepUpdated);
	}

	public boolean isKeptUpdated() {
		return recordEnumeration.isKeptUpdated();
	}

	public void destroy() {
		recordEnumeration.destroy();
	}

}
