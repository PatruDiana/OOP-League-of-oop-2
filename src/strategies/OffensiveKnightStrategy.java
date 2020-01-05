package strategies;
import heroes.Hero;
import common.Constants;
public class OffensiveKnightStrategy implements strategies.Strategy {
    /**
     * if the hero choose to play offensive.
     * @param hero - a Knight hero.
     */
    public void changecoef(final Hero hero) {
        float life = hero.getHpCurrent() * Constants.KNIGHT_LIFE_OFF;
        hero.setHpCurrentStrategy(hero.getHpCurrent() - Math.round(life));
        for (int i = 0; i < hero.getAbilities().size(); i++) {
            hero.getAbilities().get(i).setCoefOffensive(Constants.KNIGHT_OFF);
        }
    }
}
