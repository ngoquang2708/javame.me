package com.ngoquang2708.me.appmanager;

import java.io.Reader;

import javax.microedition.lcdui.List;

import com.ngoquang2708.me.midp.midlet.MIDlet;
import com.ngoquang2708.util.Strings;

/*
 * TODO
 *  - Implement JAD-style for listing and launching MIDlets
 *  - ...
 */
public final class ApplicationLauncher {
	
	private static volatile boolean isStarted = false;
	
	private ApplicationLauncher() { }

	public static void start(javax.microedition.midlet.MIDlet hostMIDlet) {
		if (!isStarted) {
			synchronized (ApplicationLauncher.class) {
				if (!isStarted) {
					ApplicationManager.init(hostMIDlet);
					// TODO
					isStarted = true;
				}
			}
		}
	}
	
	static class MIDletList extends List {

		public MIDletList(String title, int listType) {
			super(title, listType);
		}
	}
	
	static class MIDletInfo {
		String name;
		String icon;
		MIDlet midlet;

		MIDletInfo() { }

		static MIDletInfo parseString(String line) {
			MIDletInfo result = new MIDletInfo();
			String[] parts = Strings.split(line, ',');
			result.name = parts[0];
			result.icon = parts[1];
			try {
				result.midlet = ApplicationManager.getMIDlet(parts[2]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
		
		static MIDletInfo parseStream(Reader reader) {
			return null; // TODO
		}
	}
}