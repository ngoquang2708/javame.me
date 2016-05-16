package com.ngoquang2708.me.midp.lcdui.impl;

import com.ngoquang2708.me.midp.lcdui.Command;
import com.ngoquang2708.me.midp.lcdui.Item;
import com.ngoquang2708.me.midp.lcdui.ItemCommandListener;

public class NativeItemCommandListenerForwarder implements
		javax.microedition.lcdui.ItemCommandListener {

	private final ItemCommandListener itemCommandListener;

	public NativeItemCommandListenerForwarder(
			ItemCommandListener itemCommandListener) {
		if ((this.itemCommandListener = itemCommandListener) == null)
			throw new NullPointerException();
	}

	public void commandAction(
			javax.microedition.lcdui.Command cmd,
			javax.microedition.lcdui.Item item) {
		itemCommandListener.commandAction(Command.of(cmd), Item.of(item));
	}
}
