package com.ashindigo.pi.tftcontroller.apps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.ashindigo.pi.tftcontroller.EnumRotate;
import com.ashindigo.pi.tftcontroller.IApplication;
import com.ashindigo.pi.tftcontroller.PiTFTControllerMain;

public class AppPhone implements IApplication {

	JFrame appFrame = new JFrame();
	JTextField text = new JTextField();
	JButton exit = new JButton("Exit");
	JButton call = new JButton("Call");
	JButton delete = new JButton("Delete");
	ArrayList<JButton> numButtons = new ArrayList<JButton>();

	@Override
	public void open() {
		appFrame.setLayout(null);
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Uncomment to make full screen
		// mainFrame.setUndecorated(true); // Removes window buttons
		appFrame.setVisible(true);
		text.setEditable(false);
		appFrame.add(text);
		
		int i = 1;
		for (int x = 0; 3 > x; x++) {
			for (int y = 0; 3 > y; y++) {
				JButton button = new JButton(Integer.toString(i));
				appFrame.add(button);
				button.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						text.setText(text.getText() + ((JButton) e.getSource()).getText());
					}
				});
				i++;
				numButtons.add(button);
			}
		}
		
		rotate(PiTFTControllerMain.rotationMode);
		
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		appFrame.add(exit);
		
		call.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				call(text.getText());
			}
		});
		appFrame.add(call);
		
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (text.getText().length() != 0) {
					text.setText(text.getText().substring(0, text.getText().length() - 1));
				}
			}
		});
		appFrame.add(delete);
	}

	protected void call(String text) {
		// TODO Add dial
	}

	@Override
	public void exit() {
		appFrame.dispose();
	}

	@Override
	public String getName() {
		return "Phone";
	}

	@Override
	public void rotate(EnumRotate rotation) {
		if (rotation == EnumRotate.VERTICAL) {
			appFrame.setSize(320, 480);
			text.setLocation(10, 10);
			text.setSize(280, 70);
			exit.setLocation(100, 385);
			exit.setSize(100, 40);
			call.setLocation(0, 385);
			call.setSize(100, 40);
			delete.setLocation(200, 385);
			delete.setSize(100, 40);
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
			text.setLocation(10, 10);
			text.setSize(440, 70);
			call.setLocation(0, 235);
			call.setSize(160, 30);
			exit.setLocation(160, 235);
			exit.setSize(160, 30);
			delete.setLocation(320, 235); // Goes off screen
			delete.setSize(160, 30); 
			int i = 0;
			for (int x = 0; 3 > x; x++) {
				for (int y = 0; 3 > y; y++) {
					numButtons.get(i).setSize(50, 50);
					numButtons.get(i).setLocation((50 * y) + 165, (50 * x) + 85);
					i++;
					// Call Exit Delete
				}
			}
		}
	}

}
