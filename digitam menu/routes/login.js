const express = require('express');
const loginRouter = express.Router();
const md5 = require('md5');
const mongoclient = require('mongodb').MongoClient;
const url = "mongodb+srv://mb1234:mb1234@digirest-kn36s.mongodb.net/test?retryWrites=true&w=majority";

loginRouter.use(express.urlencoded());

/**
 *      when user clicks on login button with their 
 *      email ID and password
 * 
 *      it checks for the user availability and 
 *      take them to the dashboard
 * 
 *      if user is unavailable in DB
 *      they prompt to type the valid email Id and password
 */

loginRouter.post('/login', function(reqt, resp)
{
    var mail = reqt.body.username;
    var psw = reqt.body.psw

    mongoclient.connect(url, function(err, db)
    {
        if(err)
            console.log("Databse connection Error");
        else
        {
            var dbs = db.db('mydigires');
            dbs.collection('user', function(err, user)
            {
                user.findOne({"e_mail":mail},function(err, res)
                {
                    if(err)
                        console.log("No Users found");
                    else
                    {
                        if( md5(psw) == res.password)
                        {
                            console.log("User verfied");
                            resp.render('dashboard',
                            {
                                btns :true,
                                view:true,
                                createmenu : false,
                                failed:false,
                                success:false,
                                updmenu:false
                            });
                        }
                        else
                        {
                            console.log("Not verified");
                            resp.render('home', 
                            {
                                home : false,
                                loginSection : true,
                                registerSection : false,
                                error:true,
                                rerror:false,
                                success:false,
                                osuccess : false
                            });
                        }
                    }
                });

            });
        }
    });
});

module.exports = loginRouter;