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
				<%--<input type="text" name="employeeType" class="form-control" ng-model="employeeType" />--%>
				<select name="cars" name="employeeType" class="form-control" ng-model="employeeType"  >
					<option value="JUNIOR_DEVELOPER" selected="selected">Junior Developer</option>
					<option value="SENIOR_DEVELOPER">Senior Developer</option>
					<option value="TEAM_LEAD">Team Lead</option>
					<option value="PROJECT_MANAGER">Project Manager</option>
				</select>
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

	</div>
	<h1>Team</h1>
	<div class="row">
		<div ng-controller="postTeamController" class="col-md-4">
			<form name="teamForm" ng-submit="submitForm()">
				<label>TeamName</label>
				<input type="text" name="teamName"	class="form-control" ng-model="teamName" />
				<label>DeveloperPersonalNumber</label>
				<input type="text" name="developerPersonalNumber" class="form-control" ng-model="developerPersonalNumber" />
				<label>TeamLeadPersonalNumber</label>
				<input type="text" name="teamLeadPersonalNumber" class="form-control" ng-model="teamLeadPersonalNumber" />
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
			<p>{{postResultMessage}}</p>
		</div>
		<div ng-controller="getallteamController" class="col-md-4">
			<h3>All Teams</h3>

			<button ng-click="getAllTeams()">Get All Teams</button>

			<div ng-show="showAllTeams">
				<ul class="list-group">
					<li ng-repeat="team in allteams">
						<h4 class="list-group-item">
							Team Name: {{team.teamName}}<br />
							<br />
							Developers:<br/>
							<ul class="list-group">
								<li ng-repeat="developer in team.developers">
									<h4 class="list-group-item">
										First Name: {{developer.firstName}}<br />
										Last Name: {{developer.lastName}}<br />
										Personal Number: {{developer.personalNumber}}<br />
										Employee Type: {{developer.employeeType}}
									</h4>
								</li>
							</ul>
							<div>
								<p><br/>
							Team Lead: <br />
										First Name: {{team.teamLead.firstName}}<br />
										Last Name: {{team.teamLead.lastName}}<br />
										Personal Number: {{team.teamLead.personalNumber}}<br />
										Employee Type: {{team.teamLead.employeeType}}
								</p>
							</div>
						</h4>
					</li>
				</ul>
			</div>
			<p>{{getResultMessage}}</p>
		</div>
	</div>

	<h1>Project</h1>
	<div class="row">
		<div ng-controller="postProjectController" class="col-md-4">
			<form name="projectForm" ng-submit="submitForm()">
				<label>ProjectName</label>
				<input type="text" name="projectName"	class="form-control" ng-model="projectName" />
				<label>ClientName</label>
				<input type="text" name="clientName" class="form-control" ng-model="clientName" />
				<label>TeamName</label>
				<input type="text" name="teamName" class="form-control" ng-model="teamName" />
				<label>ProjectManagerPersonalNumber</label>
				<input type="text" name="projectManagerPersonalNumber" class="form-control" ng-model="projectManagerPersonalNumber" />
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
			<p>{{postResultMessage}}</p>
		</div>
		<div ng-controller="getallprojectController" class="col-md-4">
			<h3>All Projects</h3>

			<button ng-click="getAllProjects()">Get All Projects</button>

			<div ng-show="showAllProjects">
				<ul class="list-group">
					<li ng-repeat="project in allprojects">
						<h4 class="list-group-item">
							Project Name: {{project.projectName}}<br />
							Client Name: {{project.clientName}}<br />
							<br />
							Teams:<br/>
							<ul class="list-group">
								<li ng-repeat="team in project.teamRecords">
									<h4 class="list-group-item">
										Team Name: {{team.teamName}}<br />
										<br />
										Developers:<br/>
										<ul class="list-group">
											<li ng-repeat="developer in team.developers">
												<h4 class="list-group-item">
													First Name: {{developer.firstName}}<br />
													Last Name: {{developer.lastName}}<br />
													Personal Number: {{developer.personalNumber}}<br />
													Employee Type: {{developer.employeeType}}
												</h4>
											</li>
										</ul>
										<div>
											<p><br/>
												Team Lead: <br />
												First Name: {{team.teamLead.firstName}}<br />
												Last Name: {{team.teamLead.lastName}}<br />
												Personal Number: {{team.teamLead.personalNumber}}<br />
												Employee Type: {{team.teamLead.employeeType}}
											</p>
										</div>
									</h4>
								</li>
							</ul>
							<div>
								<p><br/>
									Project Manager: <br />
									First Name: {{project.projectManager.firstName}}<br />
									Last Name: {{project.projectManager.lastName}}<br />
									Personal Number: {{project.projectManager.personalNumber}}<br />
									Employee Type: {{project.projectManager.employeeType}}
								</p>
							</div>
						</h4>
					</li>
				</ul>
			</div>
			<p>{{getResultMessage}}</p>
		</div>
	</div>

	<h1>Task</h1>

	<div class="row">
		<div ng-controller="postTaskController" class="col-md-4">
			<form name="taskForm" ng-submit="submitForm()">
				<label>TaskName</label>
				<input type="text" name="taskName"	class="form-control" ng-model="taskName" />
				<label>TaskDescription</label>
				<input type="text" name="taskDescription" class="form-control" ng-model="taskDescription" />
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
			<p>{{postResultMessage}}</p>
		</div>
		<div ng-controller="getalltaskController" class="col-md-4">
			<h3>All Tasks</h3>

			<button ng-click="getAllTasks()">Get All Tasks</button>

			<div ng-show="showAllTasks">
				<ul class="list-group">
					<li ng-repeat="task in alltasks">
						<h4 class="list-group-item">
							Task Name: {{task.taskName}}<br />
							Task Description: {{task.taskDescription}}<br />
						</h4>
					</li>
				</ul>
			</div>
			<p>{{getResultMessage}}</p>
		</div>

	</div>

	<h1>Time Sheet</h1>

	<div class="row">
		<div ng-controller="postTimeSheetController" class="col-md-4">
			<form name="timeSheetForm" ng-submit="submitForm()">
				<label>ProjectName</label>
				<input type="text" name="projectName"	class="form-control" ng-model="projectName" />
				<label>EmployeePersonalNumber</label>
				<input type="text" name="employeePersonalNumber" class="form-control" ng-model="employeePersonalNumber" />
				<label>Date (yyyy-mm-dd)</label>
				<input type="text" name="date" class="form-control" ng-model="date" />
				<label>WorkedHours</label>
				<input type="text" name="workedHours" class="form-control" ng-model="workedHours" />
				<label>Team</label>
				<input type="text" name="team" class="form-control" ng-model="team" />
				<label>TaskName</label>
				<input type="text" name="taskName" class="form-control" ng-model="taskName" />
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
			<p>{{postResultMessage}}</p>
		</div>
		<div ng-controller="getalltimeSheetsController" class="col-md-4">
			<h3>All Time Sheets</h3>

			<button ng-click="getAllTimeSheets()">Get All Time Sheets</button>

			<div ng-show="showAllTimeSheets">
				<ul class="list-group">
					<li ng-repeat="timeSheet in alltimeSheets">
						<h4 class="list-group-item">
							Date: {{timeSheet.date}}<br />
							Worked Hours: {{timeSheet.workedHours}}<br />
							Team: {{timeSheet.team}}<br />
							<br/>
							<br/>
							Task:<br/>
							Task Name: {{timeSheet.taskDTO.taskName}}<br />
							Task Description: {{timeSheet.taskDTO.taskDescription}}<br />
							<br/>
							<br/>
							Employee: <br/>
							First Name: {{timeSheet.employeeDTO.firstName}}<br />
							Last Name: {{timeSheet.employeeDTO.lastName}}<br />
							Personal Number: {{timeSheet.employeeDTO.personalNumber}}<br />
							Employee Type: {{timeSheet.employeeDTO.employeeType}}
							<br/>
							<br/>
							Project Name: {{timeSheet.projectRecord.projectName}}<br />
							Client Name: {{timeSheet.projectRecord.clientName}}<br />
							<br />
							Teams:<br/>
							<ul class="list-group">
								<li ng-repeat="team in timeSheet.projectRecord.teamRecords">
									<h4 class="list-group-item">
										Team Name: {{team.teamName}}<br />
										<br />
										Developers:<br/>
										<ul class="list-group">
											<li ng-repeat="developer in team.developers">
												<h4 class="list-group-item">
													First Name: {{developer.firstName}}<br />
													Last Name: {{developer.lastName}}<br />
													Personal Number: {{developer.personalNumber}}<br />
													Employee Type: {{developer.employeeType}}
												</h4>
											</li>
										</ul>
										<div>
											<p><br/>
												Team Lead: <br />
												First Name: {{team.teamLead.firstName}}<br />
												Last Name: {{team.teamLead.lastName}}<br />
												Personal Number: {{team.teamLead.personalNumber}}<br />
												Employee Type: {{team.teamLead.employeeType}}
											</p>
										</div>
									</h4>
								</li>
							</ul>
							<div>
								<p><br/>
									Project Manager: <br />
									First Name: {{timeSheet.projectRecord.projectManager.firstName}}<br />
									Last Name: {{timeSheet.projectRecord.projectManager.lastName}}<br />
									Personal Number: {{timeSheet.projectRecord.projectManager.personalNumber}}<br />
									Employee Type: {{timeSheet.projectRecord.projectManager.employeeType}}
								</p>
							</div>
						</h4>
					</li>
				</ul>
			</div>
			<p>{{getResultMessage}}</p>
		</div>

	</div>

	<h1>Person Work Log</h1>

	<div class="row">
		<div ng-controller="gettimesheetsbyprsonalnumberandprojectnameController" class="col-md-4">
			<h3>Employee Personal Number</h3>
			<input type="text" class="form-control" style="width: 100px;" ng-model="personalNumber" /><br />
			<h3>Project Name</h3>
			<input type="text" class="form-control" style="width: 100px;" ng-model="projectName" /><br />

			<button ng-click="getTimeSheetsByPresonalNumberAndProject()">Get Work Log</button>

			<div ng-show="showTimeSheetsByPresonalNumberAndProject">
				Sum Of Working Hours: {{workLog.sumOfWorkingHours}}<br/>
				<ul class="list-group">
					<li ng-repeat="timeSheet in workLog.timeSheetRecords">
						<h4 class="list-group-item">
							Date: {{timeSheet.date}}<br />
							Worked Hours: {{timeSheet.workedHours}}<br />
							Team: {{timeSheet.team}}<br />
							<br/>
							<br/>
							Task:<br/>
							Task Name: {{timeSheet.taskDTO.taskName}}<br />
							Task Description: {{timeSheet.taskDTO.taskDescription}}<br />
							<br/>
							<br/>
							Employee: <br/>
							First Name: {{timeSheet.employeeDTO.firstName}}<br />
							Last Name: {{timeSheet.employeeDTO.lastName}}<br />
							Personal Number: {{timeSheet.employeeDTO.personalNumber}}<br />
							Employee Type: {{timeSheet.employeeDTO.employeeType}}
							<br/>
							<br/>
							Project Name: {{timeSheet.projectRecord.projectName}}<br />
							Client Name: {{timeSheet.projectRecord.clientName}}<br />
							<br />
							Teams:<br/>
							<ul class="list-group">
								<li ng-repeat="team in timeSheet.projectRecord.teamRecords">
									<h4 class="list-group-item">
										Team Name: {{team.teamName}}<br />
										<br />
										Developers:<br/>
										<ul class="list-group">
											<li ng-repeat="developer in team.developers">
												<h4 class="list-group-item">
													First Name: {{developer.firstName}}<br />
													Last Name: {{developer.lastName}}<br />
													Personal Number: {{developer.personalNumber}}<br />
													Employee Type: {{developer.employeeType}}
												</h4>
											</li>
										</ul>
										<div>
											<p><br/>
												Team Lead: <br />
												First Name: {{team.teamLead.firstName}}<br />
												Last Name: {{team.teamLead.lastName}}<br />
												Personal Number: {{team.teamLead.personalNumber}}<br />
												Employee Type: {{team.teamLead.employeeType}}
											</p>
										</div>
									</h4>
								</li>
							</ul>
							<div>
								<p><br/>
									Project Manager: <br />
									First Name: {{timeSheet.projectRecord.projectManager.firstName}}<br />
									Last Name: {{timeSheet.projectRecord.projectManager.lastName}}<br />
									Personal Number: {{timeSheet.projectRecord.projectManager.personalNumber}}<br />
									Employee Type: {{timeSheet.projectRecord.projectManager.employeeType}}
								</p>
							</div>
						</h4>
					</li>
				</ul>
			</div>
			<p>{{getResultMessage}}</p>
		</div>
	</div>
</div>
</body>
</html>
