var mysql = require('mysql');

var conn = mysql.createConnection({
    host     : '??',
    user     : 'admin',
    password : '??',
    database : 'utopia'
});

conn.connect(function(err)
{
    if (err) throw err;
    conn.query("SHOW COLUMNS FROM tbl_booking", function (err, result, fields)
    {
      if (err) throw err;
      console.log(result);
      process.exit(0);
    });
});


