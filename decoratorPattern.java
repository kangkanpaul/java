abstract class Shape{
    //String description = " what";
    public abstract String getDescription();
    public abstract float getCost();
}

class Sphere extends Shape{
    
    public String getDescription(){
        return "I am a Sphere";
    }
    public float getCost(){
        return 3.00f;
    }
}

class Cube extends Shape{
    public String getDescription(){
        return "I am a Cube";
    }
    public float getCost(){
        return 5.00f;
    }
}

abstract class Colors extends Shape{
    public abstract String getDescription();
}

class Blue extends Colors{
    Shape shape;
    public Blue(Shape shape){
        this.shape = shape;
    }
    public String getDescription(){
        return shape.getDescription() + " and I am Blue colored";
    }
    public float getCost(){
        return shape.getCost()+0.10f;
    }
}

class Red extends Colors{
    Shape shape;
    public Red(Shape shape){
        this.shape = shape;
    }
    public String getDescription(){
        return shape.getDescription() + " and I am Red colored";
    }
    public float getCost(){
        return shape.getCost()+0.20f;
    }
}

class ShapeToys{
    public static void main(String[] args){
        Shape toy = new Sphere();
        toy = new Blue(toy);
        System.out.println(toy.getDescription()+" $"+toy.getCost());
        
        Shape toy2 = new Cube();
        toy2 = new Red(toy2);
        toy2 = new Blue(toy2);
        System.out.println(toy2.getDescription()+" $"+toy2.getCost());
        
    }
}
