import java.io.*;
import java.util.*;

class Person implements Serializable{
    String name;
    String id;
    int credit;

    public Person(String name,String id,int credit){
        this.name = name;
        this.id = id;
        this.credit = credit;
    }
    public String toString(){
        return "Name : " + name + "\nID : " + id + "\nCredit : " + credit;
    }
}

public class Main {
    public static void main(String[] args){



        //replace("soru1.txt","a","z","aabbccddaa");
        //replace("soru1.txt","ab","z","aabbccddaa");
        //replace("soru1.txt","ab","xy","aabbccddaa");
        //replace("soru1.txt","abcd","xy","aabbccddaa");

        Person p1=new Person("Joshua Read","0001",10000);
        Person p2=new Person("Jesse Morgan","0002",5000);
        Person p3=new Person("Alexa Stone","0003",2800);
        Person p4=new Person("Belle Davidson","0004",6400);
        Person p5=new Person("Lee Owen","0005",150);


        ObjectOutputStream writer = null;
        ObjectInputStream reader = null;
        try{
            writer = new ObjectOutputStream(new FileOutputStream("soru2.bin"));
            reader = new ObjectInputStream(new FileInputStream("soru2.bin"));
            writer.writeObject(p1);
            writer.writeObject(p2);
            writer.writeObject(p3);
            writer.writeObject(p4);
            writer.writeObject(p5);
            writer.close();

            Person pa = (Person)reader.readObject();
            Person pb = (Person)reader.readObject();
            Person pc = (Person)reader.readObject();
            Person pd = (Person)reader.readObject();
            Person pe = (Person)reader.readObject();
            reader.close();

            System.out.println(pa);
            System.out.println(pb);
            System.out.println(pc);
            System.out.println(pd);
            System.out.println(pe);

            pa.credit = pa.credit + 100;
            pb.credit = pb.credit + 100;
            pc.credit = pc.credit + 100;
            pd.credit = pd.credit + 100;
            pe.credit = pe.credit + 100;

            System.out.println(pa);
            System.out.println(pb);
            System.out.println(pc);
            System.out.println(pd);
            System.out.println(pe);


        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
    public static void replace(String text,String oldChars,String newChars,String input){


        PrintWriter writer = null;
        try{
            writer = new PrintWriter(new FileOutputStream(text));
            writer.print(input);
            writer.close();

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }


        char[] olds = new char[oldChars.length()];
        char[] news = new char[oldChars.length()];
        int count = 0;
        for(int i=0;i< olds.length;i++){
            if(count >= newChars.length())
                count = 0;
            olds[i] = oldChars.charAt(i);
            news[i] = newChars.charAt(count);
            count++;
        }

        Scanner reader = null;
        try{
            reader = new Scanner(new FileInputStream(text));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        String in = reader.nextLine();
        String inn = "";
        for(int i=0;i<olds.length;i++){
            inn = in.replace(olds[i],news[i]);
            in = inn;
        }

        try{
            writer = new PrintWriter(new FileOutputStream(text));
            writer.print(inn);
            writer.close();

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }




    }


}
