package com.ashindigo.pi.tftcontroller.apps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.management.ManagementFactory;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import com.ashindigo.pi.tftcontroller.IApplication;
import com.sun.management.OperatingSystemMXBean;

public class AppStatus implements IApplication {
	
	JFrame appFrame = new JFrame();
	static JProgressBar memBar = new JProgressBar();
	static JLabel memLabel = new JLabel();
	static JProgressBar cpuBar = new JProgressBar();
	static JLabel cpuLabel = new JLabel();
	static JProgressBar diskBar = new JProgressBar();
	static JLabel diskLabel = new JLabel();
	static JProgressBar heatBar = new JProgressBar();
	static JLabel heatLabel = new JLabel();
	static OperatingSystemMXBean os = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

	@Override
	public void open() {
		appFrame.setLayout(null);
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Uncomment to make full screen
		// mainFrame.setUndecorated(true); // Removes window buttons
		appFrame.setSize(320, 480);
		appFrame.setVisible(true);
		memBar.setMinimum(0);
		memBar.setMaximum(Math.toIntExact((os.getTotalPhysicalMemorySize() / 1000000)));
		memBar.setLocation(10, 10);
		memBar.setSize(280, 50);
		memLabel.setSize(280, 50);
		memLabel.setHorizontalAlignment(JLabel.CENTER);
		memLabel.setVerticalAlignment(JLabel.CENTER);
		memBar.add(memLabel);
		appFrame.add(memBar);
		cpuBar.setMinimum(0);
		cpuBar.setMaximum(100);
		cpuBar.setLocation(10, 70);
		cpuBar.setSize(280, 50);
		cpuLabel.setSize(280, 50);
		cpuLabel.setHorizontalAlignment(JLabel.CENTER);
		cpuLabel.setVerticalAlignment(JLabel.CENTER);
		cpuBar.add(cpuLabel);
		appFrame.add(cpuBar);
		diskBar.setMinimum(0);
		diskBar.setMaximum(Math.toIntExact(new File("/").getTotalSpace() / 1000000));
		diskBar.setLocation(10, 130);
		diskBar.setSize(280, 50);
		diskLabel.setSize(280, 50);
		diskLabel.setHorizontalAlignment(JLabel.CENTER);
		diskLabel.setVerticalAlignment(JLabel.CENTER);
		diskBar.add(diskLabel);
		appFrame.add(diskBar);
		heatBar.setMinimum(0);
		heatBar.setMaximum(85);
		heatBar.setLocation(10, 190);
		heatBar.setSize(280, 50);
		heatLabel.setSize(280, 50);
		heatLabel.setHorizontalAlignment(JLabel.CENTER);
		heatLabel.setVerticalAlignment(JLabel.CENTER);
		heatBar.add(heatLabel);
		appFrame.add(heatBar);
		// Insert network speed
		// Insert uptime
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
		
	}

	@Override
	public void exit() {
		appFrame.dispose();
	}	

}