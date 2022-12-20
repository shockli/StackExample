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

import java.util.ArrayList;

public class StackExample {
    public static void main(String[] args) throws Exception {
        System.out.println(getRightBrackets(")()())"));
        System.out.println(getRightBrackets(")(()())"));
        System.out.println(getRightBrackets(")("));
        System.out.println(getRightBrackets("(()(()())"));
  }
  public static String getRightBrackets(String test){
        String stack = "";
        String result = "";
        Boolean reduceDeepLength = false;
        ArrayList<Integer> unclosedIndex = new ArrayList();
        for(int i = 0; i < test.length();){
            if(stack.endsWith("(") && test.substring(i,i+1).equals(")")){
                String updatedResult = ""; //вставка текущих скобок в result (формируемый ответ)
                if(reduceDeepLength){
                    //скобки обворачивают предыдуший результат если глубина стека уменьшилась
                    updatedResult=result.substring(0,unclosedIndex.get(unclosedIndex.size()-1)) + "(" + result.substring(unclosedIndex.get(unclosedIndex.size()-1))  + ")";
                }else{
                    //или идут следом
                    updatedResult= result + "()";
                }
                result = updatedResult;
                stack= stack.substring(0, stack.length()-1);  //уменьшение глубины стека
                reduceDeepLength=true;
                unclosedIndex.remove(unclosedIndex.size()-1);
            }else{
                stack+= test.substring(i,i+1); //увеличение глубины стека
                unclosedIndex.add(i);
                reduceDeepLength=false;
            }
            //System.out.println(i + " " + stack);
            i++;
        }
      return result.length() + " - " + result;
  }
}
