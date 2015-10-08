/**2012-6-23**/

package com.cq.effectivejava.p30;

/**
 * enum extends from Enums,so it can implements other interface
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-6-23 陈强新建
 */
public enum Operation implements IOperation {
    PLUS {// 将枚举的项目看做是一个该类的一个实例即可
    
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS {
        
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES {
        
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE {
        
        @Override
        public double apply(double x, double y) {
            return x / y;
        }
    };
}
