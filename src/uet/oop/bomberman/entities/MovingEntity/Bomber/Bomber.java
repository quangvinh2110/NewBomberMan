package uet.oop.bomberman.entities.MovingEntity.Bomber;

import uet.oop.bomberman.GraphicsRenderer.GameSpriteSheet.GameSpriteSheet2.GameSprite2;

import java.util.ArrayList;

public enum Bomber {

    Bomberman("/NewGame/BombermanImage.png"),
    BomberLady("/NewGame/BombertheKidImage.png"),
    BomberGreat("/NewGame/PrettyBomberImage.png"),
    BomberHammer("/NewGame/PunkBomberImage.png");

    private final String urlCharacter;

    Bomber(String urlCharacter) {

        this.urlCharacter = urlCharacter;
    }

    public String getUrlCharacter() {
        return urlCharacter;
    }

    public ArrayList<GameSprite2> getMovingSprites(Direction direction) {
        ArrayList<GameSprite2> sprites = new ArrayList<>();
        switch (this.ordinal()) {
            case 0:
                switch (direction.ordinal()) {
                    case 0: // front/down
                        sprites.add(GameSprite2.bomberman_front_moving1);
                        sprites.add(GameSprite2.bomberman_front_standing);
                        sprites.add(GameSprite2.bomberman_front_moving2);
                        break;
                    case 1: // back/up
                        sprites.add(GameSprite2.bomberman_back_moving1);
                        sprites.add(GameSprite2.bomberman_back_standing);
                        sprites.add(GameSprite2.bomberman_back_moving2);
                        break;
                    case 2: // left
                        sprites.add(GameSprite2.bomberman_left_moving1);
                        sprites.add(GameSprite2.bomberman_left_standing);
                        sprites.add(GameSprite2.bomberman_left_moving2);
                        break;
                    case 3: // right
                        sprites.add(GameSprite2.bomberman_right_moving1);
                        sprites.add(GameSprite2.bomberman_right_standing);
                        sprites.add(GameSprite2.bomberman_right_moving2);
                        break;
                }
                break;
            case 1:
                switch (direction.ordinal()) {
                    case 0: // front/down
                        sprites.add(GameSprite2.bomberLady_front_moving1);
                        sprites.add(GameSprite2.bomberLady_front_standing);
                        sprites.add(GameSprite2.bomberLady_front_moving2);
                        break;
                    case 1: // back/up
                        sprites.add(GameSprite2.bomberLady_back_moving1);
                        sprites.add(GameSprite2.bomberLady_back_standing);
                        sprites.add(GameSprite2.bomberLady_back_moving2);
                        break;
                    case 2: // left
                        sprites.add(GameSprite2.bomberLady_left_moving1);
                        sprites.add(GameSprite2.bomberLady_left_standing);
                        sprites.add(GameSprite2.bomberLady_left_moving2);
                        break;
                    case 3: // right
                        sprites.add(GameSprite2.bomberLady_right_moving1);
                        sprites.add(GameSprite2.bomberLady_right_standing);
                        sprites.add(GameSprite2.bomberLady_right_moving2);
                        break;
                }
                break;
            case 2:
                switch (direction.ordinal()) {
                    case 0: // front/down
                        sprites.add(GameSprite2.bomberGreat_front_moving1);
                        sprites.add(GameSprite2.bomberGreat_front_standing);
                        sprites.add(GameSprite2.bomberGreat_front_moving2);
                        break;
                    case 1: // back/up
                        sprites.add(GameSprite2.bomberGreat_back_moving1);
                        sprites.add(GameSprite2.bomberGreat_back_standing);
                        sprites.add(GameSprite2.bomberGreat_back_moving2);
                        break;
                    case 2: // left
                        sprites.add(GameSprite2.bomberGreat_left_moving1);
                        sprites.add(GameSprite2.bomberGreat_left_standing);
                        sprites.add(GameSprite2.bomberGreat_left_moving2);
                        break;
                    case 3: // right
                        sprites.add(GameSprite2.bomberGreat_right_moving1);
                        sprites.add(GameSprite2.bomberGreat_right_standing);
                        sprites.add(GameSprite2.bomberGreat_right_moving2);
                        break;
                }
                break;
            case 3:
                switch (direction.ordinal()) {
                    case 0: // front/down
                        sprites.add(GameSprite2.bomberHammer_front_moving1);
                        sprites.add(GameSprite2.bomberHammer_front_standing);
                        sprites.add(GameSprite2.bomberHammer_front_moving2);
                        break;
                    case 1: // back/up
                        sprites.add(GameSprite2.bomberHammer_back_moving1);
                        sprites.add(GameSprite2.bomberHammer_back_standing);
                        sprites.add(GameSprite2.bomberHammer_back_moving2);
                        break;
                    case 2: // left
                        sprites.add(GameSprite2.bomberHammer_left_moving1);
                        sprites.add(GameSprite2.bomberHammer_left_standing);
                        sprites.add(GameSprite2.bomberHammer_left_moving2);
                        break;
                    case 3: // right
                        sprites.add(GameSprite2.bomberHammer_right_moving1);
                        sprites.add(GameSprite2.bomberHammer_right_standing);
                        sprites.add(GameSprite2.bomberHammer_right_moving2);
                        break;
                }
                break;
        }

        return sprites;
    }

    public ArrayList<GameSprite2> getDeathSprites() {
        ArrayList<GameSprite2> sprites = new ArrayList<>();
        switch (this.ordinal()) {
            case 0:
                sprites.add(GameSprite2.bomberman_death1);
                sprites.add(GameSprite2.bomberman_death2);
                sprites.add(GameSprite2.bomberman_death3);
                sprites.add(GameSprite2.bomberman_death4);
                break;
            case 1:
                sprites.add(GameSprite2.bomberLady_death1);
                sprites.add(GameSprite2.bomberLady_death2);
                sprites.add(GameSprite2.bomberLady_death3);
                sprites.add(GameSprite2.bomberLady_death4);
                break;
            case 2:
                sprites.add(GameSprite2.bomberGreat_death1);
                sprites.add(GameSprite2.bomberGreat_death2);
                sprites.add(GameSprite2.bomberGreat_death3);
                sprites.add(GameSprite2.bomberGreat_death4);
                break;
            case 3:
                sprites.add(GameSprite2.bomberHammer_death1);
                sprites.add(GameSprite2.bomberHammer_death2);
                sprites.add(GameSprite2.bomberHammer_death3);
                sprites.add(GameSprite2.bomberHammer_death4);
                break;
        }

        return sprites;
    }

}
