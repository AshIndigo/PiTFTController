package com.ashindigo.pi.tftcontroller.apps;

import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.ashindigo.pi.tftcontroller.EnumRotate;
import com.ashindigo.pi.tftcontroller.IApplication;
import com.hopding.jrpicam.RPiCamera;
import com.hopding.jrpicam.exceptions.FailedToRunRaspistillException;

// WIP for now
public class AppCamera implements IApplication {

	JFrame appFrame = new JFrame();
	RPiCamera camera;

	@Override
	public void open() {
		try {
			camera = new RPiCamera();
			appFrame.setSize(320, 480);
			appFrame.setLayout(null);
			JLabel label = new JLabel(new ImageIcon(camera.takeBufferedStill()));
			label.setBounds(0, 0, 100, 100);
			appFrame.add(label);
		} catch (FailedToRunRaspistillException | IOException | InterruptedException e) {
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

	@Override
	public void rotate(EnumRotate rotation) {
		// TODO Auto-generated method stub
		
	}

}
