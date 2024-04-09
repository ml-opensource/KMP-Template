package fakes

import domain.model.Product
import domain.model.ProductList

internal object FakeDataSource {
    val product = Product(
        id = 1,
        title = "iPhone 9",
        description = "An apple mobile which is nothing like apple",
        price = 549,
        discountPercentage = 12.96,
        rating = 4.69,
        stock = 94,
        brand = "Apple",
        category = "smartphones",
        thumbnail = "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg",
        images = listOf(
            "https://cdn.dummyjson.com/product-images/1/1.jpg",
            "https://cdn.dummyjson.com/product-images/1/2.jpg",
            "https://cdn.dummyjson.com/product-images/1/3.jpg",
            "https://cdn.dummyjson.com/product-images/1/4.jpg",
            "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg",
        ),
    )

    val productList = ProductList(products = listOf(product), limit = 1, skip = 0, total = 100)
}
