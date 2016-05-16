package com.ngoquang2708.me.midp.lcdui;

public class TextBox extends Screen {
	
	protected final javax.microedition.lcdui.TextBox nativeTextBox;
	
	TextBox(javax.microedition.lcdui.TextBox nativeTextBox) {
		super(nativeTextBox);
		this.nativeTextBox = (javax.microedition.lcdui.TextBox) getNativeDisplayable();
	}

	public TextBox(String title, String text, int maxSize, int constraints) {
		this(new javax.microedition.lcdui.TextBox(title, text, maxSize, constraints));
	}

	public void delete(int offset, int length) {
		nativeTextBox.delete(offset, length);
	}

	public int getCaretPosition() {
		return nativeTextBox.getCaretPosition();
	}

	public int getChars(char[] data) {
		return nativeTextBox.getChars(data);
	}

	public int getConstraints() {
		return nativeTextBox.getConstraints();
	}

	public int getMaxSize() {
		return nativeTextBox.getMaxSize();
	}

	public String getString() {
		return nativeTextBox.getString();
	}

	public void insert(char[] data, int offset, int length, int position) {
		nativeTextBox.insert(data, offset, length, position);
	}

	public void insert(String src, int position) {
		nativeTextBox.insert(src, position);
	}

	public void setChars(char[] data, int offset, int length) {
		nativeTextBox.setChars(data, offset, length);
	}

	public void setConstraints(int constraints) {
		nativeTextBox.setConstraints(constraints);
	}

	public void setInitialInputMode(String characterSubset) {
		nativeTextBox.setInitialInputMode(characterSubset);
	}

	public int setMaxSize(int maxSize) {
		return nativeTextBox.getMaxSize();
	}

	public void setString(String text) {
		nativeTextBox.setString(text);
	}
	
	public void setTicker(Ticker ticker) {
		nativeTextBox.setTicker(ticker.getNativeTicker());
	}
	
	public void setTitle(String s) {
		nativeTextBox.setTitle(s);
	}

	public int size() {
		return nativeTextBox.size();
	}

	public String toString() {
		return "TextBox [nativeTextBox=" + nativeTextBox + "]";
	}
}