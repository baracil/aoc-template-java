package fpc.aoc.common;

import lombok.Getter;
import lombok.NonNull;

import java.util.function.IntBinaryOperator;
import java.util.function.UnaryOperator;

public class TransformedArrayOfChar extends AbstractArrayOfChar implements ArrayOfChar {

  @Getter
  private final @NonNull Transformation transformation;

  private final @NonNull BaseArrayOfChar delegate;

  @Getter
  private final int width;

  @Getter
  private final int height;

  private final @NonNull IntBinaryOperator xTransformer;
  private final @NonNull IntBinaryOperator yTransformer;

  public TransformedArrayOfChar(@NonNull Transformation transformation, @NonNull BaseArrayOfChar delegate) {
    this.transformation = transformation;
    this.delegate = delegate;
    this.width = switch (transformation.rotation()) {
      case _000, _180 -> delegate.width();
      case _270, _090 -> delegate.height();
    };
    this.height = switch (transformation.rotation()) {
      case _000, _180 -> delegate.height();
      case _270, _090 -> delegate.width();
    };
    this.xTransformer = transformation.xTransformer();
    this.yTransformer = transformation.yTransformer();
  }

  @Override
  public char filling() {
    return delegate.filling();
  }

  @Override
  public char get(@NonNull Position position) {
    return get(position.x(), position.y());
  }

  @Override
  public char get(int x, int y) {
    if (x < 0 || x >= width || y < 0 || y >= height) {
      return delegate.filling();
    }
    final int ox = Tools.mod(xTransformer.applyAsInt(x, y), delegate.width());
    final int oy = Tools.mod(yTransformer.applyAsInt(x, y), delegate.height());


    return delegate.get(ox, oy);
  }

  @Override
  public @NonNull ArrayOfChar rotate(@NonNull Rotation rotation) {
    return transform(t -> t.compose(rotation));
  }

  @Override
  public @NonNull ArrayOfChar flip(@NonNull Flipping flipping) {
    return transform(t -> t.compose(flipping));
  }

  @Override
  public @NonNull ArrayOfChar transform(@NonNull Transformation transformation) {
    return transform(t -> t.compose(transformation));
  }

  private @NonNull ArrayOfChar transform(@NonNull UnaryOperator<Transformation> modifier) {
    final Transformation newTransformation = modifier.apply(this.transformation);
    if (newTransformation.equals(transformation)) {
      return this;
    }
    return new TransformedArrayOfChar(newTransformation, delegate);
  }
}
