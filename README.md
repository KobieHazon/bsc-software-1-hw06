# Software 1 - Homework 6

A 2018 CS BSc Java assignment submission covering contract reasoning, polynomial operations, stack behavior, and small object/static-method riddles. The recovered source is split into `partsA-C` and `riddles`, matching the submitted archive layout.

## Components

- `SectionA`: stack-like wrapper over a linked list with contract reasoning captured in the written answer.
- `SectionB`: small methods implemented from contracts: containment, minimum, reverse, and placeholder root behavior from the recovered source.
- `Polynomial`: polynomial construction, coefficient access and mutation, addition, scalar multiplication, derivation, evaluation, and root checks.
- `riddle.a` through `riddle.d`: small class-interaction exercises. Some recovered files are marked in-code as scaffold files that should not be changed.

## Build

```bash
make
```

This compiles all Java sources into `build/` using `javac -Xlint:all -Werror`.

## Testing

```bash
make test
```

The validation run compiles the project, executes the maintained regression harness, and runs the recovered polynomial `Test` class.

## Repository Structure

- `assignment/MISSING_HANDOUT.md`: provenance note explaining that the exact matching handout was not recovered
- `solution-answers.txt`: my recovered written answers
- `src/partsA-C/`: recovered SectionA, SectionB, Polynomial, and small recovered tester
- `src/riddles/`: recovered riddle packages, including scaffold files marked in comments
- `tests/RunHw6Checks.java`: maintained Java regression harness

## Implementation notes

The maintained version keeps the recovered source-root split and public APIs, fixes strict-compiler warnings, repairs bounded defects in stack null handling, polynomial coefficient expansion and derivative handling, `SectionB.min2`, single-source formatting, and adds a strict local build and test path.

## License

No repository-wide license is declared because the exact supplied exercise terms were not recovered.
