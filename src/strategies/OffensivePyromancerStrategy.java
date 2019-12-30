package strategies;
import heroes.Hero;

public class OffensivePyromancerStrategy implements Strategy {

    @Override
    public void changecoef(Hero hero) {
        float life = 1f/4*hero.getHpCurrent();
        hero.setHpCurrentStrategy(hero.getHpCurrent() - Math.round(life));
        for (int i = 0 ; i < hero.getAbilities().size(); i++) {
            hero.getAbilities().get(i).setCoefOffensive(0.7f);
        }
    }
}
