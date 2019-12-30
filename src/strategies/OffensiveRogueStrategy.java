package strategies;
import heroes.Hero;

public class OffensiveRogueStrategy implements strategies.Strategy {

    @Override
    public void changecoef(heroes.Hero hero) {
        float life = 1f/7 * hero.getHpCurrent();
        hero.setHpCurrentStrategy(hero.getHpCurrent() - Math.round(life));
        for (int i = 0; i < hero.getAbilities().size(); i++) {
            hero.getAbilities().get(i).setCoefOffensive(0.4f);
        }
    }
}
