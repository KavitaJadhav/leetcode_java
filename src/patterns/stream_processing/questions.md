
### Google stream-processing questions worth practicing

1. **Logger Rate Limiter — LeetCode 359**

    * Stream of `(timestamp, message)`
    * Suppress the same message within 10 seconds.
    * A recent Google L4 report used essentially this question, with a follow-up involving removal/expiration of old messages. ([LeetCode][1])
    * **You already did this.**

2. **Moving Average from Data Stream — LeetCode 346**

    * Maintain the average of the last `K` values.
    * Google-tagged interview question. ([Jointaro][2])
    * **You already did this.**

3. **Find Median from Data Stream — LeetCode 295**

    * Continuously add values and query the median.
    * Appears among Google interview question datasets. ([StealthCoder][3])
    * **You already did this.**

4. **Sliding Window Maximum — LeetCode 239**

    * Streaming/sliding-window maximum.
    * Also appears in Google interview question lists. ([StealthCoder][3])
    * **You already did this.**

5. **Top-K most active users in the last 1 hour**

    * Stream of user activity events.
    * Return the top-K users within a moving time window.
    * A Google Data Engineering interview report describes this as a stream-windowing problem using **heap + sliding window**. ([GitHub][4])
    * **This is a very good next problem for you.**

6. **Detect users active for K consecutive time windows**

    * User activity logs arrive **out of order**.
    * Detect whether a user was active in `K` consecutive windows of size `W`.
    * A recent Google Data Engineer interview-prep source specifically describes this pattern, including late/out-of-order data. ([Interview101][5])

7. **Event-stream deduplicator**

    * `process(timestamp, eventId)`
    * Determine whether an event was already seen within a TTL.
    * Google-tagged backend interview question; timestamps are non-decreasing. ([Prepare.sh][6])

8. **Stock statistics from a data stream**

    * Stream: `(stockSymbol, timestamp, price)`
    * Query current price, 52-week high and 52-week low.
    * This is reported as a Google interview question and requires per-stock sliding-window statistics. ([Reddit][7])

9. **Streaming temperature statistics**

    * A recent Google L4 interview report mentions a coding round involving **streaming temperature statistics**, alongside an out-of-order logger variant. ([Reddit][8])

[1]: https://leetcode.com/discuss/post/6684774/google-l4-interview-experience-usa-by-an-bre1/?utm_source=chatgpt.com "Google L4 interview experience | USA - Discuss - LeetCode"
[2]: https://www.jointaro.com/interviews/questions/moving-average-from-data-stream/?company=google&utm_source=chatgpt.com "Moving Average from Data Stream Interview Question for Google"
[3]: https://www.stealthcoder.app/companies/google?utm_source=chatgpt.com "Google Coding Interview Questions (277 Problems Reported) | StealthCoder"
[4]: https://github.com/Noman654/dataengineer_prep/blob/main/dsa/google.md?utm_source=chatgpt.com "dataengineer_prep/dsa/google.md at main · Noman654/dataengineer_prep · GitHub"
[5]: https://www.interview101.com/interviews/google/data-engineer?utm_source=chatgpt.com "Google Data Engineer Interview — Questions & Prep Guide (2026) | Interview101"
[6]: https://prepare.sh/interview/backend-engineering/code/event-stream-deduplicator?utm_source=chatgpt.com "Google: Event Stream Deduplicator — Backend Engineering Interview Q&A (2026) | Prepare.sh"
[7]: https://www.reddit.com/r/leetcode/comments/1c68oxp?utm_source=chatgpt.com "Stock stat from stock data stream | leetcode discuss section"
[8]: https://www.reddit.com/r/OfferEngineering/comments/1wd0amp/google_swe_fullloop_interview_experience_sep_2026/?utm_source=chatgpt.com "Google SWE Full-loop Interview Experience Sep 2026"
