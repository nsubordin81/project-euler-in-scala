/* Attribution: I got this text from gotocode.io

There are n doors in a hallway that are initially closed. You first open all of the doors. Then, you close every second door. On the third round, you toggle every third door, opening it if it's closed or closing it if it's open. For the i-th round, you toggle every i door. For the n-th round, you only toggle the last door. Write a function to return how many doors are open after n rounds.

For example, given the input, 3, you should return: 1
Round 0, the doors are [closed, closed, closed].
Round 1, the doors are [open, open, open].
Round 2, the doors are [open, closed, open].
Round 3, the doors are [open, closed, closed].

The function should return 1,
because there is only one door open.

create a class called 'HallwayDoors'
create a method 'count_open' which takes in n, the number of doors in the hallway
assume all the doors are initially closed
return how many doors are open after n rounds of toggling */

class HallwayDoors:
  // doing this with a for expression and a zip with index to get the item index tuple
  // chose to use a mutable variable so I could reassign the list as it changes, list
  // objects themselves  are immutable
  // there are some definite patterns emerging that could result in a formulaic approach
  // primes other than 1 end up closed because they aren't revisited, composites state
  // varies in the examples, but might be all but the terminal composites end up open
  def count_open(n: Int): List[Boolean] =
    val numberOfDoors = n
    var doorStates = List.fill(numberOfDoors)(false)

    for i <- List.tabulate[Int](numberOfDoors)(_ + 1) do
      doorStates.zipWithIndex.foreach { case (item, index) =>
        // println("door states before: " + doorStates)
        // println(
        //   "door number is " + index + " and divisor is " + i + " and value of door is " + item
        // )
        if index + 1 % i == 0 then doorStates = doorStates.updated(index, !item)
      // println("door states after: " + doorStates)
      }

    return doorStates
