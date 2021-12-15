package uet.oop.bomberman.Scene.Game.Map;

import uet.oop.bomberman.GraphicsRenderer.GameSpriteSheet.GameSpriteSheet2.GameSprite2;
import uet.oop.bomberman.entities.Bomb.Bomb;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.FixedEntity.Fragile.TreeRoot;
import uet.oop.bomberman.entities.FixedEntity.Indestructible.Grass;
import uet.oop.bomberman.entities.FixedEntity.Indestructible.Home;
import uet.oop.bomberman.entities.FixedEntity.Indestructible.Wall;

import java.util.ArrayList;
import java.util.Arrays;

import static uet.oop.bomberman.Scene.Game.Map.Map.fixedMap;

public class MapManager {



    private final ArrayList<Entity> fixedEntityInMap;
    private final ArrayList<Entity> dynamicEntityInMap;
    private final ArrayList<Bomb> bombs;
    private int[][] encodedMap;


    public MapManager() {
        this.fixedEntityInMap = new ArrayList<>();
        this.dynamicEntityInMap = new ArrayList<>();
        this.bombs = new ArrayList<>();
        encodedMap = Arrays.copyOf(fixedMap, fixedMap.length);
        createMap(encodedMap);
    }


    private void createMap(int[][] map) {
        createBoundaryWall();
        for(int i = 1; i < Map.HEIGHT - 1; i++) {
            for (int j = 2; j < Map.WIDTH - 2; j++){
                if (map[i][j] == GridObject.Grass.ordinal()) {
                    Entity grass = new Grass(j* Map.TILE_SIZE, i* Map.TILE_SIZE, GameSprite2.grass.getImage());
                    this.fixedEntityInMap.add(grass);
                } else if (map[i][j] == GridObject.GrassBelowHome.ordinal()) {
                    Entity grass = new Grass(j* Map.TILE_SIZE, i* Map.TILE_SIZE, GameSprite2.grassBelowHome.getImage());
                    this.fixedEntityInMap.add(grass);
                } else if (map[i][j] == GridObject.Home.ordinal()) {
                    Entity home = new Home(j* Map.TILE_SIZE, i* Map.TILE_SIZE, GameSprite2.home.getImage());
                    this.fixedEntityInMap.add(home);
                } else if (map[i][j] == GridObject.GrassBelowTreeRoot.ordinal()) {
                    Entity grass = new Grass(j* Map.TILE_SIZE, i* Map.TILE_SIZE,GameSprite2.grassBelowTreeRoot.getImage());
                    this.dynamicEntityInMap.add(grass);
                } else if (map[i][j] == GridObject.TreeRoot.ordinal()) {
                    Entity treeRoot = new TreeRoot(j* Map.TILE_SIZE, i* Map.TILE_SIZE, GameSprite2.treeRoot.getImage());
                    this.dynamicEntityInMap.add(treeRoot);
                }
            }
        }
    }

