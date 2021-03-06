//: holding/AsListInference.java
// Arrays.asList() makes its best guess about type.

package holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Snow {
}

class Powder extends Snow {
}

class Light extends Powder {
}

class Heavy extends Powder {
}

class Crusty extends Snow {
}

class Slush extends Snow {
}

public class AsListInference {
    
    public static void main(String[] args) {
        List<Snow> snow1 = Arrays.asList(new Crusty(), new Slush(), new Powder());
        
        // Won't compile: Arrays.asList中只有Powder，因而只会创建List<Power>,对比第三十五行，则没问题
        // List<Snow> snow2 = Arrays.asList(new Light(), new Heavy());
        List<Snow> snow2 = Arrays.asList(new Crusty(), new Heavy());
        // Compiler says:
        // found : java.util.List<Powder>
        // required: java.util.List<Snow>
        
        // Collections.addAll() doesn't get confused:
        List<Snow> snow3 = new ArrayList<Snow>();
        // 从snow3中得到了类型信息，在编译期间不会报错
        Collections.addAll(snow3, new Light(), new Heavy());
        
        // Give a hint using an
        // explicit type argument specification:
        List<Snow> snow4 = Arrays.<Snow> asList(new Light(), new Heavy());
    }
} // /:~
