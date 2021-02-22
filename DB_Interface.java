import java.sql.*;
import java.util.*;
import java.io.IOException;

public class DB_Interface {

	// Server Connection Info
	static Connection connect = null; // Initialize the connection object
	static final String url = "jdbc:mysql://cmpt322.ckwho3dwhqhy.us-west-1.rds.amazonaws.com:3306/sys";// Server hostname
	static final String user = "admin";// Server username
	static final String pass = "SoftwareE2021";// Server password

	// QUERIES
	private static final String addStudent = "INSERT INTO Student (firstName, lastName)\n"
			+ "VALUES (?, ?);";// Query to add a student to the database
	
	private static final String addResult = "INSERT INTO Result (studentID, score)\n"
	+"VALUES (?, ?);";// Query to add a result into the database
	
	private static final String addAddSubQuestion = "INSERT INTO Questions (questionType, leftNum, operator, rightNum, answer)\n"
			+ "VALUES (add.sub, ?, ?, ?, ?);";// Query to add an addition or subtraction question to the database
	
	private static final String addPlaceQuestion = "INSERT INTO Questions (questionType, number, place, answer)\n"
			+ "VALUES (place, ?, ?, ?);";// Query to add place questions to the database
	
	private static final String getStudentID = "SELECT ID\n"
			+ "FROM Student\n"
			+ "WHERE firstName = '?' AND lastName = '?'";// Query to get the ID of a specific student
	
	private static final String getStudentResults = "SELECT *\n"
			+ "FROM Results\n"
			+ "WHERE StudentID = ?";// Query to get the results of a specific student

	// Prepared Statements for our queries
	private PreparedStatement addStudentPP;// Prepared statement for adding a student
	private PreparedStatement addResultPP;// Prepared statement for adding a result
	private PreparedStatement addAddSubQuestionPP;// Prepared statement for adding an addition or subtraction question
	private PreparedStatement addPlaceQuestionPP;// Prepared statement for adding a place question
	private PreparedStatement getStudentIDPP;// Prepared statement for getting the student's ID
	private PreparedStatement getStudentResultsPP;// Prepared statement for getting the student's Results

	public DB_Interface() throws SQLException {
		connect();// Calls the connection to the database 
	}

	//Connects to the database
	public void connect() throws SQLException {
		try {
			connect = DriverManager.getConnection(url, user, pass);// Opens connection to server
		} catch (SQLException ex) {
			ex.printStackTrace();// Catches SQL Exceptions
		} /*finally {
			try {
				if(connect != null && !connect.isClosed())
					System.out.println("Connected");
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}*/ //Tests if the connection is successful, uncomment if something doesn't seem to be working.

		// Prepares the statements to give to the database
		this.addStudentPP = this.connect.prepareStatement(addStudent);
		this.addResultPP = this.connect.prepareStatement(addResult);
		this.addAddSubQuestionPP = this.connect.prepareStatement(addAddSubQuestion);
		this.addPlaceQuestionPP = this.connect.prepareStatement(addPlaceQuestion);
		this.getStudentIDPP = this.connect.prepareStatement(getStudentID);
		this.getStudentResultsPP = this.connect.prepareStatement(getStudentResults);
		
		//We have to add logic and code here in order to execute the correct query (in a loop)
		
	}

	//Adds students to the database
	public void addStudent(String first, String last) throws SQLException {
		addStudentPP.setString(1, first);// Sets the first name to be the inputed value
		addStudentPP.setString(2, last);// Sets the last name to be the inputed value
		
		addStudentPP.execute();// Executes the query, adding the first and last name to the database
	}
	
	//Adds results to the database
	public void addResult(int studentID, double score) throws SQLException {
		//Sets the variable values in the query
		addResultPP.setInt(1, studentID);
		addResultPP.setDouble(2, score);
		
		addResultPP.execute();// Executes the query
	}
	
	//Adds an addition or subtraction problem to the database
	public void addAddSubQuestion(int left, String operator, int right, double answer) throws SQLException {
		//Sets the variable values in the query
		addAddSubQuestionPP.setInt(1, left);
		addAddSubQuestionPP.setString(2, operator);
		addAddSubQuestionPP.setInt(3, right);
		addAddSubQuestionPP.setDouble(4, answer);
		
		addAddSubQuestionPP.execute();// Executes the query
	}
	
	//Adds a place question to the database
	public void addPlaceQuestion(double number, String place, double answer) throws SQLException {
		//Sets the variable values in the query
		addPlaceQuestionPP.setDouble(1, number);
		addPlaceQuestionPP.setString(2, place);
		addPlaceQuestionPP.setDouble(3, answer);
		
		addPlaceQuestionPP.execute();// Executes the query
	}
	
	//Closes the database connection
	public static void close() {
		try {
			connect.close();// Closes the server connection
		} catch (SQLException ex) {
			ex.printStackTrace();// Catches SQL Exceptions
		}
	}
}
