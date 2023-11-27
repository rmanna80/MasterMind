import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Game{
    public static final String RESET = "\u001B[0m";
    public static final String SQUARE = "\u25A0";
   
    public static String[] colors = {"red", "green", "yellow", "blue", "purple", "gray"};

    public static String[] codes = { "\u001B[31m", "\u001B[32m", "\u001B[33m", "\u001B[34m", "\u001B[35m", "\u001B[37m" };

    public static int LENGTH = 4;
    




    public static void main(String[] args){
        String[] answer = {"red", "green", "blue", "gray"};
        for(int i = 0; i < answer.length;i++){
            answer[i] = colors[(int)(Math.random() * colors.length)];
        }
        System.out.println(Arrays.toString(answer));
        Scanner scanner = new Scanner(System.in);
        String allCorrect = "";
        for(int i = 0; i < LENGTH;i++){
            allCorrect += "h";
        }


        while(true){
            System.out.println("Enter in your guess");
            String[] guess = new String[LENGTH];
            boolean[] placed = new boolean[LENGTH];
            String feedback = "";

            for(int i = 0; i < guess.length; i++){
                guess[i] = scanner.next();
                System.out.print(getCode(guess[i]) + SQUARE + RESET);
                boolean place = false;
                for(int j = 0; j < answer.length;j++){
                    if(guess[i].equals(answer[j]) && i == j && place == false && placed[i] == false){
                        place = true;
                        feedback += "h";
                        placed[i] = true;

                    }
                    
                }
                for(int j = 0; j < answer.length;j++){
                    if(guess[i].equals(answer[j]) && place == false && placed[j] == false){
                        place = true;
                        feedback += "p";
                        placed[j] = true;
                    }
                }
                
            }
            System.out.println();
            System.out.println(shuffle(feedback));
            if(feedback.equals(allCorrect)){
                System.out.println("correct");
                break;
            }
            



            
        }
    }
    public static String getCode(String color){
        for(int i = 0; i < colors.length;i++){
            if(colors[i].equals(color)){
                return codes[i];
            }
        }
        return "not found";
    }
    public static String shuffle(String str){
        ArrayList<String> list = new ArrayList<String>();
        for(int i = 0; i < str.length(); i++){
            list.add(str.substring(i, i + 1));
            
        }
        Collections.shuffle(list);
        String result = "";
        for(int i = 0; i < list.size();i++){
            result += list.get(i);
        }
        return result;
    }
}