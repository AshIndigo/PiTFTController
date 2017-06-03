package com.ashindigo.pi.tftcontroller.apps;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Scanner;

public class MonitorThread extends Thread {

	public void run() {
		File root = new File("/");
		this.setName("Monitor-Thread");
		while (true) {
			AppStatus.memBar.setValue(Math.toIntExact(AppStatus.os.getTotalPhysicalMemorySize() / 1000000) - Math.toIntExact(AppStatus.os.getFreePhysicalMemorySize() / 1000000));
			AppStatus.memLabel.setText("<html><div style='text-align: center;'>Memory:" + "<br>" + NumberFormat.getPercentInstance().format(new Double(AppStatus.memBar.getPercentComplete())) + "<br>" + (Math.toIntExact(AppStatus.os.getTotalPhysicalMemorySize() / 1000000) - Math.toIntExact((AppStatus.os.getFreePhysicalMemorySize() / 1000000)) + "mb / " + (AppStatus.os.getTotalPhysicalMemorySize() / 1000000) + "mb </html>"));
			AppStatus.cpuBar.setValue((int) (AppStatus.os.getSystemCpuLoad() * 100));
			AppStatus.cpuLabel.setText("<html><div style='text-align: center;'> CPU: <br>" + (int) (AppStatus.os.getSystemCpuLoad() * 100) + "%");
			// Actually gets the entire disks size not just the current partition
			AppStatus.diskBar.setValue(Math.toIntExact(root.getTotalSpace() / 1000000) - Math.toIntExact(root.getUsableSpace() / 1000000));
			AppStatus.diskLabel.setText("<html><div style='text-align: center;'> Disk Space: <br>" + NumberFormat.getPercentInstance().format(new Double(AppStatus.diskBar.getPercentComplete())) + "<br>" + (Math.toIntExact(root.getTotalSpace() / 1000000) - Math.toIntExact(root.getUsableSpace() / 1000000)) + "mb / " + Math.toIntExact(root.getTotalSpace() / 1000000) + "mb");
			try {
				//AppStatus.heatBar.setValue(Integer.parseInt(execCmd("vcgencmd measure_temp").replaceAll("'C", "")));
				//System.out.println(execCmd("cmd.exe /c echo 1").replaceAll("\"", "").replaceAll(System.lineSeparator(), ""));
				AppStatus.heatBar.setValue(Integer.parseInt(execCmd("cmd.exe /c echo 5").replaceAll("\"", "").replaceAll(System.lineSeparator(), "")));
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			AppStatus.heatLabel.setText("<html><div style='text-align: center;'> Temperature: <br>" + AppStatus.heatBar.getValue() + "C°");
			
		}
	}
	
	public static String execCmd(String cmd) throws java.io.IOException {
		Scanner s = new Scanner(Runtime.getRuntime().exec(cmd).getInputStream()).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
