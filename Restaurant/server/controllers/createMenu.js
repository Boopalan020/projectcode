const express = require('express');
const menuRoute = express.Router();
const cors = require('cors');
const bodyparser = require('body-parser');

menuRoute.use(cors());
menuRoute.use(bodyparser.json());

// MONGO CONNECTIVITY
const mongoClient = require('mongodb').MongoClient;
var url = "mongodb+srv://palan1234:palan1234@angulardatabase-xoly9.mongodb.net/test?retryWrites=true&w=majority";


// Adding items to the MENU
menuRoute.post('/additem', function (req, res) {

    /**
     *      Dish type : CHICKEN , MUTTON, MEALS, DINNER ,BREAKFAST, LUNCH
     *      Food Item
     *      Price of that food Item
     */

    console.log(req.body);

    mongoClient.connect(url, function (error, db) {
        if (error)
            console.log('dataase connection error');
        else {
            var dbs = db.db('AnguDigital');
            dbs.collection('foodItems', function (err, foodItems) {
                foodItems.insertOne({
                    "category": req.body.categ,
                    "food_name": req.body.foodname,
                    "price": req.body.price
                }, function (error, result) {
                    if (!error) {
                        console.log('Food item Added to the MENUCARD successfully');
                        res.status(200).send({
                            'success': "Menu created successfully"
                        });
                    } else {
                        console.log('Error in createing the menucard');
                        res.status(404).send({
                            'success': "Menu created successfully"
                        });
                    }

                    /**
                     *      Respective response should be sent to the angular client side application
                     */

                });
            });
        }
    });
});

// Deleting the items from the menu card
menuRoute.post('/deleteItem', function (req, res) {
    mongoClient.connect(url, function (err, db) {
        if (err)
            console.log('database connection failure');
        else {
            var dbs = db.db('AnguDigital');
            dbs.collection('foodItems', function (err, foodItems) {
                foodItems.deleteOne({
                    "food_name": req.body.foodname,
                    "price": req.body.price
                }, function (err, result) {
                    if (!err && result.deletedCount > 0) {
                        console.log(result);
                        console.log('Successfully food item is removed from the MENUCARD')
                        res.status(200).send({
                            'success': 'Food Item deleted successfully'
                        });
                    } else {
                        console.log(result);
                        console.log('Failed to delete food item from the MENUCARD');
                        res.status(404).send({
                            'success': 'Could not delete Food Item from menu' 
                        });
                    }

                });
            });
        }
    });
});


module.exports = menuRoute;