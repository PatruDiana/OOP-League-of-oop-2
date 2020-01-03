package magician;

public class AppearAngel extends magician.Observer {
    @Override
    public String update() {
        return "Angel " + angel.getName() + " was spawned at " + angel.getCoodx() + " " + angel.getCoordy();
    }

    @Override
    public void addangel(angels.Angel angel) {
        this.angel = angel;
        this.angel.addObservers(this);
    }

    @Override
    public void addhero(heroes.Hero hero) {

    }
}
