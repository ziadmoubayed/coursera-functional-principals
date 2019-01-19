def sum(f: Int => Int)(a: Int, b: Int): Int = {
  def loop(b: Int, acc: Int): Int = {
    if (b == a) acc
    else loop(b - 1, f(acc + b))
  }

  loop(b, 0)
}

sum(x => x * x)(0, 2)
sum(x => x)(1, 2)
sum(x => x)(0, 3)
sum(x => x)(0, 4)
sum(x => x)(0, 5)
sum(x => x)(0, 6)

def product(f: Int => Int)(a: Int, b: Int) :Int = {
  if (b < a) 1
  else f(a) * product(f)(a + 1, b)
}

product(x => x * x)(3, 7)

def factorial(n: Int) = product(x => x)(1, n)
factorial(3)

def mapReduce(map: Int => Int)(reduce: (Int, Int) => Int)(zero :Int)(a :Int, b :Int) :Int = {
  println(a, b)
  if (b < a) zero
  else reduce(map(a),  mapReduce(map)(reduce)(zero)(a + 1, b))
}

mapReduce(x => x)((y, z) => y + z)(0)(1, 3)
mapReduce(x => x)((y, z) => y * z)(1)(1, 3)