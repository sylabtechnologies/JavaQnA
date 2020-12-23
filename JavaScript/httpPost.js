// https://www.freecodecamp.org/news/here-is-the-most-popular-ways-to-make-an-http-request-in-javascript-954ce8c95aaa/?

var http = require('http');
var str = '';

var senddata = '{"publisherId":10,"publisherName":"hey","publisherAddress":"hey"}';

var options = {
      host: '127.0.0.1',
      path: '/lms/publisher',
      method: 'POST',

      headers: {
        'Content-Type': 'application/json',
        'Content-Length': Buffer.byteLength(senddata)
      }      

  };

var req = http.request(options, function(res) {
    res.setEncoding('utf8');
    res.on('data', function (chunk) {
        console.log('Response: ' + chunk);
    });
});

req.write(senddata);
req.end();


