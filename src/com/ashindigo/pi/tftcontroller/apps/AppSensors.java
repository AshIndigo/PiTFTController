package com.ashindigo.pi.tftcontroller.apps;

import javax.swing.JFrame;

import com.ashindigo.pi.tftcontroller.EnumRotate;
import com.ashindigo.pi.tftcontroller.IApplication;
import com.ashindigo.pi.tftcontroller.PiTFTControllerMain;

public class AppSensors implements IApplication {

	JFrame appFrame = new JFrame();

	@Override
	public void open() {
		appFrame.setLayout(null);
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if (PiTFTControllerMain.fullScreen) {
			appFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			appFrame.setUndecorated(true); 
		}
		rotate(PiTFTControllerMain.rotationMode);
	}

	@Override
	public void exit() {
		appFrame.dispose();

	}

	@Override
	public String getName() {
		return "Sensors";
	}

	@Override
	public void rotate(EnumRotate rotation) {
		if (rotation == EnumRotate.VERTICAL) {
			appFrame.setSize(320, 480);

		} else if (rotation == EnumRotate.HORIZONTAL) {
			appFrame.setSize(480, 320);

		}
	}
}
