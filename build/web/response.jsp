<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>REST Automation Report</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 2px;
        }

        tr:nth-child(1) {
            background-color: #dddddd;
        }
    </style>
    <body>
    <jsp:useBean id="mybean" scope="session" class="my.java.pack.TableClass" />
    <jsp:setProperty name="mybean" property="table" />
    <center><font size = "6" color = "blue">Showing results for build <jsp:getProperty name="mybean" property="table" />:</font></center>
    <br>
    <br>
    <font size = "2"> <jsp:getProperty name="mybean" property="formattedTable" /></font>
</body>
</html>
