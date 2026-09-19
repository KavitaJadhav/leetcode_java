package patterns.stream_processing.window;

import java.util.*;
//### Next — Detect K Consecutive Active Windows
//
//Given a stream of events:
//
//`(timestamp, userId)`
//
//A user is considered **active in a time window** if they have at least one event during that window.
//
//Design a data structure to determine whether a user was active in **K consecutive windows**, where each window has size `W` seconds.
//
//**Twist:** Events may arrive **out of order**.
//
//**Example:**
//`W = 60`, `K = 3`
//
//```text
//user A:
//10   → window 0
//70   → window 1
//130  → window 2
//
//→ A was active in 3 consecutive windows
//```
//
//**Pattern:** Time bucketing + HashMap + consecutive-sequence tracking
//
//**Complexity target**
//
//* `add()` → **O(log N)** or **O(1)** depending on structure
//* `isActiveForKWindows()` → **O(K)** or better
//* Space → **O(E)**
//
//Try the approach first; ask for **code** when ready.

public class ConsecutiveActiveWindows {

    int windowSize;
    int requiredWindows;

    // userId -> windows in which the user was active
    Map<Integer, TreeSet<Integer>> userWindows;

    public ConsecutiveActiveWindows(
            int windowSize,
            int requiredWindows) {

        this.windowSize = windowSize;
        this.requiredWindows = requiredWindows;
        this.userWindows = new HashMap<>();
    }

    public void add(int timestamp, int userId) {

        int windowNumber = timestamp / windowSize;

        userWindows
                .computeIfAbsent(
                        userId,
                        key -> new TreeSet<>()
                )
                .add(windowNumber);
    }

    public boolean isActiveForKWindows(int userId) {

        TreeSet<Integer> windows = userWindows.get(userId);

        if (windows == null ||
                windows.size() < requiredWindows) {
            return false;
        }

        int consecutiveWindows = 1;
        int previousWindow = windows.first();

        for (int currentWindow : windows.tailSet(previousWindow + 1)) {

            if (currentWindow == previousWindow + 1) {
                consecutiveWindows++;

                if (consecutiveWindows >= requiredWindows) {
                    return true;
                }
            } else {
                consecutiveWindows = 1;
            }

            previousWindow = currentWindow;
        }

        return false;
    }

    public static void main(String[] args) {

        ConsecutiveActiveWindows stream =
                new ConsecutiveActiveWindows(60, 3);

        // Out of order
        stream.add(130, 1);  // window 2
        stream.add(10, 1);   // window 0
        stream.add(70, 1);   // window 1

        System.out.println(
                stream.isActiveForKWindows(1)
        );
        // true
    }
}