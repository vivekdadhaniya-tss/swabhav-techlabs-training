package com.tss.ass12;

class Voter {

    private int id;
    private String name;
    private int age;

    Voter(int id, String name, int age) throws AgeException {
        this.id = id;
        this.name = name;

        if (age < 18) {
            throw new AgeException(age);
        }

        this.age = age;
    }

    // Getter & Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws AgeException {
        if (age < 18) {
            throw new AgeException(age);
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return "Voter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
