package com.tree.www.test;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;

public class Test1 {
	public static void main(String[] args) {
        String eventId = "login";
        Map<String, Object> args2 = Maps.newHashMap();
        args2.put("time", new Date());
        args2.put("time2", new Date());
        if (doDecision(eventId, args2)) {

        }
    }

    /**  
     * @param eventId
     * @param args
     * @return
     */
    private static boolean doDecision(String eventId, Map<String, Object> args) {
        if (eventId.equals("login")) {
            run(args);
        }
        return false;
    }


    private static void run(Map<String, Object> args) {
        List<String> rules;
    }
}

class RuleTemplate1 {
    private String p1;
    private String p2;
    private String p3;

    public boolean run(Map<String, Object> args) {
        if (args.get(p1).getClass().getName() == args.get(p2).getClass().getName()) {
            switch (p3) {
                case "eq":
                    return (Integer) args.get(p1) == (Integer) args.get(p2);
                case "gt":
                    return (Integer) args.get(p1) > (Integer) args.get(p2);
                default:
                    break;
            }
        }
        return false;
    }

    /**
     * Getter method for property <tt>p1</tt>.
     * 
     * @return property value of p1
     */
    public final String getP1() {
        return p1;
    }

    /**
     * Setter method for property <tt>p1</tt>.
     * 
     * @param p1 value to be assigned to property p1
     */
    public final void setP1(String p1) {
        this.p1 = p1;
    }

    /**
     * Getter method for property <tt>p2</tt>.
     * 
     * @return property value of p2
     */
    public final String getP2() {
        return p2;
    }

    /**
     * Setter method for property <tt>p2</tt>.
     * 
     * @param p2 value to be assigned to property p2
     */
    public final void setP2(String p2) {
        this.p2 = p2;
    }

    /**
     * Getter method for property <tt>p3</tt>.
     * 
     * @return property value of p3
     */
    public final String getP3() {
        return p3;
    }

    /**
     * Setter method for property <tt>p3</tt>.
     * 
     * @param p3 value to be assigned to property p3
     */
    public final void setP3(String p3) {
        this.p3 = p3;
    }

}
