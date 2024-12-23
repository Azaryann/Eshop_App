package am.azaryan.service;

import am.azaryan.entity.Product;
import am.azaryan.entity.ProductPicture;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductPictureService {

    ProductPicture save(ProductPicture productPicture);

    void saveAll(Product product, List<MultipartFile> multipartFiles);

    List<ProductPicture> findAllByProduct(Product product);
}
