# Software 1 - Homework 6

A 2018 CS BSc Java assignment submission covering contract reasoning, polynomial operations, stack behavior, and small object/static-method riddles. The source is split into `partsA-C` and `riddles`, matching the submitted archive layout.

## Components

- `SectionA`: stack-like wrapper over a linked list with contract reasoning captured in the written answer.
- `SectionB`: small methods implemented from contracts: containment, minimum, reverse, and placeholder root behavior from the source.
- `Polynomial`: polynomial construction, coefficient access and mutation, addition, scalar multiplication, derivation, evaluation, and root checks.
- `riddle.a` through `riddle.d`: small class-interaction exercises. Some files are marked in-code as scaffold files that should not be changed.

## Build

```bash
make
```

This compiles all Java sources into `build/` using `javac -Xlint:all -Werror`.

## Testing

```bash
make test
```

The validation run compiles the project, executes the maintained regression harness, and runs the polynomial `Test` class.

## Repository Structure

- `solution-answers.txt`: my written answers
- `src/partsA-C/`: SectionA, SectionB, Polynomial, and small tester
- `src/riddles/`: riddle packages, including scaffold files marked in comments
- `tests/RunHw6Checks.java`: maintained Java regression harness
