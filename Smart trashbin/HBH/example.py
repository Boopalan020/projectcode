import RPi.GPIO as GPIO
import time
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
                r1=r.get("http://smartmanoj.pythonanywhere.com/way2?&u=9445972779&p=Intel@65&r=9842278780&t='Overweighted in dustbin'")
               
                if r1.text=="spam":
                    r1=r.get("http://smartmanoj.pythonanywhere.com/way2?&u=9445972779&p=Intel@65&r=9842278780&t='Overweighted in dustbin'")
                    
                flag+=1
               #storage=urllib2.urlopen('https://api.thingspeak.com/update?api_key=M6DSVT6MMGSAIP1F&field1='+str(val))
        hx.power_down()
        hx.power_up()

        time.sleep(2)
	GPIO.cleanup()
        execfile('/home/pi/Documents/HBH/pro1.py')
        
    except (KeyboardInterrupt, SystemExit):
        cleanAndExit()