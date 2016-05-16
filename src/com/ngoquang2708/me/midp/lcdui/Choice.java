package com.ngoquang2708.me.midp.lcdui;

public interface Choice {

	static final int EXCLUSIVE = javax.microedition.lcdui.Choice.EXCLUSIVE;
	static final int MULTIPLE = javax.microedition.lcdui.Choice.MULTIPLE;
	static final int IMPLICIT = javax.microedition.lcdui.Choice.IMPLICIT;
	static final int POPUP = javax.microedition.lcdui.Choice.POPUP;

	static final int TEXT_WRAP_ON = javax.microedition.lcdui.Choice.TEXT_WRAP_ON;
	static final int TEXT_WRAP_OFF = javax.microedition.lcdui.Choice.TEXT_WRAP_OFF;
	static final int TEXT_WRAP_DEFAULT = javax.microedition.lcdui.Choice.TEXT_WRAP_DEFAULT;

	int append(String stringPart, Image imagePart);

	void delete(int elementNum);

	void deleteAll();

	int getFitPolicy();

	Font getFont(int elementNum);

	Image getImage(int elementNum);

	int getSelectedFlags(boolean[] selectedArray_return);

	int getSelectedIndex();

	String getString(int elementNum);

	void insert(int elementNum, String stringPart, Image imagePart);

	boolean isSelected(int elementNum);

	void set(int elementNum, String stringPart, Image imagePart);

	void setFitPolicy(int fitPolicy);

	void setFont(int elementNum, Font font);

	void setSelectedFlags(boolean[] selectedArray);

	void setSelectedIndex(int elementNum, boolean selected);

	int size();

	javax.microedition.lcdui.Choice getNativeChoice();

}