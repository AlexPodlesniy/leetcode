package to400.to310;

import java.util.*;

class RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {
        if (isValid(s)) {
            return List.of(s);
        }
        return bfs(s);
    }

    private List<String> bfs (String root) {
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<String>();
        List<String> result = new ArrayList<>();

        q.add(root);
        int currentLevelSize = 0;

        while (q.peek() != null) {
            currentLevelSize = q.size();
            for (int i = 0; i < currentLevelSize; i++) {
                String s = q.poll();

                if (visited.contains(s)) {
                    continue;
                }

                visited.add(s);

                for (int j = 0; j < s.length(); j++) {
                    char c = s.charAt(j);
                    if (c == '(' || c == ')') {
                        q.add(removeChar(s, j));
                    }
                }

                if (isValid(s)) {
                    result.add(s);
                }

            }
            if (!result.isEmpty()) {
                return result;
            }
        }
        return result;
    }

    private String removeChar(String s, int index) {
        return s.substring(0, index)
                .concat(s.substring(index + 1, s.length()));
    }

    private boolean isValid(String s) {
        char[] ca = s.toCharArray();
        int result = 0;
        for (char c : ca) {
            if (c == '(') {
                result++;
            } else if (c == ')') {
                result--;
                if (result < 0) {
                    return false;
                }
            }
        }
        return result == 0;
    }
}
