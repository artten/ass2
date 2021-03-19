/**
 * @author yair koskas
 * one dimensional line
 */

public class Function {
    private double slope;
    private double constant;

    private double slope(Point one, Point two) {
        return (one.getY() - two.getY())/(one.getX() - two.getX());
    }

    private double constant(Point one, double slope) {
        return (one.getY() - slope * one.getX());
    }

    public Function(Point one, Point two) {
        this.slope = slope(one, two);
        this.constant = constant(one, this.slope);
    }


    public double getSlope() {
        return  this.slope;
    }

    public double getConstant(){
        return this.constant;
    }

    public double getYbyX(double x) {
        return x*this.slope + this.constant;
    }

    public Point functionsInteract (Function other) {
        double x = (other.getConstant() - this.constant)/( this.slope - other.getSlope());
        System.out.println("@@@@@@@@@@@@@@@@@@@");
        System.out.println(x);
        System.out.println(getYbyX(x));
        System.out.println(other.getYbyX(x));
        System.out.println(getYbyX(x) == other.getYbyX(x));
        System.out.println("@@@@@@@@@@@@@@@@@@@");
        if((int) (getYbyX(x) * 100000) == (int) (other.getYbyX(x) * 100000)) {
            return new Point(x,getYbyX(x));
        }
        return null;
    }

}
