public class GuessTheNumber {
    public static void main(String[] args) throws Exception {
      int finalNumber = 10;
      String[] operations = {"X * 5", "X * 0", "X + 10"};
  
      int actualNumber = GuessTheNumber.getActualNumber(finalNumber, operations, operations.length);
      System.out.println("The actual number will be " + actualNumber + " after performing given operations.");
    }
    
    public static int getActualNumber(int finalNumber, String[] operations, int totalOperations) throws Exception{
        int num = finalNumber;
        for(int i = totalOperations-1; i >= 0; i--) {
          char opr = operations[i].charAt(2);
          int op = Integer.parseInt(operations[i].substring(4));
          //divide by 0 case
          if(opr == '/' && op == 0) return -1;
          //if multiple answers are possible then return -2
          if(opr == '%'|| (opr=='^' && op == 0) || (opr == '*' && op == 0)) return -2;
          switch (opr) {
            case '+' -> num -= op;
            case '-' -> num += op;
            case '*' -> num /= op;
            case '/' -> num *= op;
            case '^' -> num = (int) Math.pow(num, 1f / op);
          }
        }
    
        return num;
      }
    }