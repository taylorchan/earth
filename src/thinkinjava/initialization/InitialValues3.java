/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package initialization;


/**
 * 
 * @author:   Taylor Chan
 * @since:    2015-8-6
 * @version : 1.0
 */
public class InitialValues3 {
    Dependency de = new Dependency(this); 
    
    {      
        System.out.println("private module, flag is==>" + this.flag);               
    }    
   
    
    public InitialValues3() {
        super();
        System.out.println("now int Init3's constructor");
    }
    
    int flag = 33;
    
    public static void main(String args[]) {
        InitialValues3 in = new InitialValues3();
        System.out.println(in.flag);
        System.out.println("finish");
    }
}

class Dependency{
    Dependency(InitialValues3 _init){
        init = _init;
    }
    
    InitialValues3 init = null; 
    
    void regist(InitialValues3 _init){
        init = _init;
    }
}
