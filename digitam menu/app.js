const express = require('express');
const path = require('path');
const bodyparser = require('body-parser');


// required routes are imported here

    /*
     * Routes are imported here from the routes folder
     */

const homePage = require('./routes/home');
const loginPage = require('./routes/login');
const detPage = require('./routes/dashboard');
const Cmenu = require('./routes/cmenu');
const newAccount = require('./routes/createaccount');
const orderPage = require('./routes/placeorder');


const app = express();

// assigning server to the port number 2002
const port = process.env.PORT || 2002;

// providing the template engine to the express
app.use(bodyparser.json());
app.use(bodyparser.urlencoded({ extended : true }));
app.set('view engine', 'ejs');
app.use(express.static(path.join(__dirname,'public')));

// routing process goes here
    /*
     * Based URL received routing goes here 
     */

app.get('/', homePage);                                         // home page router
app.get('/home', homePage);                                     // home page router
app.post('/category', homePage);                                // category to homePage

app.get('/register',homePage);                                  // Routing to the register page
app.get('/tologin', homePage);                                  // Routing to the login page

app.post('/login', loginPage);                                  // admin to homePage
app.get('/view', detPage);                                      // details page
app.get('/createmenu', detPage);                                // details page
app.get('/update', detPage);                                    // update page render

app.post('/continue', Cmenu);                                   // Cmenu page
app.post('/updmenu', Cmenu);                                    // update menu

app.post('/newuser',newAccount);                                // creating new user

app.post('/ordernow', orderPage);                               // routing to the order page


// listening to the port number
app.listen(port, () => console.log("Server running in the port " + port));