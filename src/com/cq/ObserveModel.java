/******************************************************************************
 * Copyright (C) 2010 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/

package com.cq;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈强
 * @since 1.0
 * @version 2011-9-28 陈强新建
 */
class ObserveModel {
    
}

class Observable {
    
    protected List<Observer> lstObs;
    
    private boolean flag = false;
    
    /**
     * @return 获取 flag属性值
     */
    public boolean isFlag() {
        return flag;
    }
    
    /**
     * @param flag 设置 flag 属性值为参数值 flag
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    
    Observable() {
        lstObs = new ArrayList<Observer>();
    }
    
    public synchronized void addObservers(Observer obs) {
        if (obs != null && !this.lstObs.contains(obs)) {
            this.lstObs.add(obs);
        }
    }
    
    public synchronized void removeObservers(Observer obs) {
        this.lstObs.remove(obs);
    }
    
    void notifyObservers() {
        notifyObservers(null);
    }
    
    void notifyObservers(Object arg) {
        Object[] arrLocal;
        synchronized (this) {
            if (!flag) {
                return;
            }
            arrLocal = lstObs.toArray();
        }
        for (int i = arrLocal.length - 1; i >= 0; i--) {
            ((Observer) arrLocal[i]).update(this, arg);
        }
        
    }
    
}

interface Observer {
    
    void update(Observable o, Object arg);
    
}

/**
 * 被观察者
 * 
 * @author 陈强
 * @since 1.0
 * @version 2011-9-28 陈强新建
 */
class Observablesub extends Observable {
    
    public static void main(String args[]) {
        Observablesub obs = new Observablesub();
        Observer observer = new ObserverImpl1();
        Observer observer2 = new ObserverImpl2();
        obs.addObservers(observer);
        obs.addObservers(observer2);
        obs.setFlag(true);
        if (obs.isFlag()) {
            obs.notifyObservers();
        }
    }
}

class ObserverImpl1 implements Observer {
    
    /**
     * @see com.cq.Observer#update(com.cq.Observable, java.lang.Object)
     */
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("观察者1做出了反应！！");
    }
    
}

class ObserverImpl2 implements Observer {
    
    /**
     * @see com.cq.Observer#update(com.cq.Observable, java.lang.Object)
     */
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("观察者2做出了反应！！");
    }
    
}
