package strategies;

import heroes.Hero;
import common.Constants;

public class DefensiveKnightStrategy implements Strategy {
    /**
     * if the hero choose to play defensive.
     * @param hero - Knight hero.
     */
    public void changecoef(final Hero hero) {
        for (int i = 0; i < hero.getAbilities().size(); i++) {
            hero.getAbilities().get(i).setCoefDefensive(Constants.KNIGHT_DEF);
        }
        float life = Constants.KNIGHT_LIFE_DEF * hero.getHpCurrent();
        hero.setHpCurrentStrategy(hero.getHpCurrent() + Math.round(life));
    }
}
