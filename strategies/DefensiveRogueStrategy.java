package strategies;

import heroes.Hero;
import common.Constants;
public class DefensiveRogueStrategy implements Strategy {
    /**
     * if the hero choose to play defensive.
     * @param hero - a Rogue hero.
     */
    public void changecoef(final Hero hero) {
        for (int i = 0; i < hero.getAbilities().size(); i++) {
            hero.getAbilities().get(i).setCoefDefensive(Constants.ROGUE_DEF);
        }
        float life = Constants.ROGUE_LIFE_DEF * hero.getHpCurrent();
        hero.setHpCurrentStrategy(hero.getHpCurrent() + Math.round(life));
    }
}
