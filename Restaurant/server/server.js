const express = require('express');
const bodyparser = require('body-parser');
const cors = require('cors');

// IMPORTING THE CONTROLLERS
const createAccountPage = require('./controllers/createAccount');
const loginContollerPage = require('./controllers/login');
const menuController = require('./controllers/createMenu');
const dashboardPage = require('./controllers/dashboard');
const customerPage = require('./controllers/customerView');

const port = 2022;

const app = express();
app.use(bodyparser.json());
app.use(cors());

app.use('/register', createAccountPage);                       // Creating Account

app.use('/login', loginContollerPage);                         // User Login Page controller

app.use('/menucard', menuController);                          // Creating the database to insert menu item

app.use('/dashboard', dashboardPage);                          // Routing to the dashboard

app.use('/customer', customerPage);                            // Customer Page to show the menu

app.listen(port, function () {
    return console.log("server listening at " + port);
});