/**
 * qccr.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.tree.www.spel;

/**
 * 
 * @author pengyongshan
 *
 * @version $Id: Item.java, v 0.1 2016年10月8日 下午7:17:51 pengyongshan Exp $
 */
public class Item {

    private String name;

    private int    total;

    /**
     * Getter method for property <tt>name</tt>.
     * 
     * @return property value of name
     */
    public final String getName() {
        return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     * 
     * @param name value to be assigned to property name
     */
    public final void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for property <tt>total</tt>.
     * 
     * @return property value of total
     */
    public final int getTotal() {
        return total;
    }

    /**
     * Setter method for property <tt>total</tt>.
     * 
     * @param total value to be assigned to property total
     */
    public final void setTotal(int total) {
        this.total = total;
    }

}
