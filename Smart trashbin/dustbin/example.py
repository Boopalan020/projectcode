import RPi.GPIO as GPIO
import requests as r
import time
import os
import sys
from hx711 import HX711
import urllib2

def cleanAndExit():
    
    GPIO.cleanup()
    

cleanAndExit()

hx = HX711(5, 6)


hx.set_reading_format("LSB", "MSB")

hx.set_reference_unit(92)

hx.reset()
hx.tare()
flag=0
while True:
    try:
        val = hx.get_weight(5)
        val=abs(val)



        print "Weight is:",val 
        if val > 300:
            if flag==0:
                r1=r.get("http://smartmanoj.pythonanywhere.com/way2?&u=8825971005&p=boopalan1234&r=9489149398&t='Overweighted in dustbin'")
               
                if r1.text=="spam":
                    r1=r.get("http://smartmanoj.pythonanywhere.com/way2?&u=8825971005&p=boopalan1234&r=9489149398&t='Overweighted in dustbin'")
                    
                flag+=1
               #storage=urllib2.urlopen('https://api.thingspeak.com/update?api_key=M6DSVT6MMGSAIP1F&field1='+str(val))
        hx.power_down()
        hx.power_up()

        time.sleep(2)
	execfile('/home/pi/dustbin/pro.py')
        
    except (KeyboardInterrupt, SystemExit):
        cleanAndExit()

GPIO.cleanup()
