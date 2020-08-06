from flask import Flask, render_template, request,redirect, url_for
import pymysql

mtest = Flask(__name__)

#DB connection
#Admin Name : Root 
#DataBase Pass : no   
#DataBase Name : ExamReg 
#Local Host
db = pymysql.connect("localhost", "root", "", "ExamReg")

def validatePassword(psw , repeated):
	if psw == repeated:
		return True
	else:
		return False
	return False

#Start Loading Pages
#Starting page of the Website

@mtest.route('/')
def firstpage():
	return	render_template("index.html")

#Login Page Rendering
@mtest.route('/login')
def logcall():
	return render_template("signin.html")

#SignUp Page Rendering
@mtest.route('/signup')
def signcall():
	return render_template("signup.html")

#Storing data in DB After Submittion
#Recording User Details
@mtest.route('/fromsubmition', methods=['POST'])
def saveData():
	r = request.form 
	userid = r['userid']
	mail = r['email']
	mob = r['mobile']
	psw = r['psw']
	rpsw = r['repeat']
	valid = validatePassword(psw,rpsw)

	if valid == True:
		try:
			cursor = db.cursor()
			cursor.execute("""INSERT INTO register (userid,email,mobile,password) VALUES (%s,%s,%s,%s)""",(userid,mail,mob,psw))
			db.commit()

		except Exception as e:
			return(str(e))

	return render_template("index.html")

#Rendering to Home Page of the registration After LoggedIN
@mtest.route('/formlogin',methods=['GET'])
def login_verify():
	r = request.form
	logid = r.get('mails')
	passs = r.get('psw')
	try:
		cursor = db.cursor()
		cursor.execute("SELECT email,password FROM register WHERE email = %s AND password = %s", (logid, passs))
		rs = cursor.fetchall()

		for x in rs:
			flogid = x[0]
			fpasss = x[1]
			if flogid == logid and fpasss == passs:
				return 'Success'

			else:
				return render_template("signin.html")

	except Exception as e:
		return(str(e))

	return render_template('home.html', district = 
	 [{'name':'Erode'},
	 {'name':'Namakkal'},
	 {'name':'Salem'},
	 {'name':'Chennai'}],

	 religion = [
	 {'name':'Hindu'}, 
	 {'name':'Muslim'}, 
	 {'name':'Christian'}, 
	 {'name':'Others'}],
	 
	 states = [
	 {'name':'TamilNadu'},
	 {'name':'Kerala'},
	 {'name':'Maharastra'},
	 {'name':'Andhra Pradhes'},
	 {'name':'Karnataka'},
	 {'name':'Gujarat'},
	 {'name':'Rajasthan'},
	 {'name':'Uttar Pradhesh'},
	 {'name':'Odhisa'},
	 {'name':'Telugana'},
	 {'name':'Haryana'}],

	 board = [
	 {'name':'Matric'},
	 {'name':'State Board'},
	 {'name':'CBSE'},
	 {'name':'ICSE'},
	 {'name':'IB'}],

	 boards = [
	 {'name':'Matric'},
	 {'name':'State Board'},
	 {'name':'CBSE'},
	 {'name':'ICSE'},
	 {'name':'IB'}]) 

#After Sign Redirecting to Starting Page of the Website
@mtest.route('/back')
def goback():
	return render_template("index.html")

#When User Forgots password Redirecting to reset Password
@mtest.route('/forgot')
def forgots():
	return render_template("forgot.html")

@mtest.route('/select')
def selectdist():
	return

#Start registering Here 
#Storing Applicant's Data in the dataBase
@mtest.route('/Applicant', methods=['POST'])
def applicants():
	if request.method == 'POST':
		r = request.form
		applicant_name = r['appname']
		father = r['fatname']
		mother = r['motname']
		gen = r['gender']
		dob = r['dob']
		ph = r['phone']
		dist = str(r.get('district'))
		state = str(r.get('states'))
		nat = r['nation']
		relig = str(r.get('religion'))

		try:
			cur = db.cursor()
			query = """INSERT INTO perdet (name,father,mother,gender,dob,phone,district,state,religion,nationality) VALUES(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)"""
			cur.execute(query,(applicant_name,father,mother,gen,dob,ph,dist,state,relig,nat))
			db.commit()
		except Exception as e:
			return(str(e))

		#HTML Code here to push into the document using python
		return '<center><h1>Check Your Details Entered</h1><table width="300px" style="position:absolute;top:100px;left:450px;line-height:25px;"><h3><b><tr><td>Applicant Name :</td><td>'+applicant_name+'</td></tr><br><tr><td>Father\'s name :</td><td>'+father+'</td></tr><br><tr><td>Mother\'s Name :</td><td>'+mother+'</td></tr><br><tr><td>D.O.B :</td><td>'+dob+'</td></tr><br><tr><td>Gender :</td><td>'+gen+'</td><tr><br><tr><td>Phone.no :</td><td>'+ph+'</td></tr><br><tr><td>District :</td><td>'+dist+'</td></tr><br><tr><td>State :</td><td>'+state+'</td></tr><br><tr><td>Nationality :</td><td>'+nat+'</td></tr><br><tr><td>Religion :</td><td>'+relig+'</td></tr></b></h3></table></center><br><br><h1 style="margin-left:150px;margin-top:150px;">Go Back, Move To Address Tab To Continue Filling Details</h1>'

