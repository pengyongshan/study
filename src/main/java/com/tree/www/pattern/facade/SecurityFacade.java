package com.tree.www.pattern.facade;

public class SecurityFacade {

	private Camera camera1;

	private Camera camera2;

	private Sensor sensor;

	private Alarm alarm;

	public SecurityFacade() {
		camera1 = new Camera();
		camera2 = new Camera();
		sensor = new Sensor();
		alarm = new Alarm();
	}

	// 启动
	public void start() {
		camera1.turnOn();
		camera2.turnOn();
		sensor.activate();
		alarm.active();
	}

	// 停止
	public void stop() {
		camera1.turnOff();
		camera2.turnOff();
		sensor.deactive();
		alarm.deactive();
	}

	// 检查有无问题
	public boolean check(boolean c1, boolean c2, boolean a, boolean s) {
		return camera1.rotate(c1) || camera2.rotate(c2) || alarm.ring(a) || sensor.trigger(s);
	}
}
