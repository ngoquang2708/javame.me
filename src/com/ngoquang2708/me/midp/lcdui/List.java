package com.ngoquang2708.me.midp.lcdui;

public class List extends Screen {

    public static final Command SELECT_COMMAND = Command.of(javax.microedition.lcdui.List.SELECT_COMMAND);
    
    protected final javax.microedition.lcdui.List nativeList;
    
    List(javax.microedition.lcdui.List nativeList) {
    	super(nativeList);
    	this.nativeList = (javax.microedition.lcdui.List) getNativeDisplayable();
    }

    public List(String title, int listType) {
    	this(new javax.microedition.lcdui.List(title, listType));
    }

    public List(String title, int listType, String[] stringElements, Image[] imageElements) {
    	this(new javax.microedition.lcdui.List(title, listType, stringElements, Image.toNativeImageArray(imageElements)));
    }

    public int append(String stringPart, Image imagePart) {
    	return nativeList.append(stringPart, imagePart.getNativeImage());
    }

    public void delete(int elementNum) {
    	nativeList.delete(elementNum);
    }

    public void deleteAll() {
    	nativeList.deleteAll();
    }

    public int getFitPolicy() {
    	return nativeList.getFitPolicy();
    }

    public Font getFont(int elementNum) {
    	return Font.of(nativeList.getFont(elementNum));
    }

    public Image getImage(int elementNum) {
    	return Image.of(nativeList.getImage(elementNum));
    }

    public int getSelectedFlags(boolean[] selectedArray_return) {
    	return nativeList.getSelectedFlags(selectedArray_return);
    }

    public int getSelectedIndex() {
    	return nativeList.getSelectedIndex();
    }

    public String getString(int elementNum) {
    	return nativeList.getString(elementNum);
    }

    public void insert(int elementNum, String stringPart, Image imagePart) {
    	nativeList.insert(elementNum, stringPart, imagePart.getNativeImage());
    }

    public boolean isSelected(int elementNum) {
    	return nativeList.isSelected(elementNum);
    }

    public void removeCommand(Command cmd) {
    	nativeList.removeCommand(cmd.getNativeCommand());
    }

    public void set(int elementNum, String stringPart, Image imagePart) {
    	nativeList.set(elementNum, stringPart, imagePart.getNativeImage());
    }

    public void setFitPolicy(int policy) {
    	nativeList.setFitPolicy(policy);
    }

    public void setFont(int elementNum, Font font) {
    	nativeList.setFont(elementNum, font.getNativeFont());
    }

    public void setSelectCommand(Command command) {
    	nativeList.setSelectCommand(command.getNativeCommand());
    }

    public void setSelectedFlags(boolean[] selectedArray) {
    	nativeList.setSelectedFlags(selectedArray);
    }

    public void setSelectedIndex(int elementNum, boolean selected) {
    	nativeList.setSelectedIndex(elementNum, selected);
    }

    public void setTicker(Ticker ticker) {
    	super.setTicker(ticker);
    }

    public void setTitle(String s) {
    	super.setTitle(s);
    }
    
    public int size() {
    	return nativeList.size();
    }
    
    public javax.microedition.lcdui.List getNativeList() {
    	return nativeList;
    }
}
