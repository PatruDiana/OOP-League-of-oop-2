package strategies;

import heroes.Hero;

public class DefensiveRogueStrategy implements Strategy {
    @Override
    public void changecoef(Hero hero) {
        for(int i = 0; i < hero.getAbilities().size(); i++) {
            hero.getAbilities().get(i).setCoefDefensive(0.1f);
        }
        float life = 1f/2 * hero.getHpCurrent();
        hero.setHpCurrentStrategy(hero.getHpCurrent() + Math.round(life));
    }
}
