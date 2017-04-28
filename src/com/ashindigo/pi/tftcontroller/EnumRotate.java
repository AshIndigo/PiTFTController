package com.ashindigo.pi.tftcontroller;

public enum EnumRotate {
	VERTICAL(0),
	HORIZONTAL(1);
	
	public final int mode;
	
	EnumRotate(int mode) {
		this.mode = mode;
	}
}
