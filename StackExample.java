/*
* Пример 1:
               Ввод: "(()"
               Вывод: 2 - "()"
Пример 2:
               Ввод: ")()())"
               Вывод: 4 - "()()"
Пример 3:
               Ввод: ")(()())"
               Вывод: 6 - "(()())"
Пример 4:
               Ввод: ")("
               Вывод: 0
               * */

public class StackExample {
    public static void main(String[] args) throws Exception {
        System.out.println(getRightBrackets("(()"));
        System.out.println(getRightBrackets(")()())"));
        System.out.println(getRightBrackets(")(()())"));
        System.out.println(getRightBrackets(")("));
  }
  public static String getRightBrackets(String test){
        String stack = "";
        String result = "";
        Boolean reduceDeepLength = false;
        for(int i = 0; i < test.length();){
            if(stack.endsWith("(") && test.substring(i,i+1).equals(")")){
                String updatedResult = ""; //вставка текущих скобок в result (формируемый ответ)
                if(reduceDeepLength){
                    //скобки обворачивают предыдуший результат если глубина стека уменьшилась
                    updatedResult= "(" + result + ")";
                }else{
                    //или идут следом
                    updatedResult= result + "()";
                }
                result = updatedResult;
                stack= stack.substring(0, stack.length()-1);  //уменьшение глубины стека
                reduceDeepLength=true;
            }else{
                stack+= test.substring(i,i+1); //увеличение глубины стека
                reduceDeepLength=false;
            }
            i++;
        }
      return result.length() + " - " + result;
  }
}