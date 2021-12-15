package uet.oop.bomberman.Setup;

public class FilePath {

    public static class GraphicsFilePath {
        public static class GameSpriteSheet {
            public static final String SpriteSheet1 = "/Gfx/classic.png";
            public static final String SpriteSheet2 = "/Gfx/Gfx.png";
            public static final String Bomberman = "/SuperBomberMan/Bomberman.png";
            public static final String BomberLady = "/SuperBomberMan/BomberLady.png";
            public static final String BomberGreat = "/SuperBomberMan/BomberGreat.png";
            public static final String BomberHammer = "/SuperBomberMan/BomberHammer.png";
            public static final String Background = "/SuperBomberMan/background.png";
            public static final String Background1 = "/SuperBomberMan/background1.png";
        }

        public static class UISpriteSheet {

        }
    }

    public static class FontFilePath {
        public static String Font1 = "/Font/kenvector_future.ttf";
    }

    public static class SoundFilePath {

        public static final String MenuMusic = "/Sfx/MenuMusic.mp3";
        public static class InGame {
            public static final String GameMusic = "/Sfx/GameMusic.mp3";

            public static final String ReadyGoSound = "/Sfx/ReadyGo.mp3";

            public static final String WalkingSound = "/Sfx/Walking.mp3";

            public static final String CreateBombSound = "/Sfx/CreateBomb.mp3";
            public static final String ExplosionSound = "/Sfx/Explosion.mp3";

            public static final String DyingSound = "/Sfx/Dying.mp3";

            public static final String HurryUpWarning = "/Sfx/HurryUpWarning.mp3";
            public static final String HurryUpMusic = "/Sfx/HurryUpMusic.mp3";

            public static final String ResultFoundSound = "/Sfx/ResultFound.mp3";
            public static final String WinnerMusic = "/Sfx/Winner.mp3";
            public static final String DrawGameMusic = "/Sfx/DrawGame.mp3";

            public static final String ChampionMusic = "/Sfx/Champion.mp3";
        }
    }

    public static class InfoFilePath {

        public static final String CreditInfo = "/Info/Credit.txt";
        public static final String HowToPlayInfo = "/Info/HowToPlay.txt";
    }

}
