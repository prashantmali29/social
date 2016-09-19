// login user
userManagementModule.service('userManagementService', [
		'$http',
		function($http) {

			this.getAllUser = function(callback) {
				$http.post("/Social/rest/getAllUsers").success(function(users) {
					callback(users);
				}).error(function(data, status) {
					console.log(" in get ALL user error" + status);
				});
			}

			this.edit = function(id, callback) {
				console.log(" in edit user service" + id)
				$http.post("/Social/rest/editUser/" + id).success(
						function(response) {
							callback(response);
						}).error(function(data, status) {
					console.log(" in edit user error" + status)
				});
			}

			this.updateUser = function(userDto, callback) {
				console.log("in update user service ");
				$http.post("/Social/rest/updateUser", userDto).success(
						function(response) {
							if (response) {
								console.log("User updated successfully");
								callback(response);
							} else {
								console.log("User updated failed");
							}
						}).error(function(data, status) {
				});
			}
		} ]);
