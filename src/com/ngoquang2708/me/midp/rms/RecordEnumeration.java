package com.ngoquang2708.me.midp.rms;

import javax.microedition.rms.InvalidRecordIDException;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.rms.RecordStoreNotOpenException;

public interface RecordEnumeration {

	int numRecords();

	byte[] nextRecord() throws InvalidRecordIDException, RecordStoreNotOpenException, RecordStoreException;

	int nextRecordId() throws InvalidRecordIDException;

	byte[] previousRecord() throws InvalidRecordIDException, RecordStoreNotOpenException, RecordStoreException;

	int previousRecordId() throws InvalidRecordIDException;

	boolean hasNextElement();

	boolean hasPreviousElement();

	void reset();

	void rebuild();

	void keepUpdated(boolean keepUpdated);

	boolean isKeptUpdated();

	void destroy();

}