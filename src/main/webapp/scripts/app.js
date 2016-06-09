(function(){
	var app = angular.module("myapp",['ngRoute']);
	
	app.config(['$routeProvider',
	            function($routeProvider){
					$routeProvider.
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
		$scope.showSignupForm=false;
		$scope.showLoginForm=false;
		$scope.showAddPostOption = false;
		$scope.showSignUpOption = true;
		$scope.showLoginOption = true;
		$scope.showLogoutOption = false;
		$scope.currentUser = "Guest";
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
			$scope.post.author = $scope.currentUser;
			$http.post("rest/blog/newPost",$scope.post).success(function(data, status, headers, config){
				if(data == "Added the post Successfully"){
					$scope.post.date = "Just Now";
					$scope.posts.push(angular.copy($scope.post));
					$scope.showNewPostForm = false;
					$scope.post = {};
				}
				alert(data);
				
			});
		};
		
		$scope.addUser = function(){
			$http.post("rest/blog/signUp",$scope.user).success(function(data, status, headers, config){
				$scope.user={};
				$scope.showSignupForm=false;
				alert(data);
				});
		};
		
		$scope.login = function(){
			$http.post("rest/blog/login",$scope.loginUser).success(function(data, status, headers, config){
				$scope.showLoginForm=false;
				alert(data);
				if(data == "Logged in succesfully"){
					$scope.currentUser = $scope.loginUser.userName;
					$scope.showAddPostOption = true;
					$scope.showSignUpOption = false;
					$scope.showLogoutOption = true;
					$scope.showLoginOption = false;
				}
				$scope.loginUser={};
				});
		};
		
		$scope.logout = function(){
			$scope.currentUser = "Guest";
			$scope.showAddPostOption = false;
			$scope.showSignUpOption = true;
			$scope.showLoginOption = true;
			$scope.showLogoutOption = false;
			alert("Succesfully logged out");
		};
		
	});
	
})();