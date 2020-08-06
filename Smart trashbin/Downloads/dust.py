import RPi.GPIO as GPIO
import subprocess
import os
import threading
import time
import requests as r
GPIO.setmode(GPIO.BCM)
TRIG = 23
ECHO = 24
GPIO.setup(TRIG,GPIO.OUT)
GPIO.setup(ECHO,GPIO.IN)
DAT =27
CLK=14
num=0
AO=21
flag=0
GPIO.setup(AO,GPIO.IN)
GPIO.setwarnings(False)
GPIO.setup(CLK, GPIO.OUT)
GPIO.output(TRIG, False)
def weight():
  i=0
  num=0
  GPIO.setup(DAT, GPIO.OUT)
  GPIO.output(DAT,1)
  GPIO.output(CLK,0)
  GPIO.setup(DAT, GPIO.IN)

  while GPIO.input(DAT) == 1:
      i=0
  for i in range(24):
        GPIO.output(CLK,1)
        num=num<<1

        GPIO.output(CLK,0)

        if GPIO.input(DAT) == 0:
            num=num+1

  GPIO.output(CLK,1)
  num=num^0x800000
  GPIO.output(CLK,0)
  wei=0
  wei=((num)/1406)
  wei=(wei-6020)-95

  if(wei<0):
	w="Weight is 0"
	return w
  else:
	w ="Weight is "+str(wei)+"g"
        return w
print "Waiting For Sensor To Settle"
time.sleep(2)
while(True):
	GPIO.output(TRIG, True)
	time.sleep(0.00001)
	GPIO.output(TRIG, False)
	while GPIO.input(ECHO)==0:
		pulse_start = time.time()
	while GPIO.input(ECHO)==1:
		pulse_end = time.time()
	
	pulse_duration = pulse_end - pulse_start

	distance = pulse_duration*17150
	distance = round(distance, 2)
	distance=17.1-distance
	if(distance>=17.1):
		s="Garbage Level : Full (Over Flow of Garbage)"
	else: 
		s="Garbage Level :"+str(distance)+"cm"
	print s
        time.sleep(1)
	w1=weight()
	print w1
	time.sleep(1)

        b=GPIO.input(AO)
        if (b==0 ):
                x="Presence of methane"
                print x
                flag+=1
        else:
                x="No presence of methane"
                print x

        time.sleep(2)
	r.get("http://smartmanoj.pythonanywhere.com/way2?&u=8825971005&p=boopalan1234&r=9566719305&t="+s+w1+x)
	print "WARNING SENT"
	
GPIO.cleanup()

