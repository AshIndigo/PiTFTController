package com.ashindigo.pi.tftcontroller.apps;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.ashindigo.pi.tftcontroller.IApplication;

public class AppPhone implements IApplication {

	JFrame appFrame = new JFrame();

	@Override
	public void open() {
		appFrame.setLayout(null);
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Uncomment to make full screen
		//mainFrame.setUndecorated(true); // Removes window buttons
		appFrame.setSize(320, 480);
		appFrame.setVisible(true);
		JTextField text = new JTextField();
		text.setEditable(false);
		text.setLocation(10, 10);
		text.setSize(280, 70);
		appFrame.add(text);
		int i = 1;
		for (int x = 0; 3 > x; x++) {
			for (int y = 0; 3 > y; y++) {
				JButton button = new JButton(Integer.toString(i));
				button.setSize(100, 100);
				button.setLocation(100 * y, (100 * x) + 85);
				appFrame.add(button);
				i++;
			}
		}
	}

	@Override
	public void exit() {
		appFrame.setVisible(false);
	}

}
