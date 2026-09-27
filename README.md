# Java LeetCode Solutions

My LeetCode solutions in Java, organized by difficulty and pattern.

## Structure

```
src/main/java/leetcode/solutions/
├── types/              # Shared data structures (e.g. ListNode and TreeNode)
├── easy/
│   ├── binarysearch/
│   ├── bitmanipulation/
│   ├── dynamicprogramming/
│   ├── graphs/
│   ├── greedy/
│   ├── hashing/
│   ├── heaps/
│   ├── intervals/
│   ├── linkedlist/
│   ├── math/
│   ├── stack/
│   ├── tree/
│   ├── twopointers/
│   └── various/
├── medium/
│   ├── backtracking/
│   ├── binarysearch/
│   ├── graphs/
│   ├── hashing/
│   ├── heaps/
│   ├── intervals/
│   ├── linkedlist/
│   ├── slidingwindow/
│   ├── sorting/
│   ├── stack/
│   ├── tree/
│   ├── tries/
│   ├── twopointers/
│   └── various/
└── hard/
│   ├── linkedlists/
│   ├── slidingwindow/
│   ├── stack/
│   └── twopointers/
```

## LeetCode Visualizer

[ValentinoFilipetto/leetcode-visualizer](https://github.com/ValentinoFilipetto/leetcode-visualizer)
is a companion web app (Vite + React + TS) that renders a step-by-step,
scrubbable visualization for solutions in this repo.

It reads the Java sources at build time (`pnpm run extract` →
`src/data/solutions.generated.json`), and each solution has a hand-written
TypeScript "tracer" that replays the same algorithm so the visualizer can show
its steps. Tracers reference source lines by quoting the line's text (not line
numbers), so editing a Java line that a tracer quotes breaks that highlight.

After adding or renaming a solution in this repo, in the visualizer repo run:

```
pnpm run extract
pnpm run check
```

`check` reports solutions with no tracer and tracers whose quoted Java line no
longer exists.

## More docs

Additional documentation to understand solutions. Still in progress.

1) [Bitwise operations cheatsheet](./docs/bitwise-operations-cheatsheet.md)