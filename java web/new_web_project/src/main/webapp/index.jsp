<!DOCTYPE html>
<html>
<head>
	<title>Add Expenses</title>
</head>
<body>
	<p>The current date and time is: <%= new java.util.Date() %></p>

	<form action="/s" method="post">
		<label for="exp_category">Expense Category:</label>
		<select name="exp_category" id="exp_category">
          <option value="transportation">Transportation</option>
          <option value="food">Food</option>
          <option value="fees">Fees</option>
          <option value="bills">Bills</option>
          <option value="entertainment">Entertainment</option>
        </select>
		<br />

        <label for="exp_name">Expense Name:</label>
        <input type="text" id="exp_name" name="exp_name" />
        <br />

        <label for="description">Description:</label>
        <input type="text" id="desc" name="desc" />
        <br />

        <label for="amount">Amount:</label>
        <input type="text" id="amount" name="amount" />
        <br />



		<input type="submit" value="Submit" />
	</form>

</body>
</html>