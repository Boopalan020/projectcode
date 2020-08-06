from time import localtime, strftime
import RPi.GPIO as GPIO
import time
import requests as r
import threading
import sys
import urllib2


GPIO.setmode(GPIO.BOARD)
GPIO.setwarnings(False)





TRIG = 16
ECHO = 18
AO=40
flag=0
flagm=0
def checkspam(r):
    if r=="spam":

            r1=r.get("http://smartmanoj.pythonanywhere.com/way2?&u=8883471297&p=Intel@65&r=9842278780&t='bin is full or has bad smell'")
            
def sendmsg(a,f):
    if f==1:
    
        if a==0:


            r1=r.get("http://smartmanoj.pythonanywhere.com/way2?&u=8883471297&p=Intel@65&r=9842278780&t='bin is full plz replace it...'")
            
            checkspam(r1.text)
        if a==1:
            r1=r.get("http://smartmanoj.pythonanywhere.com/way2?&u=9445972779&p=Intel@65&r=9842278780&t='bad smell detected in the dustbin'")
            
            checkspam(r1.text)
    return   


while True:
        
            GPIO.setup(TRIG,GPIO.OUT)
            GPIO.setup(ECHO,GPIO.IN)
            
            time.sleep(2)
            GPIO.output(TRIG, True)
            time.sleep(0.00001)
            GPIO.output(TRIG, False)
            while GPIO.input(ECHO)==0:
                pulse_start = time.time()
            while GPIO.input(ECHO)==1:
               pulse_end = time.time()       
            pulse_duration = pulse_end - pulse_start
            distance = pulse_duration * 17140
            distance = round(distance, 1)


	    print distance            
            time.sleep(2)
            if (distance <=6):


		print "Dustbin is full"                
                flag+=1
                sendmsg(0,flag)
            
                

            GPIO.setup(AO,GPIO.IN)
            

	    b=GPIO.input(AO)





	    print b
            if (b== 0):




		print "Bad Smell Detected"
                flagm+=1
                sendmsg(1,flagm)


            #weight()
            storage=urllib2.urlopen('https://api.thingspeak.com/update?api_key=HO1RT37M1H2XPIO5&field1='+str(distance)+'&field2='+str(b))
            execfile('/home/pi/dustbin/example.py')
            
           





