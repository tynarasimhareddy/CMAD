<html>

<body>
<script src="scripts/jquery-2.1.3.js"></script>
<Script>
$(document).ready(function(){
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
});
</script>
<div id="templates" style="display: none;">
	<table>
		<tr><td>Name</td><td>Email-ID</td><td>JoinDate</td><td>Age</td></tr>
	</table>
</div>
<table id="users" border=1>
<tr><td>Name</td><td>Email-ID</td><td>JoinDate</td><td>Age</td></tr>
</table>
</body>
</html>
