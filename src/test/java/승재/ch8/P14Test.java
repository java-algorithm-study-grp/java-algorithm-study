package 승재.ch8;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class P14Test {
    private final P14 p14 = new P14();

    @ParameterizedTest
    @MethodSource
    void test(final ListNode list1, final ListNode list2, final List<Integer> expected) {
        //when
        ListNode listNode = p14.mergeTwoLists(list1, list2);

        //then
        List<Integer> actual = new ArrayList<>();
        while (listNode != null) {
            actual.add(listNode.val);
            listNode = listNode.next;
        }

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of(new ListNode(1, new ListNode(2, new ListNode(4))),
                        new ListNode(1, new ListNode(3, new ListNode(4))),
                        List.of(1, 1, 2, 3, 4, 4)
                ),
                Arguments.of(new ListNode(1, new ListNode(2, new ListNode(4))),
                        new ListNode(1, null),
                        List.of(1, 1, 2, 4)
                )
        );
    }

}
