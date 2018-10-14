package my.java.pack;
import java.sql.*;

public class TableClass_failed{
    private String table;
    private String tableui;
    public TableClass_failed() {
        table = null;
        tableui = null;
    }
    public void setTable(String data) {
        this.table = data;
    }    
    public String getTable() {
        return table;
    }
    public void setTableui(String data) {
        this.tableui = data;
    }    
    public String getTableui() {
        return tableui;
    }
    
    
    public String getFormattedTable() {
        String table_start = "<table style=\"width:100%\">";
        String table_stop = "</table>";
        String row_start = "<tr>";
        String row_stop = "</tr>";
        String column_start = "<th>";
        String column_start_pass = "<th bgcolor=\"#99ffcc\">";
        String column_start_fail = "<th bgcolor=\"#ffb5cb\">";
        String column_stop = "</th>";
        String new_platform_table_breaker = table_stop + "<br><br>" + table_start;
        
        String statistics = null;
        int total_number_of_tests = 0;
        int total_number_of_passed_tests = 0;
        
        String final_table = table_start;
        
        try {
            // Connect to DataBase
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection db_con = DriverManager.getConnection("jdbc:mysql://10.141.40.34:3306/appsec_pv_auto_report","cstanuica","spirent");
            
            // Execute Query
            Statement db_statement = db_con.createStatement();
            ResultSet db_rs = db_statement.executeQuery("select * from RestAPI where BUILD='"+this.table+"' AND RESULT = 'FAIL' ORDER BY PLATFORM, ID ASC");
            
            //Create Header and add to table
            //Create Header and add to table
            String header_row = row_start;
            header_row = header_row + column_start + "ID" + column_stop;
            header_row = header_row + column_start + "BUILD" + column_stop;
            header_row = header_row + column_start + "PLATFORM" + column_stop;
            header_row = header_row + column_start + "TEST" + column_stop;
            
            header_row = header_row + column_start + "RESULT" + column_stop;
            header_row = header_row + column_start + "DETAILS" + column_stop;
            header_row = header_row + row_stop;
            
            final_table = final_table + header_row;
            
            //Create each row and break the table when needed
            String previous_platform = null;
            String current_row = null;
            
            while (db_rs.next()) {
                current_row = row_start;
                // Add all information, except RESULT
                for (int i =1; i <= 4; i++) {
                    current_row = current_row + column_start + db_rs.getString(i) + column_stop;
                }
                
                //Verify result, populate statistics and add RESULT column with correct color
                if (db_rs.getString(5).equals("FAIL")) {
                    //Increment total number of tests
                    total_number_of_tests++;
                    //Add Result column with color red
                    current_row = current_row + column_start_fail + db_rs.getString(5) + column_stop;
                } else if (db_rs.getString(5).equals("PASS")) {
                    //Increment total number of tests and total number of PASS tests
                    total_number_of_tests++;
                    total_number_of_passed_tests++;
                    //Add Result column with color green
                    current_row = current_row + column_start_pass + db_rs.getString(5) + column_stop;
                } else {
                    //Increment total number of tests and total number of PASS tests
                    total_number_of_tests++;
                    //Add Result column with color green
                    current_row = current_row + column_start + db_rs.getString(5) + column_stop;
                }
                
                //Add DETAILS information and close row
                 if(db_rs.getString(6) == null){
                    current_row = current_row + column_start + "" + column_stop;
                }else{
                    current_row = current_row + column_start + db_rs.getString(6) + column_stop;
                }
                current_row = current_row + row_stop;
                
                // Verify if the platform was changed. If so, breack in new table
                if (previous_platform == null) {
                    previous_platform = db_rs.getString(3);
                } else if (previous_platform.equals(db_rs.getString(3)) == false) {
                    previous_platform = db_rs.getString(3);
                    final_table = final_table + new_platform_table_breaker + header_row;
                }
                
                final_table = final_table + current_row;
            }
            
            // Closse DataBase
            db_con.close();
        }
        catch (Exception e) {
            System.out.println(e);
            return "DataBase ERROR! <br><br>" + e;
        }
        
        final_table = final_table + table_stop;
        
        // Populate statistics with Number of tests and Pass percentage
        statistics = "Total Number of FAILED Tests: " + total_number_of_tests + "<br>";
        
        
        final_table = statistics + final_table;
        
        return final_table;
    }
    public String getFormattedTableUi() {
        String table_start = "<table style=\"width:100%\">";
        String table_stop = "</table>";
        String row_start = "<tr>";
        String row_stop = "</tr>";
        String column_start = "<th>";
        String column_start_pass = "<th bgcolor=\"#99ffcc\">";
        String column_start_fail = "<th bgcolor=\"#ffb5cb\">";
        String column_stop = "</th>";
        String new_platform_table_breaker = table_stop + "<br><br>" + table_start;
        
        String statistics = null;
        int total_number_of_tests = 0;
        int total_number_of_passed_tests = 0;
        
        String final_table = table_start;
        
        try {
            // Connect to DataBase
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection db_con = DriverManager.getConnection("jdbc:mysql://10.141.40.34:3306/appsec_pv_auto_report","cstanuica","spirent");
            
            // Execute Query
            Statement db_statement = db_con.createStatement();
            ResultSet db_rs = db_statement.executeQuery("select * from UI where BUILD='"+this.tableui+"' AND RESULT = 'FAIL' ORDER BY PLATFORM, ID ASC");
            
            //Create Header and add to table
            String header_row = row_start;
            header_row = header_row + column_start + "ID" + column_stop;
            header_row = header_row + column_start + "BUILD" + column_stop;
            header_row = header_row + column_start + "PLATFORM" + column_stop;
            header_row = header_row + column_start + "TEST" + column_stop;
            header_row = header_row + column_start + "RESULT" + column_stop;
            header_row = header_row + column_start + "DETAILS" + column_stop;
            header_row = header_row + row_stop;
            
            final_table = final_table + header_row;
            
            //Create each row and break the table when needed
            String previous_platform = null;
            String current_row = null;
            
            while (db_rs.next()) {
                current_row = row_start;
                // Add all information, except RESULT
                for (int i =1; i <= 4; i++) {
                    current_row = current_row + column_start + db_rs.getString(i) + column_stop;
                }
                
                //Verify result, populate statistics and add RESULT column with correct color
                if (db_rs.getString(5).equals("FAIL")) {
                    //Increment total number of tests
                    total_number_of_tests++;
                    //Add Result column with color red
                    current_row = current_row + column_start_fail + db_rs.getString(5) + column_stop;
                } else if (db_rs.getString(5).equals("PASS")) {
                    //Increment total number of tests and total number of PASS tests
                    total_number_of_tests++;
                    total_number_of_passed_tests++;
                    //Add Result column with color green
                    current_row = current_row + column_start_pass + db_rs.getString(5) + column_stop;
                } else {
                    //Increment total number of tests and total number of PASS tests
                    total_number_of_tests++;
                    //Add Result column with color green
                    current_row = current_row + column_start + db_rs.getString(5) + column_stop;
                }
                
                //Add DETAILS information and close row
                if(db_rs.getString(6) == null){
                    current_row = current_row + column_start + "" + column_stop;
                }else{
                    current_row = current_row + column_start + db_rs.getString(6) + column_stop;
                }
                current_row = current_row + row_stop;
                
                // Verify if the platform was changed. If so, breack in new table
                if (previous_platform == null) {
                    previous_platform = db_rs.getString(3);
                } else if (previous_platform.equals(db_rs.getString(3)) == false) {
                    previous_platform = db_rs.getString(3);
                    final_table = final_table + new_platform_table_breaker + header_row;
                }
                
                final_table = final_table + current_row;
            }
            
            // Closse DataBase
            db_con.close();
        }
        catch (Exception e) {
            System.out.println(e);
            return "DataBase ERROR! <br><br>" + e;
        }
        
        final_table = final_table + table_stop;
        
        // Populate statistics with Number of tests and Pass percentage
        statistics = "Total Number of Executed Tests: " + total_number_of_tests + "<br>";
        statistics = statistics + "Total Number of Passed Tests: " + total_number_of_passed_tests + "<br>";
        statistics = statistics + "PASS PERCENTAGE: " + ((float)total_number_of_passed_tests / total_number_of_tests)*100 + "%<br><br>" ;
        
        final_table = statistics + final_table;
        
        return final_table;
    }
}
