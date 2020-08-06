const express = require('express');
const orderRouter = express.Router();
const bodyparser = require('body-parser');
const fs = require('fs');
const orderPlaced = require('./order.json');

orderRouter.use(bodyparser.urlencoded());

orderRouter.post('/ordernow', function(reqt, resp)
{
    var foodname = reqt.body.itemName;
    var foodprices = reqt.body.itemPrice;
    var customerName = reqt.body.username;
    var tableNumer = reqt.body.tablenum;
    var totalAmount = 0;

    for (let i = 0; i < foodname.length; i++) 
        totalAmount += Number(foodprices[i]) ;
            
    var order = {
        name : customerName,
        table_number : tableNumer,
        food_items : foodname,
        food_price : foodprices,
        Bill_amount : totalAmount
    };
    orderPlaced.push(order);
    fs.writeFile("./routes/order.json", JSON.stringify(orderPlaced), err => { 
        if (err) throw err;  
        console.log("Done writing");
    }); 

    resp.render('home',
    {
        home : true,
        loginSection : false,
        registerSection : false,
        error:false,
        rerror : false,
        success:false,
        osuccess : true
    });

});

module.exports = orderRouter;