    private void createBoundaryWall() {
        // create top left corner
        Entity top_left_corner1 = new Wall(0, 0, GameSprite2.top_corner_wall1.getImage());
        fixedEntityInMap.add(top_left_corner1);
        Entity top_left_corner2 = new Wall(0, Map.TILE_SIZE, GameSprite2.side_wall2.getImage());
        fixedEntityInMap.add(top_left_corner2);
        Entity top_left_corner3 = new Wall(Map.TILE_SIZE, 0, GameSprite2.top_corner_wall2.getImage());
        fixedEntityInMap.add(top_left_corner3);
        Entity top_left_corner4 = new Wall(Map.TILE_SIZE, Map.TILE_SIZE, GameSprite2.top_corner_wall3.getImage());
        fixedEntityInMap.add(top_left_corner4);

        // create top right corner
        Entity top_right_corner1 = new Wall(Map.WIDTH* Map.TILE_SIZE, 0, GameSprite2.top_corner_wall1.getImage(), true);
        fixedEntityInMap.add(top_right_corner1);
        Entity top_right_corner2 = new Wall(Map.WIDTH* Map.TILE_SIZE, Map.TILE_SIZE, GameSprite2.side_wall2.getImage(), true);
        fixedEntityInMap.add(top_right_corner2);
        Entity top_right_corner3 = new Wall((Map.WIDTH - 1)* Map.TILE_SIZE, 0, GameSprite2.top_corner_wall2.getImage(), true);
        fixedEntityInMap.add(top_right_corner3);
        Entity top_right_corner4 = new Wall((Map.WIDTH - 1)* Map.TILE_SIZE, Map.TILE_SIZE, GameSprite2.top_corner_wall3.getImage(), true);
        fixedEntityInMap.add(top_right_corner4);

        // create bottom left corner
        Entity bottom_left_corner1 = new Wall(0, (Map.HEIGHT - 2)* Map.TILE_SIZE, GameSprite2.bottom_corner_wall1.getImage());
        fixedEntityInMap.add(bottom_left_corner1);
        Entity bottom_left_corner2 = new Wall(0, (Map.HEIGHT - 1)* Map.TILE_SIZE, GameSprite2.bottom_corner_wall2.getImage());
        fixedEntityInMap.add(bottom_left_corner2);
        Entity bottom_left_corner3 = new Wall(Map.TILE_SIZE, (Map.HEIGHT - 2)* Map.TILE_SIZE, GameSprite2.bottom_corner_wall3.getImage());
        fixedEntityInMap.add(bottom_left_corner3);
        Entity bottom_left_corner4 = new Wall(Map.TILE_SIZE, (Map.HEIGHT - 1)* Map.TILE_SIZE, GameSprite2.bottom_corner_wall4.getImage());
        fixedEntityInMap.add(bottom_left_corner4);

        // create bottom right corner
        Entity bottom_right_corner1 = new Wall(Map.WIDTH* Map.TILE_SIZE, (Map.HEIGHT - 2)* Map.TILE_SIZE, GameSprite2.bottom_corner_wall1.getImage(), true);
        fixedEntityInMap.add(bottom_right_corner1);
        Entity bottom_right_corner2 = new Wall(Map.WIDTH* Map.TILE_SIZE, (Map.HEIGHT - 1)* Map.TILE_SIZE, GameSprite2.bottom_corner_wall2.getImage(), true);
        fixedEntityInMap.add(bottom_right_corner2);
        Entity bottom_right_corner3 = new Wall((Map.WIDTH - 1)* Map.TILE_SIZE, (Map.HEIGHT - 2)* Map.TILE_SIZE, GameSprite2.bottom_corner_wall3.getImage(), true);
        fixedEntityInMap.add(bottom_right_corner3);
        Entity bottom_right_corner4 = new Wall((Map.WIDTH - 1)* Map.TILE_SIZE, (Map.HEIGHT - 1)* Map.TILE_SIZE, GameSprite2.bottom_corner_wall4.getImage(), true);
        fixedEntityInMap.add(bottom_right_corner4);

        // create side wall
        for (int i = 2; i < Map.HEIGHT - 2; i++) {
            Entity left_side_wall1 = new Wall(Map.TILE_SIZE, i* Map.TILE_SIZE, GameSprite2.side_wall1.getImage());
            Entity left_side_wall2 = new Wall(0, i* Map.TILE_SIZE, GameSprite2.side_wall2.getImage());
            Entity right_side_wall1 = new Wall((Map.WIDTH - 1)* Map.TILE_SIZE, i* Map.TILE_SIZE, GameSprite2.side_wall1.getImage(), true);
            Entity right_side_wall2 = new Wall(Map.WIDTH* Map.TILE_SIZE, i* Map.TILE_SIZE, GameSprite2.side_wall2.getImage(), true);
            fixedEntityInMap.add(left_side_wall1);
            fixedEntityInMap.add(left_side_wall2);
            fixedEntityInMap.add(right_side_wall1);
            fixedEntityInMap.add(right_side_wall2);
        }

        // create top and bottom wall
        for (int i = 2; i < Map.WIDTH - 2; i++) {
            Entity top_wall = new Wall(i* Map.TILE_SIZE, 0, GameSprite2.top_edge_wall.getImage());
            Entity bottom_wall = new Wall(i* Map.TILE_SIZE, (Map.HEIGHT - 1)* Map.TILE_SIZE, GameSprite2.bottom_edge_wall.getImage());
            fixedEntityInMap.add(top_wall);
            fixedEntityInMap.add(bottom_wall);
        }
    }

    public ArrayList<Entity> getFixedEntityInMap() {
        return fixedEntityInMap;
    }

