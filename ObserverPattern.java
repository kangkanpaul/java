// Online Java Compiler
// Use this editor to write, compile and run your Java code onlin
import java.util.ArrayList;
interface Publisher {
    public void reg(Subscriber s);
    public void rem(Subscriber s);
    public void notify1();
}

interface Subscriber {
    public void update(int price);
    
}
interface Display{
    public void display();
}

class NSE1 implements Publisher{
    private ArrayList<Subscriber> subscribers;
    private int price;
    
    public NSE1(){
        subscribers = new ArrayList<Subscriber>();
    }
    
    public void reg(Subscriber s){
        subscribers.add(s);
    }
    
    public void rem(Subscriber s){
        int i = subscribers.indexOf(s);
        if (i>0){
            subscribers.remove(s);
        }
    }
    public void notify1(){
        for(int i=0;i<subscribers.size();i++){
            Subscriber ss = subscribers.get(i);
            ss.update(price);
        }
    }
     public void marketChanged() {
        notify1();
     }
    public void setPrice(int p){
        this.price = p;
        marketChanged();
    }
}

class Kangkan implements Subscriber, Display{
    private int price;
    private Publisher nse;
    Kangkan(Publisher nse){
        this.nse = nse;
        nse.reg(this);
    }
    public void update(int price){
        this.price = price;
        display();
    }
    public void display(){
        System.out.println("Kangkan Price is updated :"+price);
    }
}

class Ramesh implements Subscriber, Display{
    private int price;
    private Publisher nse;
    Ramesh(Publisher nse){
        this.nse = nse;
        nse.reg(this);
    }
    public void update(int price){
        this.price = price;
        display();
    }
    public void display(){
        System.out.println("Ramesh Price is updated :"+price);
    }
}

class Susovan implements Subscriber, Display{
    private int price;
    private Publisher nse;
   Susovan(Publisher nse){
        this.nse = nse;
        nse.reg(this);
    }
    public void update(int price){
        this.price = price;
        display();
    }
    public void display(){
        System.out.println("Susovan Price is updated :"+price);
    }
}
class Market{
    public static void main(String args[]){
        NSE1 NSE = new NSE1();
        Kangkan Kangkan1 = new Kangkan(NSE);
        Ramesh Ramesh1 = new Ramesh(NSE);
        Susovan Susovan1 = new Susovan(NSE);
        
        NSE.setPrice(800);
        NSE.setPrice(900);
        NSE.rem(Susovan1);
        NSE.setPrice(1000);
        NSE.reg(Susovan1);
        NSE.setPrice(1111);
    }
}
