//package uet.oop.bomberman.entities.character.enemy.ai;
//
//import uet.oop.bomberman.entities.Position;
//import uet.oop.bomberman.entities.character.Bomber.Bomber;
//import uet.oop.bomberman.entities.character.enemy.Enemy;
//
//public class MediumAI extends AI {
//
//
//    public MediumAI(Bomber bomber, Enemy e) {
//        this._bomber = bomber;
//        this._e = e;
//    }
//
//    private double costFunction(Position start, Position end) {
//        // TODO: trả về khoảng cách Manhattan giữa 2 vị trí start và end vì ở đây enemy chỉ có thể di chuyển ngang hoặc dọc
//        return Math.abs(start.getCoordinateX() - end.getCoordinateX()) + Math.abs(start.getCoordinateY() - end.getCoordinateY());
//    }
//
//    @Override
//    public int calculateDirection() {
//        // TODO: cài đặt thuật toán tìm đường đi best first search
////        int bomberX = this._bomber.getXTile();
////        int bomberY = this._bomber.getYTile();
////        int enemyX = this._e.getXTile();
////        int enemyY = this._e.getYTile();
//
//
//        return 0;
//    }
//
//}
