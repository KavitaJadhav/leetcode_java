package patterns.stream_processing;
//### Next — User Sessionization
//
//**Question:**
//Given a stream of `(timestamp, userId)` events, group each user's events into **sessions**. A new session starts when the gap between two consecutive events for that user is greater than `X` minutes. Return the sessions for a given user.
//
//**Example:**
//
//```text
//user=A: 10, 12, 15, 40, 42
//X=10 minutes
//
//Sessions:
//[10, 12, 15]
//[40, 42]
//```
//
//**Pattern:** HashMap + timestamp tracking + session boundaries
//
//**Complexity target:**
//
//* `add()` → **O(1) average**
//* `getSessions()` → **O(S)** where S = number of sessions
//* Space → **O(E)**
//
//**Follow-up:** What changes if events arrive **out of order**?

import java.util.*;

public class UserSessionization {

    private final int sessionGap;
    private final Map<String, Integer> lastSeen;
    private final Map<String, List<List<Integer>>> sessions;

    public UserSessionization(int sessionGap) {
        this.sessionGap = sessionGap;
        this.lastSeen = new HashMap<>();
        this.sessions = new HashMap<>();
    }

    public void add(int timestamp, String userId) {

        if (!lastSeen.containsKey(userId)) {
            sessions
                    .computeIfAbsent(userId, key -> new ArrayList<>())
                    .add(new ArrayList<>());

            sessions.get(userId).get(0).add(timestamp);
        }
        else {
            int previousTimestamp = lastSeen.get(userId);

            if (timestamp - previousTimestamp > sessionGap) {
                sessions.get(userId).add(new ArrayList<>());
            }

            sessions.get(userId)
                    .get(sessions.get(userId).size() - 1)
                    .add(timestamp);
        }

        lastSeen.put(userId, timestamp);
    }

    public List<List<Integer>> getSessions(String userId) {
        return sessions.getOrDefault(userId, new ArrayList<>());
    }
}