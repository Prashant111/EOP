package stack_and_queues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static linked_lists.LinkedListReverseSublistTest.list;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class N6MaxBuildingWithSunsetTest {

    private List<Integer> nullList;
    private List<Integer> emptyList;
    private List<Integer> singleItemList;
    private List<Integer> increasing;
    private List<Integer> decreasing;

    @BeforeEach
    void setUp() {
        nullList = null;
        emptyList = list();
        singleItemList = list(1);
        increasing = list(1, 2, 3, 4, 5, 6);
        decreasing = list(6, 5, 4, 3, 2, 1);
    }

    private void assertMaxBuildingWithSunsetView(List<Integer> expected, List<Integer> input) {
        N6MaxBuildingWithSunset n6MaxBuildingWithSunset = new N6MaxBuildingWithSunset(input);
        List<Integer> actual = n6MaxBuildingWithSunset.buildingsWithSunsetView();
        assertEquals(expected, actual);
    }

    @Test
    void buildingsWithSunsetView_emptyList() {
        assertThrows(N6MaxBuildingWithSunset.NullInput.class, () ->
                new N6MaxBuildingWithSunset(nullList)
        );
    }

    @Test
    void buildingsWithSunsetView_EmptyList() {
        assertMaxBuildingWithSunsetView(list(), emptyList);
    }

    @Test
    void buildingsWithSunsetView_SingleItemList() {
        assertMaxBuildingWithSunsetView(list(1), singleItemList);
    }

    @Test
    void buildingsWithSunsetView_Increasing() {
        assertMaxBuildingWithSunsetView(list(1, 2, 3, 4, 5, 6), increasing);
    }

    @Test
    void buildingsWithSunsetView_Decreasing() {
        assertMaxBuildingWithSunsetView(list(6), decreasing);
    }
}