package com.ashindigo.pi.tftcontroller.apps;

import java.io.IOException;

import com.ashindigo.pi.tftcontroller.EnumRotate;
import com.ashindigo.pi.tftcontroller.IApplication;

public class AppRetropie implements IApplication {

	@Override
	public void open() {
		try {
			//Process proc0 = Runtime.getRuntime().exec("pkill x");
			Process proc = Runtime.getRuntime().exec("emulationstation");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void exit() {

	}

	@Override
	public String getName() {
		return "Retropie";
	}

	@Override
	public void rotate(EnumRotate rotation) {
		
	}

}
