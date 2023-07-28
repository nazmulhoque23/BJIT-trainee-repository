<%@ page import="java.sql.*" %>

<% Class.forName("com.mysql.cj.jdbc.Driver"); %>

<HTML>
    <HEAD>
        <TITLE>Selecting tableName From a Database</TITLE>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
          <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </HEAD>

    <BODY>
        <H1>Selecting records from Database</H1>

        <%
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/web_app", "root", "");

            Statement statement = connection.createStatement() ;
            ResultSet resultset =
                statement.executeQuery("select * from expense_manager") ;
        %>

        <TABLE class="table">
            <TR>
                <TH>category</TH>
                <TH>date</TH>
                <TH>expense_name</TH>
                <TH>description</TH>
                <TH>amount</TH>
            </TR>
            <% while(resultset.next()){ %>
            <TR>
                <TD> <%= resultset.getString(2) %></td>
                <TD> <%= resultset.getString(3) %></TD>
                <TD> <%= resultset.getString(4) %></TD>
                <TD> <%= resultset.getString(5) %></TD>
                <TD> <%= resultset.getString(6) %></TD>
            </TR>
            <% } %>
        </TABLE>
    </BODY>
</HTML>