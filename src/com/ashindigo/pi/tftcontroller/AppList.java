package com.ashindigo.pi.tftcontroller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.ashindigo.pi.tftcontroller.apps.AppShutdown;


public class AppList {

	public static ArrayList<Component> appList = new ArrayList<Component>();

	public static void setupList() {
		for (int i = 0; 24 > i; i++) {
			ButtonApp button1 = new ButtonApp("Test", new AppShutdown());
			button1.setSize(61, 61);
			//button1.setFont(new Font(button1.getFont().getFontName(), Font.PLAIN, 8)); TODO Mess with sizing or add tap hold to view name
			button1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					((ButtonApp) e.getSource()).app.open();
				}
			});
			appList.add(button1);
		}
	}

}
