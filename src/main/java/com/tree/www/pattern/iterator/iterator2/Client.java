package com.tree.www.pattern.iterator.iterator2;

/**
 * Created by pysh on 2018/6/6.
 */
public class Client {
    public static void main(String[] args) {
        Container container =  new NameRepository();
        for (Iterator iterator = container.getIterator();iterator.hasNext();) {
            String name = (String) iterator.next();
            System.out.println("name:" + name);
        }
    }
}

interface Iterator<E> {
    boolean hasNext();
    E next();
}

interface Container {
    Iterator getIterator();
}
class NameRepository implements Container {

    public String[] names = {"AAAA","BBBB","CCCC", "DDDD"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator<String> {

        private int index;

        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        @Override
        public String next() {
            if(hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}
