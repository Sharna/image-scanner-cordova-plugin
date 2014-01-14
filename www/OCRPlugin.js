
var exec = require('cordova/exec');
var scan = function (success, fail) {
	exec(success, fail, "OcrPlugin", "scan", []);
};
module.exports = scan;

