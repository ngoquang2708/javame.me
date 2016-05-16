package com.ngoquang2708.me.midp.lcdui;

public class StringItem extends Item {
	
	protected final javax.microedition.lcdui.StringItem nativeStringItem;
	
	StringItem(javax.microedition.lcdui.StringItem nativeStringItem) {
		super(nativeStringItem);
		this.nativeStringItem = (javax.microedition.lcdui.StringItem) getNativeItem();
	}

	public StringItem(String label, String text) {
		this(label, text, Item.PLAIN);
	}

	public StringItem(String label, String text, int appearanceMode) {
		this(new javax.microedition.lcdui.StringItem(label, text, appearanceMode));
	}

	public int getAppearanceMode() {
		return nativeStringItem.getAppearanceMode();
	}

	public Font getFont() {
		return Font.of(nativeStringItem.getFont());
	}

	public void setFont(Font font) {
		nativeStringItem.setFont(font.getNativeFont());
	}

	public void setPreferredSize(int width, int height) {
		nativeStringItem.setPreferredSize(width, height);
	}

	public String getText() {
		return nativeStringItem.getText();
	}

	public void setText(String text) {
		nativeStringItem.setText(text);
	}
}
