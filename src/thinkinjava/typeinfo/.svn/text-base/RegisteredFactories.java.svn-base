//: typeinfo/RegisteredFactories.java
// Registering Class Factories in the base class.

package typeinfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import typeinfo.factory.Factory;

class Part {
    
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
    
    static List<Factory<? extends Part>> partFactories = new ArrayList<Factory<? extends Part>>();
    static {
        // Collections.addAll() gives an "unchecked generic
        // array creation ... for varargs parameter" warning.
        // 工厂都被添加到工厂的list中，有了工厂就可以生产对应的产品
        partFactories.add(new FuelFilter.Factory());
        partFactories.add(new AirFilter.Factory());
        partFactories.add(new CabinAirFilter.Factory());
        partFactories.add(new OilFilter.Factory());
        partFactories.add(new FanBelt.Factory());
        partFactories.add(new PowerSteeringBelt.Factory());
        partFactories.add(new GeneratorBelt.Factory());
    }
    
    private static Random rand = new Random(47);
    
    public static Part createRandom() {
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }
}

// Filter可以视为分类的标识
class Filter extends Part {
}

class FuelFilter extends Filter {
    
    // Create a Class Factory for each specific type:
    // 工厂的特性就是制造（所以实现Factory接口），对于同一类产品，只需要一个工厂即可，
    // 此处对静态内部类的使用很重要
    public static class Factory implements typeinfo.factory.Factory<FuelFilter> {
        
        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}

class AirFilter extends Filter {
    
    public static class Factory implements typeinfo.factory.Factory<AirFilter> {
        
        public AirFilter create() {
            return new AirFilter();
        }
    }
}

class CabinAirFilter extends Filter {
    
    public static class Factory implements typeinfo.factory.Factory<CabinAirFilter> {
        
        public CabinAirFilter create() {
            return new CabinAirFilter();
        }
    }
}

class OilFilter extends Filter {
    
    public static class Factory implements typeinfo.factory.Factory<OilFilter> {
        
        public OilFilter create() {
            return new OilFilter();
        }
    }
}

class Belt extends Part {
}

class FanBelt extends Belt {
    
    public static class Factory implements typeinfo.factory.Factory<FanBelt> {
        
        public FanBelt create() {
            return new FanBelt();
        }
    }
}

class GeneratorBelt extends Belt {
    
    public static class Factory implements typeinfo.factory.Factory<GeneratorBelt> {
        
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}

class PowerSteeringBelt extends Belt {
    
    public static class Factory implements typeinfo.factory.Factory<PowerSteeringBelt> {
        
        public PowerSteeringBelt create() {
            return new PowerSteeringBelt();
        }
    }
}

public class RegisteredFactories {
    
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            System.out.println(Part.createRandom());
    }
} /*
   * Output: GeneratorBelt CabinAirFilter GeneratorBelt AirFilter
   * PowerSteeringBelt CabinAirFilter FuelFilter PowerSteeringBelt
   * PowerSteeringBelt FuelFilter
   */// :~
