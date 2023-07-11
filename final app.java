import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Quiz {
    private String title;
    private List<Question> questions;

    public Quiz(String title) {
        this.title = title;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void startQuiz() {
        System.out.println("Welcome to the " + title + " quiz!");

        // Shuffle the questions
        Collections.shuffle(questions);

        int score = 0;
        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            for (int i = 0; i < question.getOptions().size(); i++) {
                System.out.println((i + 1) + ". " + question.getOptions().get(i));
            }

            System.out.print("Enter your answer (1-" + question.getOptions().size() + "): ");
            int answer = getUserInput();
            System.out.println();

            if (question.isCorrect(answer)) {
                System.out.println("Correct answer!");
                score++;
            } else {
                System.out.println("Wrong answer!");
            }
        }

        System.out.println("Quiz ended. Your score: " + score + "/" + questions.size());
        rateScore(score);
    }

    private void rateScore(int score) {
        if (score >= 1 && score <= 3) {
            System.out.println("Rating: Bad");
        } else if (score >= 4 && score <= 6) {
            System.out.println("Rating: You can do better");
        } else if (score >= 7 && score <= 8) {
            System.out.println("Rating: Satisfactory");
        } else if (score == 9 || score == 10) {
            System.out.println("Rating: You played well");
        }
    }

    private int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        return userInput;
    }
}

class Question {
    private String questionText;
    private List<String> options;
    private int correctAnswer;

    public Question(String questionText, List<String> options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public boolean isCorrect(int answer) {
        return answer == correctAnswer;
    }
}

public class Quiz_App {
    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        System.out.println("Welcome to the Quiz App!");
        System.out.print("Enter your name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println();

        System.out.println("Hello, " + name + "!");
        System.out.println("1. Start Quiz");
        System.out.println("2. Quit");

        int choice = getUserInput();
        System.out.println();

        switch (choice) {
            case 1:
                Quiz quiz = createQuiz();
                quiz.startQuiz();
                break;
            case 2:
                System.out.println("Thank you for playing!");
                break;
            default:
                            
                System.out.println("Invalid choice. Please try again.");
                displayMainMenu();
                break;
        }
        //
        boolean playAgain = true;
    while (playAgain) {
        System.out.println( name + "wanna play again?");
        System.out.println("1. Start Quiz");
        System.out.println("2. Quit");

        int choice2 = getUserInput();
        System.out.println();

        switch (choice2) {
            case 1:
                Quiz quiz = createQuiz();
                quiz.startQuiz();
                break;
            case 2:
                System.out.println("Thank you for playing!");
                playAgain = false;
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
    }

    public static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        return userInput;
    }

    public static Quiz createQuiz() {
        Quiz quiz = new Quiz("General Knowledge Quiz");

        List<String> question1Options = new ArrayList<>();
        question1Options.add("Java");
        question1Options.add("C++");
        question1Options.add("Python");
        question1Options.add("JavaScript");
        Question question1 = new Question("Which programming language is used for Android app development?", question1Options, 1);
        quiz.addQuestion(question1);

        List<String> question2Options = new ArrayList<>();
        question2Options.add("OpenAI");
        question2Options.add("Microsoft");
        question2Options.add("Google");
        question2Options.add("Facebook");
        Question question2 = new Question("Which company developed the GPT-3 language model?", question2Options, 1);
        quiz.addQuestion(question2);
List<String> question3Options = new ArrayList<>();
        question3Options.add("OpenAI");
        question3Options.add("Tesla");
        question3Options.add("SpaceX");
        question3Options.add("Microsoft");
        Question question3 = new Question("Which company was founded by Elon Musk?", question3Options, 3);
        quiz.addQuestion(question3);

        List<String> question4Options = new ArrayList<>();
        question4Options.add("USA");
        question4Options.add("China");
        question4Options.add("Russia");
        question4Options.add("India");
        Question question4 = new Question("Which country has the largest population?", question4Options, 1);
        quiz.addQuestion(question4);

        List<String> question5Options = new ArrayList<>();
        question5Options.add("Mount Everest");
        question5Options.add("K2");
        question5Options.add("Kangchenjunga");
        question5Options.add("Makalu");
        Question question5 = new Question("Which is the highest mountain in the world?", question5Options, 1);
        quiz.addQuestion(question5);

        List<String> question6Options = new ArrayList<>();
        question6Options.add("Spain");
        question6Options.add("France");
        question6Options.add("Italy");
        question6Options.add("Portugal");
        Question question6 = new Question("Which country is known for the Eiffel Tower?", question6Options, 2);
        quiz.addQuestion(question6);

        List<String> question7Options = new ArrayList<>();
        question7Options.add("Atlantic Ocean");
        question7Options.add("Pacific Ocean");
        question7Options.add("Indian Ocean");
        question7Options.add("Arctic Ocean");
        Question question7 = new Question("Which is the largest ocean in the world?", question7Options, 2);
        quiz.addQuestion(question7);

        List<String> question8Options = new ArrayList<>();
        question8Options.add("Nile");
        question8Options.add("Amazon");
        question8Options.add("Yangtze");
        question8Options.add("Mississippi");
        Question question8 = new Question("Which is the longest river in the world?", question8Options, 1);
        quiz.addQuestion(question8);

        List<String> question9Options = new ArrayList<>();
        question9Options.add("New York City");
        question9Options.add("Los Angeles");
        question9Options.add("Chicago");
        question9Options.add("San Francisco");
        Question question9 = new Question("Which city is known as the 'Big Apple'?", question9Options, 1);
        quiz.addQuestion(question9);

        List<String> question10Options = new ArrayList<>();
        question10Options.add("Australia");
        question10Options.add("Africa");
        question10Options.add("South America");
        question10Options.add("Antarctica");
        Question question10 = new Question("Which continent is known as the 'Land Down Under'?", question10Options, 1);
        quiz.addQuestion(question10);
        

        return quiz;
    }
}

