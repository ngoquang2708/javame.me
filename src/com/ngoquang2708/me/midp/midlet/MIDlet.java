package com.ngoquang2708.me.midp.midlet;

import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.midlet.MIDletStateChangeException;

import com.ngoquang2708.me.appmanager.ApplicationManager;
import com.ngoquang2708.me.appmanager.MIDletAccessor;


public abstract class MIDlet extends MIDletAccessor {
	
	protected MIDlet() {
	}
	
	public final String getAppProperty(String key) {
		return ApplicationManager.getAppProperty(this, key);
	}
	
	public final void setAppProperty(String name, String value) {
		ApplicationManager.setAppProperty(this, name, value);
	}

	public final int checkPermission(String permission) {
		return ApplicationManager.checkPermission(this, permission);
	}

	public final void notifyDestroyed() {
		ApplicationManager.notifyDestroyed(this);
	}

	public final void notifyPaused() {
		ApplicationManager.notifyPaused(this);
	}

	public final boolean platformRequest(String url) throws ConnectionNotFoundException {
		return ApplicationManager.platformRequest(this, url);
	}

	public final void resumeRequest() {
		ApplicationManager.resumeRequest(this);
	}

	protected abstract void startApp() throws MIDletStateChangeException;

	protected abstract void pauseApp();

	protected abstract void destroyApp(boolean unconditional) throws MIDletStateChangeException;

}