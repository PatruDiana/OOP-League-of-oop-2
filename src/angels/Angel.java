package angels;

public abstract  class Angel implements VisitAngel{
    protected int coodx;
    protected int coordy;

    public Angel(int coodx, int coordy) {
        this.coodx = coodx;
        this.coordy = coordy;
    }

    public int getCoodx() {
        return coodx;
    }

    public int getCoordy() {
        return coordy;
    }
    public abstract String getName();
}
