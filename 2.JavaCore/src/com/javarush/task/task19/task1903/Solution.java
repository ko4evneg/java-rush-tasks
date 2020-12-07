package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        //System.out.println(IncomeDataAdapter.getPhoneNumber("501234567"));
    }

    public static class IncomeDataAdapter implements Contact, Customer {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }
        public IncomeDataAdapter() {
           // this.data = data;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            String phone = String.format("%010d",data.getPhoneNumber());
            //String res = String.format("+%02d (%s) %s-%s-%s",data.getCountryPhoneCode(),phone.substring(0,3),phone.substring(3,6),phone.substring(6,8),phone.substring(8,10));
            return String.format("+%d(%s)%s-%s-%s", data.getCountryPhoneCode(), phone.substring(0, 3), phone.substring(3, 6),phone.substring(6, 8), phone.substring(8, 10));
        }

/*        //@Override
        public static String getPhoneNumber(String num) {
            String number = num;//Integer.toString(data.getPhoneNumber());
            for (int i = 0; i < (10 - number.length()); i++)
                number = "0" + number;
            return "+";// + data.getCountryCode() + "(" + number.substring(0, 3) + ")" + number.substring(3);
        }*/
    }


    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}
