<html>
    <head>
        <title>AppSec PV - Auto Report</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
    </head>
    <body>
        <br>
        <div><center><font size = "6" color = "blue">Spirent AppSec - Automation Report</font></center></div>
        
        <br>
        <br>
        <center>
        <form name="TableInputForm" action="response.jsp">
            REST API Automation (all results): <br>
            Enter the build and press OK
            <input type="text" name="table" value="" />
            <input type="submit" value="OK" />
            <br>
            
        </form>
        </center>
    
    <br>
        <br>
        <center>
        <form name="TableInputForm" action="response_failed.jsp">
            REST API Automation (failed test cases): <br>
            Enter the build and press OK
            <input type="text" name="table" value="" />
            <input type="submit" value="OK" />
            <br>
            
        </form>
        </center>
    
    
    
        <br>
        <br>
        <center>
        <form name="TableInputForm" action="response_ui.jsp">
            UI Automation (all results): <br>
            Enter the build and press OK
            <input type="text" name="tableui" value="" />
            <input type="submit" value="OK" />
            <br>
            
        </form>
        </center>
        
        <br>
        <br>
        <center>
        <form name="TableInputForm" action="response_ui_failed.jsp">
            UI Automation (failed test cases): <br>
            Enter the build and press OK
            <input type="text" name="tableui" value="" />
            <input type="submit" value="OK" />
            <br>
            
        </form>
        </center>
    </body>
</html>
