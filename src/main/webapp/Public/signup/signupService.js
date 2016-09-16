//Sign-up related service
signupModule.service('signupService', ['$http', function ($http) {
	
    this.performSignUp = function (userDto, callback) {
    	
    	console.log("in signup service");
        $http.post("/Social/rest/signUp", userDto)
            .success(function (userDto) {
                if (userDto) {
                    callback();
                } else {
                    //Registration  Failed
                    
                }
            })
            .error(function (data, status) {
               
            });
    }


}
])
;
