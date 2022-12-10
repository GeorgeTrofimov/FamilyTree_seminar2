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