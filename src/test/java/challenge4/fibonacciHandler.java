package challenge4;

class fibonacciHandler {
    fibonacciHandler(){
    }
    String calculate(long order){

        if(order == 0){
            return "0 is not valid.";
        }
        else{
            long number = fibo(order, 0, 0);
            return number + " " + numberToString(number);
        }
    }
    private long fibo(long order, long current, long previous){
        if(order > 0) {
            if(current == 0){
                return fibo(order -1, 1, 0);
            }
            else{
                return fibo(order -1, current + previous, current);
            }
        }
        return current;
    }
    private String numberToString(long number){
        String[] ones_position = new String[]{"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] tens = new String[]{"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tens_position = new String[]{"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String[] thousands_position = new String[]{"thousand", "million", "billion", "trillion", "quadrillion", "quintillion"};

        StringBuilder fibonacciString = new StringBuilder();
        String[] splitNum = String.valueOf(number).split("");
        int[] toConvert = new int[(splitNum.length)];
        for(int i = 0; i < splitNum.length; i++){
            toConvert[i] = Integer.valueOf(splitNum[splitNum.length-(i+1)]);
        }
        for(int i = 0; i < toConvert.length; i++){
            if(!fibonacciString.toString().equals("") && !fibonacciString.substring(0,1).equals(" ")){
                fibonacciString.insert(0, " ");
            }
            if(i%3==0 && i!=0 && toConvert.length > 3){
                if(toConvert[i]!=0 || toConvert[i+1]!=0 || toConvert[i+2]!=0){
                    fibonacciString.insert(0, " " + thousands_position[(i / 3) - 1]);
                }
            }
            if((i+1)%3==1 && toConvert.length == i+1){
                fibonacciString.insert(0, ones_position[toConvert[i]]);
            }
            else if((i+1)%3==1 && toConvert[i+1]!=1){
                fibonacciString.insert(0, ones_position[toConvert[i]]);
            }
            else if((i+1)%3==2 && toConvert[i]==1){
                fibonacciString.insert(0, tens[toConvert[i - 1]]);
            }
            else if((i+1)%3==2){
                fibonacciString.insert(0, tens_position[toConvert[i]]);
            }
            else if((i+1)%3==0 && toConvert[i]!=0){
                fibonacciString.insert(0, ones_position[toConvert[i]] + " hundred");
            }
        }
        return fibonacciString.toString();
    }
}
