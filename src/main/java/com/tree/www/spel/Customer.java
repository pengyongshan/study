/**
 * qccr.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.tree.www.spel;

/**
 * 
 * @author pengyongshan
 *
 * @version $Id: Customer.java, v 0.1 2016年10月8日 下午7:20:05 pengyongshan Exp $
 */
public class Customer {

    private Item   item;

    private String itemName;

    @Override
    public String toString() {
        return "itemName=" + this.itemName + ",item.total=" + item.getTotal();
    }

    /**
     * Getter method for property <tt>item</tt>.
     * 
     * @return property value of item
     */
    public final Item getItem() {
        return item;
    }

    /**
     * Setter method for property <tt>item</tt>.
     * 
     * @param item value to be assigned to property item
     */
    public final void setItem(Item item) {
        this.item = item;
    }

    /**
     * Getter method for property <tt>itemName</tt>.
     * 
     * @return property value of itemName
     */
    public final String getItemName() {
        return itemName;
    }

    /**
     * Setter method for property <tt>itemName</tt>.
     * 
     * @param itemName value to be assigned to property itemName
     */
    public final void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
