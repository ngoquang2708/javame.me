package com.ngoquang2708.me.appmanager;

import javax.microedition.midlet.MIDletStateChangeException;

public abstract class MIDletAccessor {
	
	protected MIDletAccessor() { }

	protected abstract void startApp() throws MIDletStateChangeException;

	protected abstract void pauseApp();

	protected abstract void destroyApp(boolean unconditional) throws MIDletStateChangeException;

}