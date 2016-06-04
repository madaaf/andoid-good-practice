exports.services = function(app){		
	app.get('/employees', function(req, res) {
		res.sendFile(__dirname +'/employees.json');
	});
}

