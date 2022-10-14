/* Virtual Pet, version 2
 * 
 * @author Ratchet
 * @author ?
 */

import java.util.Scanner;

public class VirtualPet {
    
    VirtualPetFace face;
    int scene_number = 0;
    boolean isHungry = true;
    boolean isSleepy = true;
    boolean gameOver = false;
    boolean passExam = true;
    Scanner sc = new Scanner(System.in);
    
    // constructor
    public VirtualPet() {
        face = new VirtualPetFace();
        face.setImage("actonehappy");
        face.setMessage("Hello. Welcome to school");
    }

    public void startGame(){
        while (gameOver == false){
            System.out.print("Enter NEXT to continue: ");
            String input = sc.nextLine();
            if (input.trim().equals("NEXT")){
                next_scene();
            }
        }
    }

    // starts next scene
    public void next_scene(){
        scene_number++;
        play_scene();
    }

    // skips to scene number n
    public void skip_scene(int n){
        scene_number += n;
        play_scene();
    }

    public void play_scene(){
        // Act 1
        if (scene_number==1){
            face.setMessage("Make sure to eat and sleep before going to school.");
        }

        if (scene_number==2){
            if (isHungry == false && isSleepy == false)
                face.setMessage("You are ready for school!");
            else if (isHungry == false || isSleepy == false) {
                face.setImage("actonesick");
                face.setMessage("You are feeling a little unwell, but can still go to school.");
            }
            else {
                face.setImage("actoneskeleton");
                face.setMessage("You did not eat or sleep. You died.");
                gameOver = true;
            }
        }

        // Act 2

        if (scene_number == 3){
            face.setImage("acttwohappy");
            face.setMessage("\n\n\nYou are in math class now");
            face.setMessage("Enter FOCUS to pay attention to class; Enter SLEEP to sleep in class. ");
            System.out.print("Enter FOCUS to pay attention to class; Enter SLEEP to sleep in class. ");

            boolean valid = false;

            while (!valid){
                String input = sc.nextLine();
                if (input.equals("FOCUS")){
                    face.setMessage("Congratulations, you are listening to the Mr. Becker");
                    face.setMessage("Mr.Becker tells you the classroom join code: FIEWN190");
                    valid = true;
                }

                else if (input.equals("SLEEP")){
                    face.setImage("acttwoasleep");
                    face.setMessage("You did not hear what Mr. Becker said.");
                    valid = true;
                }

                else
                    System.out.println("Please provide a valid response.");

            }
        }

        // Act 3

        if (scene_number == 4){
            face.setImage("actthreehappy");
            face.setMessage("\n\n\nIt is passing period now. You see your friend walking towards you.");
            face.setMessage("Enter SHAKE to shake their hand. Enter anything else to not shake their hand.");
            System.out.println("Enter SHAKE to shake their hand. Enter anything else to not shake their hand.");

            String input = sc.nextLine();

            if (input.equals("SHAKE"))
                face.setMessage("Congratulations, you shook your friend's hand.");

            else{
                face.setImage("actthreetired");
                face.setMessage("You didn't shake yo;ur friends hand.");
                face.setMessage("Your friend raises their hand to shake your hand. You have one more chance.");
                face.setMessage("Enter SHAKE to shake their hand. Enter anything else to not shake their hand.");
                System.out.println("Enter SHAKE to shake their hand. Enter anything else to not shake their hand.");
                input = sc.nextLine();

                if (input.equals("SHAKE")){
                    face.setImage("actthreehappy");
                    face.setMessage("Congratulations, you shook your friend's hand.");
                }
                else{
                    face.setImage("actthreeburied");
                    face.setMessage("That's not cool. Your friend and their friends bury you.");
                    gameOver = true;
                }
            }
        }

        // Act 4

        if(scene_number == 5){
            face.setImage("actfourhappy");
            face.setMessage("\n\n\nYou have to use the bathroom during passing period.");
            face.setMessage("Enter STALLS to use the stalls. Enter URINALS to use the urinals.");
            System.out.println("Enter STALLS to use the stalls. Enter URINALS to use the urinals.");

            boolean valid = false;

            while (!valid){
                String input = sc.nextLine();
                if (input.equals("STALLS")){
                    face.setImage("actfourskeleton");
                    face.setMessage("You are setting on toilet when someone throws a trashcan over the stalls. You died.");
                    valid = true;
                    gameOver = true;
                }

                else if (input.equals("URINALS")){
                    face.setMessage("You look straight forward and keep your back straight. You are safe.");
                    valid = true;
                }

                else
                    System.out.println("Please provide a valid response.");
            }
        }

        // Act 5

        if(scene_number == 6){
            face.setImage("actfivehappy");
            face.setMessage("\n\n\nIt's lunch time! Enjoy your lunch.");
        }

        // Act 6

        if(scene_number == 7){
            face.setImage("actsixtired");
            face.setMessage("\n\n\nFor some reason you are in math class again.");
            face.setMessage("Mr. Becker says \"POP QUIZ!\"");
            face.setMessage("Answer the questions in the console correctly.");

            int questionNumber = 1;

            if(questionNumber == 1){
                System.out.print("1. What is the third derivative of (777x)^2: ");
                int intInput = Integer.parseInt(sc.nextLine());
                if (intInput != 0)
                    passExam = false;
                questionNumber++;
            }

            if(questionNumber == 2){
                System.out.print("2. What is my first name: ");
                String strInput = sc.nextLine();
                if (! strInput.equalsIgnoreCase("dean"))
                    passExam = false;
                questionNumber++;
            }

            if(questionNumber == 3) {
                System.out.print("3. Enter the google classroom join code I gave you earlier: ");
                String strInput = sc.nextLine();
                if (!strInput.equals("FIEWN190"))
                    passExam = false;
            }

            face.setMessage("You have now finished the exam.");
            System.out.println("You have now finished the exam.");
        }

        // Act 7

        if(scene_number == 8){
            if (passExam == true) {
                face.setImage("actsevenhappy");
                face.setMessage("\n\n\nYou discussed the math exam with your friends. All your answers were correct. GG'S!");
            }
            else{
                face.setImage("actsevenskeleton");
                face.setMessage("\n\n\nYou discussed the math exam with your friends. You got an incorrect answer. You died.");
            }
            gameOver = true;
        }
    }


    // Supplementary Methods
    public void eat(){
        isHungry = false;
    }

    public void sleep(){
        isSleepy = false;
    }
}