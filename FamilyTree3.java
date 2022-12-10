import java.util.ArrayList;

interface FamilyTree3 {
    void append(Humanking Parents, Humanking Children);

    void append1(Humanking Relatives, Humanking I);

    void append2(Humanking RelativesInLaw, Humanking I);

    void append3(Humanking Wife, Humanking I);

    void append4(Humanking Children, Humanking I);

    ArrayList<Work> getData();
}