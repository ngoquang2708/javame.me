package com.ngoquang2708.me.midp.rms;

public interface RecordListener {

	void recordAdded(RecordStore recordStore, int recordId);

	void recordChanged(RecordStore recordStore, int recordId);

	void recordDeleted(RecordStore recordStore, int recordId);

}
