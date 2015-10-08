/**2012-5-27**/

package com.cq.model.intepretor;

import java.util.Map;
import java.util.Stack;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-5-27 陈强新建
 */
public class Calculator {
    
    private final Expression expre;
    
    public Calculator(String exp) {
        Stack<Expression> stack = new Stack<Expression>();
        char[] chararray = exp.toCharArray();
        
        Expression left = null;
        Expression right = null;
        for (int i = 0; i < chararray.length; i++) {
            switch (chararray[i]) {
                case '+':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(chararray[i + 1]));
                    stack.push(new SubExpression(left, right));
                    break;
                case '-':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(chararray[i + 1]));
                    stack.push(new SubExpression(left, right));
                    break;
                default:
                    stack.push(new VarExpression(String.valueOf(chararray[i])));
            }
        }
        this.expre = stack.pop();
    }
    
    public int run(Map<String, Integer> var) {
        return this.expre.intepreter(var);
    }
    
}
