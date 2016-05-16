package com.ngoquang2708.me.midp.lcdui;

public class TextField extends Item {
	
	public static final int ANY = javax.microedition.lcdui.TextField.ANY;
	public static final int EMAILADDR = javax.microedition.lcdui.TextField.EMAILADDR;
	public static final int NUMERIC = javax.microedition.lcdui.TextField.NUMERIC;
	public static final int PHONENUMBER = javax.microedition.lcdui.TextField.PHONENUMBER;
	public static final int URL = javax.microedition.lcdui.TextField.URL;	
	public static final int DECIMAL = javax.microedition.lcdui.TextField.DECIMAL;

	public static final int PASSWORD = javax.microedition.lcdui.TextField.PASSWORD;
	public static final int UNEDITABLE = javax.microedition.lcdui.TextField.UNEDITABLE;
	public static final int SENSITIVE = javax.microedition.lcdui.TextField.SENSITIVE;
	public static final int NON_PREDICTIVE = javax.microedition.lcdui.TextField.NON_PREDICTIVE;
	public static final int INITIAL_CAPS_WORD = javax.microedition.lcdui.TextField.INITIAL_CAPS_WORD;
	public static final int INITIAL_CAPS_SENTENCE = javax.microedition.lcdui.TextField.INITIAL_CAPS_SENTENCE;
	
	public static final int CONSTRAINT_MASK = javax.microedition.lcdui.TextField.CONSTRAINT_MASK;
	
	protected final javax.microedition.lcdui.TextField nativeTextField;
	
	TextField(javax.microedition.lcdui.TextField nativeTextField) {
		super(nativeTextField);
		this.nativeTextField = (javax.microedition.lcdui.TextField) getNativeItem();
	}
	
	public TextField(String label, String text, int maxSize, int constraints) {
		this(new javax.microedition.lcdui.TextField(label, text, maxSize, constraints));
	}

	public String getString() {
		return nativeTextField.getString();
	}

	public void setString(String text) {
		nativeTextField.setString(text);
	}

	public int getChars(char[] data) {
		return nativeTextField.getChars(data);
	}

	public void setChars(char[] data, int offset, int length) {
		nativeTextField.setChars(data, offset, length);
	}

	public void insert(String src, int position) {
		nativeTextField.insert(src, position);
	}

	public void insert(char[] data, int offset, int length, int position) {
		nativeTextField.insert(data, offset, length, position);
	}

	public void delete(int offset, int length) {
		nativeTextField.delete(offset, length);
	}

	public int getMaxSize() {
		return nativeTextField.getMaxSize();
	}

	public int setMaxSize(int maxSize) {
		return nativeTextField.setMaxSize(maxSize);
	}

	public int size() {
		return nativeTextField.size();
	}

	public int getCaretPosition() {
		return nativeTextField.getCaretPosition();
	}

	public void setConstraints(int constraints) {
		nativeTextField.setConstraints(constraints);
	}

	public int getConstraints() {
		return nativeTextField.getConstraints();
	}

	public void setInitialInputMode(String characterSubset) {
		nativeTextField.setInitialInputMode(characterSubset);
	}
}
