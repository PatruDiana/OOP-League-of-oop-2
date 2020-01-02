package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Dracula extends Angel implements VisitAngel {
    public Dracula(int coodx, int coordy) {
        super(coodx, coordy);
    }

    @Override
    public void visit(Pyromancer p) {
        for(int i = 0; i < p.getAbilities().size(); i++) {
            p.getAbilities().get(i).setCoefDefensive(0.3f);
        }
        p.setHpCurrent(40);
    }

    @Override
    public void visit(Knight k) {
        for(int i = 0; i < k.getAbilities().size(); i++) {
            k.getAbilities().get(i).setCoefDefensive(0.2f);
        }
        k.setHpCurrent(60);
    }

    @Override
    public void visit(Rogue r) {
        for (int i = 0; i < r.getAbilities().size(); i++) {
            r.getAbilities().get(i).setCoefDefensive(0.1f);
        }
        r.setHpCurrent(35);
    }

    @Override
    public void visit(Wizard w) {
        for (int i = 0; i < w.getAbilities().size(); i++) {
            w.getAbilities().get(i).setCoefDefensive(0.4f);
        }
        w.setHpCurrent(20);
    }

    @Override
    public String toString() {
        return "Dracula: " + coodx + ", " + coordy;
    }
    public String getName() {
        return "Dracula";
    }
}
