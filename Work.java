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