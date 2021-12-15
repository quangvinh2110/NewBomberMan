package uet.oop.bomberman.Scene.Game;

import uet.oop.bomberman.GraphicsRenderer.GameSpriteSheet.GameSpriteSheet2.GameSprite2;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.FixedEntity.Fragile.TreeRoot;
import uet.oop.bomberman.entities.FixedEntity.Unbreakable.Grass;
import uet.oop.bomberman.entities.FixedEntity.Unbreakable.Home;
import uet.oop.bomberman.entities.FixedEntity.Unbreakable.Wall;

import java.util.ArrayList;
import java.util.Arrays;

public class Map {

    public static final int WIDTH = 31;
    public static final int HEIGHT = 13;

    private final ArrayList<Entity> map;
    private final int[][] encodedMap;
    public static final int TILE_SIZE = GameSprite2.RESIZE_TILE_SIZE*GameSprite2.SCALE_FACTOR;

    public static final int[][] fixedMap = new int[][]{
            {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9},
            {9, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 9},
            {9, 9, 0, 2, 0, 2, 0, 2, 4, 2, 4, 2, 4, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 9, 9},
            {9, 9, 0, 4, 0, 4, 0, 1, 4, 1, 4, 4, 3, 4, 0, 4, 4, 4, 0, 1, 0, 4, 0, 1, 4, 4, 0, 4, 0, 9, 9},
            {9, 9, 0, 2, 0, 2, 4, 2, 4, 2, 4, 2, 0, 2, 0, 2, 4, 2, 0, 2, 0, 2, 0, 2, 3, 2, 0, 2, 0, 9, 9},
            {9, 9, 0, 4, 0, 1, 4, 4, 4, 4, 4, 4, 0, 1, 0, 4, 4, 1, 0, 4, 0, 4, 4, 4, 0, 1, 0, 4, 0, 9, 9},
            {9, 9, 0, 2, 0, 2, 3, 2, 4, 2, 3, 2, 0, 2, 0, 2, 4, 2, 0, 2, 0, 2, 4, 2, 0, 2, 0, 2, 0, 9, 9},
            {9, 9, 0, 1, 0, 1, 4, 4, 3, 4, 0, 4, 0, 4, 0, 1, 4, 4, 0, 4, 0, 1, 4, 1, 0, 1, 0, 1, 0, 9, 9},
            {9, 9, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 4, 2, 0, 2, 0, 2, 3, 2, 0, 2, 0, 2, 0, 9, 9},
            {9, 9, 0, 1, 0, 4, 0, 1, 0, 4, 0, 1, 0, 1, 0, 4, 3, 4, 0, 1, 0, 1, 0, 4, 0, 4, 0, 1, 0, 9, 9},
            {9, 9, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 9, 9},
            {9, 9, 0, 4, 0, 1, 0, 1, 0, 1, 0, 1, 0, 4, 0, 4, 0, 1, 0, 1, 0, 4, 0, 4, 0, 4, 0, 4, 0, 9, 9},
            {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}
    };


    public static int[][] createDynamicMap() {
        return null;
    }



    public Map() {
        this.map = new ArrayList<>();
        encodedMap = Arrays.copyOf(fixedMap, fixedMap.length);
        createMap(encodedMap);
    }

    public Map(int mode){
        this.map = new ArrayList<>();
        if (mode == 1) {
            encodedMap = fixedMap;
        } else {
            encodedMap = createDynamicMap();
        }
        createMap(encodedMap);
    }

    private void createMap(int[][] map) {
        createBoundaryWall();
        for(int i = 1; i < Map.HEIGHT - 1; i++) {
            for (int j = 2; j < Map.WIDTH - 2; j++){
                switch (map[i][j]){
                    case 0:
                        Entity grass = new Grass(j*Map.TILE_SIZE, i* Map.TILE_SIZE, GameSprite2.grass.getImage());
                        this.map.add(grass);
                        break;
                    case 1:
                        Entity grass1 = new Grass(j*Map.TILE_SIZE, i*Map.TILE_SIZE, GameSprite2.grassBelowHome.getImage());
                        this.map.add(grass1);
                        break;
                    case 2:
                        Entity home = new Home(j*Map.TILE_SIZE, i*Map.TILE_SIZE, GameSprite2.home.getImage());
                        this.map.add(home);
                        break;
                    case 3:
                        Entity grass2 = new Grass(j*Map.TILE_SIZE, i*Map.TILE_SIZE,GameSprite2.grassBelowTreeRoot.getImage());
                        this.map.add(grass2);
                        break;
                    case 4:
                        Entity treeRoot = new TreeRoot(j*Map.TILE_SIZE, i*Map.TILE_SIZE, GameSprite2.treeRoot.getImage());
                        this.map.add(treeRoot);
                        break;
                }

            }
        }
    }

