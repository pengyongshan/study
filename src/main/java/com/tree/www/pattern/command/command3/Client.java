package com.tree.www.pattern.command.command3;

/**
 * Created by pysh on 2018/3/19.
 */
public class Client {
    public static void main(String[] args) {
        Command command = new ForwardCommand(new Role());
        Invoker invoker = new Invoker(command);
        invoker.action();
        invoker.reset();
    }
}

interface Command {
    void execute();

    void undo();
}

class Role {
    public void forward() {
        System.out.println("走10步");
    }

    public void back() {
        System.out.println("退10步");
    }
}

class ForwardCommand implements Command {

    private Role role;

    public ForwardCommand(Role role) {
        this.role = role;
    }

    @Override
    public void execute() {
        role.forward();
    }

    @Override
    public void undo() {
        role.back();
    }
}

class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action() {
        command.execute();
    }

    public void reset() {
        command.undo();
    }
}
