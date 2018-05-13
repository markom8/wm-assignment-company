<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Assignment</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
	<script
			src="http://ajax.googleapis.com/ajax/libs/angularjs/1.6.0/angular.min.js"></script>
	<script src="/js/angular.js"></script>
	<link rel="stylesheet"
		  href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" />
</head>
</head>
<body>
<div class="container" ng-app="app">
	<h1>Employee</h1>

	<div class="row">
		<div ng-controller="postEmployeeController" class="col-md-4">
			<form name="employeeForm" ng-submit="submitForm()">
				<label>FirstName</label>
				<input type="text" name="firstname"	class="form-control" ng-model="firstname" />
				<label>LastName</label>
				<input type="text" name="lastname" class="form-control" ng-model="lastname" />
				<label>PersonalNumber</label>
				<input type="text" name="personalNumber" class="form-control" ng-model="personalNumber" />
				<label>EmployeeType</label>
				<input type="text" name="employeeType" class="form-control" ng-model="employeeType" />
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
			<p>{{postResultMessage}}</p>
		</div>
		<div ng-controller="getallemployeeController" class="col-md-4">
			<h3>All Employees</h3>

			<button ng-click="getAllEmployees()">Get All Employees</button>

			<div ng-show="showAllEmployees">
				<ul class="list-group">
					<li ng-repeat="employee in allemployees">
						<h4 class="list-group-item">
							First Name: {{employee.firstName}}<br />
							Last Name: {{employee.lastName}}<br />
							Personal Number: {{employee.personalNumber}}<br />
							Employee Type: {{employee.employeeType}}
						</h4>
					</li>
				</ul>
			</div>
			<p>{{getResultMessage}}</p>
		</div>
		<div ng-app="myApp" ng-controller="employeesCtrl">

			<ul>
				<li ng-repeat="x in myData">
					Employee: {{ x.firstName + ', ' + x.lastName }}
				</li>
			</ul>

		</div>

	</div>
	<div class="row">

	</div>
</div>
</body>
</html>
