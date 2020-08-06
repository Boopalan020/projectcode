



from time import localtime, strftime
import RPi.GPIO as GPIO
import time
import requests as r
import threading
GPIO.setmode(GPIO.BOARD)
GPIO.setwarnings(False)
AO=40
flag=0
while True:

    GPIO.setup(AO,GPIO.IN)



    b=GPIO.input(AO) 
    print AO,b 



    if (b==0 ):


        print AO 

	print "Presence of methane"
        flag+=1
    else:
        print "No presence of methane"
    time.sleep(5)
