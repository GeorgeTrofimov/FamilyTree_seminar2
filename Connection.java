public class Connection {
    public String name, connection, gender;
    public int age;

    public Connection(String name, String gender,String connection, int age){
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.connection = connection;

       // System.out.println("Имя члена семьи: " + this.name);
       // System.out.println("Пол: " + this.gender);
       // System.out.println("Возраст: " + this.age);
       // System.out.println("Отношения: " + this.connection);
    }
}
