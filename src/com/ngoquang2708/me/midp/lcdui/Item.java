package com.ngoquang2708.me.midp.lcdui;

import java.util.Hashtable;

public abstract class Item {
	
	protected static final Hashtable nativeItemItemMap = new Hashtable();

	public static final int LAYOUT_DEFAULT = 0x0000;

	public static final int LAYOUT_LEFT = 0x0001;
	public static final int LAYOUT_RIGHT = 0x0002;
	public static final int LAYOUT_CENTER = 0x0003;

	public static final int LAYOUT_TOP = 0x0010;
	public static final int LAYOUT_BOTTOM = 0x0020;
	public static final int LAYOUT_VCENTER = 0x0030;

	public static final int LAYOUT_NEWLINE_BEFORE = 0x0100;
	public static final int LAYOUT_NEWLINE_AFTER = 0x0200;

	public static final int LAYOUT_SHRINK = 0x0400;
	public static final int LAYOUT_EXPAND = 0x0800;
	public static final int LAYOUT_VSHRINK = 0x1000;
	public static final int LAYOUT_VEXPAND = 0x2000;

	public static final int LAYOUT_2 = 0x4000;

	public static final int PLAIN = 0;
	public static final int HYPERLINK = 1;
	public static final int BUTTON = 2;
	
	protected javax.microedition.lcdui.Item nativeItem;
	
	protected Form parent;
		
	Item(javax.microedition.lcdui.Item nativeItem) {
		if ((this.nativeItem = nativeItem) == null)
			throw new NullPointerException();
		nativeItemItemMap.put(this.nativeItem, this);
	}

	public void addCommand(Command cmd) {
		nativeItem.addCommand(cmd.getNativeCommand());
	}

	public String getLabel() {
		return nativeItem.getLabel();
	}

	public int getLayout() {
		return nativeItem.getLayout();
	}

	public int getMinimumHeight() {
		return nativeItem.getMinimumHeight();
	}

	public int getMinimumWidth() {
		return nativeItem.getMinimumWidth();
	}

	public int getPreferredHeight() {
		return nativeItem.getPreferredHeight();
	}

	public int getPreferredWidth() {
		return nativeItem.getPreferredWidth();
	}

	public void notifyStateChanged() {
		nativeItem.notifyStateChanged();
	}

	public void removeCommand(Command cmd) {
		nativeItem.removeCommand(cmd.getNativeCommand());
	}

	public void setDefaultCommand(Command cmd) {
		nativeItem.setDefaultCommand(cmd.getNativeCommand());
	}

	public void setItemCommandListener(final ItemCommandListener itemCommandListener) {
		nativeItem.setItemCommandListener(new javax.microedition.lcdui.ItemCommandListener() {

			public void commandAction(javax.microedition.lcdui.Command cmd, javax.microedition.lcdui.Item item) {
				itemCommandListener.commandAction(Command.of(cmd), Item.of(item));
			}
		});
	}

	public void setLabel(String label) {
		nativeItem.setLabel(label);
	}

	public void setLayout(int layout) {
		nativeItem.setLayout(layout);
	}

	public void setPreferredSize(int width, int height) {
		nativeItem.setPreferredSize(width, height);
	}
	
	public javax.microedition.lcdui.Item getNativeItem() {
		return nativeItem;
	}
	
	void setParent(Form form) {
		if ((this.parent = form) == null)
			throw new NullPointerException();
	}
	
	Form getParent() {
		return parent;
	}
	
	public static Item of(javax.microedition.lcdui.Item nativeItem) {
		return (Item) nativeItemItemMap.get(nativeItem);
	}

	public static final javax.microedition.lcdui.Item[] toNativeItemArray(Item[] items) {
		if (items != null) {
			javax.microedition.lcdui.Item[] result = new javax.microedition.lcdui.Item[items.length];
			for (int i = 1; i < items.length; ++i)
				result[i] = items[i].getNativeItem();
		}
		return new javax.microedition.lcdui.Item[0];
	}
}