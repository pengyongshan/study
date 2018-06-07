package com.tree.www.pattern.memento.memento4;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pysh on 2018/6/7.
 */
public class Client {
    public static void main(String[] args) {
        GameRole role = new GameRole();

        System.out.println("初始化");
        role.initState();
        role.stateDisplay();

        RoleStateCaretaker caretaker = new RoleStateCaretaker();
        caretaker.setRoleStateMemento("init", role.createMemento());

        System.out.println("战斗中");
        role.fight();
        role.stateDisplay();
        caretaker.setRoleStateMemento("fight", role.createMemento());

        System.out.println("死后");
        role.died();
        role.stateDisplay();

        System.out.println("恢复到初始化");
        role.recoverMemento(caretaker.getRoleStateMemento("init"));
        role.stateDisplay();

        System.out.println("恢复到战斗中");
        role.recoverMemento(caretaker.getRoleStateMemento("fight"));
        role.stateDisplay();

    }
}

// 发起人
class GameRole {
    private int vit;
    private int atk;
    private int def;

    public void stateDisplay() {
        System.out.println("当前角色状态：");
        System.out.println("生命值：" + vit);
        System.out.println("攻击力：" + atk);
        System.out.println("防御力：" + def);
    }

    public RoleStateMemento createMemento() {
        return new RoleStateMemento(vit, atk, def);
    }

    public void recoverMemento(RoleStateMemento memento) {
        this.atk = memento.getAtk();
        this.vit = memento.getVit();
        this.def = memento.getDef();
    }

    public void initState() {
        this.vit = 100;
        this.atk = 100;
        this.def = 100;
    }

    public void fight() {
        this.vit = 50;
        this.atk = 50;
        this.def = 50;
    }

    public void died() {
        this.vit = 0;
        this.atk = 0;
        this.def = 0;
    }

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }
}
// 备忘录-保存对象状态
class RoleStateMemento {
    private int vit;
    private int atk;
    private int def;

    public RoleStateMemento(int vit, int atk, int def) {
        this.vit = vit;
        this.atk = atk;
        this.def = def;
    }

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }
}

// 管理者
class RoleStateCaretaker {
    private Map<String, RoleStateMemento> mementoMap = new HashMap<>();

    public RoleStateMemento getRoleStateMemento(String action) {
        return mementoMap.get(action);
    }

    public void setRoleStateMemento(String action, RoleStateMemento roleStateMemento) {
        mementoMap.put(action, roleStateMemento);
    }
}