    private void createBoundaryWall() {
        // create top left corner
        Entity top_left_corner1 = new Wall(0, 0, GameSprite2.top_corner_wall1.getImage());
        map.add(top_left_corner1);
        Entity top_left_corner2 = new Wall(0, Map.TILE_SIZE, GameSprite2.side_wall2.getImage());
        map.add(top_left_corner2);
        Entity top_left_corner3 = new Wall(Map.TILE_SIZE, 0, GameSprite2.top_corner_wall2.getImage());
        map.add(top_left_corner3);
        Entity top_left_corner4 = new Wall(Map.TILE_SIZE, Map.TILE_SIZE, GameSprite2.top_corner_wall3.getImage());
        map.add(top_left_corner4);

        // create top right corner
        Entity top_right_corner1 = new Wall(Map.WIDTH* Map.TILE_SIZE, 0, GameSprite2.top_corner_wall1.getImage(), true);
        map.add(top_right_corner1);
        Entity top_right_corner2 = new Wall(Map.WIDTH* Map.TILE_SIZE, Map.TILE_SIZE, GameSprite2.side_wall2.getImage(), true);
        map.add(top_right_corner2);
        Entity top_right_corner3 = new Wall((Map.WIDTH - 1)* Map.TILE_SIZE, 0, GameSprite2.top_corner_wall2.getImage(), true);
        map.add(top_right_corner3);
        Entity top_right_corner4 = new Wall((Map.WIDTH - 1)* Map.TILE_SIZE, Map.TILE_SIZE, GameSprite2.top_corner_wall3.getImage(), true);
        map.add(top_right_corner4);

        // create bottom left corner
        Entity bottom_left_corner1 = new Wall(0, (Map.HEIGHT - 2)* Map.TILE_SIZE, GameSprite2.bottom_corner_wall1.getImage());
        map.add(bottom_left_corner1);
        Entity bottom_left_corner2 = new Wall(0, (Map.HEIGHT - 1)* Map.TILE_SIZE, GameSprite2.bottom_corner_wall2.getImage());
        map.add(bottom_left_corner2);
        Entity bottom_left_corner3 = new Wall(Map.TILE_SIZE, (Map.HEIGHT - 2)* Map.TILE_SIZE, GameSprite2.bottom_corner_wall3.getImage());
        map.add(bottom_left_corner3);
        Entity bottom_left_corner4 = new Wall(Map.TILE_SIZE, (Map.HEIGHT - 1)* Map.TILE_SIZE, GameSprite2.bottom_corner_wall4.getImage());
        map.add(bottom_left_corner4);

        // create bottom right corner
        Entity bottom_right_corner1 = new Wall(Map.WIDTH* Map.TILE_SIZE, (Map.HEIGHT - 2)* Map.TILE_SIZE, GameSprite2.bottom_corner_wall1.getImage(), true);
        map.add(bottom_right_corner1);
        Entity bottom_right_corner2 = new Wall(Map.WIDTH* Map.TILE_SIZE, (Map.HEIGHT - 1)* Map.TILE_SIZE, GameSprite2.bottom_corner_wall2.getImage(), true);
        map.add(bottom_right_corner2);
        Entity bottom_right_corner3 = new Wall((Map.WIDTH - 1)* Map.TILE_SIZE, (Map.HEIGHT - 2)* Map.TILE_SIZE, GameSprite2.bottom_corner_wall3.getImage(), true);
        map.add(bottom_right_corner3);
        Entity bottom_right_corner4 = new Wall((Map.WIDTH - 1)* Map.TILE_SIZE, (Map.HEIGHT - 1)* Map.TILE_SIZE, GameSprite2.bottom_corner_wall4.getImage(), true);
        map.add(bottom_right_corner4);

        // create side wall
        for (int i = 2; i < Map.HEIGHT - 2; i++) {
            Entity left_side_wall1 = new Wall(Map.TILE_SIZE, i* Map.TILE_SIZE, GameSprite2.side_wall1.getImage());
            Entity left_side_wall2 = new Wall(0, i* Map.TILE_SIZE, GameSprite2.side_wall2.getImage());
            Entity right_side_wall1 = new Wall((Map.WIDTH - 1)* Map.TILE_SIZE, i* Map.TILE_SIZE, GameSprite2.side_wall1.getImage(), true);
            Entity right_side_wall2 = new Wall(Map.WIDTH* Map.TILE_SIZE, i* Map.TILE_SIZE, GameSprite2.side_wall2.getImage(), true);
            map.add(left_side_wall1);
            map.add(left_side_wall2);
            map.add(right_side_wall1);
            map.add(right_side_wall2);
        }

        // create top and bottom wall
        for (int i = 2; i < Map.WIDTH - 2; i++) {
            Entity top_wall = new Wall(i* Map.TILE_SIZE, 0, GameSprite2.top_edge_wall.getImage());
            Entity bottom_wall = new Wall(i* Map.TILE_SIZE, (Map.HEIGHT - 1)* Map.TILE_SIZE, GameSprite2.bottom_edge_wall.getImage());
            map.add(top_wall);
            map.add(bottom_wall);
        }
    }

    public ArrayList<Entity> getMap() {
        return map;
    }


    public boolean haveEntityAtGridLocation(int x, int y) {
        if (y > Map.HEIGHT - 1 || y < 0 || x > Map.WIDTH - 1 || x < 0) {
            return false;
        }
        System.out.println("Position encodeMap[" + y + "][" + x +"]: " + this.encodedMap[y][x]);
        return this.encodedMap[y][x] != 0 && this.encodedMap[y][x] != 1 && this.encodedMap[y][x] != 3;
    }


}
