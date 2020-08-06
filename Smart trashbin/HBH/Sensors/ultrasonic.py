import httplib, urllib
from time import localtime, strftime
import RPi.GPIO as GPIO
import time
GPIO.setmode(GPIO.BCM)
GPIO.setwarnings(False)
TRIG = 23
ECHO = 24
def doit():
		
	params = urllib.urlencode({'field1':distance, 'field2':final,'key':'GCPTWVHV3YI8IEEZ'})
	headers = {"Content-type": "application/x-www-form-urlencoded","Accept": "text/plain"}
	conn = httplib.HTTPConnection("api.thingspeak.com:80")
	
	try:
		conn.request("POST", "/update", params, headers)
		response = conn.getresponse()
		print distance
		print final
		print strftime("%a, %d %b %Y %H:%M:%S", localtime())
		print response.status, response.reason
		data = response.read()
		conn.close()
	except:
		print "connection failed"	
while True:
            print "Distance Measurement In Progress"
            GPIO.setup(TRIG,GPIO.OUT)
            GPIO.setup(ECHO,GPIO.IN)
            print "Waiting For Sensor To Settle"
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
            print "Distance:",distance,"cm"
            doit()
            time.sleep(2)







