package 승재.ch7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class P3Test {


    @ParameterizedTest
    @MethodSource
    @DisplayName("해시맵을 사용해 두개의 합을 구한다")
    void test(int[] arr, int target, int first, int second) {
        //given
        var p3 = new P3();

        //when
        var twoSum = p3.twoSum(arr, target);

        //then
        assertThat(twoSum[0]).isEqualTo(first);
        assertThat(twoSum[1]).isEqualTo(second);
    }

    private static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, 0, 1),
                Arguments.of(new int[]{3, 2, 4}, 6, 1, 2),
                Arguments.of(new int[]{3, 3}, 6, 0, 1)
        );
    }

    @Test
    @DisplayName("containsKey를 사용하지 않으면 NPE가 발생한다")
    void test2() {
        //given
        final var p3 = new P3();

        //when
        var twoSum = p3.twoSum(new int[]{2, 5, 5, 11}, 10);

        //then
        assertThat(twoSum[0]).isEqualTo(1);
        assertThat(twoSum[1]).isEqualTo(2);
    }
}
