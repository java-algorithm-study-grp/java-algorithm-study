package 승재.ch6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class P2Test {

    private final P2 problem = new P2();

    @ParameterizedTest
    @MethodSource
    void test(final char[] sample, final char[] actual) {
        assertThat(problem.reverseString(sample)).isEqualTo(actual);
    }

    private static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of(new char[]{'h', 'e', 'l', 'l', 'o'}, new char[]{'o', 'l', 'l', 'e', 'h'}),
                Arguments.of(new char[]{'H', 'a', 'n', 'n', 'a', 'h'}, new char[]{'h', 'a', 'n', 'n', 'a', 'H'})
        );
    }

}
