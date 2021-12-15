package uet.oop.bomberman.Setup;

/**
 * This class contains all the strings displayed in the game.
 */

public class Strings {

    public static final String WindowTitle = AppInfo.AppName;

    public static class Error {
        public static final String FatalError = "Fatal Error!";

        public static final String GfxNotFound = "Graphics not found or invalid!";
        public static final String FontNotFound = "Font not found or invalid!";
        public static final String AudioNotFound = "Audio not found or invalid!";
        public static final String InfoNotFound = "Info not found or invalid!";

    }

    public static class Game {
        public static final String HurryUp = "Hurry Up!";
        public static final String ScoreBoard = "Score Board";
        public static final String GameOver = "Game Over!";
    }

    public static class MainMenu {
        public static final String NewGame = "New Game";
        public static final String HowToPlay = "How to Play";
        public static final String Credit = "Credit";
        public static final String Exit = "Exit";

        public static final String Back = "Back";   // not used here but convenient to place it here
    }

    public static class NewGame {
        public static final String COMvsCOM = "COM vs COM";
        public static final String HUMANvsCOM = "HUMAN vs COM";

        public static final String Play = "Play";                   // not used here but convenient to place it here
        public static final String PleaseWait = "Please Wait...";   // not used here but convenient to place it here
    }


    public static class PlayMode {
        public static final String BOMBERvsBOMBER = "BOMBER vs BOMBER";
        public static final String BOMBERvsENEMIES = "BOMBER vs ENEMIES";
    }


}
