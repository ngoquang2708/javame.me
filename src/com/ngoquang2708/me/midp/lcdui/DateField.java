package com.ngoquang2708.me.midp.lcdui;

import java.util.Date;
import java.util.TimeZone;

public class DateField extends Item {

	public static final int DATE = javax.microedition.lcdui.DateField.DATE;
	public static final int TIME = javax.microedition.lcdui.DateField.TIME;
	public static final int DATE_TIME = javax.microedition.lcdui.DateField.DATE_TIME;
	
	protected final javax.microedition.lcdui.DateField nativeDateField;
	
	DateField(javax.microedition.lcdui.DateField nativeDateField) {
		super(nativeDateField);
		this.nativeDateField = (javax.microedition.lcdui.DateField) getNativeItem();
	}

	public DateField(String label, int mode) {
		this(label, mode, null);
	}

	public DateField(String label, int mode, TimeZone timeZone) {
		this(new javax.microedition.lcdui.DateField(label, mode, timeZone));
	}

	public Date getDate() {
		return nativeDateField.getDate();
	}

	public void setDate(Date date) {
		nativeDateField.setDate(date);
	}

	public int getInputMode() {
		return nativeDateField.getInputMode();
	}

	public void setInputMode(int mode) {
		nativeDateField.setInputMode(mode);
	}
	
	public javax.microedition.lcdui.DateField getNativeDateField() {
		return nativeDateField;
	}
}