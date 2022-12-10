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
        class NEWParents extends Research{
            public NEWParents(FamilyTree3 pd) {

                super(pd);
            }

            @Override
            public ArrayList<Humanking> spend(Family p, Relationship re) {
                var result = new ArrayList<Humanking>();
                for (Family person:SearchWorkOfTree(p, Relationship.Parents))
                {
                    result.addAll(SearchWorkOfTree(person, Relationship.Parents));
                }
                return result;
            }
        }


//        System.out.println(new Research(gt).spend(George, Relationship.Wife));
        System.out.println(" Relationship" + new NEWParents(gt).spend(Vera));
//        System.out.println(new Research(gt).spend(George, Relationship.Relatives));
//        System.out.println(new Research(gt).spend(George, Relationship.RelativesInLaw));
//        System.out.println(new Research(gt).spend(George, Relationship.Children));
    }
}
