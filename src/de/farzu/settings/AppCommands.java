package de.farzu.settings;
/**
 * Diese Klasse stellt Nutzerauswahlmöglichkeiten als öffentliche Konstanten
 * zur Verfügung. Von dieser Klasse kann kein Objekt erzeugt werden.
 */
public class AppCommands {
//    region Konstanten
    public static final int USER_CMD_SHOW = 1;
    public static final int USER_CMD_CREATE = 2;
    public static final int USER_CMD_EDIT = 3;
    public static final int USER_CMD_DELETE = 4;
    public static final int USER_CMD_GET = 5;
    public static final int USER_CMD_SORT = 6;
    public static final int USER_CMD_EXIT = 0;
//    endregion

//    region Attribute
//    endregion

//    regionKonstruktor
    /**
     * Privater Konstruktor um Objekterzeugung von außen zu verhindern.
     */
    private AppCommands(){

    }
//    endregion

//    regionMethoden
//    endregion

}
