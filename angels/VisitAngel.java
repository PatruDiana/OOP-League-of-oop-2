package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public interface VisitAngel {
    void visit(Pyromancer p);
    void visit(Knight k);
    void visit(Rogue r);
    void visit(Wizard w);
}
