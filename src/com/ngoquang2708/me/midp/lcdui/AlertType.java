package com.ngoquang2708.me.midp.lcdui;

import java.util.Hashtable;

import com.ngoquang2708.me.appmanager.ApplicationManager;


public class AlertType {
	
	public static final AlertType INFO;

	public static final AlertType WARNING;

	public static final AlertType ERROR;

	public static final AlertType ALARM;

	public static final AlertType CONFIRMATION;
	
	private static final Hashtable map;
	
	protected final javax.microedition.lcdui.AlertType nativeAlertType;
	
	AlertType(javax.microedition.lcdui.AlertType nativeAlertType) {
		if ((this.nativeAlertType = nativeAlertType) == null)
			throw new NullPointerException();
	}
	
	protected AlertType() {
		nativeAlertType = newCustomAlert();
	}

	public boolean playSound(Display display) {
		return nativeAlertType.playSound(ApplicationManager.getHostDisplay());
	}

	public javax.microedition.lcdui.AlertType getNativeAlertType() {
		return nativeAlertType;
	}
	
	private javax.microedition.lcdui.AlertType newCustomAlert() {
		javax.microedition.lcdui.AlertType result = new javax.microedition.lcdui.AlertType() { };
		map.put(result, this);
		return result;
	}
	
	public static AlertType of(javax.microedition.lcdui.AlertType nativeAlertType) {
		AlertType result;
		if ((result = (AlertType) map.get(nativeAlertType)) == null) {
			synchronized (map) {
				if ((result = (AlertType) map.get(nativeAlertType)) == null) {
					result = new AlertType(nativeAlertType);
					map.put(nativeAlertType, result);
				}	
			}
		}
		return result;
	}
	
	static {
		map = new Hashtable();
		INFO = AlertType.of(javax.microedition.lcdui.AlertType.INFO);
		WARNING = AlertType.of(javax.microedition.lcdui.AlertType.WARNING);
		ERROR = AlertType.of(javax.microedition.lcdui.AlertType.ERROR);
		ALARM = AlertType.of(javax.microedition.lcdui.AlertType.ALARM);
		CONFIRMATION = AlertType.of(javax.microedition.lcdui.AlertType.CONFIRMATION);
	}
}