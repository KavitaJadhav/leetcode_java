DIJKSTRA — NOTES

Dijkstra is fundamentally about finding the shortest distance from one source to every reachable node.

Pattern:
- Shortest path in a weighted graph.
- Finds shortest distances from ONE source to ALL reachable nodes.
- If we only need source → target, we can stop early when target is removed from the min-heap.

When to use:
- Graph has weighted edges.
- Edge weights must be non-negative.
- BFS is not appropriate when edge costs are different.

Core idea:
1. Start source with distance = 0.
2. Put source into a min-heap ordered by distance.
3. Pop the node with the smallest distance.
4. Relax all its neighbors:
   newDistance = currentDistance + edgeWeight
5. If newDistance is smaller than the previously known distance:
   update distance
   add neighbor to the heap.
6. Continue until heap is empty.
7. For a single target, stop when target is popped/finalized.

Why PriorityQueue?
- Always processes the node with the smallest known distance first.
- This gives Dijkstra its shortest-path guarantee.

distances[] vs visited[]:

STANDARD VERSION:
- Maintain distances[node] = shortest distance found so far.
- Update it whenever a shorter path is found.
- This is the clearest/general Dijkstra implementation.

VISITED VERSION:
- Can use visited[] instead of distances[].
- Mark a node visited ONLY when it is popped from the min-heap.
- The first time a node is popped, its shortest distance is finalized.
- Do NOT mark it visited when adding it to the heap.

Important distinction:

WRONG:
add neighbor to heap
mark neighbor visited

CORRECT:
pop minimum-distance node
if already visited → skip
mark visited
process neighbors

Why can we stop when target is popped?
- The heap always pops the smallest-distance node.
- Therefore, when target is popped for the first time,
  no future path can give it a smaller distance.

Example:

A --2--> B
A --5--> C
B --1--> C

Start A:
distance[A] = 0
distance[B] = 2
distance[C] = 5

Then process B:
A → B → C = 2 + 1 = 3

Update:
distance[C] = 3

So shortest A → C = 3.

BFS vs Dijkstra:

BFS:
- Unweighted graph / equal edge cost
- Uses Queue
- First visit gives shortest distance

Dijkstra:
- Weighted graph / different non-negative edge costs
- Uses Min-Heap
- First POP/finalization gives shortest distance

Your Maze II problem:
- Ball rolls multiple cells.
- One move can have cost 1, 2, 3, ... cells.
- Therefore edge costs are different.
- BFS is not sufficient.
- Use Dijkstra + PriorityQueue.
- Each stopping position is a graph node.
- Rolling from one stopping position to another is an edge.
- Edge weight = number of cells rolled.

Interview answer:
"Because the movement cost between stopping positions is variable, I cannot use BFS. I'll model each stopping position as a graph node and use Dijkstra with a min-heap. I'll maintain the shortest known distance to each position and relax it whenever I find a shorter path."