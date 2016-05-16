package com.ngoquang2708.me.midp.lcdui.impl;

import com.ngoquang2708.me.midp.lcdui.Item;
import com.ngoquang2708.me.midp.lcdui.ItemStateListener;

public class NativeItemStateListenerForwarder implements
		javax.microedition.lcdui.ItemStateListener {

	private final ItemStateListener itemStateListener;

	public NativeItemStateListenerForwarder(ItemStateListener itemStateListener) {
		if ((this.itemStateListener = itemStateListener) == null)
			throw new NullPointerException();
	}

	public void itemStateChanged(javax.microedition.lcdui.Item item) {
		itemStateListener.itemStateChanged(Item.of(item));
	}
}
