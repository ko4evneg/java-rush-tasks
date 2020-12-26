package com.javarush.task.task21.task2107;

import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
*/

public class Solution implements Cloneable {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    @Override
    protected Solution clone() throws CloneNotSupportedException {
        Solution sol = new Solution();
        for (Map.Entry<String, User> e : users.entrySet()) {
            sol.users.put(e.getKey(), e.getValue().clone());
        }
        return sol;
    }

    @Override
    public int hashCode() {
        int result = 0;
        for (Map.Entry<String, User> entry : users.entrySet()) {
            result += entry.getKey().hashCode() + entry.getValue().hashCode();
        }
        return result;
    }


    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable{
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            User user = (User) o;

            if (age != user.age) return false;
            return name != null ? name.equals(user.name) : user.name == null;
        }

        @Override
        public int hashCode() {
            int result = age;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }

        @Override
        protected User clone() throws CloneNotSupportedException {
            return new User(age, name);
        }
    }
}
