package pl.za.community.forum.util.result;

import java.util.Objects;

public final class Failure<T, E> implements Result<T, E> {
    private final E value;

    private Failure(E value) {
        this.value = value;
    }

    public static <E1> Result<?, E1> from(E1 value) {
        return new Failure<>(value);
    }

    public E value() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Failure) obj;
        return Objects.equals(this.value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Failure[value=%s]".formatted(value);
    }

}
