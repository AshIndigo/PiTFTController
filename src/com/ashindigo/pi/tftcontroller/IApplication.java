package com.ashindigo.pi.tftcontroller;

public interface IApplication {

	public void open();
	
	public void exit();
	
	public String getName();
	
	public void rotate(EnumRotate rotation);
}
