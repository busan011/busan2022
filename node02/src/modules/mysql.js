var mysql = require('mysql');

var conn = mysql.createConnection({
    host: "192.168.99.103",
    user: "scott",
    password: "tiger",
    port:3306,
    database:'mydb'
});
//var sql='CREATE TABLE IF NOT EXISTS dept (DEPTNO int(11) DEFAULT NULL,DNAME varchar(14) DEFAULT NULL,LOC varchar(13) DEFAULT NULL) ENGINE=InnoDB DEFAULT CHARSET=utf8';
//var sql="insert into dept values (3333,'회계팀','창원')";
conn.connect(function(err) {
    if (err) throw err;
    console.log("Connected!");
});

module.exports=conn;