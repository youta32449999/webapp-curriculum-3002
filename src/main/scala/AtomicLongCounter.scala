import java.util.concurrent.atomic.AtomicLong
import java.util.function.LongUnaryOperator

object AtomicLongCounterMain extends App {

  for (i <- 1 to 100) {
    new Thread(() => println(AtomicLongCounter.next)).start()
  }

}

object AtomicLongCounter {
  private[this] val counter = new AtomicLong(0L)

  def next: Long = {
    counter.updateAndGet(new LongUnaryOperator {
      override def applyAsLong(operand: Long): Long =  operand + 1
    })
  }
  //  こっちの方がシンプル
  //  def next: Long = counter.incrementAndGet()

}
