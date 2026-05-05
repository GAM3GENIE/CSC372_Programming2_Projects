public class ShapeArray {
    public static void main(String[] args){

        Shape[] shapeArray = {
                new Sphere(6.0),
                new Cylinder(4.0, 8.0),
                new Cone(3.0, 9.0)
        };

        for(Shape shape : shapeArray){
            System.out.println(shape.toString());
            System.out.println();
        }

    }

}
