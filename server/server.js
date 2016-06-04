
var path = require('path');
var express = require('express');
var http = require('http');
var app = express();

// for images
app.use(express.static(path.join(__dirname, 'images')));

require('./module/employeeService.js').services(app);

var server = http.createServer(app);
server.listen(5003);
console.log("server listen on port 5003");


