package pl.za.community.forum;

import java.util.Objects;

public final class Success<T, E> implements Result<T, E> {
    private final T value;

    private Success(T value) {
        this.value = value;
    }

    public static <T1> Result<T1, ?> from(T1 value) {
        return new Success<>(value);
    }

    public T value() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Success) obj;
        return Objects.equals(this.value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Success[value=%s]".formatted(value);
    }

}
