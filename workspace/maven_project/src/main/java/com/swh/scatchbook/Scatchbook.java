package com.swh.scatchbook;

public class Scatchbook {
    private String name;
    private Drawing[] drawList;     //  배열은 크기를 동적으로 조절하기가 힘들다. Chap23, 24 제네릭과 컬렉션을 통해 동적으로 크기를 조정하는 것을 배우게 된다.
    
    public Scatchbook(String name, int size) {
        this.name = name;
        this.drawList = new Drawing[size];
    }
    
    public void addDrawing(Drawing d){
        for(int index = 0; index < drawList.length; index++){
            if(drawList[index] == null) {
                drawList[index] = d;
                break;
            }
        }
    }
    
    public void draw(){
        for(Drawing d : drawList) System.out.println(d.draw());
    }

    public static void main(String args[]) {
        Scatchbook scatchbook = new Scatchbook("SWH아카데미 스케치북", 2);
        Circle circle = new Circle(5000);
        Line line = new Line(5);
        Rectangle rectangle = new Rectangle();

        scatchbook.addDrawing(circle);
        scatchbook.addDrawing(rectangle);
//        scatchbook.addDrawing(line);      //  컴파일 오류
        scatchbook.draw();
    }
}