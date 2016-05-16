package com.ngoquang2708.me.midp.lcdui;

import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;

public class Image {
	
	private static final Hashtable map = new Hashtable();
	
	protected final javax.microedition.lcdui.Image nativeImage;
	
	protected final Graphics graphics;
	
	protected String resourceName;
	
	Image(javax.microedition.lcdui.Image nativeImage) {
		if ((this.nativeImage = nativeImage) == null)
			throw new NullPointerException();
		this.resourceName = null;
		this.graphics = this.nativeImage.isMutable() ? new Graphics(this.nativeImage.getGraphics()) : null;
	}
	
	Image(String resourceName, javax.microedition.lcdui.Image  nativeImage) {
		this(nativeImage);
		this.resourceName = resourceName;
	}

	public Graphics getGraphics() throws IllegalStateException {
		if (graphics == null)
			throw new IllegalStateException();
		return graphics;
	}

	public int getHeight() {
		return nativeImage.getHeight();
	}

	public int getWidth() {
		return nativeImage.getWidth();
	}

	public boolean isMutable() {
		return nativeImage.isMutable();
	}

	public void getRGB(int[] rgbData, int offset, int scanlength, int x, int y, int width, int height) {
		nativeImage.getRGB(rgbData, offset, scanlength, x, y, width, height);
	}

	public javax.microedition.lcdui.Image getNativeImage() {
		return nativeImage;
	}
	
	public static Image createImage(InputStream stream) throws IOException {
		return new Image(javax.microedition.lcdui.Image.createImage(stream));
	}

	public static Image createImage(Image image, int x, int y, int width, int height, int transform) {
		return new Image(javax.microedition.lcdui.Image.createImage(image.getNativeImage(), x, y, width, height, transform));
	}

	public static Image createRGBImage(int[] rgb, int width, int height, boolean processAlpha) {
		return new Image(javax.microedition.lcdui.Image.createRGBImage(rgb, width, height, processAlpha));
	}
	
	public static Image createImage(int width, int height) {
		return new Image(javax.microedition.lcdui.Image.createImage(width, height));
	}

	public static Image createImage(Image source) {
		return Image.of(source.getNativeImage());
	}

	public static Image createImage(byte[] imageData, int imageOffset,int imageLength) {
		return new Image(javax.microedition.lcdui.Image.createImage(imageData, imageOffset, imageLength));
	}
	
	public static Image createImage(String resourceName) throws IOException {
		Image result;
		if ((result = (Image) map.get(resourceName)) == null) {
			synchronized (map) {
				if ((result = (Image) map.get(resourceName)) == null) {
					result = new Image(resourceName, javax.microedition.lcdui.Image.createImage(resourceName));
					map.put(resourceName, result);
				}
			}
		}
		return result;
	}

	public static Image of(javax.microedition.lcdui.Image nativeImage) {
		Image result;
		if ((result = (Image) map.get(nativeImage)) == null) {
			synchronized (map) {
				if ((result = (Image) map.get(nativeImage)) == null) {
					result = new Image(nativeImage);
					map.put(nativeImage, result);
				}
			}
		}
		return result;
	}

	public static javax.microedition.lcdui.Image[] toNativeImageArray(Image[] images) {
		if (images != null) {
			javax.microedition.lcdui.Image[] result = new javax.microedition.lcdui.Image[images.length];
			for (int i = 0; i < images.length; ++i)
				result[i] = images[i].getNativeImage();
			return result;
		}
		return new javax.microedition.lcdui.Image[0];
	}
}