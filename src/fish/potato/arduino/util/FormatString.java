package fish.potato.arduino.util;

public class FormatString {
	public static String formatMessage(String message) {
		String arrayDec = "static byte pattern[" + (message.length() + 1) + "][8] = ";
		
		return arrayDec + formatString(message) + ";";
	}
	
	private static String formatString(String message) {
		String stringArray = "{";
		String[] messageArr = stripPunct(message).toUpperCase().split("(?!^)");
		
		for (int i = 0; i < messageArr.length; i++) {
			if (messageArr[i].equals(" ")) {
				stringArray += "space,";
			}
			else {
				stringArray += ("_" + messageArr[i] + ",");
			}
		}
		
		return stringArray + "space}";
	}
	
	private static String stripPunct(String message) {
		return message.replaceAll("\\p{P}", "");
	}
}
