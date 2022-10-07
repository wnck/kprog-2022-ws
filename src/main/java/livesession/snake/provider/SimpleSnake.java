package livesession.snake.provider;

import java.util.LinkedList;
import java.util.List;
import livesession.snake.Coordinate;
import livesession.snake.Direction;
import livesession.snake.Snake;

public class SimpleSnake implements Snake {
  private static final org.slf4j.Logger logger =
      org.slf4j.LoggerFactory.getLogger(SimpleSnake.class);

  private SimpleSnakeService service;

  LinkedList<Coordinate> position;

  public SimpleSnake(final SimpleSnakeService service) {
    this.service = service;
    position = new LinkedList<>();
  }

  @Override
  public List<Coordinate> getPosition() {
    // TODO: create cloned data
    return position;
  }

  @Override
  public Direction getDirection() {
    return null;
  }

  void advance() throws IllegalPositionException {
    // TODO: advance the snake
  }
}
