/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.thinkinjava.io.serializable;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;


/**
 * 
 * @author:   qiang.chen
 * @since:    2012-12-18
 * @version : 1.0
 */
public class ExternalizableDemo {
    
    static class Blip3 implements Externalizable{
        private int i;
        
        public Blip3(){
            System.out.println("default constructor called!");
        }
        public Blip3(int i){
            this.i = i;
            System.out.println("first constructor called");
        }

        /* (non-Javadoc)
         * @see java.io.Externalizable#readExternal(java.io.ObjectInput)
         */
        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            this.i = in.readInt();
        }

        /* (non-Javadoc)
         * @see java.io.Externalizable#writeExternal(java.io.ObjectOutput)
         */
        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeInt(this.i);
        }
    }
    
    public static void main(String args[]) throws ClassNotFoundException{
        String path = System.class.getResource("/").getPath();
        String file = "out.dat";
        Blip3 b = new Blip3(555);
        Blip3 b2 = new Blip3(676);
        try {
            ObjectOutputStream ou = new ObjectOutputStream(new FileOutputStream(path +"/" + file) );
            System.out.println("write object: ");
            ou.writeObject(b);
            ou.writeObject(b2);
            ou.close();
            
            ObjectInputStream iu = new ObjectInputStream(new FileInputStream(path +"/" + file) );
            b = (Blip3)iu.readObject();
            Blip3 b3 = (Blip3)iu.readObject();
            System.out.println(b.i);
            System.out.println(b3.i);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
