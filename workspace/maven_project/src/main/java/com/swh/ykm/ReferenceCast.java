package com.swh.ykm;

class Animal {
    void eat() {
        System.out.println("먹는다.");
    }
}
class Mammal extends Animal {
    public boolean hasMom() {
        return true;
    }
}
class Ape extends Mammal {
    public void mimic() {
        System.out.println("흉내낸다.");
    }
}
class Human extends Mammal {
    public void speak() {
        System.out.println("말하다");
    }
}
public class ReferenceCast {
    public static void main(String args[]) {
        Animal animal1, animal2;
        Mammal mammal1, mammal2;
        Ape    ape1, ape2;
        Human  human1, human2;	
        
        animal1 = new Animal();
        mammal1 = new Mammal();
        ape1    = new Ape();
        human1  = new Human();

//      human2 = ape1;               // 컴파일 에러
//      human2  = mammal1;           // 컴파일 에러
//      human2 = (Human) mammal1;    // 컴파일은 성공, 실행시 에러
        mammal2 = human1;               // 성공
//      human2  = mammal2;           // 컴파일 에러
        human2 = (Human) mammal2;       // 성공
//      ape2 = (Ape) mammal2;        // 컴파일은 성공, 실행시 에러
//      ape2 = (Ape) animal1;        // 컴파일은 성공, 실행시 에러
    }
}	
