package com.ashindigo.pi.tftcontroller.apps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.ashindigo.pi.tftcontroller.EnumRotate;
import com.ashindigo.pi.tftcontroller.IApplication;
import com.ashindigo.pi.tftcontroller.PiTFTControllerMain;

public class AppCalculator implements IApplication {
	
	JFrame appFrame = new JFrame();
	ArrayList<JButton> numButtons = new ArrayList<JButton>();

	@Override
	public void open() {
		appFrame.setLayout(null);
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if (PiTFTControllerMain.fullScreen) {
			appFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Uncomment to make full screen
			appFrame.setUndecorated(true); // Removes window buttons
		}
		int i = 1;
		for (int x = 0; 3 > x; x++) {
			for (int y = 0; 3 > y; y++) {
				JButton button = new JButton(Integer.toString(i));
				appFrame.add(button);
				button.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						//calcBox.setText(calcBox.getText() + ((JButton) e.getSource()).getText());
					}
				});
				i++;
				numButtons.add(button);
			}
		}
		rotate(PiTFTControllerMain.rotationMode);
		appFrame.setVisible(true);

	}

	@Override
	public void exit() {
		appFrame.dispose();

	}

	@Override
	public String getName() {
		return "Calc";
	}

	@Override
	public void rotate(EnumRotate rotation) {
		if (rotation == EnumRotate.VERTICAL) {
			appFrame.setSize(320, 480);
			int i = 0;
			for (int x = 0; 3 > x; x++) {
				for (int y = 0; 3 > y; y++) {
					numButtons.get(i).setSize(100, 100);
					numButtons.get(i).setLocation(100 * y, (100 * x) + 85);
					i++;
				}
			}
		} else if (rotation == EnumRotate.HORIZONTAL) {
			appFrame.setSize(480, 320);
			int i = 0;
			for (int x = 0; 3 > x; x++) {
				for (int y = 0; 3 > y; y++) {
					numButtons.get(i).setSize(50, 50);
					numButtons.get(i).setLocation((50 * y) + 310, (50 * x) + 85);
					i++;
				}
			}
		}
	}

}
