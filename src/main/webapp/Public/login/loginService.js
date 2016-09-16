// login user
loginModule.service('loginService', ['$http', function ($http) {
	
    this.performLogin = function (userName, password, callback) {
        $http.post("/Social/rest/login", {userName: userName, password: password})
            .success(function (userDto) {
                
                	console.log(" in login successful" +JSON.stringify(userDto));
                    callback(userDto);
               
            })
            .error(function (data, status) {
               
            });
    }
}
])
;
