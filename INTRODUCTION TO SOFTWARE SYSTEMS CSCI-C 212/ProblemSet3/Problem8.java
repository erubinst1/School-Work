// Exercise 3.55

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Problem8 {

    /**
     * Evaluates a postfix-notation expression
     *
     * @param l list of binary operators and numeric operands as strings
     * @return Result of evaluating the postfix-notation expression
     */
    static int postfixEvaluator(List<String> l) {
        List<String> current = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for( String s: l){
            current.add(s);
        }

        for(int i = 0; i < current.size(); i++){
            if(isBinaryOperator(current.get(i))) {
                //if the temp stack is empty, means the whole stack needs the operator applied
                if(temp.isEmpty()){
                    if(current.get(i).charAt(0) == '+'){
                        for(int j = 0; j < stack.size() && j >=0; j++){
                            result += stack.pop();
                            j--;
                        }
                    }
                    else if(current.get(i).charAt(0) == '-'){
                        for(int j = 0; j < stack.size() && j >=0; j++){
                            if( j < stack.size()-1){
                                result += (stack.pop() - stack.pop());
                                j--;
                                j--;
                            }
                            else{
                                result -= stack.pop();
                                j--;
                            }
                        }
                    }
                    else if(current.get(i).charAt(0) == '*'){
                        for(int j = 0; j < stack.size() && j >=0; j++){
                            result *= stack.pop();
                            j--;
                        }
                    }
                    else if(current.get(i).charAt(0) == '/'){
                        for(int j = 0; j < stack.size() && j >=0; j++){
                            if( j < stack.size()-1){
                                result += stack.pop() / stack.pop();
                                j--;
                                j--;
                            }
                            else{
                                result /= stack.pop();
                                j--;
                            }
                        }
                    }
                }

                //if the temp stack has one thing in it, whole stack needs to be modified by that
                else if(temp.size() == 1 ){
                    List<Integer> tempStack = new ArrayList<>();
                    tempStack.add(Integer.parseInt(temp.getFirst()));

                    while( stack.size() != 0){
                        tempStack.add(0, stack.pop());
                    }

                    if(current.get(i).charAt(0) == '+'){
                        for(int j = 0; j < tempStack.size()-1; j++){
                            tempStack.add(j,tempStack.remove(j)+tempStack.getLast());
                        }
                    }
                    else if(current.get(i).charAt(0) == '-'){
                        for(int j = 0; j < tempStack.size()-1; j++){
                                tempStack.add(j,tempStack.remove(j)-tempStack.getLast());
                        }
                    }
                    else if(current.get(i).charAt(0) == '*'){
                        for(int j = 0; j < tempStack.size()-1; j++){
                            tempStack.add(j,tempStack.remove(j)*tempStack.getLast());
                        }
                    }
                    else if(current.get(i).charAt(0) == '/'){
                        for(int j = 0; j < tempStack.size()-1; j++){
                            tempStack.add(j,tempStack.remove(j)/tempStack.getLast());
                        }
                    }
                    for(int j = 0; j < tempStack.size()-1; j++){
                        stack.add(tempStack.get(j));
                    }
                    temp.removeFirst();
                }

                else if(current.get(i).charAt(0) == '+'){
                    int tempValue = 0;
                    for(int j = 0; j < temp.size() && j >=0; j++){
                        tempValue += Integer.parseInt(temp.remove(j));
                        j--;
                    }
                    stack.push(tempValue);
                }
                else if(current.get(i).charAt(0) == '-'){
                    int tempValue = 0;
                    for(int j = 0; j < temp.size() && j >=0; j++){
                        if( j < temp.size()-1){
                            tempValue += Integer.parseInt(temp.remove(j)) - Integer.parseInt(temp.remove(j));
                            j--;
                            j--;
                        }
                        else{
                            tempValue -= Integer.parseInt(temp.remove(j));
                            j--;
                        }
                    }
                    stack.push(tempValue);
                }
                else if(current.get(i).charAt(0) == '*'){
                    int tempValue = 1;
                    for(int j = 0; j < temp.size() && j >=0; j++){
                        tempValue *= Integer.parseInt(temp.remove(j));
                        j--;
                    }
                    stack.push(tempValue);
                }
                else if(current.get(i).charAt(0) == '/'){
                    int tempValue = 0;
                    for(int j = 0; j < temp.size() && j >=0; j++){
                        if( j < temp.size()-1){
                            tempValue += Integer.parseInt(temp.remove(j)) / Integer.parseInt(temp.remove(j));
                            j--;
                            j--;
                        }
                        else{
                            tempValue /= Integer.parseInt(temp.remove(j));
                            j--;
                        }
                    }
                    stack.push(tempValue);
                }

            }
            else{
                temp.add(current.get(i));
            }
        }

        if(!stack.isEmpty()){
            return stack.pop();
        }
        return result;
    }
    /**
     * Evaluates if a string contains a binary operator
     *
     * @param s string to be checked
     * @return true if the string contains a binary operator, false if not
     */
    private static boolean isBinaryOperator( String s){
        if(s.isEmpty()){
            return false;
        }
        return s.charAt(s.length()-1) == '+' || s.charAt(s.length()-1) == '-' || s.charAt(s.length()-1) == '*' || s.charAt(s.length()-1) == '/';
    }
}