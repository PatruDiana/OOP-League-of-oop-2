package angels;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class LevelUpAngel extends Angel implements VisitAngel {
    public LevelUpAngel(int coodx, int coordy) {
        super(coodx, coordy);
    }

    @Override
    public void visit(Pyromancer p) {
        for (int i = 0 ; i < p.getAbilities().size(); i++) {
            p.getAbilities().get(i).setCoefOffensive(0.2f);
        }
        int levelup = p.getLevel();
       // System.out.println("Levelup -> " + levelup);
        int XpLevelUp = Constants.XP_MIN_LEVEL + levelup* Constants.XP_UPDATE_LEVEL;
       // System.out.println("XpLevelUp -> " + XpLevelUp);
        p.increaseXp(XpLevelUp - p.getXp());
    }

    @Override
    public void visit(Knight k) {
        for(int i = 0; i < k.getAbilities().size(); i++) {
            k.getAbilities().get(i).setCoefOffensive(0.1f);
        }
        int levelup = k.getLevel();
        int XpLevelUp = Constants.XP_MIN_LEVEL + levelup* Constants.XP_UPDATE_LEVEL;
        k.increaseXp(XpLevelUp - k.getXp());
    }

    @Override
    public void visit(Rogue r) {
        for (int i = 0; i < r.getAbilities().size(); i++) {
            r.getAbilities().get(i).setCoefOffensive(0.15f);
        }
        int levelup = r.getLevel();
        int XpLevelUp = Constants.XP_MIN_LEVEL + levelup* Constants.XP_UPDATE_LEVEL;
        r.increaseXp(XpLevelUp - r.getXp());
    }

    @Override
    public void visit(Wizard w) {
        for (int i = 0; i < w.getAbilities().size(); i++) {
            w.getAbilities().get(i).setCoefOffensive(0.25f);
        }
        int levelup = w.getLevel();
        int XpLevelUp = Constants.XP_MIN_LEVEL + levelup* Constants.XP_UPDATE_LEVEL;
        w.increaseXp(XpLevelUp - w.getXp());
    }

    @Override
    public String toString() {
        return "LevelUpAngel: " + coodx + ", " + coordy;
    }
    public String getName() {
        return "LevelUpAngel";
    }
}
