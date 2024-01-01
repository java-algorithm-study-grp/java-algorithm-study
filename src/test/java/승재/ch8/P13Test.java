package 승재.ch8;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import 승재.common.ListNode;

import static org.assertj.core.api.Assertions.assertThat;

class P13Test {

    @ParameterizedTest
    @MethodSource
    void test(ListNode node) {
        //given
        final P13 p13 = new P13();

        //when
        final boolean expected = p13.isPalindrome(node);

        //then
        assertThat(expected).isTrue();
    }

    private static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of(new ListNode(1,
                        new ListNode(2, new ListNode(2, new ListNode(1))))),
                Arguments.of(new ListNode(1,
                        new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1))))))
        );
    }

}
