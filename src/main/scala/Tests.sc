val s = Seq(1, 2, 3)

def max(top: Int, s: Seq[Int]) : Int =
  s.foldLeft(0)( (r: Int, x :Int) => if (x != top && r < x) x else r  )


val t1 = max(0, s)

val t2 = max(t1, s)

t2 * t1


