package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;
    int size = 0;
    private ArrayList<Entry<String>> tree = new ArrayList<>();

    public CustomTree() {
        root = new Entry<>("0");
        tree.add(root);
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
        //return super.set(index, element);
    }

    @Override
    public boolean add(String s) {
        Entry<String> newEntry = new Entry<>(s);
        if (s != null) {
            for (int i = tree.size() - 1; i >= 0; i--) {
                if ((i > 0 && !tree.get(i - 1).isAvailableToAddChildren()) || i == 0) {
                    tree.add(newEntry);
                    newEntry.parent = tree.get(i);
                    if (tree.get(i).availableToAddLeftChildren) {
                        tree.get(i).availableToAddLeftChildren = false;
                        tree.get(i).leftChild = newEntry;
                    } else {
                        tree.get(i).availableToAddRightChildren = false;
                        tree.get(i).rightChild = newEntry;
                    }
                    size++;
                    return true;
                } else {

                }
            }
        }
        return false;
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
        //super.add(index, element);
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
        //return super.addAll(index, c);
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
        //return super.subList(fromIndex, toIndex);
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
        //return super.remove(index);
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
        //super.removeRange(fromIndex, toIndex);
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
        //return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    public String getParent(String s) {
        for (Entry<String> stringEntry : tree)
            if (stringEntry.elementName.equals(s))
                return stringEntry.parent.elementName;
        return null;
    }

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }
}
