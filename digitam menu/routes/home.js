const express = require('express');
const homeRouter = express.Router();
const bodyparser = require('body-parser');
const ceil = require('math-ceil');
const mongoclient = require('mongodb').MongoClient;
const url = "mongodb+srv://mb1234:mb1234@digirest-kn36s.mongodb.net/test?retryWrites=true&w=majority";

homeRouter.use(bodyparser.urlencoded({ extended : true }))

// to get into the home Page '/' and '/home'
homeRouter.get('/', function(rst, rsp)
{
    rsp.render('home', 
    {
        home : true,
        loginSection : false,
        registerSection : false,
        error:false,
        rerror : false,
        success:false,
        osuccess : false
    });
});

//  '/home' is also routed to home page
homeRouter.get('/home', function(rst, rsp)
{
    rsp.render('home', 
    {
        home : true,
        loginSection : false,
        registerSection : false,
        error:false,
        rerror : false,
        success:false,
        osuccess : false
    });
});

homeRouter.post('/category', function(rst, rsp)
{

    /**
     *      Here I got the input given by the user
     *      Based on that I routed to the particular page they are looking for
     *          " hotel " is for the admin of that hotel
     *          " customer " is for the customer of that hotel
     */
    var ch = rst.body.choice;
    if(ch == "hotel")
    {
        rsp.render('home', 
        {
            home : false,
            loginSection : true,
            registerSection : false,
            error:false,
            rerror : false,
            success:false,
            osuccess : false
        });
    }
    else if(ch == "customer")
    { 
        mongoclient.connect(url, function(err, db)
        {
            if(err)
                console.log('Database connection error');
            else
            {
                var dbs = db.db('mydigires');
                dbs.collection('food', function(err, food)
                {
                    food.find({}).toArray(function(err, result)
                    {
                        rsp.render('orders',
                        {
                           res : result,
                           row : ceil(result.length/4)
                        });
                    });
                });
            }
        });
    }
});

/**
 *      Here the I handled the routing to the REGISTER page
 */
homeRouter.get('/register', function(rst, rsp)
{
    rsp.render('home', 
    {
        home : false,
        loginSection : false,
        registerSection : true,
        error:false,
        rerror : false,
        success:false,
        osuccess : false
    });   
});

/**
 *      User at the register page routed to the login page using this url => ' tologin '
 */
homeRouter.get('/tologin', function(reqt, resp)
{
    resp.render('home', 
    {
        home : false,
        loginSection : true,
        registerSection : false,
        error:false,
        rerror : false,
        success:false,
        osuccess : false
    });
});

module.exports = homeRouter;