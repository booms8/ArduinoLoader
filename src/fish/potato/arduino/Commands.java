package fish.potato.arduino;

public class Commands {
	
	public final static String BUILD_MAIN = Constants.AVR_HOME + "avr-g++ -c -g -Os -Wall -fno-exceptions -ffunction-sections "
			+ "-fdata-sections -mmcu=atmega328p -DF_CPU=16000000L -MMD -DUSB_VID=null -DUSB_PID=null -DARDUINO=105 "
			+ "-D__PROG_TYPES_COMPAT__ -I" + Constants.ARDUINO_HOME + "cores/arduino -I" + Constants.ARDUINO_HOME + "variants/standard "
			+ "_4017_matrix.cpp -o _4017_matrix.cpp.o";
	
	public final static String BUILD_MESSAGE = Constants.AVR_HOME + "avr-gcc -c -g -Os -Wall -ffunction-sections -fdata-sections "
			+ "-mmcu=atmega328p -DF_CPU=16000000L -MMD -DUSB_VID=null -DUSB_PID=null -DARDUINO=105 -D__PROG_TYPES_COMPAT__ "
			+ "-I" + Constants.ARDUINO_HOME + "cores/arduino -I" + Constants.ARDUINO_HOME + "variants/standard message.c -o message.c.o";
	
	public final static String LINK_ALL = Constants.AVR_HOME + "avr-gcc -Os -Wl,--gc-sections -mmcu=atmega328p "
			+ "-o _4017_matrix.cpp.elf message.c.o _4017_matrix.cpp.o core.a -L./ -lm";
	
	public final static String GEN_EEPROM = Constants.AVR_HOME + "avr-objcopy -O ihex -j .eeprom --set-section-flags=.eeprom=alloc,load "
			+ "--no-change-warnings --change-section-lma .eeprom=0 _4017_matrix.cpp.elf _4017_matrix.cpp.eep";
	
	public final static String GEN_HEX = Constants.AVR_HOME + "avr-objcopy -O ihex -R .eeprom _4017_matrix.cpp.elf _4017_matrix.cpp.hex";
	
	public final static String LOAD = Constants.AVRDUDE_HOME + "avrdude -C" + Constants.AVRDUDE_HOME + "avrdude.conf -patmega328p "
			+ "-carduino -P/dev/ttyACM0 -b115200 -D -Uflash:w:_4017_matrix.cpp.hex:i";	
}
