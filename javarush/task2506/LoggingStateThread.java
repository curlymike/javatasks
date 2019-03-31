

public class LoggingStateThread extends Thread {
  private Thread thread;
  private State currentState, state;

  public LoggingStateThread(Thread thread) {
    currentState = state = thread.getState();
    this.thread = thread;
  }

  @Override
  public void run() {
    System.out.println(state);
    while (state != State.TERMINATED) {
      currentState = thread.getState();
      if (state != currentState) {
        state = currentState;
        System.out.println(state);
      }
    }
    yield();
  }
}
