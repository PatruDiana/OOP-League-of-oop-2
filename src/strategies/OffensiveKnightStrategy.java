package strategies;
import heroes.Hero;

public class OffensiveKnightStrategy implements strategies.Strategy {
    @Override
    public void changecoef(Hero hero) {
        float life = hero.getHpCurrent() * 1f/5;
        hero.setHpCurrentStrategy(hero.getHpCurrent() - Math.round(life));
        for (int i = 0; i < hero.getAbilities().size(); i++) {
            hero.getAbilities().get(i).setCoefOffensive(0.5f);
        }
    }
}
