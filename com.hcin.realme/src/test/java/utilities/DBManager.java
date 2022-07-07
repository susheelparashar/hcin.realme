package utilities;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;

/*
 * @author: Puneet Joshi
 */

public class DBManager {

	Properties pr;
	ChromeDriver driver;
		
	public DBManager(ChromeDriver driver, Properties pr)
	{
		this.driver=driver;
		this.pr=pr;
	}
    
    public String getOtp(String mobile) throws ClassNotFoundException, SQLException, IOException {

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=" 
        + pr.getProperty("hostName") 
        + ")(PORT=1521))(CONNECT_DATA=(UR=A)(SERVICE_NAME=" 
        + pr.getProperty("serviceName") 
        + ")(SERVER=DEDICATED)))", pr.getProperty("dbUsername"), pr.getProperty("dbPassword"));

        System.out.println("DB_ACK >> DB connected !"+mobile);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt
                .executeQuery("Select otp from quest.consent_verification where id=(select Max(id) from quest.consent_verification where mobile ="+ mobile+")");
        System.out.println("OTP");
        String otp = null;
        if (rs != null) {
            while (rs.next()) {
                otp = String.valueOf(rs.getString("OTP"));
            }
        }
        System.out.println("==(OTP)==");
        con.close();
        return otp;

    }


}
