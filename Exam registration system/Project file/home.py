from flask import Flask, request, render_template, url_for, redirect
import pymysql

homes = Flask(__name__)

@homes.route('/')
def homepage():
	return render_template("home.html")

if __name__ == '__main__':
	homes.run(debug=True)