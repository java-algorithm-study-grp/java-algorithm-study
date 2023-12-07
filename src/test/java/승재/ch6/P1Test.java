package 승재.ch6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class P1Test {

    private final P1 p1 = new P1();

    @ParameterizedTest
    @MethodSource
    void solution(final String text, final boolean actual) {
        assertThat(p1.palindrome(text)).isEqualTo(actual);
    }

    private static Stream<Arguments> solution() {
        return Stream.of(
                Arguments.of("Do geese see God?", true),
                Arguments.of("hello", false),
                Arguments.of("Bob", true),
                Arguments.of("door", false),
                Arguments.of("good", false),
                Arguments.of("goog", true),
                Arguments.of("!@#!@$is equal lauqe si ???!", true),
                Arguments.of("equal!@#!@$lauqe", true)
        );
    }

}
