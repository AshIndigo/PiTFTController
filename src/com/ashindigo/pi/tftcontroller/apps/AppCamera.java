package com.ashindigo.pi.tftcontroller.apps;

import javax.swing.JFrame;

import com.ashindigo.pi.tftcontroller.IApplication;
import com.hopding.jrpicam.RPiCamera;
import com.hopding.jrpicam.exceptions.FailedToRunRaspistillException;

public class AppCamera implements IApplication {

	JFrame appFrame = new JFrame();
	RPiCamera camera;

	@Override
	public void open() {
		try {
			camera = new RPiCamera();
			camera.turnOnPreview();
		} catch (FailedToRunRaspistillException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void exit() {
		appFrame.dispose();
		camera.stop();
	}

	@Override
	public String getName() {
		return "Camera";
	}

}
