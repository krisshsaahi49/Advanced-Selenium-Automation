package com.automation.practice;

public class OSFactory {

	public OS getEveryThing(String device) {
		if(device.toLowerCase().contains("android")) {
			return new Android();	
		}else if(device.toLowerCase().contains("ios")){
			return new Ios();
		}else {
			return new Android();
		}

	}
}
