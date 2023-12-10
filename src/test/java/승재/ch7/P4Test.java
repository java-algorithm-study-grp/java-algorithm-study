package 승재.ch7;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class P4Test {

    @ParameterizedTest
    @MethodSource
    void test(final int[] arr, final int expected) {
        //given
        P4 p = new P4();

        //when
        final int actual = p.arrayPairSum(arr);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> test() {
        return Stream.of(
            Arguments.of(new int[]{1, 4, 3, 2}, 4),
            Arguments.of(new int[]{6, 2, 6, 5, 1, 2}, 9)
        );
    }



}