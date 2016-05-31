<html>

<body>
<script src="scripts/jquery-2.1.3.js"></script>
<Script>
/* $(document).ready(function(){
	$.get("rest/user", function(data){
		var rowTemplate = $("#templates table").html();
		console.log(rowTemplate);
		for(index in data){
			var row = rowTemplate.replace("Name",data[index].name)
						.replace("Email-ID",data[index].emailId)
						.replace("JoinDate",data[index].joinDate)
						.replace("Age",data[index].age);
			$("#users").append(row);
		}
	});
}); */

function login() {
	
	var userName = document.getElementById("userName").value;
	var password = document.getElementById("password").value;
	 
	if( null == userName || userName.length <= 0){
		alert("UserName cannot be null.");
		return;
	} else if( null == password || password.length <= 0){
		alert("password cannot be null.");
		return;
	} 
	 
	var data = JSON.stringify({ "userName":document.getElementById("userName").value, "pswd":document.getElementById("password").value});
	
    $.ajax({
        type : "POST",
        url : 'rest/blog/login',
        dataType :"json",
        contentType: "application/json",
        data : data,
        success : function(result) {
          alert(result.success);
		}, 
	});
	alert("Login Successful")	
}

function signup() {
	var userName = document.getElementById("userName").value;
	var password = document.getElementById("password").value;
	var email = document.getElementById("email").value;
	
	if( null == userName || userName.length <= 0){
		alert("UserName cannot be null.");
		return;
	} else if( null == password || password.length <= 0){
		alert("password cannot be null.");
		return;
	} else if( null == email || email.length <= 0){
		alert("email cannot be null.");
		return;
	}
	
	
	var data = JSON.stringify({ "userName":document.getElementById("userName").value, "emailId":document.getElementById("email").value, "pswd":document.getElementById("password").value});
	
	$.ajax({
        type : "POST",
        url : 'rest/blog/signUp',
        dataType :"json",
        contentType: "application/json",
        data : data,
        success : function(result) {
          alert(result.success);
		}, 
	});
	alert("SignUp Successful");
}

</script>
<!-- <div id="templates" style="display: none;">
	<table>
		<tr><td>Name</td><td>Email-ID</td><td>JoinDate</td><td>Age</td></tr>
	</table>
</div>
<table id="users" border=1>
<tr><td>Name</td><td>Email-ID</td><td>JoinDate</td><td>Age</td></tr>
</table>
 -->
<div class="sp-pp">
  <div class="container">
    <h2>Sign In</h2>
    <label for="username">
        <span data-text="Username">Username</span>
    </label>
    <input id="userName" type="text" id="username" required/>
    
    <label for="password">
        <span data-text="Password">Password</span>
    </label>
    <input id="password" type="password" id="password" required/>
	
	<label for="email">
        <span data-text="Email">Email</span>
    </label>
    <input id="email" type="text" id="password" required/>
      
  </div>
</div>

<input type='submit' name='do_login' onclick='login();' value='Login'>
<input type='submit' name='do_register' onclick='signup();' value='Register'>

</body>
</html>
