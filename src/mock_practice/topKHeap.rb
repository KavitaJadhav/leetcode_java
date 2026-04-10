#!/bin/ruby

require 'json'
require 'stringio'



#
# Complete the 'getTopKFrequentEvents' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts following parameters:
#  1. INTEGER_ARRAY events
#  2. INTEGER k
#
# O(NlogK) #Heap

def getTopKFrequentEvents(events, k)
    return [] if events.empty?

    count_map = {}
    # Using array as a heap
    min_heap = []

    events.each_with_index do |event, index|
count_map[event] ||= { first_index: index, count: 0 }
count_map[event][:count] += 1
    end

    count_map.each do |element, values|
        min_heap << {element: element, count: values[:count], first_index: values[:first_index]}
             # Replicating heapify up method
            # Add complexity is O(Log N) in heap.. here its O(N log N)
             min_heap.sort_by!{|pair| [pair[:count], -pair[:first_index]]}

        if min_heap.size > k
            # Replicating heap poll behavious
            # poll complexity is O(Log N) in heap.. here its O(N)
            min_heap.shift
        end
    end

    # Sorting again to ensure ordering as in the original heap order is not garrienteed
     min_heap.sort_by!{|pair| [-pair[:count], pair[:first_index]]}
    min_heap.map{|pair| pair[:element]}
end

events_count = gets.strip.to_i

events = Array.new(events_count)

events_count.times do |i|
    events_item = gets.strip.to_i
    events[i] = events_item
end

k = gets.strip.to_i

result = getTopKFrequentEvents events, k

print result.join "\n"
print "\n"
