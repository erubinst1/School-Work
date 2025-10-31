import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class StackLanguage {

    private Stack<Double> stack;
    private Map<String, Double> variables;
    private List<String> commands;

    StackLanguage(){
        this.stack = new Stack<>();
        this.variables = new HashMap<>();
        this.commands = null;
    }

    /**
     * reads a series of “stack commands” from the file
     * @param f file name
     */
    void readFile(String f){
        commands = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(f))) {
            while (scanner.hasNextLine()) {
                commands.add(scanner.nextLine().trim());
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File not found: " + f);
        }
    }

    /**
     *  interprets the stored list of commands
     * @return top-most value of the stack after interpreting all commands
     */
    double interpret(){
        if (commands == null || commands.isEmpty()) {
            throw new IllegalStateException("No commands have been read.");
        }

        for (String s : commands) {
            s = s.replace(",", "");
            String[] commandArr = s.split(" ");
            String instruction = commandArr[0];

            if (instruction.equals("DECL")) {
                String varName = commandArr[1];
                double varValue = Integer.parseInt((commandArr[2]));
                variables.put(varName, varValue);

            } else if (instruction.equals("PUSH")) {
                double value =  Integer.parseInt(commandArr[1]);
                stack.push(value);

            } else if (instruction.equals("POP")) {
                String varName = commandArr[1];
                if (stack.isEmpty()) throw new NoSuchElementException("Stack is empty.");
                if( !variables.containsKey(varName)) throw new IllegalArgumentException("The variable has not been declared: " + varName);

                double varValue = stack.pop();
                variables.put(varName, varValue);

            } else if (instruction.equals("PEEK")) {
                String varName = commandArr[1];
                if (stack.isEmpty()) throw new NoSuchElementException("Stack is empty.");
                if( !variables.containsKey(varName)) throw new IllegalArgumentException("The variable has not been declared: " + varName);

                double varValue = stack.peek();
                variables.put(varName, varValue);

            } else if (instruction.equals("ADD")) {
                double a = stack.pop();
                double b =  Integer.parseInt(commandArr[1]);
                stack.push(a + b);

            } else if (instruction.equals("SUB")) {
                double a = stack.pop();
                double b = Integer.parseInt(commandArr[1]);
                stack.push(a - b);

            } else if (instruction.equals("XCHG")) {
                String varName = commandArr[1];
                if (stack.isEmpty()) throw new NoSuchElementException("Stack is empty.");
                if (!variables.containsKey(varName)) throw new IllegalArgumentException("Variable not declared: " + varName);

                double stackTop = stack.pop();
                double varValue = variables.get(varName);
                variables.put(varName, stackTop);
                stack.push(varValue);

            } else if (instruction.equals("DUP")) {
                stack.push(stack.peek());

            } else {
                throw new UnsupportedOperationException ("Unsupported command: " + instruction);
            }
        }
        if (stack.isEmpty()) throw new NoSuchElementException("Stack is empty after interpreting all commands.");
        return stack.peek();
    }
}