@mtest.route('/address', methods = ['POST'])
def addresss():
	if request.method == 'POST':
		r = request.form;
		door_no = r['door']
		taluk = r['taluks']
		city_name = r['city']
		pincode = r['pin']

		try:
			cur = db.cursor()
			query = """INSERT INTO address(door,taluk,city,pincode) VALUES(%s,%s,%s,%s)"""
			cur.execute(query, (door_no, taluk, city_name, pincode))
			db.commit()
		except Exception as e:
			return (str(e))
		return '<center><h1>Check Your Details Entered</h1><table width="400px" style="position:absolute;top:100px;left:450px;line-height:25px;"><h3><b><tr><td>Door Number:</td><td>'+door_no+'</td></tr><br><tr><td>Taluk:</td><td>'+taluk+'</td></tr><br><tr><td>City Name :</td><td>'+city_name+'</td></tr><br><tr><td>Pin Code :</td><td>'+pincode+'</td></tr><br><br><h1 style="margin-left:150px;margin-top:150px;">Go Back, Move To SSLC Tab To Continue Filling Details</h1>'

@mtest.route('/sslcdetails', methods = ['POST'])
def ssl():
	if request.method == 'POST':
		r = request.form
		certify = r['cerno']
		school = r['sclname']
		bd = str(r.get('board'))
		pntg = r['marper']

		try:
			cur = db.cursor()
			query = """INSERT INTO sslcdet(certno,schl_name,boards,marks) VALUES(%s,%s,%s,%s)"""
			cur.execute(query, (int(certify), school, bd, pntg))
			db.commit()
		except Exception as e:
			return(str(e))
		return '<center><h1>Check Your Details Entered</h1><table width="400px" style="position:absolute;top:100px;left:450px;line-height:25px;"><h3><b><tr><td>Certificate Number:</td><td>'+certify+'</td></tr><br><tr><td>School Name</td><td>'+school+'</td></tr><br><tr><td>Board :</td><td>'+bd+'</td></tr><br><tr><td>Percentage : </td><td>'+pntg+'</td></tr><br><br><h1 style="margin-left:150px;margin-top:150px;">Go Back, Move To HSC Tab To Continue Filling Details</h1>'

@mtest.route('/hscdetails', methods=['POST'])
def hsc():
	if request.method == 'POST':
		r = request.form
		certifys = r['cernos']
		schools = r['sclnames']
		bds = str(r.get('board'))
		pntgs = r['marpers']

		try:
			cur = db.cursor()
			query = """INSERT INTO hscdet(certificate_no,school_name,boards_name,marks) VALUES(%s,%s,%s,%s)"""
			cur.execute(query, (int(certifys), schools, bds, pntgs))
			db.commit()
		except Exception as e:
			return(str(e))
		return '<center><h1>Check Your Details Entered</h1><table width="400px" style="position:absolute;top:100px;left:450px;line-height:25px;"><h3><b><tr><td>Certificate Number:</td><td>'+certifys+'</td></tr><br><tr><td>School Name</td><td>'+schools+'</td></tr><br><tr><td>Board :</td><td>'+bds+'</td></tr><br><tr><td>Percentage : </td><td>'+pntgs+'</td></tr><br><br><h1 style="margin-left:150px;margin-top:150px;">Go Back, Move To EXAM PARTICULARS Tab To Continue Filling Details</h1>'

@mtest.route('/particulars', methods = ['POST'])
def particular():
	if request.method == 'POST':
		r = request.form;
		exam = str(r.get('noexam'))
		dis = r['part_dist']
		cen = r['part_centre']
		ttlfee = r['fees']
		statuss = r['status']

		try:
			cur = db.cursor()
			query = """INSERT INTO particulars(Examination,dist,centre,totalfee,feestatus) VALUES(%s,%s,%s,%s,%s)"""
			cur.execute(query, (exam,dis,cen,ttlfee,statuss))
			db.commit()
		except Exception as e:
			return(str(e))
		return '<h1>The Hall Ticket Will Reach You through Speed Post!!! PLEASE BE AVAILABLE</h1>'

if __name__ == '__main__':
	mtest.run(debug=True,port=5005)