package pl.za.community.forum.util.result;

public sealed interface Result<T, E> permits Success, Failure {
    default T unwrap() {
        return switch (this) {
            case Success<T, E> success -> success.value();
            case Failure<T, E> failure -> throw new FailureUnwrapException(failure.value());
        };
    }

    class FailureUnwrapException extends RuntimeException {
        private final Object value;

        public <E> FailureUnwrapException(E value) {
            this.value = value;
        }
    }
}
