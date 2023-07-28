
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Add Expenses</title>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
    <h2 align= "left" style="left: 20px;">Add expenses</h2>
    </br>

	<form action="<%= request.getContextPath() %>/s" method="post">

	   <div class = "form-group col-md-6">
		<label for="exp_category">Expense Category:</label>
		<select name="exp_category" id="exp_category" class = "form-control col-sm-5">
          <option value="transportation">Transportation</option>
          <option value="food">Food</option>
          <option value="fees">Fees</option>
          <option value="bills">Bills</option>
          <option value="entertainment">Entertainment</option>
        </select>
       </div>
		<br />

       <div class = "form-group col-md-6">
        <label for="date">Date:</label>
        <input type="date" id="date" name="date" class = "form-control col-sm-5" />
       </div>
        <br />

       <div class = "form-group col-md-6">
        <label for="exp_name">Expense Name:</label>
        <input type="text" id="exp_name" name="exp_name" class = "form-control col-sm-5" />
       </div>
        <br />

       <div class = "form-group col-md-6">
        <label for="description">Description:</label>
        <textarea type="text" id="desc" name="desc" class = "form-control col-sm-5"></textarea>
       </div>
        <br />

       <div class = "form-group col-md-6">
        <label for="amount">Amount:</label>
        <input type="text" id="amount" name="amount" class = "form-control col-sm-5" />
       </div>
        <br />

        <div class="col-auto">
       <button type="submit" class="btn btn-primary" style= "align-items:center;">Submit</button>
        </div>
	</form>

    <a href="show.jsp">
        <div class = "col-auto">
        <button class="btn btn-primary" style= "display: inline-block; margin-top:10px;">
              <span class="button--inner">Go to records from database page</span>
        </button>
        </div>
    </a>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>