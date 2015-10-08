//: interfaces/HorrorShow.java
// Extending an interface with inheritance.

package interfaces;

interface Monster {
    
    void menace();
}

interface DangerousMonster extends Monster {
    
    void destroy();
}

interface Lethal {
    
    void kill();
}

class DragonZilla implements DangerousMonster {
    
    public void menace() {
    }
    
    public void destroy() {
    }
}

interface Vampire extends DangerousMonster, Lethal {
    
    void drinkBlood();
}

class VeryBadVampire implements Vampire {
    
    public void menace() {
    }
    
    public void destroy() {
    }
    
    public void kill() {
    }
    
    public void drinkBlood() {
    }
}

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-2-22 陈强新建
 */
public class HorrorShow {
    
    static void u(Monster b) {
        b.menace();
    }
    
    static void v(DangerousMonster d) {
        d.menace();
        d.destroy();
    }
    
    static void w(Lethal l) {
        l.kill();
    }
    
    public static void main(String[] args) {
        DangerousMonster barney = new DragonZilla();
        u(barney);
        v(barney);
        Vampire vlad = new VeryBadVampire();
        u(vlad);
        v(vlad);
        w(vlad);
    }
} // /:~
