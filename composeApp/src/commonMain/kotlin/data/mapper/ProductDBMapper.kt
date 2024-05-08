//package data.mapper
//
//import com.monstarlab.kmp.ProductDB
//import domain.model.Product
//
//class ProductDBMapper {
//    fun mapToDomainModel(databaseModel: ProductDB) = Product(
//        databaseModel.brand,
//        databaseModel.category,
//        databaseModel.description,
//        databaseModel.discountPercentage,
//        databaseModel.id.toInt(),
//        databaseModel.images,
//        databaseModel.price.toInt(),
//        databaseModel.rating,
//        databaseModel.stock.toInt(),
//        databaseModel.thumbnail,
//        databaseModel.title
//    )
//
//    fun mapToDatabaseModel(domainModel: Product) = ProductDB(
//        domainModel.id.toLong(),
//        domainModel.brand,
//        domainModel.category,
//        domainModel.description,
//        domainModel.discountPercentage,
//        domainModel.rating,
//        domainModel.price.toLong(),
//        domainModel.stock.toLong(),
//        domainModel.thumbnail,
//        domainModel.title,
//        domainModel.images
//    )
//}
