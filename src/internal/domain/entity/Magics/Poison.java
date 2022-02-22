package internal.domain.entity.Magics;

import internal.domain.entity.Magic;
import internal.domain.implement.IPlayer;
import internal.domain.vo.AilmentType;
import internal.domain.vo.MagicType;
import internal.presentation.Messages;

public class Poison extends Magic {
    private static final String MAGIC_NAME = "ポイズン";
    private static final int NEED_MP = 10;

    public Poison() {
        super();
        initMagic(MAGIC_NAME, MagicType.AILMENT, NEED_MP);
    }

    @Override
    public void giveEffect(IPlayer user, IPlayer target) {
        user.removeMagicPoint(needMagicPoint);
        target.setAilment(AilmentType.POISON);
        Messages.showFormattedMessage(Messages.USE_MAGIC, needMagicPoint, MAGIC_NAME);
        Messages.showFormattedMessage(Messages.GIVE_AILMENT, target.getName(), MAGIC_NAME);
    }
}
