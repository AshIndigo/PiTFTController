package com.ashindigo.pi.tftcontroller.apps;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.ashindigo.pi.tftcontroller.IApplication;

public class AppShutdown implements IApplication {
	
	static JFrame appFrame = new JFrame();

	@Override
	public void open() {
		appFrame.setLayout(null);
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Uncomment to make full screen
		// mainFrame.setUndecorated(true); // Removes window buttons
		appFrame.setSize(320, 480);
		appFrame.setVisible(true);
		JButton shutdown = new JButton("Shutdown");
		shutdown.setSize(90, 90);
		shutdown.setLocation(50, 50);
		shutdown.setMargin(new Insets(0,0,0,0));
		shutdown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime.getRuntime().exec("sudo shutdown -h now");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		appFrame.add(shutdown);
		JButton restart = new JButton("Restart");
		restart.setSize(90, 90);
		restart.setLocation(160, 50);
		restart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime.getRuntime().exec("sudo reboot");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		appFrame.add(restart);
		JButton exit = new JButton("Quit");
		exit.setSize(90, 90);
		exit.setLocation(50, 160);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		appFrame.add(exit);
		JButton shell = new JButton("<html><div style='text-align: center;'> Exit <br> to shell </html>");
		shell.setSize(90, 90);
		shell.setLocation(160, 160);
		shell.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime.getRuntime().exec("pkill x");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		appFrame.add(shell);
		JButton back = new JButton("Back");
		back.setLocation(100, 385);
		back.setSize(100, 40);
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		appFrame.add(back);

	}

	@Override
	public void exit() {
		appFrame.dispose();
	}

	@Override
	public String getName() {
		return "Power";
	}

}
