package stack_and_queues;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class N6MaxBuildingWithSunset {
    private final List<Integer> buildingHeights;

    public N6MaxBuildingWithSunset(List<Integer> buildingHeights) {
        handleExceptions(buildingHeights);
        this.buildingHeights = buildingHeights;
    }

    private void handleExceptions(List<Integer> buildingHeights) {
        if (Objects.isNull(buildingHeights))
            throw new NullInput();
    }

    public List<Integer> buildingsWithSunsetView() {
        List<Integer> result = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < buildingHeights.size(); i++) {
            if (buildingHeights.get(i) > max) {
                max = buildingHeights.get(i);
                result.add(max);
            }
        }
        return result;
    }

    public static class NullInput extends RuntimeException {
    }
}
