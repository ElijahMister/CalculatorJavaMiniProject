//Mini Project 1: Calculator
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BinaryOperator;

public class miniproject1{

   public static void main(String[] args){
        
        //Repeats until the user enters 2. This allows the user to keep using the calculator until they are finished.
        for(int i = 0; i != 1;){
            System.out.print("\n\nMAIN MENU\n=========\n(1) Calculator \n(2) Guide\n(3) Exit\nInput: ");
            Scanner scan = new Scanner(System.in);
            String userInput = scan.nextLine();
            switch(userInput){
                case "1":
                    //User wants to use the calculator
                    calcProgram(scan, userInput);
                    break;
                case "2":
                    //User wants to see the calculator guide
                    System.out.println("\nCalculator Guide:\n+ = Addition\n- = Subtraction\n/ = Division\n* = Mulitplication\n% = Modulus\n^ = Exponent");
                    System.out.println("Order of Operations (Operates Left -> Right): Exponents | Multiplication Division Modulus | Addition Subtraction");
                    System.out.println("Input Example: 2 * 4 + 16 / 4 ^ 2 % 2 - 8\nOutput Example: 1");
                    break;
                case "3":
                    //User wants to use exit the calculator
                    i = 1;
                    break;
                default:
                    //User didn't input a valid input.
                    System.out.println("INVALID INPUT!");
            }

        }
    
   }

