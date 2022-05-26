package com.Gzl0ng.exer2;

public class Student implements Comparable{
    private String name;
    private int score;

    public Student() {
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Student){
            Student s = (Student)o;
            return -Integer.compare(this.score,s.score);
        }
        throw new RuntimeException("传入对象不一致");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name +
                '}';
    }
}
