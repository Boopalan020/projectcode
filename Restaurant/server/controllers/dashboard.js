const express = require('express');
const dashRoute = express.Router();
const cors = require('cors');
const bodyparser = require('body-parser');
const ordersfile = require('./orders.json');

dashRoute.use(cors());
dashRoute.use(bodyparser.json());

dashRoute.get('/vieworders', function(req, res)
{
    console.log('Providing the Orders file json');
    console.log(ordersfile);
    res.json(ordersfile);
});

module.exports = dashRoute;