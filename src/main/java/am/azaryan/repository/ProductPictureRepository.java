package am.azaryan.repository;

import am.azaryan.entity.Product;
import am.azaryan.entity.ProductPicture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductPictureRepository extends JpaRepository<ProductPicture, Integer> {

    List<ProductPicture> findAllByProduct(Product product);

}
