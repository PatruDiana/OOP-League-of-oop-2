package strategies;
import heroes.Hero;
import common.Constants;
public class OffensiveRogueStrategy implements strategies.Strategy {
    /**
     * if the hero choose to play offensive.
     * @param hero - a Rgoue hero.
     */
    public void changecoef(final Hero hero) {
        float life = Constants.ROGUE_LIFE_OFF * hero.getHpCurrent();
        hero.setHpCurrentStrategy(hero.getHpCurrent() - Math.round(life));
        for (int i = 0; i < hero.getAbilities().size(); i++) {
            hero.getAbilities().get(i).setCoefOffensive(Constants.ROGUE_OFF);
        }
    }
}
