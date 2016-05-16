package com.ngoquang2708.me.midp.lcdui;

public class ChoiceGroup extends Item implements Choice {
	
	protected final javax.microedition.lcdui.ChoiceGroup nativeChoiceGroup;
	
	ChoiceGroup(javax.microedition.lcdui.ChoiceGroup nativeChoiceGroup) {
		super(nativeChoiceGroup);
		this.nativeChoiceGroup = (javax.microedition.lcdui.ChoiceGroup) getNativeItem();
	}

	public ChoiceGroup(String label, int choiceType) {
		this(new javax.microedition.lcdui.ChoiceGroup(label, choiceType));
	}

	public ChoiceGroup(String label, int choiceType, String[] stringElements, Image[] imageElements) {
		this(new javax.microedition.lcdui.ChoiceGroup(label, choiceType, stringElements, Image.toNativeImageArray(imageElements)));
	}

	public int append(String stringPart, Image imagePart) {
		return nativeChoiceGroup.append(stringPart, imagePart == null ? null : imagePart.getNativeImage());
	}

	public void delete(int itemNum) {
		nativeChoiceGroup.delete(itemNum);
	}

	public void deleteAll() {
		nativeChoiceGroup.deleteAll();
	}

	public int getFitPolicy() {
		return nativeChoiceGroup.getFitPolicy();
	}

	public Font getFont(int itemNum) {
		return Font.of(nativeChoiceGroup.getFont(itemNum));
	}

	public Image getImage(int elementNum) {
		return Image.of(nativeChoiceGroup.getImage(elementNum));
	}
	
	public int getSelectedFlags(boolean[] selectedArray_return) {
		return nativeChoiceGroup.getSelectedFlags(selectedArray_return);
	}

	public int getSelectedIndex() {
		return nativeChoiceGroup.getSelectedIndex();
	}

	public String getString(int elementNum) {
		return nativeChoiceGroup.getString(elementNum);
	}

	public void insert(int elementNum, String stringPart, Image imagePart) {
		nativeChoiceGroup.insert(elementNum, stringPart, imagePart.getNativeImage());
	}

	public boolean isSelected(int elementNum) {
		return nativeChoiceGroup.isSelected(elementNum);
	}

	public void set(int elementNum, String stringPart, Image imagePart) {
		nativeChoiceGroup.set(elementNum, stringPart, imagePart.getNativeImage());
	}

	public void setFitPolicy(int policy) {
		nativeChoiceGroup.setFitPolicy(policy);
	}

	public void setFont(int itemNum, Font font) {
		nativeChoiceGroup.setFont(itemNum, font.getNativeFont());
	}

	public void setSelectedFlags(boolean[] selectedArray) {
		nativeChoiceGroup.setSelectedFlags(selectedArray);
	}

	public void setSelectedIndex(int elementNum, boolean selected) {
		nativeChoiceGroup.setSelectedIndex(elementNum, selected);
	}

	public int size() {
		return nativeChoiceGroup.size();
	}

	public javax.microedition.lcdui.Choice getNativeChoice() {
		return nativeChoiceGroup;
	}
}