package com.ngoquang2708.me.midp.lcdui;

public class ImageItem extends Item {

	public static final int LAYOUT_DEFAULT = 0;

	public static final int LAYOUT_LEFT = 1;

	public static final int LAYOUT_RIGHT = 2;

	public static final int LAYOUT_CENTER = 3;

	public static final int LAYOUT_NEWLINE_BEFORE = 0x100;

	public static final int LAYOUT_NEWLINE_AFTER = 0x200;
	
	protected final javax.microedition.lcdui.ImageItem nativeImageItem;
	
	ImageItem(javax.microedition.lcdui.ImageItem nativeImageItem) {
		super(nativeImageItem);
		this.nativeImageItem = (javax.microedition.lcdui.ImageItem) getNativeItem();
	}

	public ImageItem(String label, Image img, int layout, String altText) {
		this(label, img, layout, altText, Item.PLAIN);
	}

	public ImageItem(String label, Image img, int layout, String altText, int appearanceMode) {
		this(new javax.microedition.lcdui.ImageItem(label, img.getNativeImage(), layout, altText, appearanceMode));
	}

	public String getAltText() {
		return nativeImageItem.getAltText();
	}

	public int getAppearanceMode() {
		return nativeImageItem.getAppearanceMode();
	}

	public Image getImage() {
		return Image.of(nativeImageItem.getImage());
	}

	public int getLayout() {
		return nativeImageItem.getLayout();
	}

	public void setAltText(String text) {
		nativeImageItem.setAltText(text);
	}

	public void setImage(Image img) {
		nativeImageItem.setImage(img.getNativeImage());
	}

	public void setLayout(int layout) {
		nativeImageItem.setLayout(layout);
	}
}
