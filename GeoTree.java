import java.util.ArrayList;
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