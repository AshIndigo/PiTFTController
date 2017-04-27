package com.ashindigo.pi.tftcontroller.apps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		// mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Uncomment to make full screen
		// mainFrame.setUndecorated(true); // Removes window buttons
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
				button.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						text.setText(text.getText() + ((JButton) e.getSource()).getText());
					}
				});
				i++;
			}
		}
		JButton exit = new JButton("Exit");
		exit.setLocation(100, 385);
		exit.setSize(100, 40);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		appFrame.add(exit);
		
		JButton call = new JButton("Call");
		call.setLocation(0, 385);
		call.setSize(100, 40);
		call.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				call(text.getText());
			}
		});
		appFrame.add(call);
		
		JButton delete = new JButton("Delete");
		delete.setLocation(200, 385);
		delete.setSize(100, 40);
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

}
