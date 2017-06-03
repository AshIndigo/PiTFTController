package com.ashindigo.pi.tftcontroller.apps;

import javax.swing.JFrame;

import com.ashindigo.pi.tftcontroller.EnumRotate;
import com.ashindigo.pi.tftcontroller.IApplication;
import com.ashindigo.pi.tftcontroller.PiTFTControllerMain;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

public class AppConnectionManager implements IApplication {
	
	static JFrame appFrame = new JFrame();

	@Override
	public void open() {
		rotate(PiTFTControllerMain.rotationMode);
		appFrame.setVisible(true);
	}

	@Override
	public void exit() {
		appFrame.dispose();

	}

	@Override
	public String getName() {
		return "Network";
	}

	@Override
	public void rotate(EnumRotate rotation) {
		// TODO Auto-generated method stub

	}

}
