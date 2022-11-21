import javax.swing.*;
// Does the file include a public class called
//"Quiz" with a public static method called "main"? ( Please see line 133 )
public class Quiz {
    // graded - This variable holds the users quiz grade
    private static double graded = 5;
    // questionOptions - This is an empty container that gets filled with question options
    static String[] questionOptions = {};
    // questions - This is an empty container that gets filled with question + question options
    // The purpose is to minimize JOptionPane calls
    static String questions = "";
    // contains - This boolean is used to check valid options and is placed at outside of checker()
    // because it is used outside of checker
    static boolean contains = false;
    // quizzed - This boolean is ued to check if user has completed the quiz
    // There is an option to retake the quiz if user failed
    // This acts as a switch, so certain methods can be reset
    static boolean quizzed = false;
    // positioned - This variable helps hold position on quiz if user inputs invalid answer
    static int positioned = 0;
    // answer - This variable is placed here vs in checker() method because of redundant error
    static String answer = "33";
    static String[] validOptions = {"A", "B", "C", "D", "E"};

    //---------------------------This section checks if your answer is valid, and correct -------------//
    @SuppressWarnings("StringConcatenationInLoop")
    static void checker(){
        contains = false;
        // This for loop is to minimize the number of JOptionPane.messageDialog calls
        for(int i = 0; i < questionOptions.length - 1; i++){
            questions += questionOptions[i]+"\n";
        }
        answer = JOptionPane.showInputDialog(questions);
        answer = answer.toUpperCase();
        int i = 0;
        while (i < validOptions.length) {
            if (validOptions[i].equals(answer)) {
                contains = true;
                break;
            }
            i++;
        }
        if(!contains){
            JOptionPane.showMessageDialog(null, "Invalid!");
        }else if(answer.equals(questionOptions[5])){
            JOptionPane.showMessageDialog(null, "Correct!");
            positioned += 1;
        }else{
            JOptionPane.showMessageDialog(null, "Wrong!");
            positioned += 1;
            graded -= 1;
        }
    }
    //-------------------This section checks your grade ------------------//
    static void yourGrade(){
        double yourGrade = graded * 100 / 5;
        JOptionPane.showMessageDialog(null, "You scored " + yourGrade + "%");
        if (yourGrade > 60){
            JOptionPane.showMessageDialog(null,"You passed!");
        }else{
            JOptionPane.showMessageDialog(null,"Sorry, you failed.");
            String[] options = {"Yes", "No"};
            int restart = JOptionPane.showOptionDialog(null, "Do you want to take this quiz again?",
                    "Try again",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            if(restart < 1){
                quizzed = false;
                graded = 5;
                wholeQuiz();
            }
        }
    }
    //------------------This section contains all 5 questions -------//
    static void question1(){
        questions = "1) What is the percent value of 33/57?\n";
        questionOptions = new String[]{"A. 46%", "B. 47.47%", "C. 57.89%", "D. 63.10%", "E. None of the above", "C"};
        checker();
        if(!contains){
            wholeQuiz();
        }
    }
    static void question2(){
        questions = "2) What is the percent value of 5432/6000?\n";
        questionOptions = new String[]{"A. 88%", "B. 87.47%", "C. 90.53%", "D. 79.10%", "E. None of the above", "C"};
        checker();
        if(!contains){
            wholeQuiz();
        }
    }
    static void question3(){
        questions = "3) What language is the letter Aleph from?\n";
        questionOptions = new String[]{"A. Arabic", "B. German", "C. Russian", "D. Hebrew", "E. None of the above", "D"};
        checker();
        if(!contains){
            wholeQuiz();
        }
    }
    static void question4(){
        questions = "4) How many bones are in the human body at birth?\n";
        questionOptions = new String[]{"A. 206", "B. 300", "C. 289", "D. 10", "E. None of the above", "B"};
        checker();
        if(!contains){
            wholeQuiz();
        }
    }
    static void question5(){
        questions = "5) What language is this from 'line-spacing:33px;'?\n";
        questionOptions = new String[]{"A. CSS", "B. HTML", "C. XML", "D. PHP", "E. None of the above", "A"};
        checker();
        if(!contains){
            wholeQuiz();
        }else{
            quizzed = true;
            positioned = 0;
            yourGrade();
        }
    }
    //-----------This section calls each question ==========//
    static void wholeQuiz(){
        while(!quizzed) {
            if(positioned < 1){
                question1();
            }else if(positioned < 2){
                question2();
            }else if(positioned < 3){
                question3();
            }else if(positioned < 4){
                question4();
            }else if(positioned < 5){
                question5();
            }
        }
    }
    public static void main(String[] args){ // Does the file include public static methods called "main"?
        JOptionPane.showMessageDialog(null, "Welcome\nThis quiz will be graded.\nYou need a 61% or higher to pass.");
        wholeQuiz();
        JOptionPane.showMessageDialog(null, "Welcome to the second quiz.");
        boolean easy = false;
        // Does the main method continue to ask the quiz question until the answer is deemed correct?
        //Does the main method have one or more String assignment statements
        // that create a multiple-choice question String?
        //Does the main method have a String assignment statement that records
        // the answer to the quiz question, where the questions are
        // an argument to the method "JOptionPane.showInputDialog"?
        // Line 149 includes both of these
        do {
            String easyQuestion = JOptionPane.showInputDialog(null, "Which of the following numbers is divisible by 3?\nA. 4543\nB. 43265\nC. 4552\nD. 543\nE. None of the above");
            // Does the main method convert the answer String using the "toUpperCase" method?
            easyQuestion = easyQuestion.toUpperCase();
            boolean check = false;
            for (String validOption : validOptions) {
                if (easyQuestion.equals(validOption)) {
                    check = true;
                    break;
                }
            }
            if (easyQuestion.equals("D")) {
                //Does the main method display a message indicating that the answer is
                //correct when the answer matches a particular String ("A", "B", "C", "D", or "E")?
                JOptionPane.showMessageDialog(null, "Correct!");
                easy = true;
            } else if(check) {
                //Does the main method display a message indicating that the answer is
                // incorrect when the answer matches a particular String ("A", "B", "C", "D", or "E" but not the correct choice?)
                JOptionPane.showMessageDialog(null, "Incorrect! Please try again.");
            }else {
                //Does the main method display a message indicating that the answer is
                // invalid when the answer does not match any of the expected Strings ("A", "B", "C", "D", or "E")?
                JOptionPane.showMessageDialog(null, "Invalid. Try again.");
            }
        }while(!easy);
    }
}

