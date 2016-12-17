package com.xubh01.gen03;

/**
 * 泛型接口:与继承同理
 * 重写方法随父类而定
 *
 * @param <T>
 */
public interface Comparable<T> {
    void compare(T t);
}

//声明子类指定具体类型
class Comp implements Comparable<Integer> {

    @Override
    public void compare(Integer t) {

    }

}

//擦除
class Comp1 implements Comparable {

    @Override
    public void compare(Object t) {

    }

}

//父类擦除，子类泛型
class Comp2<T> implements Comparable {

    @Override
    public void compare(Object t) {

    }

}

//子类泛型>=父类泛型
class Comp3<T> implements Comparable<T> {

    @Override
    public void compare(T t) {

    }

}
//父类泛型，子类擦除 错误