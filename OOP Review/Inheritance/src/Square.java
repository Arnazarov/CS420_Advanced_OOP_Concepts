public class Square extends Shape {

    // data members
    private double side;
    private String name;

    public Square(double side, String name) {
        super(name);
        this.side = side;
    }

    @Override
    public double getArea(){
        return side * side;
    }

    @Override
    public double getPerimeter(){
        return 4 * side;
    }

    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Square))
            return false;
        else {
            Square oth = (Square) obj;
            return this.name.equals(oth.name) && this.side == oth.side;
        }
    }

    @Override
    public String toString() {
        return this.name + ":" + this.side;
    }
}