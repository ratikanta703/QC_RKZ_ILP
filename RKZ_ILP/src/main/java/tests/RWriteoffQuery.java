package tests;

import java.sql.ResultSet;

/*import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import oracle.jdbc.OracleTypes;

public class RWriteoffQuery extends QCStore{
	public static String VERIFICATION_FEE;

	public static void proc() throws ClassNotFoundException, SQLException {
		Connection conn = null;

		// Object of Statement. It is used to create a Statement to execute the
		// query
		Statement stmt = null;

		// Object of ResultSet => 'It maintains a cursor that points to the
		// current row in the result set'
		ResultSet resultSet = null;
		List<String> rowValues = new ArrayList();
		List<String> rowValues2 = new ArrayList();
		int total_sum[] = null;
		String stotal[] = new String [20];
		//String stotal[] = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		test.log(LogStatus.INFO, "****** Data Base Verification Has Started ******");
		 //System.out.println("before conn");
		// Open a connection
		try {

			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.254:1521:QFUNDUAT4", "ACSPROD_AUTOM_MAR0419",
					"ACSProdAuto194");
			test.log(LogStatus.PASS, "Connecting to DB To Validate WriteOff ");

		} catch (SQLException e1) {

			System.out.println("Connection Failed! Check output console" + e1);
			e1.printStackTrace();
		}

		// Execute a query
		stmt = conn.createStatement();
		//loan_nbr="10863916";
		//System.out.println("after conn");
		try {
		
			 
			 
			//resultSet = stmt.executeQuery("select VERIFICATION_FEE FROM  st_il_distribution A WHERE A.iLOAN_TRAN_CODE IN (SELECT iLOAN_TRAN_CODE  From  st_il_trans Where iloan_code In (Select iloan_code From st_il_Master Where iloan_code="+loan_nbr+"))");
			resultSet = stmt.executeQuery("exec PRC_PDL_ILP_CHARGEOFF("+business_date+")");
			                               
			
			//resultSet = stmt.executeQuery("update ca_ss_store_date set st_date= '"+Proc_Date+"' ST_DATE_ID='PRO' and st_code in (2997,2029,99999)");
			
			
			//select VERIFICATION_FEE FROM  st_il_distribution A WHERE A.iLOAN_TRAN_CODE IN (SELECT iLOAN_TRAN_CODE  From  st_il_trans Where iloan_code In (Select iloan_code From st_il_Master Where iloan_code=10863916));
			 test.log(LogStatus.PASS, "Executing the query to validate Writeoff");
			
			 //test.log(LogStatus.PASS, "Getting values from the tables ILOAN_TRAN_CODE,PAY_INTEREST and UNPAID_INTEREST with the loan number"+loan_nbr);

			while (resultSet .next())
			{
				
			 
			 System.out.println(resultSet .getString(1));
				VERIFICATION_FEE = resultSet .getString(1);
				System.out.println(VERIFICATION_FEE);
				test.log(LogStatus.PASS, "<FONT color=green style=Arial> VERIFICATION FEE is :" +VERIFICATION_FEE);
				test.log(LogStatus.PASS, "<FONT color=green style=Arial> In Verification Fee Column the Value is Null");
				 //App_BoCode = "2520717";
				
		} 
			 
			System.out.println("after query");
			
			
			
			
			

			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e) {
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}
			}
		} 
		catch (Exception e2) {

			System.out.println(" console" + e2);
			e2.printStackTrace();
		}

	}

}*/

//====================================

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.relevantcodes.extentreports.LogStatus;

import java.sql.CallableStatement;

public class RWriteoffQuery extends QCStore{
	 
    /**
     * Get skills by candidate id
     *
     * @param candidateId
     */
    //public static void getSkills(int candidateId) {
    	public static void proc() throws ClassNotFoundException, SQLException {
        // 
    		test.log(LogStatus.INFO,"************************** Connecting To DB To Validate WriteOff By Executing Procedure ********************************");
    	Connection conn = null;
        //String query = "execute PRC_PDL_ILP_CHARGEOFF('"+business_date+"')";
        
        String storedProc = "{call PRC_PDL_ILP_CHARGEOFF('" + business_date + "')}";
        ResultSet rs;
 
        try 
         {
        	
            
        	conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.254:1521:QFUNDUAT4", "ACSPROD_AUTOM_MAR0419",
					"ACSProdAuto194");
			test.log(LogStatus.PASS, "Connecting to DB Successfully ");
			
			CallableStatement stmt = conn.prepareCall(storedProc);
			//Connection connection = null;
			PreparedStatement pstmt=conn.prepareStatement(storedProc);
			//pstmt.setString(1,someVariable);
			pstmt.execute(storedProc);

            //rs = stmt.executeQuery("{call PRC_PDL_ILP_CHARGEOFF('" + business_date + "')}");
			rs = stmt.executeQuery();
		
			
			test.log(LogStatus.PASS, "PRC_PDL_ILP_CHARGEOFF Procedure Executed Successfully ");
			test.log(LogStatus.PASS,"************************************************");
            /*while (rs.next()) {
                //System.out.print;ln(String.format("%s - %s",                      
                        rs.getString(1);
            }*/
            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
 
    /**
     *
     * @param args
     */
   
}
