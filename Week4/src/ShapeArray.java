public class ShapeArray {
    public static void main(String[] args){

        Shape[] shapeArray = {
                new Sphere(10.0),
                new Cylinder(14.0, 18.0),
                new Cone(13.0, 19.0)
        };

        for(Shape shape : shapeArray){
            System.out.println(shape.toString());
            System.out.println();
        }

    }

}
