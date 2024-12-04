# Unhandled Exceptions in Scala Futures

This example demonstrates a common error in Scala code that uses `Future`s: failure to handle potential exceptions within the `Future`'s body. This can lead to uncaught exceptions, which might result in silent failures.   The provided `BuggyFutures.scala` file shows code with this issue, while `FixedFutures.scala` provides a corrected version with robust exception handling.

## Problem
The original code uses `Thread.sleep` to simulate an asynchronous operation. If this operation throws an exception (e.g., an `InterruptedException`), the exception is not handled and may not be reported. 

## Solution
The `FixedFutures.scala` file incorporates `recover` or `recoverWith` to gracefully handle any exceptions within the `Future`, preventing silent failures and providing better error reporting.