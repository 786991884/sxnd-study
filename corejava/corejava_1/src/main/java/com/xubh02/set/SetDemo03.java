package com.xubh02.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * 使用字符串 接收签名:从界面上接收 到会人员的名单 放入 HashSet中
 * 点名:遍历输出名单
 *
 * @author Administrator
 */

public class SetDemo03 {
    private Scanner sc;
    private Set<String> members;
    private static String[] args;

    SetDemo03() {
        sc = new Scanner(System.in);
        members = new HashSet<String>();
    }

    public String getStringFromConsole() {
        return sc.nextLine();
    }

    //签名:
    public void addMemeber(String name) {
        members.add(name);
    }

    //点名:遍历输出名单
    public void showMemeber() {
        Iterator<String> it = members.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void main(String[] args) {
        SetDemo03 demo = new SetDemo03();
        System.out.println("====签名======");
        while (true) {
            String name = demo.getStringFromConsole();
            if (name.equalsIgnoreCase("over")) {
                break;
            }
            demo.addMemeber(name);
        }
        System.out.println("=========参会人员有====");
        demo.showMemeber();

    }

}
