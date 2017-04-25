package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
    // Return the set of customers who ordered the specified product

    return customers.filter { it.orderedProducts.contains(product) }.toSet()
}

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    // Return the most expensive product among all delivered products
    // (use the Order.isDelivered flag)

    return orders.filter { it.isDelivered }
            .flatMap { it.products }
            .maxBy { it.price }
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    // Return the number of times the given product was ordered.
    // Note: a customer may order the same product for several times.

    // imperative version...
/*
    var count = 0
    for (customer in customers) {
        for (order in customer.orders) {
            count += order.products.count { it == product }
        }
    }
    return count
*/

    // first functional version...
/*
    return customers.flatMap { it.orders }
            .sumBy { order -> order.products.count { it == product } }
*/

    // second functional version...
    // IntelliJ suggested to use a destructuring declaration
    // ( https://kotlinlang.org/docs/reference/multi-declarations.html )
    return customers.flatMap { it.orders }
            .sumBy { (products) -> products.count { it == product } }

}
