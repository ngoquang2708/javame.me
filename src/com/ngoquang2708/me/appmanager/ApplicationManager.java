package com.ngoquang2708.me.appmanager;

import java.util.Hashtable;
import java.util.Vector;

import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.midlet.MIDletStateChangeException;

import com.ngoquang2708.me.midp.lcdui.Alert;
import com.ngoquang2708.me.midp.lcdui.Display;
import com.ngoquang2708.me.midp.lcdui.Displayable;
import com.ngoquang2708.me.midp.midlet.MIDlet;


public final class ApplicationManager {

	private static javax.microedition.midlet.MIDlet hostMidlet;
	private static javax.microedition.lcdui.Display hostDisplay;
	private static Hashtable packageMidletMap;
	private static Hashtable nameMidletMap;
	private static Hashtable midletDisplayMap;
	private static Hashtable displayMidletMap;
	private static Hashtable midletAppPropertiesMap;
	private static Hashtable midletThreadsMap;
	private static Display currentDisplay;
	private static OverlayDisplay overlayDisplay;

	private ApplicationManager() {
		throw new RuntimeException();
	}

	public static synchronized void init(javax.microedition.midlet.MIDlet hostMidlet) {
		if (ApplicationManager.hostMidlet != null)
			throw new IllegalStateException();
		if ((ApplicationManager.hostMidlet = hostMidlet) == null)
			throw new NullPointerException();
		ApplicationManager.hostDisplay = javax.microedition.lcdui.Display.getDisplay(ApplicationManager.hostMidlet);
		ApplicationManager.midletDisplayMap = new Hashtable();
		ApplicationManager.displayMidletMap = new Hashtable();
		ApplicationManager.midletAppPropertiesMap = new Hashtable();
		ApplicationManager.midletThreadsMap = new Hashtable();
		ApplicationManager.packageMidletMap = new Hashtable();
		ApplicationManager.nameMidletMap = new Hashtable();
		ApplicationManager.overlayDisplay = new OverlayDisplay() { };
	}

	public static boolean platformRequest(MIDlet midlet, String url) throws ConnectionNotFoundException {
		return hostMidlet.platformRequest(url);
	}

	public static int checkPermission(MIDlet midlet, String permission) {
		return hostMidlet.checkPermission(permission);
	}

	public static void resumeRequest(MIDlet midlet) {
	}

	public static void notifyPaused(MIDlet midlet) {
		midlet.pauseApp();
	}

	public static Display getDisplay(MIDlet midlet) {
		Display display;
		if ((display = (Display) midletDisplayMap.get(midlet)) == null) {
			synchronized (midletDisplayMap) {
				if ((display = (Display) midletDisplayMap.get(midlet)) == null) {
					display = new Display();
					midletDisplayMap.put(midlet, display);
					displayMidletMap.put(display, midlet);
				}
			}
		}
		return display;
	}

	public static MIDlet getMIDlet(Display display) {
		MIDlet midlet = (MIDlet) displayMidletMap.get(display);
		if (midlet == null)
			throw new IllegalStateException();
		return midlet;
	}

	public static MIDlet getMIDlet(String className) throws Exception {
		MIDlet midlet;
		if ((midlet = (MIDlet) nameMidletMap.get(className)) == null) {
			synchronized (nameMidletMap) {
				if ((midlet = (MIDlet) nameMidletMap.get(className)) == null) {
					midletThreadsMap.put(className, new Vector());
					midlet = (MIDlet) Class.forName(className).newInstance();
					nameMidletMap.put(className, midlet);
				}
			}
		}
		return midlet;
	}

	public static void refreshDisplay() {
		Display currentDisplay;
		if ((currentDisplay = getCurrentDisplay()) != null) {
			Displayable currentDisplayable;
			if ((currentDisplayable = currentDisplay.getCurrent()) instanceof Alert)
				getHostDisplay().setCurrent(
						currentDisplayable.asAlert(),
						currentDisplay.getNext().getNativeDisplayable());
			else
				getHostDisplay().setCurrent(currentDisplayable.getNativeDisplayable());
		}
	}

	public static Display getCurrentDisplay() {
		return currentDisplay;
	}

	public static void setCurrentDisplay(Display currentDisplay) {
		ApplicationManager.currentDisplay = currentDisplay;
		ApplicationManager.refreshDisplay();
	}

	public static String getAppProperty(String midletClassName, String name) {
		return (String) (getAppProperties(midletClassName)).get(name);
	}

	public static String getAppProperty(MIDlet midlet, String name) {
		return getAppProperty(midlet.getClass().getName(), name);
	}

	public static void setAppProperty(MIDlet midlet, String name, String value) {
		setAppProperty(midlet.getClass().getName(), name, value);
	}

	public static void setAppProperty(String midletClassName, String name, String value) {
		getAppProperties(midletClassName).put(name, value);
	}

	public static javax.microedition.lcdui.Display getHostDisplay() {
		return hostDisplay;
	}

	public static javax.microedition.midlet.MIDlet getHostMidlet() {
		return hostMidlet;
	}

	public static OverlayDisplay getOverlayDisplay() {
		return overlayDisplay;
	}

	public static void setOverlayDisplay(OverlayDisplay overlayDisplay) {
		if ((ApplicationManager.overlayDisplay = overlayDisplay) == null)
			throw new NullPointerException();
	}
	
	/*
	 * Resolves MIDlet instance base on Runnable object that in the same package
	 * as MIDlet class
	 */
	public static MIDlet resolveMIDlet(Runnable runnable) {
		String runnableClassName = runnable.getClass().getName();
		
		// TODO
		throw new RuntimeException();
	}
	
	public static void notifyNewThread(MIDlet midlet, Thread thread) {
		// TODO
		throw new RuntimeException();
	}
	
	public static void notifyDestroyed(MIDlet midlet) {
		// TODO terminates all of its threads
		try {
			// XXX remove me
			if (nameMidletMap.size() == 1)
				hostMidlet.notifyDestroyed();
			
			midlet.destroyApp(true);
		} catch (MIDletStateChangeException e) {
			e.printStackTrace();
		}
	}

	private static Hashtable getAppProperties(String midletClassName) {
		Hashtable properties;
		if ((properties = (Hashtable) midletAppPropertiesMap.get(midletClassName)) == null) {
			synchronized (midletAppPropertiesMap) {
				if ((properties = (Hashtable) midletAppPropertiesMap.get(midletClassName)) == null)
					midletAppPropertiesMap.put(midletClassName, (properties = new Hashtable()));
			}
		}
		return properties;
	}
}