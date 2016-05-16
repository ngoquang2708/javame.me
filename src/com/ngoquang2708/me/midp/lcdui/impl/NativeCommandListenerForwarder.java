package com.ngoquang2708.me.midp.lcdui.impl;

import com.ngoquang2708.me.midp.lcdui.Command;
import com.ngoquang2708.me.midp.lcdui.CommandListener;
import com.ngoquang2708.me.midp.lcdui.Displayable;

public class NativeCommandListenerForwarder implements
		javax.microedition.lcdui.CommandListener {

	private final CommandListener commandListener;

	public NativeCommandListenerForwarder(CommandListener commandListener) {
		if ((this.commandListener = commandListener) == null)
			throw new NullPointerException();
	}

	public void commandAction(
			javax.microedition.lcdui.Command cmd,
			javax.microedition.lcdui.Displayable d) {
		commandListener.commandAction(Command.of(cmd), Displayable.of(d));
	}
}
