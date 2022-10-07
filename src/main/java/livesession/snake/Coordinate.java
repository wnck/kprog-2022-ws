package livesession.snake;

public class Coordinate {
  private static final org.slf4j.Logger logger =
      org.slf4j.LoggerFactory.getLogger(Coordinate.class);
  private int row;
  private int column;

  public Coordinate(final int row, final int column) {
    this.row = row;
    this.column = column;
  }

  public int getRow() {
    return row;
  }

  public int getColumn() {
    return column;
  }

  public Coordinate getNeighbor(Direction direction) {
    switch (direction) {
      case EAST:
        return new Coordinate(row, column + 1);
      case WEST:
        return new Coordinate(row, column - 1);
      case NORTH:
        return new Coordinate(row - 1, column);
      case SOUTH:
        return new Coordinate(row + 1, column);
      default:
        throw new IllegalArgumentException("Unknown direction: " + direction);
    }
  }

  // TODO: equals and hashcode
}
