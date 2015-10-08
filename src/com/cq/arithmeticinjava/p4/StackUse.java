/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.arithmeticinjava.p4;

import java.util.LinkedList;


/**
 * 表达式的转化,将中序列表达式转化为逆波兰式，用栈实现
 * @author: qiang.chen
 * @since:    2012-7-23
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
public class StackUse {
    
    public static String convertExp(String exp){
        assert exp!=null;
        StringBuilder sb = new StringBuilder();
        char[] tempArray = exp.toCharArray();
        LinkedList<Op> ls = new LinkedList<Op>();
        for(char e:tempArray){
            if((e>=65 && e<=90) || (e>=97 && e<=122)){
                sb.append(e);
                continue;
            }
            Op op = getOp(e);
            if(op != null){
                //输入的符号的优先级大于栈顶部的符号,或者栈顶的是(，输入的符号入站
                if(ls.isEmpty() || ls.peek().option == '(' ||op.level > ls.peek().level){
                    ls.push(op);
                    continue;
                }
                //输入的符号优先级小于等于栈顶部的符号
                while(!ls.isEmpty() && op.level<=ls.peek().level && ls.peek().option != '(')
                    sb.append(ls.pop().option);
                ls.push(op);
                continue;
            }
            Op op2 = getLeftBracket(e);
            if(op2 != null){//"("直接入站
                ls.push(op2);
                continue;
            }
            Op op3 = getRightBracket(e);
            if(op3 != null){
                //括号出栈
                while(!ls.isEmpty() && ls.peek().option != '(')
                    sb.append(ls.pop().option);
                if(!ls.isEmpty())
                    ls.pop();
                continue;
            }
            
        }
        while(!ls.isEmpty()){
            Op temp = ls.pop();
            if(temp.option != '(' && temp.option !=')')
                sb.append(temp.option);
        }
        return sb.toString();
    }
    
    /**
     * 
     */
    private  static Op getOp(char opchar){
        
        for(Op op:Op.values()){
            if(opchar !='(' && opchar!=')' && op.option == opchar){
                return op;
            }
        }
        return null;
        
    }
    /**
     * 
     */
    private  static Op getLeftBracket(char opchar){
        
        for(Op op:Op.values()){
            if((opchar =='(') && op.option == opchar){
                return op;
            }
        }
        return null;
        
    }
    /**
     * 
     */
    private  static Op getRightBracket(char opchar){
        
        for(Op op:Op.values()){
            if((opchar ==')') && op.option == opchar){
                return op;
            }
        }
        return null;
        
    }
    
  private enum Op{
      ADD('+',1),
      MINUS('-',1),
      MULTI('*',2),
      DEV('/',2),
      LEFT('(',3),
      RIGHT(')',3);
      
      char option;
   

      int level;
      
      Op(char option,int level){
          this.option = option;
          this.level = level;
      }
  }
  
  public static void main(String[] args) {
      String exp = "a+b*c+(d*e+f)*g";
      System.out.println(convertExp(exp));
    
}
}
