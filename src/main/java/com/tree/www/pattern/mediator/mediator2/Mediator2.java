package com.tree.www.pattern.mediator.mediator2;


/**
 * Created by pysh on 2018/6/1.
 */
public class Mediator2 {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        Seller seller = new Seller("今日头条", mediator);
        Buyer buyer = new Buyer("IT导航", mediator);

        seller.sell("我有房出租");
        buyer.buy("我要租房子");
    }
}

interface Mediator {
    void contact(String message, Person person);
}

class ConcreteMediator implements Mediator {

    @Override
    public void contact(String message, Person person) {
        System.out.println(person.getName() + ":" + message);
    }
}

class Person {
    private String name;
    private Mediator mediator;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public Person(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }
}

class Buyer extends Person {

    public Buyer(String name, Mediator mediator) {
        super(name, mediator);
    }

    public void buy(String message) {
        getMediator().contact(message, this);
    }
}

class Seller extends Person {

    public Seller(String name, Mediator mediator) {
        super(name, mediator);
    }

    public void sell(String message) {
        getMediator().contact(message, this);
    }
}
