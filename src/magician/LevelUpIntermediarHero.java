package magician;

public class LevelUpIntermediarHero extends magician.Observer {
    @Override
    public String update() {
        return this.hero.getName() +  " " + this.hero.getIndex() + " reached level";
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
