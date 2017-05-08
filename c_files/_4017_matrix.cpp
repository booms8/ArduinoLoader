#line 1 "_4017_matrix.ino"
#include "message.c"

//0: flash
//1: scroll
#include "Arduino.h"
void setup();
void loop();
void showChar(byte charPattern[]);
void scrollChar(byte pattern1[], byte pattern2[]);
void doReset();
void doClock();
#line 5

//clock pin
int clock = 8;
//resent pin
int reset = 9;
//number of cycles to delay on each character
int charDelay = 80;
//blank time following each character (milliseconds)
int charBuffer = 50;
//delay for each row (microseconds);
int cycle = 1000;

void setup() {
  DDRD = B11111111;
  pinMode(clock, OUTPUT);
  pinMode(reset, OUTPUT);
  doReset();
}

void loop() {
  if (mode == 0) {
    for (int k = 0; k < sizeof(pattern) / 8; k++) {
      showChar(pattern[k]);
      doReset();
    }
  }
  else {
    for (int k = 0; k < sizeof(pattern) / 8; k++) {
      if (k < (sizeof(pattern) / 8) - 1) {
        scrollChar(pattern[k], pattern[k + 1]);
        doReset();
      }
      else {
        scrollChar(pattern[k], pattern[0]);
        doReset();
      }
    }
  }
}

void showChar(byte charPattern[]) {
  for (int j = 0; j < charDelay; j++) {
    for (int i = 0; i < 10; i++) {
      if (i >= 8) {
        doClock();
      }
      else {
        PORTD = charPattern[i];
        delayMicroseconds(cycle - 5);
        PORTD = B00000000;
        doClock();
      }
    }
  }
  delay(charBuffer);
}

void scrollChar(byte pattern1[], byte pattern2[]) {
  for (int m = 0; m < 8; m++) {
    for (int j = 0; j < charDelay / 8; j++) {
      for (int i = 0; i < 10; i++) {
        if (i >= 8) {
          doClock();
        }
        else {
          PORTD = (pattern1[i] << m) + (pattern2[i] >> (8 - m));
          delayMicroseconds(cycle - 5);
          PORTD = B00000000;
          doClock();
        }
      }
    }
  }
}

void doReset() {
  digitalWrite(reset, HIGH);
  delayMicroseconds(5);
  digitalWrite(reset, LOW);
}

void doClock() {
  digitalWrite(clock, HIGH);
  delayMicroseconds(5);
  digitalWrite(clock, LOW);
}
