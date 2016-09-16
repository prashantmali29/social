// login user
userManagementModule.service('userManagementService', ['$http', function ($http) {
	
    this.getAllUser = function (callback) {
    	console.log(" in userManagementService");
        $http.post("/Social/rest/getAllUsers")
            .success(function (users) {
                	console.log(" in get ALL user success" +JSON.stringify(users));
                    callback(users);
            })
            .error(function (data, status) {
            	console.log(" in get ALL user error" +status);
            });
    }
}
])
;
