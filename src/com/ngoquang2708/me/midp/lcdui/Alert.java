package com.ngoquang2708.me.midp.lcdui;

import com.ngoquang2708.me.midp.lcdui.impl.NativeCommandListenerForwarder;

public class Alert extends Screen {
	
	public static final Command DISMISS_COMMAND = Command
			.of(javax.microedition.lcdui.Alert.DISMISS_COMMAND);

	public static final int FOREVER = javax.microedition.lcdui.Alert.FOREVER;

	final javax.microedition.lcdui.Alert nativeAlert;
	
	Alert(javax.microedition.lcdui.Alert nativeAlert) {
		super(nativeAlert);
		this.nativeAlert = (javax.microedition.lcdui.Alert) getNativeDisplayable();
	}

	public Alert(String title) {
		this(new javax.microedition.lcdui.Alert(title));
	}

	public Alert(String title, String alertText, Image alertImage, AlertType alertType) {
//		this(new javax.microedition.lcdui.Alert(
//				title,
//				alertText,
//				alertImage == null ? null : alertImage.getNativeImage(),
//				alertType == null ? null : alertType.getNativeAlertType()));
		
		this(new javax.microedition.lcdui.Alert("aa"));
	}

	public void addCommand(Command cmd) {
		nativeAlert.addCommand(cmd.getNativeCommand());
	}

	public void removeCommand(Command cmd) {
		nativeAlert.removeCommand(cmd.getNativeCommand());
	}

	public int getDefaultTimeout() {
		return nativeAlert.getDefaultTimeout();
	}

	public String getString() {
		return nativeAlert.getString();
	}

	public int getTimeout() {
		return nativeAlert.getTimeout();
	}

	public AlertType getType() {
		return AlertType.of(nativeAlert.getType());
	}

	public void setType(AlertType type) {
		nativeAlert.setType(type.getNativeAlertType());
	}

	public void setCommandListener(final CommandListener commandListener) {
		nativeAlert.setCommandListener(new NativeCommandListenerForwarder(
				commandListener));
	}

	public Image getImage() {
		return new Image(nativeAlert.getImage());
	}

	public void setImage(Image img) {
		nativeAlert.setImage(img.getNativeImage());
	}

	public Gauge getIndicator() {
		return Gauge.valueOf(nativeAlert.getIndicator());
	}

	public void setIndicator(Gauge indicator) {
		nativeAlert.setIndicator(indicator.getNativeGauge());
	}

	public void setString(String str) {
		nativeAlert.setString(str);
	}

	public void setTimeout(int time) {
		nativeAlert.setTimeout(time);
	}
	
	public static Alert of(javax.microedition.lcdui.Alert nativeAlert) {
		Alert result;
		if ((result = (Alert) nativeDisplayableDisplayableMap
				.get(nativeAlert)) == null) {
			synchronized (nativeDisplayableDisplayableMap) {
				if ((result = (Alert) nativeDisplayableDisplayableMap
						.get(nativeAlert)) == null) {
					result = new Alert(nativeAlert);
					nativeDisplayableDisplayableMap.put(nativeAlert, result);
				}	
			}
		}
		return result;
	}
}