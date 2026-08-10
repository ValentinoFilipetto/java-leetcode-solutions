# The Left Shift Operator (`<<`)

## What is it?

`<<` is the **left shift** bitwise operator. It shifts all bits in a number
to the left by N positions, padding the right side with `0`s. Each shift doubles the value, `1 << n` is equivalent to 2ⁿ. 
Left shifting by 1 multiplies by 2, by 2 multiplies by 4, and so on.

## Syntax

 ```java
 result = value << n;
```

For example:
```
1 << 0  →  00000000000000000000000000000001
1 << 1  →  00000000000000000000000000000010
1 << 6  →  00000000000000000000000001000000
1 << 31 →  10000000000000000000000000000000
```

# The OR Assignment Operator (`|=`)

## What is it?

`|=` is the **bitwise OR assignment** operator. It turns ON a specific bit
in a number by OR-ing it with a mask. If the bit is already `1`, it stays `1`.
If it is `0`, it becomes `1`.

## Syntax

 ```java
 value |= mask;
```

# The XOR Assignment Operator (`^=`)

## What is it?

`^=` is the **bitwise XOR assignment** operator. It toggles a specific bit
in a number by XOR-ing it with a mask. If the bit is `1`, it becomes `0`.
If it is `0`, it becomes `1`.

## Syntax

 ```java
 value ^= mask;
```

# The Bitwise AND Operator (`&`)
   
## What is it?

`&` is the **bitwise AND** operator. It compares two numbers bit by bit —
the result is `1` only when **both** bits are `1`, otherwise `0`.
This makes it perfect for **checking** whether a specific bit is ON.
   
## Syntax
   
```java
result = value & mask;
```