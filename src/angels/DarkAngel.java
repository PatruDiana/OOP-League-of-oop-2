package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class DarkAngel extends Angel implements VisitAngel {
    public DarkAngel(int coodx, int coordy) {
        super(coodx, coordy);
    }

    @Override
    public void visit(Pyromancer p) {
        p.setHpCurrent(30);
    }

    @Override
    public void visit(Knight k) {
        k.setHpCurrent(40);
    }

    @Override
    public void visit(Rogue r) {
        r.setHpCurrent(10);
    }

    @Override
    public void visit(Wizard w) {
        w.setHpCurrent(20);
    }

    @Override
    public String toString() {
        return "DarkAngel: " + coodx + ", " + coordy;
    }
    public String getName() {
        return "DarkAngel";
    }
}
