const express = require('express');
const menuRouter = express.Router();
const mongoclient = require('mongodb').MongoClient;
const url = "mongodb+srv://mb1234:mb1234@digirest-kn36s.mongodb.net/test?retryWrites=true&w=majority";

menuRouter.use(express.urlencoded());

// for adding the food to the menu card => inserted into the database document
menuRouter.post('/continue', function(reqt, resp)
{
    var categ = reqt.body.category;
    var dname = reqt.body.dname;
    var price = reqt.body.price;

    mongoclient.connect(url, function(err, db)
    {
        if(err)
            console.log("Databse connection error");
        else
        {
            var dbs = db.db('mydigires');
            dbs.collection('food',function(err, food)
            {
                food.insertOne({'category':categ,'d_name': dname,'price':price}, function(err, res)
                {
                    if(err)
                    {
                        console.log("Insertion failed");
                        resp.render('dashboard',
                        {
                            btns:true,
                            view:false,
                            createmenu : true,
                            failed:true,
                            success: false,
                            updmenu:false
                        });
                    }
                    else
                    {
                        console.log("Insertion successful");
                        resp.render('dashboard',
                        {
                            btns:true,
                            view:false,
                            createmenu : true,
                            failed:false,
                            success: true,
                            updmenu:false
                        });
                    }
                });
            });
        }
    });
});

// updating the price of the food available in the database document
menuRouter.post('/updmenu', function(reqt, resp)
{
    var categ = reqt.body.category;
    var dname = reqt.body.dname;
    var price = reqt.body.price;

    console.log(categ + " " + dname + " " + price);

    mongoclient.connect(url, function(err, db)
    {
        if(err)
            console.log("databse connection error");
        else
        {
            var dbs = db.db('mydigires');
            dbs.collection('food', function(err, food)
            {
                food.update({"category":categ,"d_name":dname},{$set:{"price":price}}, {upsert:true}, function(err, res)
                {
                    // if it is failed
                    if(err)
                    {
                        console.log('Updation Failed');
                        resp.render('dashboard',
                        {
                            btns:true,
                            view:false,
                            createmenu : false,
                            failed:true,
                            success: false,
                            updmenu:true
                        });
                    }
                    //if it is successfull
                    else
                    {
                        console.log('Updation successfull');
                        resp.render('dashboard',
                        {
                            btns:true,
                            view:false,
                            createmenu : false,
                            failed:false,
                            success: true,
                            updmenu:true
                        });
                    }
                });
            });
        }
    });
});

module.exports = menuRouter;