// login user
App.service('loginService', ['$http', function ($http) {
    this.performLogin = function (username, password, callback) {
        $http.post("/Social/rest/login", {userName: username, password: password})
            .success(function (userDto) {
                if (userDto) {
                    callback();
                } else {
                    //Login Failed
                }
            })
            .error(function (data, status) {
               
            });
    }

    this.performSignUp = function (userDto, callback) {
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
