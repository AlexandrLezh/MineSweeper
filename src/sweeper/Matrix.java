package sweeper;

class Matrix {
    Box[][] matrix;

    Matrix(Box box) {
        matrix = new Box[Ranges.getCell().x][Ranges.getCell().y];
        for (Cell cell : Ranges.getAllCells()) {
            matrix[cell.x][cell.y] = box;
        }
    }

    Box get(Cell cell) {
        if (Ranges.inRange(cell)) {
            return matrix[cell.x][cell.y];
        }
        return null;
    }

    void set(Cell cell, Box box) {
        if (Ranges.inRange(cell)) {
            matrix[cell.x][cell.y] = box;
        }
    }
}
