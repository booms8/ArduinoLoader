package fish.potato.arduino.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import fish.potato.arduino.Constants;

public class ClassWriter {
	public static void createClass(String formattedMessage, int mode) {
		String content = "#include \"" + Constants.CHAR_FILE + ".h\"\n\n" +
				"static int mode = " + mode + ";\n" +
				formattedMessage;
		File messageClass = new File(Constants.WORKING_DIR + Constants.MESSAGE_FILE + ".c");
		
		try {
		    FileWriter classWriter = new FileWriter(messageClass, false);
		    classWriter.write(content);
		    classWriter.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}  
	}
}
