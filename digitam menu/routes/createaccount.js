const express = require('express');
const accRouter = express.Router();
const md5 = require('md5');
const mongoclient = require('mongodb').MongoClient;
const url = "mongodb+srv://mb1234:mb1234@digirest-kn36s.mongodb.net/test?retryWrites=true&w=majority";

accRouter.use(express.urlencoded());

accRouter.post('/newuser', function(reqt, resp)
{
    var username = reqt.body.username;
    var mailid = reqt.body.mailid;
    var phone = reqt.body.phno;
    var psw = reqt.body.cpsw;

    mongoclient.connect(url, function(err, db)
    {
        if(err)
            console.log("Databse connection error");
        else
        {
            var dbs = db.db('mydigires');
            dbs.collection('user', function(err, user)
            {
                user.insert({"user_name":username,"e_mail":mailid,"phone_no":phone,"password":md5(psw)}, function(err, res)
                {
                    if(err)
                    {
                        console.log("User registeration failed");
                        resp.render('home', 
                        {
                            home : false,
                            loginSection : false,
                            registerSection : true,
                            error:false,
                            rerror:true,
                            success:false,
                            osuccess : false
                        });
                    }
                    else
                    {
                        console.log("User registration successful");
                        resp.render('home', 
                        {
                            home : false,
                            loginSection : true,
                            registerSection : false,
                            error:false,
                            rerror:false,
                            success:true,
                            osuccess : false
                        });
                    }
                });
            });
        }
    });

});

module.exports = accRouter;