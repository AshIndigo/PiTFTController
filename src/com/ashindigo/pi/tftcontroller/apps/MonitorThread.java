package com.ashindigo.pi.tftcontroller.apps;

import java.io.File;
import java.text.NumberFormat;

public class MonitorThread extends Thread {

	public void run() {
		File root = new File("/");
		this.setName("Monitor-Thread");
		//Process proc = null;
		//try {
		//	proc = Runtime.getRuntime().exec("vcgencmd measure_temp");
			//proc = Runtime.getRuntime().exec("write");
		//} catch (IOException e) {
			//e.printStackTrace();
		//}
		while (true) {
			AppStatus.memBar.setValue(Math.toIntExact(AppStatus.os.getTotalPhysicalMemorySize() / 1000000) - Math.toIntExact(AppStatus.os.getFreePhysicalMemorySize() / 1000000));
			AppStatus.memLabel.setText("<html><div style='text-align: center;'>Memory:" + "<br>" + NumberFormat.getPercentInstance().format(new Double(AppStatus.memBar.getPercentComplete())) + "<br>" + (Math.toIntExact(AppStatus.os.getTotalPhysicalMemorySize() / 1000000) - Math.toIntExact((AppStatus.os.getFreePhysicalMemorySize() / 1000000)) + "mb / " + (AppStatus.os.getTotalPhysicalMemorySize() / 1000000) + "mb </html>"));
			AppStatus.cpuBar.setValue((int) (AppStatus.os.getSystemCpuLoad() * 100));
			AppStatus.cpuLabel.setText("<html><div style='text-align: center;'> CPU: <br>" + (int) (AppStatus.os.getSystemCpuLoad() * 100) + "%");
			// Actually gets the entire disks size not just the current partition
			AppStatus.diskBar.setValue(Math.toIntExact(root.getTotalSpace() / 1000000) - Math.toIntExact(root.getUsableSpace() / 1000000));
			AppStatus.diskLabel.setText("<html><div style='text-align: center;'> Disk Space: <br>" + NumberFormat.getPercentInstance().format(new Double(AppStatus.diskBar.getPercentComplete())) + "<br>" + (Math.toIntExact(root.getTotalSpace() / 1000000) - Math.toIntExact(root.getUsableSpace() / 1000000)) + "mb / " + Math.toIntExact(root.getTotalSpace() / 1000000) + "mb");
			AppStatus.heatBar.setValue(50);
			AppStatus.heatLabel.setText("<html><div style='text-align: center;'> Temperature: <br>" + AppStatus.heatBar.getValue() + "C°");
		}
	}
}
