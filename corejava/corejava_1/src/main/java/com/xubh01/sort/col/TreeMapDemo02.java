package com.xubh01.sort.col;

import java.util.TreeMap;

public class TreeMapDemo02 {
    public static void main(String[] args) {
        Worker w1 = new Worker("垃圾回收员", 12000);
        Worker w2 = new Worker("农民工", 8000);
        Worker w3 = new Worker("程序猿", 5000);

        TreeMap<Worker, String> employees = new TreeMap<Worker, String>();
        employees.put(w1, "xubh02");
        employees.put(w2, "xubh02");
        employees.put(w3, "xubh02");
        System.out.println(employees.keySet());
    }

}
