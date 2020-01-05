package magician;

public class ActionAngel extends magician.Observer {
    @Override
    public String update() {
        return angel.actionangel(this.hero);
    }

    @Override
    public void addangel(angels.Angel angel) {
        this.angel = angel;
        this.angel.addObservers(this);
    }

    @Override
    public void addhero(heroes.Hero hero) {}
}
