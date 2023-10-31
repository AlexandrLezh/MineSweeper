package sweeper;

class Matrix {
    private final Box[][] matrix;

    Matrix(Box box) {
        matrix = new Box[FieldOfGame.getSize().x][FieldOfGame.getSize().y];
        for (Cell cell : FieldOfGame.getAllCells()) {
            matrix[cell.x][cell.y] = box;
        }
    }

    Box get(Cell cell) {
        if (FieldOfGame.inRange(cell)) {
            return matrix[cell.x][cell.y];
        }
        return null;
    }

    void set(Cell cell, Box box) {
        if (FieldOfGame.inRange(cell)) {
            matrix[cell.x][cell.y] = box;
        }
    }
}
