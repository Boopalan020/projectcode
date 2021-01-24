const express = require('express');
const accRoute = express.Router();
const md5 = require('md5');
const cors = require('cors');
const bodyparser = require('body-parser');

accRoute.use(bodyparser.json());
accRoute.use(cors());

// MONGO CONFIGURATION CODE DOWN
const mongoClient = require('mongodb').MongoClient;
var url = "mongodb+srv://palan1234:palan1234@angulardatabase-xoly9.mongodb.net/test?retryWrites=true&w=majority";

accRoute.post('/', function(req, res)
{
    console.log(req.body);

    var name = req.body.first_name + " " + req.body.last_name;
    var hotelName = req.body.Hotel_name;
    var mail = req.body.email;
    var password = req.body.confirm_pass;

    var hashed_pass = md5(password);

    console.log('Hashed password  : ' + hashed_pass);

    mongoClient.connect(url, function(err, db)
    {
        /**
         *      DATABASE NAME       :   AnguDigital
         *  
         *      COLLECTION NAME     :   AdminAcnts  => for registration
         */
        if(err)
            console.log('database connection failure');
        else
        {
            var dbs = db.db('AnguDigital');
            dbs.collection('AdminAcnts', function(err, AdminAcnts)
            {
                AdminAcnts.insertOne({
                    'User_Name' : name,
                    'Hotel_Name' : hotelName,
                    'Mail_ID' : mail,
                    'password' : hashed_pass
                }, function(err, result){
                    if(err)
                    {
                        res.status(404).send({
                            ok: true,
                            success : "Problem in creating your Account. Try again Later"
                        });
                    }
                    else
                    {
                        res.status(200).send({
                            ok: true,
                            success : "Account created Successfully! Get back to Login Page"
                        });
                    }
                });
            });
        }
    });

});
module.exports = accRoute;