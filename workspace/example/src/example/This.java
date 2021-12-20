package example;


class Cat{
    int decibel;
    CatTower catTower;
    Cat() {
        catTower = new CatTower(3);
    }
    void yawong(int decibel) {
        this.decibel = decibel;
        catTower.walk(this);
    }
}

class CatTower {
    int height;
    CatTower() {
    }
    CatTower(int height) {
        this.height = height;
    }
    void walk(Cat cat) {
        System.out.println(height + "높이 에서 " + cat.decibel + " 데시벨로 야옹거린다.");
    }
}
public class This {
    public static void main(String args[]) {
        Cat koya = new Cat();
        koya.yawong(10);
    }
}