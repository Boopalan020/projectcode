const express = require('express');
const customerRout = express.Router();
const cors = require('cors');
const bodyparser = require('body-parser');
const file = require('./orders.json');
const fs = require('fs');
const uniqid = require('uniqid');

customerRout.use(bodyparser.json());
customerRout.use(cors());

// MONGO CONNECTIVITY
const mongoClient = require('mongodb').MongoClient;
var url = "mongodb+srv://palan1234:palan1234@angulardatabase-xoly9.mongodb.net/test?retryWrites=true&w=majority";

customerRout.get('/viewmenu', function(req, res)
{
    mongoClient.connect(url, function(err, db)
    {
        if(err)
            console.log('Database connection error');
        else
        {
            var dbs = db.db('AnguDigital');
            dbs.collection('foodItems', function(err, foodItems)
            {
                foodItems.find({}).toArray(function(err, result){
                    if(err)
                    {
                        console.log('Problem in Finding the document in the databse');
                    }
                    else
                    {
                        if(result == null)
                        {
                            res.status(200).send({ 'found' : 'Menu is Emty.Wait for admin to update their Hotel Menu Card',result:result})
                        }
                        else
                        {
                            res.json(result);
                        }
                    }
                });
            });
        }
    });
});

customerRout.post('/placeorder', function(req, res)
{
    console.log(req.body);

    var order = {
        _id : uniqid(),
        Customer : req.body.Customer,
        Table : req.body.Table,
        Dishes : req.body.Dishes,
        Bill : req.body.Bill
    };

    file.push(order);
    fs.writeFile("./controllers/orders.json", JSON.stringify(file), err =>
    {
        if (err)
        {
            res.status(404).send({"ok":false,"Message" : "Placing ORder Failed"});
            throw err;
        }
        res.status(200).send({"ok":true,"Message":"Order placed Successfully"});
    });

});

module.exports = customerRout;