   public static void calcProgram(Scanner scan, String userInput){
        //This function is the calculator. Takes in the scan object and userInput string.
        
        //Takes in user input and stores it into userInput.
        System.out.print("Calculator Input: ");
        userInput = scan.nextLine().trim();

        //Iterates through each character in the input. Defines an empty list.
        //If char = a number, it will add to temp number. Once char = a operand, end the temp number and place it in the list
        //Then place the operand in the next index, then continue until finished.
        //Example: 15 + 2 + 352 / 2 -> [15, +, 2, 352, /, 2]
        List<String> myList = new ArrayList<>();
        String tempNum = "";
        for(int i = 0; i < userInput.length(); i++){
            //Iterate through the character, if number add to tempNum.
            for(char num = '0'; num < ':'; num++){ //In ASCII : is right after 9
                if(userInput.charAt(i) == num){
                    tempNum += num;

                    //This puts the last number into the list
                    if(i == (userInput.length() - 1)){
                        myList.add(tempNum);
                    }
                }
            }

            //If the previous wasn't a number, then it will run through this next.
            //Checks if an operand was used, if so, then put tempNum in array
            //Then put the operand in the array. Then change myIndex and tempNum.
            if(userInput.charAt(i) == '+'){
                myList.add(tempNum);
                myList.add("+");
                tempNum = "";
            }else if(userInput.charAt(i) == '-'){
                myList.add(tempNum);
                myList.add("-");
                tempNum = "";
            }else if(userInput.charAt(i) == '*'){
                myList.add(tempNum);
                myList.add("*");
                tempNum = "";
            }else if(userInput.charAt(i) == '/'){
                myList.add(tempNum);
                myList.add("/");
                tempNum = "";
            }else if(userInput.charAt(i) == '%'){
                myList.add(tempNum);
                myList.add("%");
                tempNum = "";
            }else if(userInput.charAt(i) == '^'){
                myList.add(tempNum);
                myList.add("^");
                tempNum = "";
            }else if(userInput.charAt(i) == '.'){
                //This is if the user decided to type a float.
                tempNum += ".";
            }else{
                //Do nothing as its either a space or a character that isn't valid.
            }

        }

        //Time to take it step by step. From left to right follow the order of operations to
        //calculate the answer. Throw errors for instances like /0 or two operators together, etc.
        try{
            //Order of Operations: Exponent
            for(int i = 0; i < myList.size(); i++){
                if(myList.get(i) == "^"){
                    //Take element before, the element were on, and element next to do operation.
                    //Remove each then replace the output at the index of the first element removed.
                    //Ex. 2 ^ 2 + 3 -> 4 + 3
                    float numOut;
                    numOut = (float) Math.pow(Double.parseDouble(myList.get(i - 1)), Double.parseDouble(myList.get(i + 1)));
                    if(Float.isInfinite(numOut)) {
                        throw new ArithmeticException("Division by zero resulted in infinity");
                    }
                    myList.set(i - 1, Float.toString(numOut));
                    myList.remove(i + 1);
                    myList.remove(i);
                    i -= 2;
                }
            }
            //Order of Operations: Multiplication Division Modulus
            for(int i = 0; i < myList.size(); i++){
                if(myList.get(i) == "*" || myList.get(i) == "/" || myList.get(i) == "%"){
                    //Take element before, the element were on, and element next to do operation.
                    //Remove each then replace the output at the index of the first element removed.
                    //Ex. 2 * 3 + 4 -> 6 + 4
                    float numOut;
                    if(myList.get(i) == "*"){
                        numOut = Float.parseFloat(myList.get(i - 1)) * Float.parseFloat(myList.get(i + 1));
                    }else if(myList.get(i) == "/"){
                        numOut = Float.parseFloat(myList.get(i-1)) / Float.parseFloat(myList.get(i + 1));
                    }else{
                        numOut = Float.parseFloat(myList.get(i-1)) % Float.parseFloat(myList.get(i + 1));
                    }

                    if(Float.isInfinite(numOut)) {
                        throw new ArithmeticException("Division by zero resulted in infinity");
                    }
                    myList.set(i - 1, Float.toString(numOut));
                    myList.remove(i + 1);
                    myList.remove(i);
                    i -= 2;
                }
            }
            //Order of Operations: Addtion Subtraction
            for(int i = 0; i < myList.size(); i++){
                if(myList.get(i) == "+" || myList.get(i) == "-"){
                    //Take element before, the element were on, and element next to do operation.
                    //Remove each then replace the output at the index of the first element removed.
                    //Ex. 3 + 3 - 4 -> 6 - 4
                    float numOut;
                    if(myList.get(i) == "+"){
                        numOut = Float.parseFloat(myList.get(i - 1)) + Float.parseFloat(myList.get(i + 1));
                    }else{
                        numOut = Float.parseFloat(myList.get(i - 1)) - Float.parseFloat(myList.get(i + 1));
                    }

                    myList.set(i - 1, Float.toString(numOut));
                    myList.remove(i + 1);
                    myList.remove(i);
                    i -= 2;
                }

            }

            //Now if the answer is a decimal, we need to round up or down base on user input.
            int result;
            while(true){
                if(Float.parseFloat(myList.get(0)) - (int) Float.parseFloat((myList.get(0))) > 0){
                    System.out.print("The result was a float, would you like to...?\n(1) Round Up\n(2) Round Down\nInput: ");
                    String userChoice = scan.nextLine();
                    if(userChoice.equals("1")){
                        //User wants to round up so add to become a whole number, then convert to int.
                        result = (int) Math.ceil(Double.parseDouble(myList.get(0)));
                        break;
                    }else if(userChoice.equals("2")){
                        //User wants to round down so convert float to int, truncates the float.
                        result = (int) Float.parseFloat(myList.get(0));
                        break;
                    }else{
                        //User typed in an invalid input.
                        System.out.println("Not a valid input. Try again.");
                    }
                }else{
                    result = (int) Float.parseFloat(myList.get(0));
                    break;
                }
            }

            //Ask the user if they would like the output in decimal, binary, or hexadecimal.
            while(true){
                System.out.print("Would you like your result in...?\n(1) Decimal\n(2) Binary\n(3) Hexadecimal\nInput: ");
                String userChoice = scan.nextLine();
                if(userChoice.equals("1")){
                        //User wants to output in decimal
                        System.out.println("\nAnswer: " + result);
                        break;
                    }else if(userChoice.equals("2")){
                        //User wants to output in binary
                        System.out.println("\nAnswer: " + decBin(result));
                        break;
                    }else if(userChoice.equals("3")){
                        //User wants to output in hex
                        System.out.println("\nAnswer: " + decHex(result));
                        break;
                    }else{
                        //User typed in an invalid input.
                        System.out.println("Not a valid input. Try again.");
                    }

            }
        }catch (ArithmeticException ex){
            System.out.println("Error: " + ex.getMessage());
        }catch (IndexOutOfBoundsException ex){
            System.out.println("Error: " + ex.getMessage());
        }catch (NumberFormatException ex){
            System.out.println("Error: Incorrect Format!");
        }

   }

