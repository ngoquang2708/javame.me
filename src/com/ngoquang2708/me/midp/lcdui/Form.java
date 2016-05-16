package com.ngoquang2708.me.midp.lcdui;

import com.ngoquang2708.me.midp.lcdui.impl.NativeItemStateListenerForwarder;

public class Form extends Screen {
	
	protected final javax.microedition.lcdui.Form nativeForm;
	
	Form(javax.microedition.lcdui.Form nativeForm) {
		super(nativeForm);
		this.nativeForm = (javax.microedition.lcdui.Form) getNativeDisplayable();
	}

	public Form(String title) {
		this(title, null);
	}

	public Form(String title, Item[] items) {
		this(new javax.microedition.lcdui.Form(title, Item.toNativeItemArray(items)));
	}
	
	public int append(Image img) {
		return nativeForm.append(img.getNativeImage());
	}
	
	public int append(Item item) {
		int itemIndex = nativeForm.append(item.getNativeItem());
		item.setParent(this);
		return itemIndex;
	}
	
	public int append(String str) {
		return nativeForm.append(str);
	}
	
	public void delete(int itemNum) {
		nativeForm.delete(itemNum);
	}
	
	public void deleteAll() {
		nativeForm.deleteAll();
	}
	
	public Item get(int itemNum) {
		return Item.of(nativeForm.get(itemNum));
	}
	
	public int getHeight() {
		return nativeForm.getHeight();
	}
	
	public int getWidth() {
		return nativeForm.getWidth();
	}
	
	public void insert(int itemNum, Item item) {
		nativeForm.insert(itemNum, item.getNativeItem());
	}
	
	public void set(int itemNum, Item item) {
		nativeForm.set(itemNum, item.getNativeItem());
	}
	
	public void setItemStateListener(ItemStateListener itemStateListener) {
		nativeForm.setItemStateListener(new NativeItemStateListenerForwarder(itemStateListener));
	}
	
	public int size() {
		return nativeForm.size();
	}
}