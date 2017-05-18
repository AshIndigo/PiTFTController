package com.ashindigo.pi.tftcontroller.apps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

import com.ashindigo.pi.tftcontroller.EnumRotate;
import com.ashindigo.pi.tftcontroller.IApplication;
import com.ashindigo.pi.tftcontroller.PiTFTControllerMain;

public class AppIRC implements IApplication {
	
	static JFrame appFrame = new JFrame();
	static JTextField msgBox = new JTextField();
	public static JTextPane chatBox = new JTextPane();
	static JButton enterButton = new JButton();

	@Override
	public void open() {
			appFrame.setLayout(null);
			appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			appFrame.add(msgBox);
			appFrame.add(chatBox);
			appFrame.setVisible(true);
			chatBox.setEditable(false);
			enterButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					IRCThread.bot.sendIRC().message("#ashindigo", msgBox.getText());
					chatBox.setText(AppIRC.chatBox.getText() + "\n" + IRCThread.bot.getNick() + ": " + msgBox.getText());
					msgBox.setText("");
				}
			});
			appFrame.add(enterButton);
			SwingUtilities.getRootPane(enterButton).setDefaultButton(enterButton);
			rotate(PiTFTControllerMain.rotationMode);
			new Thread(new IRCThread()).start();;
	}

	@Override
	public void exit() {
		appFrame.dispose();
	}

	@Override
	public String getName() {
		return "IRC";
	}

	@Override
	public void rotate(EnumRotate rotation) {
		if (rotation == EnumRotate.VERTICAL) {
			appFrame.setSize(320, 480);
			msgBox.setLocation(10, 400);
			msgBox.setSize(280, 25);
			chatBox.setSize(280, 380);
			chatBox.setLocation(10, 10);
		} else if (rotation == EnumRotate.HORIZONTAL) {
			appFrame.setSize(480, 320);
			msgBox.setLocation(10, 10);
			msgBox.setSize(280, 50);
		}
	}
}
