const express = require('express');
const dashRouter = express.Router();

dashRouter.use(express.urlencoded());


// Giving view to the user vision
dashRouter.get('/view', function(reqt, resp)
{
    resp.render('dashboard',
    {
        btns:true,
        view:true,
        createmenu : false,
        failed:false,
        success:false,
        updmenu:false
    });
});

// giving the creaemenu form to the user vision
dashRouter.get('/createmenu', function(reqt, resp)
{
    resp.render('dashboard',
    {
        btns:true,
        view:false,
        createmenu : true,
        failed:false,
        success: false,
        updmenu:false
    });
});

// giving the update menu form to the user vision
dashRouter.get('/update', function(reqt, resp)
{
    resp.render('dashboard',
    {
        btns:true,
        view:false,
        createmenu:false,
        failed:false,
        success:false,
        updmenu:true
    });
});

module.exports = dashRouter;