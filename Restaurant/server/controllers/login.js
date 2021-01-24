const express = require('express');
const loginRout = express.Router();
const md5 = require('md5');
const cors = require('cors');
const bodyparser = require('body-parser');

loginRout.use(bodyparser.json());
loginRout.use(cors());

// MONGO CONNECTIVITY
const mongoClient = require('mongodb').MongoClient;
var url = "mongodb+srv://palan1234:palan1234@angulardatabase-xoly9.mongodb.net/test?retryWrites=true&w=majority";

loginRout.post('/', function(req, res)
{
    var mail = req.body.emailids;
    var psw = req.body.passwords;

    mongoClient.connect(url, function(err, db)
    {
        if(err)
            console.log('Databse connection Failure');
        else
        {
            var dbs = db.db('AnguDigital');
            dbs.collection('AdminAcnts', function(err, AdminAcnts){
                AdminAcnts.findOne({"Mail_ID" : mail, "password" : md5(psw)}, function(err, result)
                {
                    if(err || result == null)
                    {
                        console.log('Error Occured or no User found in the database');
                        res.status(404).send({"Found":false, "Message":"User Login Failed"});
                    }
                    else
                    {
                        console.log('User Found');
                        res.status(200).send({"found":true, result : result });
                    }
                    /**
                     *      SENDING THE RESPONSE TO THE ANGULAR WITH APPRPRIATE DATA HERE
                     */
                });
            });
        }
    });
});

module.exports = loginRout;