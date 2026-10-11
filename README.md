# Java LeetCode Solutions

My LeetCode solutions in Java, organized by difficulty and pattern.

## LeetCode Visualizer

[ValentinoFilipetto/leetcode-visualizer](https://github.com/ValentinoFilipetto/leetcode-visualizer)
is a companion web app (Vite + React + TS) that renders a step-by-step,
scrubbable visualization for solutions in this repo.

It reads the Java sources at build time (`pnpm run extract` →
`src/data/solutions.generated.json`), and each solution has a hand-written
TypeScript "tracer" that replays the same algorithm so the visualizer can show
its steps. Tracers reference source lines by quoting the line's text (not line
numbers), so editing a Java line that a tracer quotes breaks that highlight.

After adding or renaming a solution in this repo, the easiest way to visualize it is to use Claude Code and run the [sync-java-solutions](https://github.com/ValentinoFilipetto/leetcode-visualizer/blob/main/.claude/skills/sync-java-solutions/SKILL.md) skill. That will create a complete visualization, run several tests and push change to GitHub, where they will be deployed.

## More docs

Additional documentation to understand solutions. Still in progress...

1) [Bitwise operations cheatsheet](./docs/bitwise-operations-cheatsheet.md)