//Create functions for converting between binary, hexadecimal, and decimal.
public class convFunctions{

    public static void main(String[] args){

        System.out.println(hexBin("23"));

    }

    public static String decHex(int dec){
        //Takes in an decimal integer and returns the Hex conversion.
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

    public static String binHex(String Bin){
        //Takes in a string that represents a binary number, and returns an String that is its hexadecimal counterpart.
        String temp = "";
        String conNum = "";
        int binRem = Bin.length() % 4;
        
        //Takes the string and adds 0s so there is a equals groups of 4
        if(binRem == 1){
            Bin = "000" + Bin;
        }else if(binRem == 2){
            Bin = "00" + Bin;
        }else if(binRem == 3){
            Bin = "0" + Bin;
        }

        //Go through string and group in four, once that is done add to conNum the binary equivalent of 1-9A-F
        for(int i = 0; i < Bin.length(); i++){

            temp += Bin.charAt(i);

            if(temp.equals("0000")){
                conNum += "0";
                temp = "";
            }else if(temp.equals("0001")){
                conNum += "1";
                temp = "";
            }else if(temp.equals("0010")){
                conNum += "2";
                temp = "";
            }else if(temp.equals("0011")){
                conNum += "3";
                temp = "";
            }else if(temp.equals("0100")){
                conNum += "4";
                temp = "";
            }else if(temp.equals("0101")){
                conNum += "5";
                temp = "";
            }else if(temp.equals("0110")){
                conNum += "6";
                temp = "";
            }else if(temp.equals("0111")){
                conNum += "7";
                temp = "";
            }else if(temp.equals("1000")){
                conNum += "8";
                temp = "";
            }else if(temp.equals("1001")){
                conNum += "9";
                temp = "";
            }else if(temp.equals("1010")){
                conNum += "A";
                temp = "";
            }else if(temp.equals("1011")){
                conNum += "B";
                temp = "";
            }else if(temp.equals("1100")){
                conNum += "C";
                temp = "";
            }else if(temp.equals("1101")){
                conNum += "D";
                temp = "";
            }else if(temp.equals("1110")){
                conNum += "E";
                temp = "";
            }else if(temp.equals("1111")){
                conNum += "F";
                temp = "";
            }else{
                //Do nothing
            }

        }

        return conNum;

    }

    public static String hexBin(String Hex){
        //Takes in a string hex number, and returns a string that represents its binary equivalent.
        //Takes in a string that represents a binary number, and returns an String that is its hexadecimal counterpart.
        String conNum = "";

        //Go through each letter, and add to conNum its binary equivalent.
        for(int i = 0; i < Hex.length(); i++){
            if(Hex.charAt(i) == '0'){
                conNum += "0000";
            }else if(Hex.charAt(i) == '1'){
                conNum += "0001";
            }else if(Hex.charAt(i) == '2'){
                conNum += "0010";
            }else if(Hex.charAt(i) == '3'){
                conNum += "0011";
            }else if(Hex.charAt(i) == '4'){
                conNum += "0100";
            }else if(Hex.charAt(i) == '5'){
                conNum += "0101";
            }else if(Hex.charAt(i) == '6'){
                conNum += "0110";
            }else if(Hex.charAt(i) == '7'){
                conNum += "0111";
            }else if(Hex.charAt(i) == '8'){
                conNum += "1000";
            }else if(Hex.charAt(i) == '9'){
                conNum += "1001";
            }else if(Hex.charAt(i) == 'A'){
                conNum += "1010";
            }else if(Hex.charAt(i) == 'B'){
                conNum += "1011";
            }else if(Hex.charAt(i) == 'C'){
                conNum += "1100";
            }else if(Hex.charAt(i) == 'D'){
                conNum += "1101";
            }else if(Hex.charAt(i) == 'E'){
                conNum += "1110";
            }else{ // If char == 'F', if anything else assume 'F'
                conNum += "1111";
            }
        }

        //This erases any trailing 0s
        int myCount = 0;
        for(int i = 0; i < conNum.length(); i++){
            //From left to right, find how many zeros there are. Once it finds a 1 stop.
            if(conNum.charAt(i) == '0'){
                myCount += 1;
            }else{
                break;
            }
        }
        //Makes a string that is from the first 1 to the end of the string, then assigns it to conNum.
        conNum = conNum.substring(myCount, conNum.length());

        return conNum;

    }



}