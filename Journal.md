# Phase 1 Complete

I made a Company class and added ten companies to a PriorityQueue. The compareTo method puts the smallest company first. Reversing the comparison would put the largest first.

# Phase 2 Complete

I added a loop that merges the two smallest companies and increases their combined size by 10%. Adding to the queue takes O(log N), while sorting a whole list usually takes O(N log N).

# Phase 3 Complete

I made the program stop when a company reaches 500,000 or fewer than two companies remain. Checking the queue size prevents removing missing items, which relates to underflow.

# Phase 4: Validation and Reflection

I tested starting sizes of [enter sizes]. The result was [enter result].

The AI review suggested checking for an existing titan and making sure two companies remain before merging. These checks are included in the code.

During testing, I noticed [enter what happened].
