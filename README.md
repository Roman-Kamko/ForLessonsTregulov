# Курс Заура Трегулова "JAVA - получи черный пояс"

Иду по курсу, повторяя все что делает Заур, использую много комментариев для создания импровизируемой БД на случай что-то быстро подсмотреть, освежить в памяти.

### Темы:

+ интерфейсы Comparable & Comparator

***

+ Generics
  + intro (см. Test1.java)
  + Parametrized classes
  + Parametrized methods
  + Пример (см. game.Test)
  + Subtyping
  + TypeErasure
  + WildCard

***

+ Collections
  + Iterator
  + ListIterator
  + BinarySearch
  + BigO
  + List interface
    - ArrayList
    - LinkedList
    - Vector
    - Stack
  + Equals & HashCode
  + Map interface
    - HashMap
    - TreeMap
    - HashTable
  + Set interface
    - HashSet
    - LinkedHashSet
    - TreeSet
    - LinkedHashSet
  + Queue interface
    - PriorityQueue
    - Deque interface
      - LinkedList
      - ArrayDeque
  
***

+ Nested classes
  - StaticNested classes
  - Inner classes
  - local inner classes
  - Anonymous classes

***

+ Lambda expressions
  - Lambda
  - Predicate
  - Consumer
  - Supplier
  - Function
  - метод .forEach();

***

+ Stream
  - map
  - filter
  - sorted
  - forEach
  - reduce
  - chaining methods
  - collect(Collectors.groupingBy)
  - collect(Collectors.partitioningBy)
  - flatMap
  - mapToInt
  - Other methods
  - Parallel stream

***

+ Multithreading
  + способы создания потока
  + имя и приоритет потока
  + sleep() & join()
  + Concurrency/Parallelism
  + Asynchronous/Synchronous
  + Synchronized & Data race
  + Монитор и Synchronized блоки
  + wait() & notify()
  + возможные ситуации в многопоточном программировании:
    + Deadlock
    + Livelock
    + Lock starvation
  + Daemon потоки
  + interrupt() прерывание потока
  + ThreadPool & ExecutorService