   public static String decHex(int dec){
        //Takes in a decimal integer and returns the Hex conversion.
        String conNum = "";

        while(dec != 0){
            //Finds the remainder, converts it into ABCDEF1-9, then puts it into a string temp.
            //Divides by dec until it == 0
            int myHex = (dec % 16);
            if(myHex == 10){
                conNum = "A" + conNum;
            }else if(myHex == 11){
                conNum = "B" + conNum;
            }else if(myHex == 12){
                conNum = "C" + conNum;
            }else if(myHex == 13){
                conNum = "D" + conNum;
            }else if(myHex == 14){
                conNum = "E" + conNum;
            }else if(myHex == 15){
                conNum = "F" + conNum;
            }else{
                conNum = String.valueOf(myHex) + conNum;
            }
            dec = (int) (dec / 16);
        }

        //If conNum empty make conNum = 0
        if(conNum == ""){
            conNum = "0";
        }


        return conNum;

   }

   public static String decBin(int dec){
        String conNum = "";

        //Puts the remainder into temp, then divides dec by 2 until it is 0.
        while(dec != 0){
            conNum = String.valueOf(dec % 2) + conNum;
            dec = (int) (dec / 2);
        }

        //If conNum is empty make conNum = 0
        if(conNum == ""){
            conNum = "0";
        }

        return conNum;

   }

   public static int hexDec(String Hex){
        //Takes in a string that represents a hexadecimal number and returns an integer that is its decimal counterpart.
        int conNum = 0;
        for(int i = 0; i < Hex.length(); i++){
            if(Hex.charAt(i) == '1'){
                conNum += (Math.pow(16, Hex.length() - 1 - i));
            }else if(Hex.charAt(i) == '2'){
                conNum += (Math.pow(16, Hex.length() - 1 - i))*2;
            }else if(Hex.charAt(i) == '3'){
                conNum += (Math.pow(16, Hex.length() - 1 - i))*3;
            }else if(Hex.charAt(i) == '4'){
                conNum += (Math.pow(16, Hex.length() - 1 - i))*4;
            }else if(Hex.charAt(i) == '5'){
                conNum += (Math.pow(16, Hex.length() - 1 - i))*5;
            }else if(Hex.charAt(i) == '6'){
                conNum += (Math.pow(16, Hex.length() - 1 - i))*6;
            }else if(Hex.charAt(i) == '7'){
                conNum += (Math.pow(16, Hex.length() - 1 - i))*7;
            }else if(Hex.charAt(i) == '8'){
                conNum += (Math.pow(16, Hex.length() - 1 - i))*8;
            }else if(Hex.charAt(i) == '9'){
                conNum += (Math.pow(16, Hex.length() - 1 - i))*9;
            }else if(Hex.charAt(i) == 'A'){
                conNum += (Math.pow(16, Hex.length() - 1 - i))*10;
            }else if(Hex.charAt(i) == 'B'){
                conNum += (Math.pow(16, Hex.length() - 1 - i))*11;
            }else if(Hex.charAt(i) == 'C'){
                conNum += (Math.pow(16, Hex.length() - 1 - i))*12;
            }else if(Hex.charAt(i) == 'D'){
                conNum += (Math.pow(16, Hex.length() - 1 - i))*13;
            }else if(Hex.charAt(i) == 'E'){
                conNum += (Math.pow(16, Hex.length() - 1 - i))*14;
            }else{ // If char == 'F', if anything else assume 'F'
                conNum += (Math.pow(16, Hex.length() - 1 - i))*15;
            }
        }

        return conNum;

   }

   public static int binDec(String Bin){
        //Takes in a string that represents a binary number and returns an integer that is its decimal counterpart.
        int conNum = 0;
        conNum = 0;
        for(int i = 0; i < Bin.length(); i++){
            if(Bin.charAt(i) == '1'){
                conNum += (Math.pow(2, Bin.length() - 1 - i));
            }
        }

        return conNum;

   }

}