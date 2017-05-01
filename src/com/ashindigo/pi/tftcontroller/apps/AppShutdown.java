package com.ashindigo.pi.tftcontroller.apps;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.ashindigo.pi.tftcontroller.EnumRotate;
import com.ashindigo.pi.tftcontroller.IApplication;
import com.ashindigo.pi.tftcontroller.PiTFTControllerMain;

public class AppShutdown implements IApplication {
	
	static JFrame appFrame = new JFrame();
	JButton shutdown = new JButton("Shutdown");
	JButton restart = new JButton("Restart");
	JButton exit = new JButton("Quit");
	JButton shell = new JButton("<html><div style='text-align: center;'> Exit <br> to shell </html>");
	JButton back = new JButton("Back");

	@Override
	public void open() {
		appFrame.setLayout(null);
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Uncomment to make full screen
		// mainFrame.setUndecorated(true); // Removes window buttons
		appFrame.setVisible(true);
		
		rotate(PiTFTControllerMain.rotationMode);

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
	
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		appFrame.add(exit);

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

	@Override
	public void rotate(EnumRotate rotation) {
		if (rotation == EnumRotate.VERTICAL) {
			appFrame.setSize(320, 480);
			shutdown.setSize(90, 90);
			shutdown.setLocation(50, 50);
			restart.setSize(90, 90);
			restart.setLocation(160, 50);
			exit.setSize(90, 90);
			exit.setLocation(50, 160);
			shell.setSize(90, 90);
			shell.setLocation(160, 160);
			back.setLocation(100, 385);
			back.setSize(100, 40);
			
		} else if (rotation == EnumRotate.HORIZONTAL) {
			appFrame.setSize(480, 320);
			shutdown.setSize(90, 90);
			shutdown.setLocation(100, 50);
			restart.setSize(90, 90);
			restart.setLocation(260, 50);
			exit.setSize(90, 90);
			exit.setLocation(100, 160);
			shell.setSize(90, 90);
			shell.setLocation(260, 160);
			back.setLocation(190, 250);
			back.setSize(70, 30);
			
		}
		
	}

}
