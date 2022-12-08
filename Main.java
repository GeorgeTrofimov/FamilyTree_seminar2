import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
       /* Connection George = new Connection("George", "Men", "I", 22)
        Connection Anastasiya = new Connection("Anastasiya", "Women", "Wife", 21);
        Connection Kirill = new Connection("Kirill", "Men", "Parents", 52);
        Connection Vera = new Connection("Vera", "Women", "Parents", 50);
        Connection Danya = new Connection("Danya", "Men", "Relatives", 29);
        Connection Sergey = new Connection("Sergey", "Men", "Relatives", 61);
        Connection Nata = new Connection("Nata", "Women", "Relatives", 65);
        Connection Ira = new Connection("Ira", "Women", "Relatives", 57);
        Connection Valya = new Connection("Valya", "Women", "Relatives", 34);
        Connection Evgeniy = new Connection("Evgeniy", "Men", "Relatives", 29);
        Connection Anatoliy = new Connection("Anatoliy", "Men", "RelativesInLaw", 46);
        Connection Svetlana = new Connection("Svetlana", "Women", "RelativesInLaw", 43);
        Connection Artyom = new Connection("Artyom", "Men", "RelativesInLaw", 8);
        Connection Nikita = new Connection("Nikita", "Men", "RelativesInLaw", 16);
        Connection Antonina = new Connection("Antonina", "Women", "Children", 1);*/

        var George = new Humanking("George");
        var Anastasiya = new Humanking("Anastasiya");
        var Kirill = new Humanking("Kirill");
        var Vera = new Humanking("Vera");
        var Sergey = new Humanking("Sergey");
        var Nata = new Humanking("Nata");
        var Ira = new Humanking("Ira");
        var Valya = new Humanking("Valya");
        var Evgeniy = new Humanking("Evgeniy");
        var Anatoliy = new Humanking("Anatoliy");
        var Svetlana = new Humanking("Svetlana");
        var Artyom = new Humanking("Artyom");
        var Nikita = new Humanking("Nikita");
        var Antonina = new Humanking("Antonina");

        GeoTree gt = new GeoTree();
        gt.append3(George, Anastasiya);
        gt.append(George,Kirill);
        gt.append(George,Vera);
        gt.append1(George,Sergey);
        gt.append1(George,Nata);
        gt.append1(George,Ira);
        gt.append1(George,Evgeniy);
        gt.append1(George,Valya);
        gt.append2(George,Anatoliy);
        gt.append2(George,Svetlana);
        gt.append2(George,Artyom);
        gt.append2(George,Nikita);
        gt.append4(George,Antonina);

        System.out.println(new Research(gt).spend(George, Relationship.Wife));
        System.out.println(new Research(gt).spend(George, Relationship.Parents));
        System.out.println(new Research(gt).spend(George, Relationship.Relatives));
        System.out.println(new Research(gt).spend(George, Relationship.RelativesInLaw));
        System.out.println(new Research(gt).spend(George, Relationship.Children));
    }
}

enum Relationship {
    Parents,
    Children,
    Relatives,
    RelativesInLaw,
    Wife,
    I,
}

interface Family {
    String getName();
}

class Humanking implements Family {

    private String getname;

    public String getName() {
        return getname;
    }
    public Humanking(String getname) {
        this.getname = getname;
    }

    @Override
    public String toString() {
        return getName();
    }
}

class Work {
    public Work(Humanking f1, Relationship re, Humanking f2) {
        this.f1 = f1;
        this.re = re;
        this.f2 = f2;
    }

    Humanking f1;
    Relationship re;
    Humanking f2;

    @Override
    public String toString() {
        return String.format("<%s %s %s>", f1, re, f2);
    }
}

interface FamilyTree3 {
    void append(Humanking Parents, Humanking Children);

    void append1(Humanking Relatives, Humanking I);

    void append2(Humanking RelativesInLaw, Humanking I);

    void append3(Humanking Wife, Humanking I);

    void append4(Humanking Children, Humanking I);

    ArrayList<Work> getData();
}

class GeoTree implements FamilyTree3 {
    private final ArrayList<Work> tree = new ArrayList<>();

    @Override
    public ArrayList<Work> getData() {
        return tree;
    }

    public void append(Humanking Parents, Humanking Children) {
        tree.add(new Work(Parents, Relationship.Parents, Children));
        tree.add(new Work(Children, Relationship.Children, Parents));
    }


    public void append1(Humanking Relatives, Humanking I) {
        tree.add(new Work(Relatives, Relationship.Relatives, I));
    }

    public void append2(Humanking RelativesInLaw, Humanking I) {
        tree.add(new Work(RelativesInLaw, Relationship.RelativesInLaw, I));
    }

    public void append3(Humanking Wife, Humanking I) {
        tree.add(new Work(Wife, Relationship.Wife, I));
    }
    public void append4(Humanking Children, Humanking I) {
        tree.add(new Work(Children, Relationship.Children, I));
    }
}

class Research {
    ArrayList<Work> tree;

    public Research(FamilyTree3 pd) {
        tree = pd.getData();
    }

    public ArrayList<Humanking> spend(Family p, Relationship re) {
        var result = new ArrayList<Humanking>();

        for (Work t : tree) {
            if (t.f1.getName() == p.getName() && t.re == re) {
                result.add(t.f2);
            }
        }
        return result;
    }
}

class Printer {
    //
}

