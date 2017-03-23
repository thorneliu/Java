# Subtyping

Although Integer is a subtype of Number, List<Integer> is not a subtype of List<Number> and, in fact, these two types are not related. The common parent of List<Number> and List<Integer> is List<?>.

List<? extends Integer> is a subtype of List<? extends Number>


