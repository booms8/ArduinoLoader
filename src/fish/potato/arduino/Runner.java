package fish.potato.arduino;

import java.io.IOException;

import fish.potato.arduino.ArduinoLoader;

public class Runner {

	public static void main(String[] args) throws IOException, InterruptedException {
		ArduinoLoader.reprogram("yoga time", 1);
	}
}
