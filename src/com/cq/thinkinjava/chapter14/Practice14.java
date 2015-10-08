

package com.cq.thinkinjava.chapter14;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Part {
    
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
    
    static List<Class<? extends Part>> partFactories = new ArrayList<Class<? extends Part>>();
    static {
        // Collections.addAll() gives an "unchecked generic
        // array creation ... for varargs parameter" warning.
        // �����������ӵ�������list�У����˹����Ϳ���������Ӧ�Ĳ�Ʒ
        partFactories.add(FuelFilter.class);
        partFactories.add(AirFilter.class);
        partFactories.add(CabinAirFilter.class);
        partFactories.add(OilFilter.class);
        partFactories.add(FanBelt.class);
        partFactories.add(PowerSteeringBelt.class);
        partFactories.add(GeneratorBelt.class);
    }
    
    private static Random rand = new Random(47);
    
    public static Part createRandom() {
        int n = rand.nextInt(partFactories.size());
        try {
            return partFactories.get(n).newInstance();
        } catch (InstantiationException e) {
            // TODO �Զ������쳣�������ע�ͣ���ʵ��ʱ��ɾ����ע��
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO �Զ������쳣�������ע�ͣ���ʵ��ʱ��ɾ����ע��
            e.printStackTrace();
        }
        return null;
    }
}

// Filter������Ϊ����ı�ʶ
class Filter extends Part {
}

class FuelFilter extends Filter {
    
}

class AirFilter extends Filter {
    
}

class CabinAirFilter extends Filter {
    
}

class OilFilter extends Filter {
    
}

class Belt extends Part {
}

class FanBelt extends Belt {
}

class GeneratorBelt extends Belt {
    
}

class PowerSteeringBelt extends Belt {
    
}

public class Practice14 {
    
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            System.out.println(Part.createRandom());
    }
} /*
   * Output: GeneratorBelt CabinAirFilter GeneratorBelt AirFilter
   * PowerSteeringBelt CabinAirFilter FuelFilter PowerSteeringBelt
   * PowerSteeringBelt FuelFilter
   */// :~
