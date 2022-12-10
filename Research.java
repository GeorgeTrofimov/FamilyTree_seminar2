import java.util.ArrayList;

abstract class Research {
    ArrayList<Work> tree;

    public Research(FamilyTree3 pd) {
        tree = pd.getData();
    }

    protected ArrayList<Humanking> SearchWorkOfTree(Family p, Relationship re, String gender) {
        var result = new ArrayList<Humanking>();
        for (Work t : tree) {
            if (gender.equals("")) {
                if (t.f1.getName().equals(p.getName())
                        && t.re == re) {
                    result.add(t.f2);
                }
            } else {
                if (t.f1.getName().equals(p.getName())
                        && t.re == re
                        && t.f2.getName().equals(gender)) {
                    result.add(t.f2);
                }
            }
        }
        return result;
    }

    protected ArrayList<Humanking> SearchWorkOfTree(Family p, Relationship re) {
        return this.SearchWorkOfTree(p,re,"");
    }
    ArrayList<Humanking> spend(Family p){
        return null;
    };

    public abstract ArrayList<Humanking> spend(Family p, Relationship re);
}