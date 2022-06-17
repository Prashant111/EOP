package stack_and_queues;

import strings.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class N4NormalizePathNames {
    private final String inputString;

    public N4NormalizePathNames(String inputString) {
        handleException(inputString);
        this.inputString = inputString;
    }

    private void handleException(String inputString) {
        if (Objects.isNull(inputString)) throw new NullInput();
    }

    public String optimizedPathName() {
        String[] tokens = inputString.split("/");
        return parseTokens(tokens);
    }

    private String parseTokens(String[] tokens) {
        boolean absolutePath = tokens.length > 0 && tokens[0].equals("");
        List<String> tokensList = Arrays.asList(tokens);
        tokensList = tokensList.stream().filter(string -> !string.equals(".")).filter(string -> !StringUtils.isEmpty(string)).collect(Collectors.toList());

        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < tokensList.size(); i++) {
            if (tokensList.get(i).equals("..")) {
                index.add(i - 1);
                index.add(i);
            }
        }

        List<String> updatedList = new ArrayList<>();
        for (int i = 0; i < tokensList.size(); i++) {
            if (!index.contains(i)) updatedList.add(tokensList.get(i));
        }
        String path = String.join("/", updatedList);
        return absolutePath ? "/".concat(path) : path;
    }

    public static class NullInput extends RuntimeException {
    }
}
