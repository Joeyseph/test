public class Account {

//Instance variables
 private int studentID;
 private String firstName;
 private String lastName;
 private int correctAnswers;
 private int totalQuestions;
 private double percentCorrect;

 
 //Constructors
 public Account() {
  firstName = "Temporary";
  lastName = "Temporary";
  correctAnswers = 0;
  totalQuestions = 0;
  percentCorrect = 0.0;
 }
 
 public Account(String newFirstName, String newLastName) {
   firstName = newFirstName;
   lastName = newLastName;
   correctAnswers = 0;
   totalQuestions = 0;
   percentCorrect = 0.0;
 }
 
 //Accessors
 
 //Returns the students full name
 public String getName() {
  return firstName + lastName;
 }
 
 //Returns the first name of the student
 public String getFirst() {
   return firstName;
 }
 
 //Returns the last name of the student
 public String getLastName() {
   return lastName;
 }
 
 //Returns total correct answers
 public int getCorrect() {
   return correctAnswers;
 }
 
 //Returns total questions
 public int getTotalQuestions() {
   return totalQuestions;
 }
 
 //Updates and returns the students percent of correct answers
 public double getPercentCorrect() {
   return (correctAnswers * totalQuestions)*100;
 }
 
 //Returns the students ID
 public int getStudentID() {
   return studentID;
 }
 
 //Mutators
 
 //Updates the students number of correct answers and total questions
 //as well as updating the percent correct
 public void addScores(int numCorrect, int numQuestions) {
   addCorrect(numCorrect);
   addQuestions(numQuestions);
   percentCorrect = getPercentCorrect();
 }  
 
 //Updates only the number of correct answers
 public void addCorrect(int numCorrect) {
   correctAnswers = correctAnswers + numCorrect;
 }
 
 //Updates only the number of total questions
 public void addQuestions(int numQuestions) {
   totalQuestions = totalQuestions + numQuestions;
 }
 
}