package com.tree.www.pattern.command.command4;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.List;

/**
 * 日志记录
 * <p>
 * Created by pysh on 2018/3/19.
 */
public class Client {

    public static void main(String[] args) {
        OperatorWindow window = new OperatorWindow();
        Command command;
        Operator operator = new Operator();

        command = new InsertCommand("insert");
        command.setOperator(operator);
        window.setCommand(command);
        window.call("节点1");

        command = new InsertCommand("insert");
        command.setOperator(operator);
        window.setCommand(command);
        window.call("节点2");

        command = new ModifyCommand("modify");
        command.setOperator(operator);
        window.setCommand(command);
        window.call("节点1");

        command = new DeleteCommand("delete");
        command.setOperator(operator);
        window.setCommand(command);
        window.call("节点2");

        System.out.println("-------------保存操作记录---------");
        window.save();
        System.out.println("-------------死机---------");
        System.out.println("-------------恢复操作---------");
        window.recover();
    }
}

class Operator implements Serializable {

    private static final long serialVersionUID = -4069388047593704380L;

    public void insert(String args) {
        System.out.println("insert operation:" + args);
    }

    public void modify(String args) {
        System.out.println("update operation:" + args);
    }

    public void delete(String args) {
        System.out.println("delete operation:" + args);
    }
}

abstract class Command implements Serializable {

    private static final long serialVersionUID = -1112635551402351311L;
    protected String name;
    protected String args;
    protected Operator operator;

    public Command(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public abstract void execute(String args);

    public void execute() {
        execute(args);
    }
}

class InsertCommand extends Command {

    private static final long serialVersionUID = 2571977604659037275L;

    public InsertCommand(String name) {
        super(name);
    }

    @Override
    public void execute(String args) {
        this.args = args;
        operator.insert(args);
    }
}

class DeleteCommand extends Command {

    private static final long serialVersionUID = -345414893023223330L;

    public DeleteCommand(String name) {
        super(name);
    }

    @Override
    public void execute(String args) {
        this.args = args;
        operator.delete(args);
    }
}

class ModifyCommand extends Command {

    private static final long serialVersionUID = -4927454251685204288L;

    public ModifyCommand(String name) {
        super(name);
    }

    @Override
    public void execute(String args) {
        this.args = args;
        operator.modify(args);
    }
}

class OperatorWindow {
    private List<Command> commands = Lists.newArrayList();
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void call(String args) {
        command.execute(args);
        commands.add(command);
    }

    public void save() {
        FileUtil.writeCommands(commands);
    }

    public void recover() {
        List<Command> commands = FileUtil.readCommands();

        for (Command command : commands) {
            command.execute();
        }
    }
}

class FileUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtil.class);

    public static void writeCommands(List<Command> commands) {
        try {
            FileOutputStream fos = new FileOutputStream("opetator.log");
            ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(fos));
            oos.writeObject(commands);
            oos.close();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    public static List<Command> readCommands() {
        try {
            FileInputStream fis = new FileInputStream("opetator.log");
            ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(fis));
            List<Command> commands = (List<Command>) ois.readObject();
            ois.close();
            return commands;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }
    }
}
