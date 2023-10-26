package sweeper;

import java.awt.*;

public enum Box {
    ZERO,
    BOMB,
    NUM1,
    NUM2,
    NUM3,
    NUM4,
    NUM5,
    NUM6,
    NUM7,
    NUM8,

    OPENED,
    CLOSED,
    NOBOMB,
    BOMBED,
    FLAGGED;

    public Image image;
}
