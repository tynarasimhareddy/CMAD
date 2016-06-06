(function(){
	var app = angular.module("myapp",['ngRoute']);
	
	app.config(['$routeProvider',
	            function($routeProvider){
					$routeProvider.
					when('/login',{
						templateUrl : 'login.html',
						controller : 'LoginController'
					}).
					when('/singup',{
						templateUrl : 'singup.html',
						controller : 'SignUpController'
					}).
					when('/home',{
						templateUrl : 'home.html',
						controller : 'HomeController'
					}).
					otherwise({
						redirectTo: '/home'
					});
				}]);
	
	
	app.controller("HomeController",function($scope, $http, $log){

		$scope.loadingPosts = true;
		var result = $http.get('rest/blog/viewPosts');
		result.success(function(data, status, headers, config){
			$scope.posts = data;
			$scope.loadingPosts = false;
			});
		result.error(function(data, status, headers, config){
				$scope.loadingPosts = false;
				$scope.error = status;
			});
	});
	
	app.controller("LoginController",function($scope, $http, $log){

		
	});
	
app.controller("SignUpController",function($scope, $http, $log){

		
	});
	
	
	
	
})();