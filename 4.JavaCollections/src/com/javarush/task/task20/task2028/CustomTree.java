package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
Тебе необходимо:
1) переопределить метод add(String s) - добавляет элементы дерева, в качестве параметра принимает имя элемента (elementName), искать место для вставки начинаем слева направо.
2) переопределить метод size() - возвращает текущее количество элементов в дереве.
3) реализовать метод getParent(String s) - возвращает имя родителя элемента дерева, имя которого было полученного в качестве параметра.

Если необходимо, можешь вводить дополнительные методы и поля, не указанные в задании.


Требования:
2. В классе CustomTree должны быть переопределены методы add(String s) и size().
3. После добавления N элементов в дерево с помощью метода add, метод size должен возвращать N.
4. Метод getParent должен возвращать имя родителя для любого элемента дерева.
*/

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    private Entry<String> root;
    private int size = 0;
    private final ArrayList<Entry<String>> tree = new ArrayList<>();

    public CustomTree() {
        root = new Entry<>("0");
        tree.add(root);
    }

    public boolean remove(Object o) {
        if (!(o instanceof String))
            throw new UnsupportedOperationException();
        for (Entry<String> e : tree)
            if (e.elementName.equals(o)) {
                toDel(e);
                return true;
            }
        return false;
    }

    private void toDel(Entry<String> entry) {
        if (entry.rightChild != null) {
            toDel(entry.rightChild);
            entry.rightChild = null;
        }
        if (entry.leftChild != null) {
            toDel(entry.leftChild);
            entry.leftChild = null;
        }
        tree.remove(entry);
        if (entry.parent.leftChild == entry)
            entry.parent.leftChild = null;
        else
            entry.parent.rightChild = null;
        size--;
        //System.out.println("Removed: " + entry.elementName);
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
            for (int i = 0; i < tree.size(); i++) {
                if (tree.get(i).isAvailableToAddChildren()) {
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
                } else if (i == tree.size() - 1){
                    for (Entry<String> stringEntry : tree) {
                        if (stringEntry.leftChild == null && !stringEntry.availableToAddLeftChildren)
                            stringEntry.availableToAddLeftChildren = true;
                        if (stringEntry.rightChild == null && !stringEntry.availableToAddRightChildren)
                            stringEntry.availableToAddRightChildren = true;
                    }
                    add(s);
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
