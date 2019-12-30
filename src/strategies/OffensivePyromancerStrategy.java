package strategies;
import heroes.Hero;

public class OffensivePyromancerStrategy implements Strategy {

    @Override
    public void changecoef(Hero hero) {
        float life = hero.getHpCurrent() - 1f/4*hero.getHpCurrent();
        hero.setHpCurrent(Math.round(life));
    }
}
