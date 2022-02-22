package internal.domain.entity.Magics;

import internal.domain.entity.Magic;
import internal.domain.implement.IPlayer;
import internal.domain.vo.MagicType;
import internal.presentation.Messages;

public class Heal extends Magic {
    private static final String MAGIC_NAME = "ヒール";
    private static final int NEED_MP = 20;
    private static final int HEAL_HP = 50;

    public Heal() {
        super();
        initMagic(MAGIC_NAME, MagicType.HEAL, NEED_MP);
    }

    @Override
    public void giveEffect(IPlayer user, IPlayer target) {
        user.removeMagicPoint(needMagicPoint);
        target.addHitPoint(HEAL_HP);
        Messages.showFormattedMessage(Messages.USE_MAGIC, needMagicPoint, MAGIC_NAME);
        Messages.showFormattedMessage(Messages.HEAL, target.getName(), HEAL_HP);
    }
}
