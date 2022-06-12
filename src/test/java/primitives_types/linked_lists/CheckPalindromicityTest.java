package primitives_types.linked_lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import primitives_types.linked_lists.cores.SinglyLinkedListNode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static primitives_types.linked_lists.LinkedListMergingTest.linkedListOf;
import static primitives_types.linked_lists.LinkedListReverseSublistTest.list;

class CheckPalindromicityTest<T> {

    private CheckPalindromicity<T> checkPalindromicity;
    private List<T> nullList;
    private List<T> singleElementList;
    private List<T> twoNonPalindromicElementList;
    private List<T> twoPalindromicElementList;

    private List<T> threePalindromicElementList;
    private List<T> threeNonPalindromicElementList;
    private List<T> fourPalindromicElementList;
    private List<T> fourNonPalindromicElementList;

    private List<T> longEvenSizedPalindromicElementList;
    private List<T> longEvenSizedNonPalindromicElementList;
    private List<T> longOddSizedPalindromicElementList;
    private List<T> longOddSizedNonPalindromicElementList;


    @BeforeEach
    void setUp() {
        nullList = null;
        singleElementList = (List<T>) list(1);
        twoNonPalindromicElementList = (List<T>) list(1, 2);
        twoPalindromicElementList = (List<T>) list(4, 4);

        threePalindromicElementList = (List<T>) list(1, 2, 1);
        threeNonPalindromicElementList = (List<T>) list(1, 2, 3);

        fourPalindromicElementList = (List<T>) list(1, 2, 2, 1);
        fourNonPalindromicElementList = (List<T>) list(1, 2, 2, 2);

        longEvenSizedPalindromicElementList = (List<T>) list(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
        longEvenSizedNonPalindromicElementList = (List<T>) list(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 11, 10, 9, 8, 8, 6, 5, 4, 3, 2, 1);

        longOddSizedPalindromicElementList = (List<T>) list(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
        longOddSizedNonPalindromicElementList = (List<T>) list(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 11, 10, 9, 8, 8, 6, 5, 4, 3, 2, 1);
    }


    private void setLinkedListInPalindromicity(SinglyLinkedListNode<T> singlyLinkedList) {
        checkPalindromicity = new CheckPalindromicity<>(singlyLinkedList);
    }

    private void assertCheckPalindromicity(List<T> input, boolean expected) {
        setLinkedListInPalindromicity(linkedListOf(input));
        boolean actual = checkPalindromicity.test();
        assertEquals(expected, actual);
    }

    @Test
    void givenNoInstance_whenCreateInstanceWithNonNullInput_thenCreateInstanceWithoutException() {
        assertDoesNotThrow(() -> setLinkedListInPalindromicity(linkedListOf(singleElementList)));
    }

    @Test
    void givenNoInstance_whenCreateInstanceWithNonNullInput_thenThrowException() {
        assertThrows(CheckPalindromicity.NullInput.class,
                () -> setLinkedListInPalindromicity(linkedListOf(nullList)));
    }

    @Test
    void givenGivenSingleValueInput_whenCallingCheckMethod_thenShouldReturnTrue() {
        assertCheckPalindromicity(singleElementList, true);

        assertCheckPalindromicity(twoPalindromicElementList, true);
        assertCheckPalindromicity(twoNonPalindromicElementList, false);

        assertCheckPalindromicity(threePalindromicElementList, true);
        assertCheckPalindromicity(threeNonPalindromicElementList, false);

        assertCheckPalindromicity(fourPalindromicElementList, true);
        assertCheckPalindromicity(fourNonPalindromicElementList, false);

        assertCheckPalindromicity(longEvenSizedPalindromicElementList, true);
        assertCheckPalindromicity(longEvenSizedNonPalindromicElementList, false);

        assertCheckPalindromicity(longOddSizedPalindromicElementList, true);
        assertCheckPalindromicity(longOddSizedNonPalindromicElementList, false);
    }
}