package magician;

public class DieHerobyAngel extends magician.Observer {
    @Override
    public String update() {
        return "Player " + this.hero.getName() + " "+ this.hero.getIndex() + " was killed by an angel";
    }

    @Override
    public void addangel(angels.Angel angel) {

    }

    @Override
    public void addhero(heroes.Hero hero) {
        this.hero = hero;
        this.hero.addObservers(this);
    }
}
