package com.ngoquang2708.me.midp.lcdui.impl;

public interface CanvasAccessor {

	void callKeyPressed(int keyCode);

	void callKeyReleased(int keyCode);

	void callKeyRepeated(int keyCode);

	void callPointerDragged(int x, int y);

	void callPointerPressed(int x, int y);

	void callPointerReleased(int x, int y);
	
	void callSizeChanged(int w, int h);
	
	void callHideNotify();
	
	void callShowNotify();

}
