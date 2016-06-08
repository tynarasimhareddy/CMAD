(function(){
	var app = angular.module("myapp",['ngRoute']);
	
	app.config(['$routeProvider',
	            function($routeProvider){
					$routeProvider.
					when('/login',{
						templateUrl : 'login.html',
						controller : 'LoginController'
					}).
					when('/signup',{
						templateUrl : 'signup.html',
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

		$scope.posts = [];
		$scope.loadingPosts = true;
		$scope.showNewPostForm = false;
		var result = $http.get('rest/blog/viewPosts');
		result.success(function(data, status, headers, config){
			$scope.posts = data;
			$scope.loadingPosts = false;
			});
		result.error(function(data, status, headers, config){
				$scope.loadingPosts = false;
				$scope.error = status;
			});
		
		$scope.addPost = function(){
			$http.post("rest/blog/newPost",$scope.post).success(function(data, status, headers, config){
				$scope.post.date = "Just Now"
				$scope.posts.push(angular.copy($scope.post));
				$scope.showNewPostForm = false;
			});
		};
		
		
	});
	
	app.controller("LoginController",function($scope, $http, $log){

		
	});
	
app.controller("SignUpController",function($scope, $http, $log){

		
	});
	
	
	
	
})();