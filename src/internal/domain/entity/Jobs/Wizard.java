package internal.domain.entity.Jobs;

import internal.domain.entity.Player;
import internal.domain.entity.Magics.Fire;
import internal.domain.entity.Magics.Thunder;
import internal.domain.vo.JobType;

public class Wizard extends Player {
    public Wizard(String name) {
        super(name);
        initStaus(JobType.WIZARD);
        canUseMagic = true;
        magics.add(new Fire());
        magics.add(new Thunder());
    }
}
