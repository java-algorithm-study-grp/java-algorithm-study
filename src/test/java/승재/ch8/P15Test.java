package 승재.ch8;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import 승재.common.ListNode;

class P15Test {

    @Test
    void test() {
        P15 p15 = new P15();

        final ListNode listNode = p15.reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
        assertThat(listNode).isEqualTo(new ListNode(5, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1))))));
    }

}