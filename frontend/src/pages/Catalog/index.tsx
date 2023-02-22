import ProductCard from 'components/ProductCard';
import { Product } from 'types/product';

const Catalog = () => {
  const product: Product = {
    id: 2,
    name: 'SmartTV',
    description:'',
    price : 2190.0,
    imgUrl: '',
    date: '',
    categories:[
      {
        id :1,
        name: 'Livros'
      }
    ]
  }
  return (
    <div className="container my-4">
      <div className="row">
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <ProductCard product={product} />
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <ProductCard product={product} />
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <ProductCard product={product} />
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <ProductCard product={product} />
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <ProductCard product={product} />
        </div>
      </div>
    </div>
  );
};

export default Catalog;
