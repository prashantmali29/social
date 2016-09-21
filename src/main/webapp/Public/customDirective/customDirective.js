customDirectiveModule.directive("listOfUsers", function() {
	return {
		// restrict : 'AE',
		templateUrl : "directive/listOfUsers.html",
		replace : true,
	};
})