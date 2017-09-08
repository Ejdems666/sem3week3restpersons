<html>
<head>
    <title>Person app</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <link href="assets/style.css" rel="stylesheet">
</head>
<body>
<table class="table table-striped">
    <thead>
    <tr>
        <th>Id</th>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Phone</th>
    </tr>
    </thead>
    <tbody id="table-body">
    </tbody>
</table>
<input type="submit" class="button" onclick="fillTableWithPeople()" value="Refresh">
<form id="add-person">
    <label for="firstName">First name</label><input id="firstName" name="firstName" required>
    <label for="lastName">Last name</label><input id="lastName" name="lastName" required>
    <label for="phone">Phone</label><input id="phone" name="phone" required>
    <input type="submit" class="button" value="Add person">
</form>
<form id="edit-person">
    <input  name="id" type="hidden">
    <label for="firstName1">First name</label><input id="firstName1" name="firstName" required>
    <label for="lastName1">Last name</label><input id="lastName1" name="lastName" required>
    <label for="phone1">Phone</label><input id="phone1" name="phone" required>
    <input type="submit" class="button" value="Edit person">
</form>
<script src="assets/app.js" type="text/javascript"></script>
</body>
</html>
