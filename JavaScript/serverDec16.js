// https://expressjs.com/en/starter/installing.html
var express = require('express');
var app = express();
var fs = require("fs");

app.get('/:id', function (req, res) {
    fs.readFile( "users.json", 'utf8', function (err, data) {
        var users = JSON.parse( data );
        var user = users["user" + req.params.id] 
        console.log( user );
     });
})

var server = app.listen(8081, function () {
   var host = server.address().address
   var port = server.address().port
   console.log("listening at local port ", port)
})
