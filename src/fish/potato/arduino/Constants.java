package fish.potato.arduino;

public class Constants {
	public final static String AVR_HOME = "/usr/share/arduino/hardware/tools/avr/bin/";
	public final static String AVRDUDE_HOME = "/usr/share/arduino/hardware/tools/";
	public final static String ARDUINO_HOME = "/usr/share/arduino/hardware/arduino/";
	public final static String SERIAL_PORT = "/dev/ttyACM0";
	
	public static String WORKING_DIR = "c_files/";
	public static String MAIN_FILE = "matrix_8";
	public static String MESSAGE_FILE = "message_8";
	public static String CHAR_FILE = "chars_8";
	
	public static void setWorkingDir(String dir) {
		WORKING_DIR = dir;
	}
	
	public static void setMainFile(String file) {
		MAIN_FILE = file;
	}
	
	public static void setMessageFile(String file) {
		MESSAGE_FILE = file;
	}
	
	public static void setCharFile(String file) {
		CHAR_FILE = file;
	}
}
