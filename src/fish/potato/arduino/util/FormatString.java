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
			if (messageArr[i].matches("-?\\d+(\\.\\d+)?")) {
				stringArray += translateNumber(messageArr[i]);
			}
			else if (messageArr[i].equals(" ")) {
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
	
	private static String translateNumber(String message) {
		if (message.equals("0")) {
			return "zero";
		}
		else if (message.equals("1")) {
			return "one";
		}
		else if (message.equals("2")) {
			return "two";
		}
		else if (message.equals("3")) {
			return "three";
		}
		else if (message.equals("4")) {
			return "four";
		}
		else if (message.equals("5")) {
			return "five";
		}
		else if (message.equals("6")) {
			return "six";
		}
		else if (message.equals("7")) {
			return "seven";
		}
		else if (message.equals("8")) {
			return "eight";
		}
		else if (message.equals("9")) {
			return "nine";
		}
		else {
			return "";
		}
	}
}