    public ArrayList<Entity> getDynamicEntityInMap() {
        return dynamicEntityInMap;
    }

    public ArrayList<Bomb> getBombs() {
        return bombs;
    }

    public boolean haveFixedEntityAtGridLocation(int gridX, int gridY) {
        if (gridY > Map.HEIGHT - 1 || gridY < 0 || gridX > Map.WIDTH - 1 || gridX < 0) {
            return false;
        }
        System.out.println("Position encodeMap[" + gridY + "][" + gridX +"]: " + this.encodedMap[gridY][gridX]);
        return this.encodedMap[gridY][gridX] != GridObject.Grass.ordinal()
                && this.encodedMap[gridY][gridX] != GridObject.GrassBelowHome.ordinal()
                && this.encodedMap[gridY][gridX] != GridObject.GrassBelowTreeRoot.ordinal()
                && this.encodedMap[gridY][gridX] != GridObject.Bomb.ordinal();
    }

    public boolean freeToPutBomb(int gridX, int gridY) {
        if (gridY > Map.HEIGHT - 1 || gridY < 0 || gridX > Map.WIDTH - 1 || gridX < 0) {
            return false;
        }
        System.out.println("Position encodeMap[" + gridY + "][" + gridX +"]: " + this.encodedMap[gridY][gridX]);
        return this.encodedMap[gridY][gridX] == GridObject.Grass.ordinal()
                || this.encodedMap[gridY][gridX] == GridObject.GrassBelowHome.ordinal()
                || this.encodedMap[gridY][gridX] == GridObject.GrassBelowTreeRoot.ordinal();
    }

    public void removeEntityAtGridLocation(int gridX, int gridY) {
        if(encodedMap[gridY][gridX] == GridObject.Bomb.ordinal()
                || encodedMap[gridY][gridX] == GridObject.TreeRoot.ordinal()
                || encodedMap[gridY][gridX] == GridObject.Item.ordinal()) {
            for (Entity entity : dynamicEntityInMap) {
                if (entity.getX() / Map.TILE_SIZE == gridX && entity.getY() / Map.TILE_SIZE == gridY) {
                    dynamicEntityInMap.remove(entity);
                    break;
                }
            }
            updateAfterRemoveAtGridLocation(gridX, gridY);
            updateAfterRemoveAtGridLocation(gridX, gridY - 1);
        }

    }


    private void updateAfterRemoveAtGridLocation(int gridX, int gridY) {
        if(encodedMap[gridY - 1][gridX] == GridObject.Home.ordinal()) {
            encodedMap[gridY][gridX] = GridObject.GrassBelowHome.ordinal();
            Grass grass = new Grass(gridX*Map.TILE_SIZE, gridY*Map.TILE_SIZE, GameSprite2.grassBelowHome.getImage());
            fixedEntityInMap.add(grass);
        } else if(encodedMap[gridY - 1][gridX] == GridObject.TreeRoot.ordinal()) {
            encodedMap[gridY][gridX] = GridObject.GrassBelowTreeRoot.ordinal();
            Grass grass = new Grass(gridX*Map.TILE_SIZE, gridY*Map.TILE_SIZE, GameSprite2.grassBelowTreeRoot.getImage());
            fixedEntityInMap.add(grass);
        } else {
            encodedMap[gridY][gridX] = GridObject.Grass.ordinal();
            Grass grass = new Grass(gridX*Map.TILE_SIZE, gridY*Map.TILE_SIZE, GameSprite2.grass.getImage());
            fixedEntityInMap.add(grass);
        }
    }

    public void putBombAtGridLocation(Bomb bomb, int gridX, int gridY) {
        if (freeToPutBomb(gridX, gridY)) {
            encodedMap[gridY][gridX] = GridObject.Bomb.ordinal();
            bombs.add(bomb);
        }
        System.out.println(freeToPutBomb(gridX, gridY));
        System.out.println(encodedMap[gridY][gridX]);
    }

    public void receiveBomb(Bomb bomb) {
        System.out.println("(GridX, GridY): (" + bomb.getX()/Map.TILE_SIZE + ", " + bomb.getY()/Map.TILE_SIZE + ")");
        putBombAtGridLocation(bomb, bomb.getX()/Map.TILE_SIZE, bomb.getY()/Map.TILE_SIZE);
    }



}
