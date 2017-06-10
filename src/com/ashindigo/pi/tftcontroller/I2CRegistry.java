package com.ashindigo.pi.tftcontroller;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;

public class I2CRegistry {
	public static final GpioController gpio = GpioFactory.getInstance();
	/** MPU-6050 I2C Address */
	public static final int MPU6050 = 0x68;
	/** MPU-6050 Power On Register */
	public static final int MPU6050P = 0x6b;
	/** MPU-6050 Gyroscope Registers Order: XYZ */
	public static final int[] MPU6050G = new int[]{0x43, 0x45, 0x47};
	/** MPU-6050 Accelerometer Registers Order: XYZ */
	public static final int[] MPU6050A = new int[]{0x3b, 0x3d, 0x3f};
	
	public static EnumRotate getRotation() {
		return EnumRotate.VERTICAL;
	}
	
}
